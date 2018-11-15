package utils;

import io.appium.java_client.AppiumDriver;

public class KeyBoardHelper {

    public static boolean checkKeyBoardPresent(AppiumDriver driver) {

        try {
            driver.hideKeyboard();
            return true;
        } catch (Exception e) {
            System.out.println("Keyboard isn't presented!");
            return false;
        }
    }
}
