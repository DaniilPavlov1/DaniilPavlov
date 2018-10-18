package hw3.ex1;

import base.TestBase;
import dataForTests.DataForBenefits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pageObject.HomePage;

import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.setProperty;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class HomePageContentTestSuit {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        //  setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }


    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.close();
    }


    @Test
    public void HomePageContentTest() {

        //1 Open test site by URL
        homePage.open(driver);

        //2 Assert Browser title
        homePage.checkTitle(driver);

        //3 Perform login
        homePage.login("epam", "1234");

        //4 Assert User name in the left-top side of screen that user is loggined
        homePage.checkUserLoggedIn();

        //5 Assert Browser title
        homePage.checkTitle(driver);

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.checkItemsInHeaderSection();

        //7 Assert that there are 4 images on the Index Page and they are displayed
        homePage.checkImagesIsDisplayed();

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.checkTextsProperAndDisplayed();

        //9 Assert a text of the main header
        homePage.checkMainText();

        //10 Assert that there is the iframe in the center of page
        homePage.checkIframeIsDisplayed();

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        homePage.switchToIframe(driver);
        homePage.checkEpamLogoIsDisplayed();

        //12 Switch to original window back
        homePage.switchToParentFrame(driver);

        //13 Assert a text of the sub header
        homePage.checkSubHeaderTextIsProper();

        //14 Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkSubHeaderLinkIsProper();

        //15 Assert that there is Left Section
        homePage.checkLeftSectionIsDisplayed();

        //16 Assert that there is Footer
        homePage.checkFooterIsDisplayed();

    }
}

