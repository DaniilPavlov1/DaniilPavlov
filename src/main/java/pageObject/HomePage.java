package pageObject;

import dataForTests.DataForBenefits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class HomePage {

    //================================texts===================================

    private static final String PAGE_TITLE = "Home Page";
    private static final String USER_NAME = "PITER CHAILOVSKII";
    private static final String MAIN_CONTENT = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
    private static final String TITLE_CONTENT = "EPAM FRAMEWORK WISHES…";
    private static final String SUB_HEADER_CONTENT = "JDI GITHUB";
    private static final String SUB_HEADER_LINK_URL = "https://github.com/epam/JDI";

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

    //================================Lists of elements===================================

    @FindAll({
            @FindBy(xpath = ".//ul[contains(@class,'m-l8')]/li/a")
    })
    private List<WebElement> itemsInHeaderSection;

    @FindAll({
            @FindBy(xpath = ".//div[@class = 'benefit-icon']")
    })
    private List<WebElement> imagesOnTheHomePage;

    @FindAll({
            @FindBy(xpath = ".//span[@class = 'benefit-txt']")
    })
    private List<WebElement> textsOnTheHomePage;

    //================================methods===================================

    public void open(WebDriver driver) {
        driver.get("https://epam.github.io/JDI/index.html");
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
        assertEquals(driver.getTitle(), PAGE_TITLE);
    }

    public void checkMainText() {
        //check title in main header
        assertTrue(titleOfMainHeader.isDisplayed());
        assertEquals(TITLE_CONTENT, titleOfMainHeader.getText());

        //check text in main header
        assertTrue(mainText.isDisplayed());
        assertEquals(MAIN_CONTENT, mainText.getText());
    }

    public void checkUserLoggedIn() {
        assertTrue(userProfile.isDisplayed());
        assertEquals(userProfile.getText(), USER_NAME);
    }

    public void checkItemsInHeaderSection() {
        String[] str = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        List<String> content = Arrays.asList(str);
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
        String[] str = {DataForBenefits.BASE.getClaim(),
                DataForBenefits.CUSTOM.getClaim(),
                DataForBenefits.MULTI.getClaim(),
                DataForBenefits.PRACTICE.getClaim()
        };
        List<String> content = Arrays.asList(str);
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
        assertEquals(subHeader.getText(), SUB_HEADER_CONTENT);
    }

    public void checkSubHeaderLinkIsProper() {
        assertEquals(subHeaderLink.getAttribute("href"), SUB_HEADER_LINK_URL);
    }

    public void checkLeftSectionIsDisplayed() {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkFooterIsDisplayed() {
        assertTrue(footer.isDisplayed());
    }

}
