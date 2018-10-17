package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SimpleTest {

    @Test
    public void simpleTest() {
        setProperty("webriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //1 Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2 Navigate
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //3 Assert Title
        assertEquals(driver.getTitle(), "Home Page");

        //4 Login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        //5 Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo > span"));
        assertTrue(userName.isDisplayed());
        assertEquals(userName.getText(), "PITER USER_NAME");

        //6 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        driver.close();
    }
}
