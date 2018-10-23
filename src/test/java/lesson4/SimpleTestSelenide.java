package lesson4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class SimpleTestSelenide extends SelenideTestBase {


    @BeforeClass
    public void beforeClass() {

    }

    @Test
    public void simpleTest() {
        //  setProperty("webriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //1 Open BR
        //2 Navigate
        open("https://epam.github.io/JDI/index.html");


        //3 Assert Title
        assertEquals(getWebDriver().getTitle(), "Home Page");

        //4 Login
        $(".profile-photo").click();
        $("[id = 'Name']").sendKeys("epam");
        $("[id = 'Password']").sendKeys("1234");
        $(".login [type = 'submit']").click();

        //5 Assert User name in the left-top side of screen that user is loggined


    }
}
