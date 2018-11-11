package pageObjects.hw6.general.sections;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;

public class LeftSectionCucumber {

    public LeftSectionCucumber() {
        page(this);
    }

//================================collections of elements===================================

    @FindBy(css = "[class = 'sidebar-menu']")
    private ElementsCollection subCategories;

    @FindBy(css = "[class = 'sub'] > li")
    private ElementsCollection leftServiceMenuElements;

    //================================methods===================================

    @When("I click on \"(.+)\" subcategory in left Section")
    public void clickSubcategory(String subcategory) {
        subCategories.find(Condition.text(subcategory)).click();
    }

    //================================checks===================================

    @Then("Left section Service dropdown opens with options:")
    public void checkLeftServiceElements(DataTable dataTable) {
        List<String> expectedOptions = dataTable.asList(String.class);
        for (String options : expectedOptions) {
            assertTrue(leftServiceMenuElements.texts().contains(options));
        }
    }
}
