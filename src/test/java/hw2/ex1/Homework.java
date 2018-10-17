package hw2.ex1;

import DataForTests.DataForBenefits;
import DataProviders.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class Homework {


    @Test(dataProvider = "benefitsDataProvider", dataProviderClass = DataProviders.class)
    public void checkMainPage(String locator, String text) {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //1 Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert that there are 4 images on the Index Page and they are displayed
        assertTrue(driver.findElement(By.xpath(locator)).isDisplayed());

        //3 Assert that there are 4 texts on the Index Page under icons and they have proper text
        WebElement txt = driver.findElement(By.xpath(locator + "/parent::div/span"));
        assertTrue(txt.isDisplayed());
        assertEquals(text, txt.getText());

        //4 Close BR
        driver.close();
    }
}
