package hw4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHALOVSKII;


public class DatesPageSlidersTestSuit extends SelenideTestBase {
    private HomePageSelenide homePageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
    }

    @Test
    public void simpleTest() {

        //1 Open test site by URL
        homePageSelenide.openPage();

        //2 Assert Browser title
        homePageSelenide.checkTitle();

        //3 Perform login
        homePageSelenide.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePageSelenide.checkUserLoggedIn();

        //5 Open through the header menu Service -> Dates Page
        pageObjects.DatesPageSelenide datesPageSelenide = page(pageObjects.DatesPageSelenide.class);
        datesPageSelenide.openPage();

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datesPageSelenide.dragAndDropLeftSlider(0);
        datesPageSelenide.dragAndDropRightSlider(100);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkLogsCorrect();

        //8 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        datesPageSelenide.dragAndDropLeftSlider(0);
        datesPageSelenide.dragAndDropRightSlider(0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkLogsCorrect();

        //10 Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        datesPageSelenide.dragAndDropRightSlider(100);
        datesPageSelenide.dragAndDropLeftSlider(100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkLogsCorrect();

        //12 Using drag-and-drop set Range sliders.
        datesPageSelenide.dragAndDropLeftSlider(30);
        datesPageSelenide.dragAndDropRightSlider(70);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkLogsCorrect();
    }
}
