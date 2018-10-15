package core.wrappers;


import core.checkers.CheckerForBenefits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class WrapperForBenefits {


    private static final By ICON_IN_BENEFITS = By.xpath(".//div[@class='benefit-icon']");
    private static final By TEXT_IN_BENEFITS = By.xpath(".//span[@class='benefit-txt']");
    private static CheckerForBenefits checkerForBenefits = new CheckerForBenefits();
    private WebElement element;
    private WebDriver driver;

    public WrapperForBenefits(WebElement element, WebDriver driver) {
        this.driver = driver;
        this.element = element;
    }



    public WrapperForBenefits checkBenefitIconDisplayed() {
        assertTrue("One of icon's isn't displayed!", element.findElement(ICON_IN_BENEFITS).isDisplayed());
        return this;
    }

    public WrapperForBenefits checkBenefitTextDisplayed() {
        assertTrue("One of text's for benefits isn't displayed!", element.findElement(TEXT_IN_BENEFITS).isDisplayed());
        return this;
    }

    public WrapperForBenefits checkBenefitTextRight() {
        checkerForBenefits.checkElementText(element.findElement(TEXT_IN_BENEFITS));
        return this;
    }
    public static void checkAllTextsChecked() {
        checkerForBenefits.isAllElementsChecked();
    }

}
