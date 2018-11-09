package hw5;

import base.SelenideTestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.hw4.DatesPageSelenide;
import pageObjects.hw4.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;

@Feature("UI Tests")
@Story("Service And Dates Pages Testing")
@Listeners(AllureAttachmentListener.class)
public class DatesPageSlidersTest extends SelenideTestBase {
    private HomePageSelenide homePageSelenide;
    private DatesPageSelenide datesPageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
        datesPageSelenide = page(DatesPageSelenide.class);
    }

    @Test
    public void DatesPageSlidersTest() {

        //1 Open test site by URL
        homePageSelenide.openPage();

        //2 Assert Browser title
        homePageSelenide.checkTitle();

        //3 Perform login
        homePageSelenide.login();

        //4 Assert User name in the left-top side of screen that user is logged
        homePageSelenide.checkUserLoggedIn();

        //5 Open through the header menu Service -> Dates Page
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
