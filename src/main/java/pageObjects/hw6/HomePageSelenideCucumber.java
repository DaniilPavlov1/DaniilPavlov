package pageObjects.hw6;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Users;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static enums.Urls.HOME_PAGE;

public class HomePageSelenideCucumber {
    public HomePageSelenideCucumber() {
        page(this);
    }

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

    @FindBy(css = "h3.main-title.text-center")
    private SelenideElement mainHeaderElement;

    @FindBy(css = ".main-txt.text-center")
    private SelenideElement mainSubHeader;

    //================================collections of elements===================================

    @FindBy(css = ".benefit-icon")
    private ElementsCollection benefitIcons;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection textsUnderIconsElements;

    //================================methods===================================

    @Given("I am on \"Home Page\"")
    public void open() {
        Selenide.open(HOME_PAGE.url);
    }

    @When("I login as user \"(.+)\"")
    public void login(String userName) {
        profileButton.click();
        Users user = Users.getUserEnumByName(userName.toUpperCase());
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
    }

    @When("I login as user (.+) with password (.+)")
    public void login(String name, String pwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(pwd);
        submit.click();
    }

    //================================checks===================================

    @Then("The user icon (.+) is displayed on the header")
    public void checkUserLoggedIn(String expectedName) {
        userProfile.shouldBe(visible);
        userProfile.shouldHave(text(expectedName));
    }

    @And("Interface on Home Page contains all needed elements:")
    public void checkInterfaceOfHomePage(DataTable dataTable) {
        Map<String, Integer> expectedTable = dataTable.asMap(String.class, Integer.class);
        benefitIcons.shouldHave(size(expectedTable.get("Benefit pictures")));
        for (SelenideElement icon : benefitIcons) {
            icon.shouldBe(visible);
        }
        textsUnderIconsElements.shouldHave(size(expectedTable.get("Benefit texts")));
        for (SelenideElement text : textsUnderIconsElements) {
            text.shouldBe(visible);
        }
        mainHeaderElement.shouldBe(visible);
        mainSubHeader.shouldBe(visible);
    }
}