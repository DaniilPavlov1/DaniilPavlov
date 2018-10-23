package hw1;

import enums.mainPageEnums.Benefits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;

public class HomeworkWithSoft {


    @Test
    public void checkMainPage() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //1 Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert Browser title
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo > span"));
        softAssert.assertTrue(userName.isDisplayed());
        softAssert.assertEquals(userName.getText(), "PITER CHAILOVSKII");


        //5 Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        //check item "HOME"
        WebElement item = driver.findElement(By.xpath(".//ul[contains(@class,'m-l8')]//a[contains(@href, 'index')]"));
        softAssert.assertEquals("HOME", item.getText());

        //check item "CONTACT FORM"
        item = driver.findElement(By.xpath(".//ul[contains(@class,'m-l8')]//a[contains(@href, 'contacts')]"));
        softAssert.assertEquals("CONTACT FORM", item.getText());

        //check item "SERVICE"
        item = driver.findElement(By.xpath(".//ul[contains(@class,'m-l8')]//a[contains(@class, 'dropdown')]"));
        softAssert.assertEquals("SERVICE", item.getText());

        //check item "METALS & COLORS"
        item = driver.findElement(By.xpath(".//ul[contains(@class,'m-l8')]//a[contains(@href, 'metals')]"));
        softAssert.assertEquals("METALS & COLORS", item.getText());

        //7 Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertTrue(driver.findElement(By.xpath(".//div[child::span[contains(@class, 'practise')]]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath(".//div[child::span[contains(@class, 'custom')]]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath(".//div[child::span[contains(@class, 'multi')]]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath(".//div[child::span[contains(@class, 'base')]]")).isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        WebElement txt = driver.findElement(By.xpath(".//div[child::span[contains(@class, 'practise')]]/parent::div/span"));
        softAssert.assertTrue(txt.isDisplayed());
        softAssert.assertEquals(Benefits.PRACTICE.text, txt.getText());

        txt = driver.findElement(By.xpath(".//div[child::span[contains(@class, 'custom')]]/parent::div/span"));
        softAssert.assertTrue(txt.isDisplayed());
        softAssert.assertEquals(Benefits.CUSTOM.text, txt.getText());

        txt = driver.findElement(By.xpath(".//div[child::span[contains(@class, 'multi')]]/parent::div/span"));
        softAssert.assertTrue(txt.isDisplayed());
        softAssert.assertEquals(Benefits.MULTI.text, txt.getText());

        txt = driver.findElement(By.xpath(".//div[child::span[contains(@class, 'base')]]/parent::div/span"));
        softAssert.assertTrue(txt.isDisplayed());
        softAssert.assertEquals(Benefits.BASE.text, txt.getText());

        //9 Assert a text of the main header
        //check title of the main header
        WebElement title = driver.findElement(By.xpath(".//main//h3[contains(@class,'title')]"));
        softAssert.assertTrue(title.isDisplayed());
        softAssert.assertEquals("EPAM FRAMEWORK WISHES…", title.getText());
        //check text block of the main header
        String contentMainHeader = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        WebElement textMainHeader = driver.findElement(By.xpath(".//main//p[contains(@class,'txt')]"));
        softAssert.assertTrue(textMainHeader.isDisplayed());
        softAssert.assertEquals(contentMainHeader, textMainHeader.getText());

        //10 Assert that there is the iframe in the center of page
        softAssert.assertTrue(driver.findElement(By.cssSelector("iframe")) != null);

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        String currentWindow = driver.getWindowHandle();
        driver.switchTo().frame("iframe");
        softAssert.assertTrue(driver.findElement(By.xpath(".//div[@class='epam-logo']//img")) != null);
        softAssert.assertTrue(driver.findElement(By.xpath(".//div[@class='epam-logo']//img")).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().window(currentWindow);

        //13 Assert a text of the sub header
        softAssert.assertEquals("JDI GITHUB", (driver.findElement(By.xpath(".//main//h3[@class='text-center']")).getText()));

        //14 Assert that JDI GITHUB is a link and has a proper URL
        softAssert.assertEquals("https://github.com/epam/JDI", driver.findElement(By.xpath(".//main//h3[@class='text-center']/a")).getAttribute("href"));


        //15 Assert that there is Left Section
        softAssert.assertTrue(driver.findElement(By.xpath(".//div[@name='navigation-sidebar']")).isDisplayed());


        //16 Assert that there is Footer
        softAssert.assertTrue(driver.findElement(By.cssSelector("footer")).isDisplayed());

        softAssert.assertAll();

        //17 Close Browser
        driver.close();
    }
}

