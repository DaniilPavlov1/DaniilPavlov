package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.differenElementsPageEnums.CheckBoxConditions;
import enums.differenElementsPageEnums.DropdownColors;
import enums.differenElementsPageEnums.RadioButtonValues;
import org.openqa.selenium.support.FindBy;
import pageObjects.hw4.Base.LogsSelenide;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static enums.ServiceCategories.DIFFERENT;


public class DifferentElementsPageSelenide extends LogsSelenide {

    //================================single elements===================================

    @FindBy(css = "[class= 'dropdown']")
    private SelenideElement headerServiceButton;

    @FindBy(css = ".colors")
    private SelenideElement colorsDropDownMenu;

    @FindBy(css = ".right-fix-panel")
    private SelenideElement rightSectionElement;

    @FindBy(css = "._mCS_1")
    private SelenideElement leftSectionElement;

    //================================lists of elements===================================

    @FindBy(css = "[class = 'dropdown-menu'] > li")
    private ElementsCollection headerServiceMenuElements;

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkBoxElements;

    @FindBy(css = ".label-radio")
    private ElementsCollection radioButtonElements;

    @FindBy(css = "[class = 'uui-button']")
    private ElementsCollection buttonElements;

    @FindBy(css = "option")
    private ElementsCollection dropDownMenuOptions;

    //================================methods===================================

    public void openPage() {
        clickServiceHeader();
        headerServiceMenuElements.find(text(DIFFERENT.text)).click();
    }

    public void clickServiceHeader() {
        headerServiceButton.click();
    }

    //================================methods selecting elements===================================

    //Method for selecting conditions in checkbox like: Earth, Water, Wind, Fire

    public void selectConditionInCheckbox(CheckBoxConditions element) {
        checkBoxElements.find(text(element.name)).click();
        testLogs.addFirst(element.generateLog(true));
    }

    //Method for unselecting conditions in checkbox like: Earth, Water, Wind, Fire

    public void unselectConditionInCheckbox(CheckBoxConditions element) {
        checkBoxElements.find(text(element.name)).click();
        testLogs.addFirst(element.generateLog(false));
    }

    //Method for selecting values in radiobutton like: Selen, Bronze, Gold, Silver

    public void selectRadioButtonValue(RadioButtonValues element) {
        radioButtonElements.find(text(element.name)).click();
        testLogs.addFirst(element.generateLog());
    }

    //Method for selecting colors in dropdown like: Yellow, Blue, Red, Green

    public void selectColorInDropDown(DropdownColors color) {
        colorsDropDownMenu.click();
        dropDownMenuOptions.find(text(color.name)).click();
        testLogs.addFirst(color.generateLog());
    }

    //================================checks===================================

    public void checkRightSectionDisplayed() {
        rightSectionElement.isDisplayed();
    }

    public void checkLeftSectionDisplayed() {
        leftSectionElement.isDisplayed();
    }

    public void checkMainElementsPresent() {
        checkBoxElements.shouldHave(size(4));
        radioButtonElements.shouldHave(size(4));
        colorsDropDownMenu.shouldBe(visible);
        buttonElements.shouldHave(size(2));
    }

}
