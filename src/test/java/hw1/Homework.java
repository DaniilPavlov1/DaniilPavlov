package hw1;

import core.MainPage;
import core.TestBase;
import core.checkers.CheckerForHeaderMenu;
import core.wrappers.WrapperForBenefits;
import model.TestBot;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Homework extends TestBase {


    @Test
    public void homework() {
        //1 Open test site by URL
        init();
        MainPage mainPage = new MainPage(driver);

        //2 Assert Browser title
        mainPage.checkTitle();

        //3 Perform login
        mainPage.doLogin(new TestBot("epam", "1234"));

        //4 Assert User name in the left-top side of screen that user is loggined
        mainPage.checkLoggined();

        //5 Assert Browser title
        mainPage.checkTitle();

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        new CheckerForHeaderMenu(driver).checkElements();

        //Realization of pattern transformer
        List<WrapperForBenefits> list = mainPage.getBenefits();
        for (WrapperForBenefits i : list) {

            //7 Assert that there are 4 images on the Index Page and they are displayed
            i.checkBenefitIconDisplayed();

            //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
            i.checkBenefitTextRight();
        }
        WrapperForBenefits.checkAllTextsChecked();

        //9 Assert a text of the main header
        mainPage.checkMainHeaderTitleDisplayed().checkMainHeaderTitleContentRigth();
        mainPage.checkMainHeaderTextDisplayed().checkMainHeaderTextContentRigth();

        //10 Assert that there is the iframe in the center of page
        mainPage.checkIframePresent();

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        String currentWindow = driver.getWindowHandle();
        driver.switchTo().frame("iframe");
        mainPage.checkLogoDisplayed();

        //12 Switch to original window back
        driver.switchTo().window(currentWindow);

        //13 Assert a text of the sub header
        mainPage.checkSubHeaderDisplayed().checkSubHeaderContent();

        //14 Assert that JDI GITHUB is a link and has a proper URL
        mainPage.checkSubHeaderLinkDisplayed().checkSubHeaderLinkURL();

        //15 Assert that there is Left Section
        mainPage.checkLeftSectionDisplayed();

        //16 Assert that there is Footer
        mainPage.checkFooterDisplayed();

        //17 Close Browser
        stop();

    }
}
