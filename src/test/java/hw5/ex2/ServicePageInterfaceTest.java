package hw5.ex2;

import base.SelenideTestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.hw4.DifferentElementsPageSelenide;
import pageObjects.hw4.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.differenElementsPageEnums.CheckboxConditions.WATER;
import static enums.differenElementsPageEnums.CheckboxConditions.WIND;
import static enums.differenElementsPageEnums.DropdownColors.YELLOW;
import static enums.differenElementsPageEnums.Radiobutton.SELEN;

@Feature("UI Tests")
@Story("Service Page Testing")
@Listeners(AllureAttachmentListener.class)
public class ServicePageInterfaceTest extends SelenideTestBase {

    private HomePageSelenide homePageSelenide;
    private DifferentElementsPageSelenide differentElementsPageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
        differentElementsPageSelenide = page(DifferentElementsPageSelenide.class);

    }

    @Test
    public void ServicePageInterfaceTest1() {

        //1 Open test site by URL
        homePageSelenide.openPage();

        //2 Assert Browser title
        homePageSelenide.checkTitle();

        //3 Perform login
        homePageSelenide.login();

        //4 Assert User name in the left-top side of screen that user is logged
        homePageSelenide.checkUserLoggedIn();

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        homePageSelenide.clickServiceHeader();
        homePageSelenide.checkHeaderServiceElements();

        //6 Click on Service subcategory in the left section and check that drop down contains options
        homePageSelenide.clickOnLeftSelect();
        homePageSelenide.checkLeftServiceElements();

        //7 Open through the header menu Service -> Different Elements Page
        differentElementsPageSelenide.openPage();

        //8 Check interface on Different elements page, it contains all needed elements
        differentElementsPageSelenide.checkMainElementsPresent();

        //9 Assert that there is Right Section
        differentElementsPageSelenide.checkRightSectionDisplayed();

        //10 Assert that there is Left Section
        differentElementsPageSelenide.checkLeftSectionDisplayed();

        //11 Select checkboxes
        differentElementsPageSelenide.selectConditionInCheckbox(WATER);
        differentElementsPageSelenide.selectConditionInCheckbox(WIND);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        differentElementsPageSelenide.checkLogsCorrect();

        //13 Select radio Selen
        differentElementsPageSelenide.selectRadioButtonValue(SELEN);

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        differentElementsPageSelenide.checkLogsCorrect();

        //15 Select in dropdown Yellow
        differentElementsPageSelenide.selectColorInDropDown(YELLOW);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        differentElementsPageSelenide.checkLogsCorrect();

        //17 Unselect and assert checkboxes
        differentElementsPageSelenide.unselectConditionInCheckbox(WATER);
        differentElementsPageSelenide.unselectConditionInCheckbox(WIND);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPageSelenide.checkLogsCorrect();
    }
}
