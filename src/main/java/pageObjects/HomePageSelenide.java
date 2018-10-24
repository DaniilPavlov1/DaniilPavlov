package pageObjects;


import com.codeborne.selenide.SelenideElement;
import enums.Urls;
import enums.Users;
import enums.mainPageEnums.Texts;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.testng.AssertJUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Urls.HOME_PAGE_URL;
import static enums.Users.PITER_CHALOVSKII;
import static enums.mainPageEnums.Texts.TITLE_CONTENT;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSelenide {

    //================================single elements===================================

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = "[type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = "h3.main-title")
    private SelenideElement mainTitle;

    @FindBy(css = ".profile-photo > span")
    private SelenideElement userProfile;

    //================================methods===================================

    @Step("1 - Open test site by URL")
    public void openPage() {
        open(HOME_PAGE_URL.url);
    }

    @Step("3 - Perform login")
    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    //================================checks===================================

    @Step("2 - Assert Browser title")
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    @Step("4 - Assert User name in the left-top side of screen that user is loggined")
    public void checkUserLoggedIn() {
        userProfile.shouldBe(visible);
        userProfile.shouldHave(text(PITER_CHALOVSKII.name));
    }

    @Step("Check that main text correct")
    public void checkMainText() {
        mainTitle.shouldBe(visible);
        mainTitle.shouldHave(text(TITLE_CONTENT.text));
    }
}