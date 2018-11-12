package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.differenElementsPageEnums.CheckboxConditions;
import enums.differenElementsPageEnums.DropdownColors;
import enums.differenElementsPageEnums.Radiobutton;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import pageObjects.hw4.Base.LogsSelenide;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static enums.ServiceCategories.DIFFERENT;


public class DifferentElementsPageSelenide {

    private final LogsSelenide logsSelenide = new LogsSelenide();

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

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openPage() {
        clickServiceHeader();
        headerServiceMenuElements.find(text(DIFFERENT.text)).click();
    }

    private void clickServiceHeader() {
        headerServiceButton.click();
    }

    //================================methods selecting elements===================================

    @Step("Select condition {0} in checkbox")
    public void selectConditionInCheckbox(CheckboxConditions element) {
        checkBoxElements.find(text(element.name)).click();
        logsSelenide.addLog(element.generateLog(true));
    }

    @Step("Unselect condition {0} in checkbox")
    public void unselectConditionInCheckbox(CheckboxConditions element) {
        checkBoxElements.find(text(element.name)).click();
        logsSelenide.addLog(element.generateLog(false));
    }

    @Step("Select radio button {0}")
    public void selectRadioButtonValue(Radiobutton element) {
        radioButtonElements.find(text(element.name)).click();
        logsSelenide.addLog(element.generateLog());
    }

    @Step("Select color {0} in dropdown")
    public void selectColorInDropDown(DropdownColors color) {
        colorsDropDownMenu.click();
        dropDownMenuOptions.find(text(color.name)).click();
        logsSelenide.addLog(color.generateLog());
    }

    //================================checks===================================

    @Step("Assert that there is Right Section")
    public void checkRightSectionDisplayed() {
        rightSectionElement.isDisplayed();
    }

    @Step("Assert that there is Left Section")
    public void checkLeftSectionDisplayed() {
        leftSectionElement.isDisplayed();
    }

    @Step("Check Different elements page, that it contains all needed elements")
    public void checkMainElementsPresent() {
        checkBoxElements.shouldHave(size(4));
        radioButtonElements.shouldHave(size(4));
        colorsDropDownMenu.shouldBe(visible);
        buttonElements.shouldHave(size(2));
    }

    @Step("Check that logs ar correct")
    public void checkLogsCorrect() {
        logsSelenide.checkLogsCorrect();
    }
}
