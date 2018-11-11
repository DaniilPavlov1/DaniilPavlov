package pageObjects.hw6.general.sections;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;

public class HeaderCucumber {

    public HeaderCucumber() {
        page(this);
    }

//================================collections of elements===================================

    @FindBy(css = "[class $= 'm-l8'] > li")
    private ElementsCollection buttons;

    @FindBy(css = "[class = 'dropdown-menu'] > li")
    private ElementsCollection serviceMenuElements;

    //================================methods===================================

    @And("I click on \"(.+)\" button in Service dropdown")
    public void openPageThroughService(String subcategory) {
        serviceMenuElements.find(Condition.text(subcategory)).click();
    }

    @When("I click on \"(.+)\" button in Header")
    public void clickButton(String buttonName) {
        buttons.find(Condition.text(buttonName)).click();
    }

    //================================checks===================================

    @Then("Header Service dropdown opens with options:")
    public void checkHeaderServiceElements(DataTable dataTable) {
        List<String> expectedOptions = dataTable.asList(String.class);
        for (String option : expectedOptions) {
            assertTrue(serviceMenuElements.texts().contains(option.toUpperCase()));
        }
    }
}
