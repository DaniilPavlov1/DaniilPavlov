package pageObjects.hw6.general;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.Then;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Urls.getPageEnumByName;
import static org.testng.Assert.assertEquals;

public class General {
    public General() {
        page(this);
    }

    @Then("The browser title is (.+)")
    public void checkTitle(String pageTitle) {
        assertEquals(getWebDriver().getTitle(), pageTitle);
    }

    @Then("\"(.+)\" page is opened")
    public void checkPageIsOpened(String pageName) {
        assertEquals(WebDriverRunner.url(), getPageEnumByName(pageName).url);
    }
}
