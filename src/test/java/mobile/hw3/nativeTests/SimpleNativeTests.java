package mobile.hw3.nativeTests;

import enums.mobile.PropertyFile;
import mobile.hw3.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static enums.mobile.NativeElements.*;
import static enums.mobile.NativeTitles.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.KeyBoardHelper.checkKeyBoardPresent;

@Test(groups = "native")
public class SimpleNativeTests extends Hooks {

    protected SimpleNativeTests() {
        super(PropertyFile.NATIVE);
    }

    @Test(description = "Go to the \"Add Contact\" screen and check it content")
    public void simplestAddContactScreenTest() throws Exception {

        //Click "Add Contact"
        driver().findElement(ADD_BTN.getId()).click();

        //Check that "Add Contact" title is displayed and have proper text
        assertTrue(driver().findElement(ADD_CONTACT_TITLE.getId()).isDisplayed());
        assertEquals(driver().findElement(ADD_CONTACT_TITLE.getId()).getText(), ADD_CONTACT_TITLE.value);

        //Check that each title is displayed
        List<WebElement> desiredTitles = new ArrayList<>();
        for (By titleId : getListId()) {
            desiredTitles.add(driver().findElement(titleId));
        }

        for (WebElement title : desiredTitles) {
            assertTrue(title.isDisplayed());
        }

        //Check that each title have expected texts
        List<String> expectedTitles = getListValues();
        List<String> desiredTitlesValues = desiredTitles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        for (String title : expectedTitles) {
            assertTrue(desiredTitlesValues.contains(title));
        }

        //Check that all expected fields are displayed
        for (By fieldId : getFieldsIdList()) {
            assertTrue(driver().findElement(fieldId).isDisplayed());
        }

        //Check that all expected spinners are displayed
        for (By spinnerId : getSpinnersIdList()) {
            assertTrue(driver().findElement(spinnerId).isDisplayed());
        }

        //Check that button "Save" is displayed
        assertTrue(driver().findElement(SAVE_BTN.getId()).isDisplayed());

        //Check virtual keyboard appears
        assertTrue(checkKeyBoardPresent(driver()));
    }
}
