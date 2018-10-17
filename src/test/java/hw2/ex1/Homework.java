package hw2.ex1;

import dataProviders.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class Homework {


    @Test(dataProvider = "benefitsDataProvider", dataProviderClass = DataProviders.class)
    public void checkMainPage(String text) {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //1 Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = driver.findElements(By.xpath(".//div[@class = 'benefit-icon']"));
        assertEquals(images.size(), 4);
        for (WebElement image : images) {
            image.isDisplayed();
        }

        //3 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> texts = driver.findElements(By.xpath(".//span[@class = 'benefit-txt']"));
        assertEquals(images.size(), 4);
        for (WebElement txt : texts) {
            txt.isDisplayed();
        }
        List<String> strs = texts.stream().map(i -> i.getText()).collect(Collectors.toList());
        assertTrue(strs.contains(text));

        //4 Close BR
        driver.close();
    }
}
