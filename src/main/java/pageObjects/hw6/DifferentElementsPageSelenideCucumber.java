package pageObjects.hw6;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.differenElementsPageEnums.CheckboxConditions;
import enums.differenElementsPageEnums.DropdownColors;
import enums.differenElementsPageEnums.Radiobutton;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.support.FindBy;
import pageObjects.hw4.Base.LogsSelenide;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static enums.differenElementsPageEnums.CheckboxConditions.getCheckboxEnumByName;


public class DifferentElementsPageSelenideCucumber {
    public DifferentElementsPageSelenideCucumber() {
        page(this);
    }

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

    //================================methods selecting elements===================================

    @When("I set following checkboxes to true:")
    public void selectConditionInCheckbox(DataTable dataTable) {
        List<String> expectedConditions = dataTable.asList(String.class);
        for (String condition : expectedConditions) {
            CheckboxConditions element = getCheckboxEnumByName(condition);
            checkBoxElements.find(text(element.name)).click();
            logsSelenide.addLog(element.generateLog(true));
        }
    }

    @When("I set following checkboxes to false:")
    public void unselectConditionInCheckbox(DataTable dataTable) {
        List<String> expectedConditions = dataTable.asList(String.class);
        for (String condition : expectedConditions) {
            CheckboxConditions element = getCheckboxEnumByName(condition);
            checkBoxElements.find(text(element.name)).click();
            logsSelenide.addLog(element.generateLog(false));
        }
    }

    @When("I select (.+) radio-button")
    public void selectRadioButton(String radiobuttonName) {
        Radiobutton element = Radiobutton.getRadioEnumByName(radiobuttonName);
        radioButtonElements.find(text(element.name)).click();
        logsSelenide.addLog(element.generateLog());
    }

    @When("I select (.+) item from the Colors Drop Down menu")
    public void selectColorInDropDown(String colorName) {
        DropdownColors color = DropdownColors.getColorEnumByName(colorName);
        colorsDropDownMenu.click();
        dropDownMenuOptions.find(text(color.name)).click();
        logsSelenide.addLog(color.generateLog());
    }

    //================================checks===================================

    @And("The right section of the page is displayed")
    public void checkRightSectionDisplayed() {
        rightSectionElement.isDisplayed();
    }

    @And("The left section of the page is displayed")
    public void checkLeftSectionDisplayed() {
        leftSectionElement.isDisplayed();
    }

    @And("Interface on Different Elements Page contains all needed elements:")
    public void checkInterfaceOfDifferentElementsPage(DataTable dataTable) {
        Map<String, Integer> expectedTable = dataTable.asMap(String.class, Integer.class);
        checkBoxElements.shouldHave(size(expectedTable.get("Checkboxes")));
        radioButtonElements.shouldHave(size(expectedTable.get("Radios")));
        colorsDropDownMenu.shouldBe(visible);
        buttonElements.shouldHave(size(expectedTable.get("Buttons")));
    }

    @Then("Setting of the following elements properly logged")
    public void checkLogsCorrect() {
        logsSelenide.checkLogsCorrect();
    }
}
