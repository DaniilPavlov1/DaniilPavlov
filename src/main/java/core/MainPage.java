package core;

import core.transformers.BenefitsTransformer;
import core.wrappers.WrapperForBenefits;
import model.TestBot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainPage extends HelperBase {

    //User data
    private static  final String LOGIN = "epam";
    private static  final  String PASSWORD = "1234";

    //CSS selectors
    private static final By PROFILE_ICON = By.cssSelector(".profile-photo");
    private static final By INPUT_FOR_PROFILE_NAME = By.cssSelector("[id = 'Name']");
    private static final By INPUT_FOR_PROFILE_PASSWORD = By.cssSelector("[id = 'Password']");
    private static final By ENTER_TO_PROFILE = By.cssSelector(".login [type = 'submit']");
    private static final By USER_PROFILE = By.cssSelector(".profile-photo > span");
    private static final By FOOTER = By.cssSelector("footer");
    private static final By IFRAME = By.cssSelector("iframe");

    //Xpath selectors
    private static final By MAIN_HEADER_TEXT = By.xpath(".//main//p[contains(@class,'txt')]");
    private static final By LINK_IN_SUB_HEADER = By.xpath(".//main//h3[@class='text-center']/a");
    private static final By LOGO_EPAM = By.xpath(".//div[@class='epam-logo']//img");
    private static final By SUB_HEADER = By.xpath(".//main//h3[@class='text-center']");
    private static final By LEFT_SECTION = By.xpath(".//div[@name='navigation-sidebar']");
    private static final By BLOCKS_ON_INDEX_PAGE = By.xpath(".//div[@class='col-sm-3']");
    private static final By MAIN_HEADER_TITLE = By.xpath(".//main//h3[contains(@class,'title')]");

    //Text Data
    private static final String PAGE_TITLE = "Home Page";
    private static final String USER_NAME = "PITER CHAILOVSKII";
    private static final String TEXT_FOR_SUB_HEADER = "JDI GITHUB";
    private static final String URL_FOR_LINK_IN_SUB_HEADER = "https://github.com/epam/JDI";
    private static final String TEXT_FOR_TITLE_IN_MAIN_HEADER = "EPAM FRAMEWORK WISHES…";
    private static final String TEXT_FOR_MAIN_HEADER = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {}

    public MainPage doLogin(TestBot testBot) {
        click(PROFILE_ICON);
        type(LOGIN, INPUT_FOR_PROFILE_NAME);
        type(PASSWORD, INPUT_FOR_PROFILE_PASSWORD);
        click(ENTER_TO_PROFILE);
        return new MainPage(driver);
    }

    public MainPage checkLoggined() {
        WebElement userName = driver.findElement(USER_PROFILE);
        Assert.assertTrue("User profile isn't found!", userName != null);
        Assert.assertTrue("User profile isn't displayed!", userName.isDisplayed());
        assertEquals(userName.getText(), USER_NAME);
        return this;
    }

    public MainPage checkMainHeaderTitleDisplayed() {
        Assert.assertTrue("Main title isn't found!", isElementPresent(MAIN_HEADER_TITLE));
        Assert.assertTrue("Main title isn't displayed!", isElementVisible(MAIN_HEADER_TITLE));
        return this;
    }

    public MainPage checkMainHeaderTitleContentRigth() {
        Assert.assertTrue("Text in Main Header title isn't found!", driver.findElement(MAIN_HEADER_TITLE).getText() != null);
        Assert.assertTrue("Text in Main Header title isn't right!", TEXT_FOR_TITLE_IN_MAIN_HEADER.equals(driver.findElement(MAIN_HEADER_TITLE).getText()));
        return this;
    }

    public MainPage checkMainHeaderTextDisplayed() {
        Assert.assertTrue("Main Header title isn't found!", isElementPresent(MAIN_HEADER_TEXT));
        Assert.assertTrue("Main Header title isn't displayed!", isElementVisible(MAIN_HEADER_TEXT));
        return this;
    }

    public MainPage checkMainHeaderTextContentRigth() {
        Assert.assertTrue("Text in Main Header isn't found!", driver.findElement(MAIN_HEADER_TEXT).getText() != null);
        Assert.assertTrue("Text in Main Header isn't right!", TEXT_FOR_MAIN_HEADER.equals(driver.findElement(MAIN_HEADER_TEXT).getText()));
        return this;
    }

    public MainPage checkSubHeaderDisplayed() {
        Assert.assertTrue("Sub Header isn't found!", isElementPresent(SUB_HEADER));
        Assert.assertTrue("Sub Header isn't displayed!", isElementVisible(SUB_HEADER));
        return this;
    }

    public MainPage checkSubHeaderContent() {
        Assert.assertTrue("Text in Main Header isn't found!", driver.findElement(SUB_HEADER).getText() != null);
        Assert.assertTrue("Text in Main Header isn't right!", TEXT_FOR_SUB_HEADER.equals(driver.findElement(SUB_HEADER).getText()));
        return this;
    }

    public MainPage checkSubHeaderLinkDisplayed() {
        Assert.assertTrue("Link in Sub Header isn't found!", isElementPresent(LINK_IN_SUB_HEADER));
        Assert.assertTrue("Link in Sub Header isn't displayed!", isElementVisible(LINK_IN_SUB_HEADER));
        return this;
    }

    public MainPage checkSubHeaderLinkURL() {
        Assert.assertTrue("Link URL in Sub Header isn't found!", driver.findElement(LINK_IN_SUB_HEADER).getText() != null);
        Assert.assertTrue("Link URL in Sub Header isn't right!", URL_FOR_LINK_IN_SUB_HEADER.equals(driver.findElement(LINK_IN_SUB_HEADER).getAttribute("href")));
        return this;
    }

    public MainPage checkLeftSectionDisplayed() {
        Assert.assertTrue("Left Section isn't found!", isElementPresent(LEFT_SECTION));
        Assert.assertTrue("Left Section isn't displayed!", isElementVisible(LEFT_SECTION));
        return this;
    }

    public MainPage checkFooterDisplayed() {
        Assert.assertTrue("Footer isn't found!", isElementPresent(FOOTER));
        Assert.assertTrue("Footer isn't displayed!", isElementVisible(FOOTER));
        return this;
    }

    public MainPage checkLogoDisplayed() {
        Assert.assertTrue("Logo isn't found!", isElementPresent(LOGO_EPAM));
        Assert.assertTrue("Logo isn't displayed!", isElementVisible(LOGO_EPAM));
        return this;
    }

    public MainPage checkIframePresent() {
        Assert.assertTrue("Iframe isn't found!", isElementPresent(IFRAME));
        return this;
    }

    public MainPage checkTitle() {
        assertEquals(driver.getTitle(), PAGE_TITLE);
        return this;
    }


    public List<WrapperForBenefits> getBenefits() {
        if (isElementPresent(BLOCKS_ON_INDEX_PAGE)) {
            return BenefitsTransformer.wrap(driver.findElements(BLOCKS_ON_INDEX_PAGE), driver);
        }
        return Collections.emptyList();
    }
}
