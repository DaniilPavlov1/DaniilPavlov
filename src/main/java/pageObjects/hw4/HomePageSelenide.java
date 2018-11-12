package pageObjects.hw4;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.ServiceCategories;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Urls.HOME_PAGE;
import static enums.Users.PITER_CHALOVSKII;
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

    @FindBy(css = "[class = 'dropdown']")
    private SelenideElement headerServiceButton;

    @FindBy(css = "[class = 'sidebar-menu'] > [index='3']")
    private SelenideElement leftServiceButton;

    //================================collections of elements===================================

    @FindBy(css = "[class = 'dropdown-menu'] > li")
    private ElementsCollection headerServiceMenuElements;

    @FindBy(css = "[class = 'sub'] > li")
    private ElementsCollection leftServiceMenuElements;

    //================================methods===================================

    @Step("Open test site by URL")
    public void openPage() {
        open(HOME_PAGE.url);
    }

    @Step("Perform login")
    public void login() {
        profileButton.click();
        login.sendKeys(PITER_CHALOVSKII.login);
        password.sendKeys(PITER_CHALOVSKII.password);
        submit.click();
    }

    @Step("Click at dropdown \"Service\" in Header")
    public void clickServiceHeader() {
        headerServiceButton.click();
    }

    @Step("Click at dropdown \"Service\" in Left section")
    public void clickOnLeftSelect() {
        leftServiceButton.click();
    }

    //================================checks===================================

    @Step("Assert Browser title")
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    @Step("Assert User name in the left-top side of screen that user is logged")
    public void checkUserLoggedIn() {
        userProfile.shouldBe(visible);
        userProfile.shouldHave(text(PITER_CHALOVSKII.name));
    }

    @Step("Check that dropdown \"Service\" in Header section contains correct elements")
    public void checkHeaderServiceElements() {
        for (String category : ServiceCategories.getList()) {
            assertTrue(headerServiceMenuElements.texts().contains(category.toUpperCase()));
        }
    }

    @Step("Check that dropdown \"Service\" in Left section contains correct elements")
    public void checkLeftServiceElements() {
        for (String category : ServiceCategories.getList()) {
            assertTrue(leftServiceMenuElements.texts().contains(category));
        }
    }
}