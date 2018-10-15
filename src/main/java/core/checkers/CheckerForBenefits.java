package core.checkers;

import core.HelperBase;
import core.wrappers.DataForBenefits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class CheckerForBenefits {

    private HashMap<String, Boolean> textsForBenefits = new HashMap<String, Boolean>();

    {
        textsForBenefits.put(DataForBenefits.TEXT1.getClaim(), false);
        textsForBenefits.put(DataForBenefits.TEXT2.getClaim(), false);
        textsForBenefits.put(DataForBenefits.TEXT3.getClaim(), false);
        textsForBenefits.put(DataForBenefits.TEXT4.getClaim(), false);
    }

    public void checkElementText(WebElement element) {
        assertTrue("Such text for benefits not expected" + element.getText(), textsForBenefits.containsKey(element.getText()));
        textsForBenefits.put(element.getText(), true);
    }

    public void isAllElementsChecked() {
        if (!textsForBenefits.get(DataForBenefits.TEXT1.getClaim())) {
            throw new IllegalArgumentException("From MainPage - Text#1 for benefits not found!");
        }
        if (!textsForBenefits.get(DataForBenefits.TEXT2.getClaim())) {
            throw new IllegalArgumentException("From MainPage - Text#2 for benefits not found!");
        }
        if (!textsForBenefits.get(DataForBenefits.TEXT3.getClaim())) {
            throw new IllegalArgumentException("From MainPage - Text#3 for benefits not found!");
        }
        if (!textsForBenefits.get(DataForBenefits.TEXT4.getClaim())) {
            throw new IllegalArgumentException("From MainPage - Text#4 for benefits not found!");
        }
    }
}
