package pageObject;

import enums.Links;
import enums.PageTitles;
import enums.Urls;
import enums.Users;
import enums.mainPageEnums.Benefits;
import enums.mainPageEnums.Items;
import enums.mainPageEnums.Texts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class HomePage {

    //================================single elements===================================

    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private WebElement login;

    @FindBy(css = "[id = 'Password']")
    private WebElement password;

    @FindBy(css = "[type = 'submit']")
    private WebElement submit;

    @FindBy(css = ".profile-photo > span")
    private WebElement userProfile;

    @FindBy(xpath = ".//main//h3[contains(@class,'title')]")
    private WebElement titleOfMainHeader;

    @FindBy(xpath = ".//main//p[contains(@class,'txt')]")
    private WebElement mainText;

    @FindBy(css = "iframe")
    private WebElement iframe;

    @FindBy(xpath = ".//div[@class='epam-logo']//img")
    private WebElement epamLogo;

    @FindBy(xpath = ".//main//h3[@class='text-center']")
    private WebElement subHeader;

    @FindBy(xpath = ".//main//h3[@class='text-center']/a")
    private WebElement subHeaderLink;

    @FindBy(xpath = ".//div[@name='navigation-sidebar']")
    private WebElement leftSection;

    @FindBy(css = "footer")
    private WebElement footer;

    //================================lists of elements===================================

    @FindBy(xpath = "//ul[contains(@class,'m-l8')]/li/a")
    private List<WebElement> itemsInHeaderSection;

    @FindBy(xpath = "//div[@class = 'benefit-icon']")
    private List<WebElement> imagesOnTheHomePage;

    @FindBy(xpath = "//span[@class = 'benefit-txt']")
    private List<WebElement> textsOnTheHomePage;

    //================================methods===================================

    public void open(WebDriver driver) {
        driver.get(Urls.HOME_PAGE_URL.url);
    }

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    public void switchToIframe(WebDriver driver) {
        driver.switchTo().frame("iframe");
    }

    public void switchToParentFrame(WebDriver driver) {
        driver.switchTo().parentFrame();
    }

    //================================checks===================================

    public void checkTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), PageTitles.HOME_PAGE.text);
    }

    public void checkMainText() {
        //check title in main header
        assertTrue(titleOfMainHeader.isDisplayed());
        assertEquals(Texts.TITLE_CONTENT.text, titleOfMainHeader.getText());

        //check text in main header
        assertTrue(mainText.isDisplayed());
        assertEquals(Texts.MAIN_CONTENT.text, mainText.getText());
    }

    public void checkUserLoggedIn() {
        assertTrue(userProfile.isDisplayed());
        assertEquals(userProfile.getText(), Users.PITER_CHALOVSKII.name);
    }

    public void checkItemsInHeaderSection() {

        List<String> content = Items.getList();
        assertEquals(itemsInHeaderSection.size(), 4);
        for (WebElement item : itemsInHeaderSection) {
            assertTrue(content.contains(item.getText()));
        }
    }

    public void checkImagesIsDisplayed() {
        assertEquals(imagesOnTheHomePage.size(), 4);
        for (WebElement image : imagesOnTheHomePage) {
            assertTrue(image.isDisplayed());
        }
    }

    public void checkTextsProperAndDisplayed() {
        assertEquals(textsOnTheHomePage.size(), 4);
        List<String> content = Benefits.getList();
        for (WebElement text : textsOnTheHomePage) {
            assertTrue(content.contains(text.getText()));
        }
    }

    public void checkIframeIsDisplayed() {
        assertTrue(iframe.isDisplayed());
    }

    public void checkEpamLogoIsDisplayed() {
        assertTrue(epamLogo.isDisplayed());
    }

    public void checkSubHeaderTextIsProper() {
        assertEquals(subHeader.getText(), Links.SUB_HEADER_LINK_URL.text);
    }

    public void checkSubHeaderLinkIsProper() {
        assertEquals(subHeaderLink.getAttribute("href"), Links.SUB_HEADER_LINK_URL.url);
    }

    public void checkLeftSectionIsDisplayed() {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkFooterIsDisplayed() {
        assertTrue(footer.isDisplayed());
    }

}
