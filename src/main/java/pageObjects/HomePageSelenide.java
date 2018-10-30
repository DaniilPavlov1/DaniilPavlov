package pageObjects;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.ServiceCategories;
import org.openqa.selenium.support.FindBy;

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

    public void openPage() {
        open(HOME_PAGE_URL.url);
    }

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    public void clickServiceHeader() {
        headerServiceButton.click();
    }

    public void clickOnLeftSelect() {
        leftServiceButton.click();
    }

    //================================checks===================================

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    public void checkUserLoggedIn() {
        userProfile.shouldBe(visible);
        userProfile.shouldHave(text(PITER_CHALOVSKII.name));
    }

    public void checkMainText() {
        mainTitle.shouldBe(visible);
        mainTitle.shouldHave(text(TITLE_CONTENT.text));
    }

    public void checkHeaderServiceElements() {
        for (String category : ServiceCategories.getList()) {
            assertTrue(headerServiceMenuElements.texts().contains(category.toUpperCase()));
        }
    }

    public void checkLeftServiceElements() {
        for (String category : ServiceCategories.getList()) {
            assertTrue(leftServiceMenuElements.texts().contains(category));
        }
    }
}