package core.wrappers;


import core.checkers.CheckerForBenefits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class WrapperForBenefits {


    private static CheckerForBenefits checkerForBenefits = new CheckerForBenefits();
    private WebElement element;
    private WebDriver driver;

    public WrapperForBenefits(WebElement element, WebDriver driver) {
        this.driver = driver;
        this.element = element;
    }



    public WrapperForBenefits checkBenefitIconDisplayed() {
        assertTrue("One of icon's isn't displayed!", element.findElement(By.xpath(".//div[@class='benefit-icon']")).isDisplayed());
        return this;
    }

    public WrapperForBenefits checkBenefitTextDisplayed() {
        assertTrue("One of text's for benefits isn't displayed!", element.findElement(By.xpath(".//span[@class='benefit-txt']")).isDisplayed());
        return this;
    }

    public WrapperForBenefits checkBenefitTextRight() {
        checkerForBenefits.checkElementText(element.findElement(By.xpath(".//span[@class='benefit-txt']")));
        return this;
    }
    public static void isAllTextsChecked() {
        checkerForBenefits.isAllElementsChecked();
    }

}
