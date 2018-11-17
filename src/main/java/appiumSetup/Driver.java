package appiumSetup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

import static enums.mobile.enumsSetup.AdditionalCaps.APP_ACTIVITY_CAP;
import static enums.mobile.enumsSetup.AdditionalCaps.APP_PACKAGE_CAP;
import static enums.mobile.enumsSetup.Browsers.CHROME;
import static enums.mobile.enumsSetup.Browsers.SAFARI;
import static enums.mobile.enumsSetup.ErrorsTexts.UNCLEAR_TYPE_OF_MOBILE_APP;
import static enums.mobile.enumsSetup.ErrorsTexts.UNKNOWN_MOBILE_PLATFORM;
import static enums.mobile.enumsSetup.ResoursesPaths.HTTPS_PREFIX;
import static enums.mobile.enumsSetup.ResoursesPaths.PATH_TO_RESOURCES;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static utils.appium.JsonReader.getDevice;

public class Driver {
    private static AppiumDriver appiumDriver = null;
    private static WebDriverWait driverWait;
    private DesiredCapabilities capabilities;
    private static Device device;

    private static String AUT;
    protected static String SUT;
    private static String TEST_PLATFORM;
    private static String DRIVER;
    private static String DEVICE_NAME;
    private static String UDID;
    private static String APP_PACKAGE;
    private static String APP_ACTIVITY;

    protected void loadConfig(String pathToConfig) throws FileNotFoundException {
        System.out.println("Config: " + pathToConfig);
        device = getDevice(pathToConfig);

        AUT = device.aut == null ? null : PATH_TO_RESOURCES + device.aut;
        System.out.println("aut=" + AUT);
        SUT = device.sut == null ? null : HTTPS_PREFIX + device.sut;
        System.out.println("sut=" + SUT);
        TEST_PLATFORM = device.test_platform;
        DRIVER = device.driver;
        DEVICE_NAME = device.device_name;
        UDID = device.udid;
        APP_PACKAGE = device.app_package;
        APP_ACTIVITY = device.app_activity;
    }

    protected void prepareDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        String browserName;

        switch (TEST_PLATFORM) {
            case "Android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
                browserName = CHROME.browser;
                break;
            case "iOS":
                capabilities.setCapability(MobileCapabilityType.UDID, UDID);
                browserName = SAFARI.browser;
                break;
            default:
                throw new Exception(UNKNOWN_MOBILE_PLATFORM.text);
        }
        capabilities.setCapability(PLATFORM_NAME, TEST_PLATFORM);

        if (AUT != null && SUT == null) {
            if (device.isRemote) {
                capabilities.setCapability(APP_PACKAGE_CAP.capName, APP_PACKAGE);
                capabilities.setCapability(APP_ACTIVITY_CAP.capName, APP_ACTIVITY);
            } else {
                File app = new File(AUT);
                capabilities.setCapability(APP, app.getAbsolutePath());
            }
        } else if (SUT != null && AUT == null) {
            capabilities.setCapability(BROWSER_NAME, browserName);
        } else {
            throw new Exception(UNCLEAR_TYPE_OF_MOBILE_APP.text);
        }
        System.out.println(capabilities);
        if (appiumDriver == null) appiumDriver = new AppiumDriver(new URL(DRIVER), capabilities);

        if (driverWait == null) {
            driverWait = new WebDriverWait(driver(), 10);
        }

    }

    protected AppiumDriver driver() throws Exception {
        if (appiumDriver == null) prepareDriver();
        return appiumDriver;
    }

    protected WebDriverWait driverWait() {
        return driverWait;
    }

}