package hw2.ex3;

import enums.mainPageEnums.Benefits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class HomeworkWithAnnotations {
    private WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        driver = new ChromeDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        System.out.println(driver.getTitle());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.close();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println(System.currentTimeMillis());
    }


    @Test
    public void checkMainPage() {

        //1 Navigate to tested page
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo > span"));
        assertTrue(userName.isDisplayed());
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        //check item "HOME"
        WebElement item = driver.findElement(By.xpath(".//ul[contains(@class,'m-l8')]//a[contains(@href, 'index')]"));
        assertEquals("HOME", item.getText());

        //check item "CONTACT FORM"
        item = driver.findElement(By.xpath(".//ul[contains(@class,'m-l8')]//a[contains(@href, 'contacts')]"));
        assertEquals("CONTACT FORM", item.getText());

        //check item "SERVICE"
        item = driver.findElement(By.xpath(".//ul[contains(@class,'m-l8')]//a[contains(@class, 'dropdown')]"));
        assertEquals("SERVICE", item.getText());

        //check item "METALS & COLORS"
        item = driver.findElement(By.xpath(".//ul[contains(@class,'m-l8')]//a[contains(@href, 'metals')]"));
        assertEquals("METALS & COLORS", item.getText());

        //7 Assert that there are 4 images on the Index Page and they are displayed
        assertTrue(driver.findElement(By.xpath(".//div[child::span[contains(@class, 'practise')]]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath(".//div[child::span[contains(@class, 'custom')]]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath(".//div[child::span[contains(@class, 'multi')]]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath(".//div[child::span[contains(@class, 'base')]]")).isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        WebElement txt = driver.findElement(By.xpath(".//div[child::span[contains(@class, 'practise')]]/parent::div/span"));
        assertTrue(txt.isDisplayed());
        assertEquals(Benefits.PRACTICE.text, txt.getText());

        txt = driver.findElement(By.xpath(".//div[child::span[contains(@class, 'custom')]]/parent::div/span"));
        assertTrue(txt.isDisplayed());
        assertEquals(Benefits.CUSTOM.text, txt.getText());

        txt = driver.findElement(By.xpath(".//div[child::span[contains(@class, 'multi')]]/parent::div/span"));
        assertTrue(txt.isDisplayed());
        assertEquals(Benefits.MULTI.text, txt.getText());

        txt = driver.findElement(By.xpath(".//div[child::span[contains(@class, 'base')]]/parent::div/span"));
        assertTrue(txt.isDisplayed());
        assertEquals(Benefits.BASE.text, txt.getText());

        //9 Assert a text of the main header
        //check title of the main header
        WebElement title = driver.findElement(By.xpath(".//main//h3[contains(@class,'title')]"));
        assertTrue(title.isDisplayed());
        assertEquals("EPAM FRAMEWORK WISHES…", title.getText());
        //check text block of the main header
        String contentMainHeader = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        WebElement textMainHeader = driver.findElement(By.xpath(".//main//p[contains(@class,'txt')]"));
        assertTrue(textMainHeader.isDisplayed());
        assertEquals(contentMainHeader, textMainHeader.getText());

        //10 Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.cssSelector("iframe")) != null);

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        String currentWindow = driver.getWindowHandle();
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.xpath(".//div[@class='epam-logo']//img")) != null);
        assertTrue(driver.findElement(By.xpath(".//div[@class='epam-logo']//img")).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().window(currentWindow);

        //13 Assert a text of the sub header
        assertEquals("JDI GITHUB", (driver.findElement(By.xpath(".//main//h3[@class='text-center']")).getText()));

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals("https://github.com/epam/JDI", driver.findElement(By.xpath(".//main//h3[@class='text-center']/a")).getAttribute("href"));


        //15 Assert that there is Left Section
        assertTrue(driver.findElement(By.xpath(".//div[@name='navigation-sidebar']")).isDisplayed());


        //16 Assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector("footer")).isDisplayed());
    }
}

