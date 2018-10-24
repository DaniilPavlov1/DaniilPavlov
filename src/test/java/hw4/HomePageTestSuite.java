package hw4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.source;
import static org.testng.Assert.assertEquals;
import base.SelenideTestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.DatesPageSelenide;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHALOVSKII;
import static java.lang.System.setProperty;

@Feature("Smoke tests")
@Story("Home Page Testing")
@Listeners(AllureAttachmentListener.class)

public class HomePageTestSuite extends SelenideTestBase {
    private HomePageSelenide homePageSelenide;
    private DatesPageSelenide datesPageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
    }

    @Flaky
    @Test
    public void simpleTest(){
       // setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //1 Open test site by URL
        homePageSelenide.openPage();

        //2 Assert Browser title
        homePageSelenide.checkTitle();

        //3 Perform login
        homePageSelenide.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePageSelenide.checkUserLoggedIn();

        //5 Open through the header menu Service -> Dates Page
        datesPageSelenide = page(DatesPageSelenide.class);
        datesPageSelenide.openPage();

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datesPageSelenide.dragAndDropLeftSlider(0);
        datesPageSelenide.dragAndDropRightSlider(100);
        System.out.println(6);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkLogsCorrect();

        //8 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        datesPageSelenide.dragAndDropLeftSlider(0);
        datesPageSelenide.dragAndDropRightSlider(0);
        System.out.println(8);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkLogsCorrect();

        //10 Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        datesPageSelenide.dragAndDropLeftSlider(100);
        datesPageSelenide.dragAndDropRightSlider(100);
        System.out.println(10);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkLogsCorrect();

        //12 Using drag-and-drop set Range sliders.
        datesPageSelenide.dragAndDropLeftSlider(30);
        datesPageSelenide.dragAndDropRightSlider(70);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkLogsCorrect();
    }
}
