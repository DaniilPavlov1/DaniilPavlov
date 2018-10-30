package hw4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DifferentElementsPageSelenide;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHALOVSKII;
import static enums.differenElementsPageEnums.CheckBoxConditions.WATER;
import static enums.differenElementsPageEnums.CheckBoxConditions.WIND;
import static enums.differenElementsPageEnums.DropdownColors.YELLOW;
import static enums.differenElementsPageEnums.RadioButtonValues.SELEN;


public class ServicePageInterfaceTestSuit extends SelenideTestBase {
    private HomePageSelenide homePageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
    }

    @Test
    public void ServicePageInterfaceTest() {

        //1 Open test site by URL
        homePageSelenide.openPage();

        //2 Assert Browser title
        homePageSelenide.checkTitle();

        //3 Perform login
        homePageSelenide.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePageSelenide.checkUserLoggedIn();

        //5 Click on "Service" subcategory in the header and check that drop down contains options

        //5.1 Click
        homePageSelenide.clickServiceHeader();

        //5.2 Check
        homePageSelenide.checkHeaderServiceElements();

        //6 Click on Service subcategory in the left section and check that drop down contains options

        //6.1 Click
        homePageSelenide.clickOnLeftSelect();

        //6.2 Check
        homePageSelenide.checkLeftServiceElements();

        //7 Open through the header menu Service -> Different Elements Page

        //7.1 Create instance of page
        DifferentElementsPageSelenide differentElementsPageSelenide = page(DifferentElementsPageSelenide.class);

        //7.2 Open page
        differentElementsPageSelenide.openPage();

        //8 Check interface on Different elements page, it contains all needed elements
        differentElementsPageSelenide.checkMainElementsPresent();

        //9 Assert that there is Right Section
        differentElementsPageSelenide.checkRightSectionDisplayed();

        //10 Assert that there is Left Section
        differentElementsPageSelenide.checkLeftSectionDisplayed();

        //11 Select checkboxes

        //11.1 Select Water
        differentElementsPageSelenide.selectConditionInCheckbox(WATER);

        //11.2 Select Wind
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

        //17.1 Water
        differentElementsPageSelenide.unselectConditionInCheckbox(WATER);

        //17.2 Wind
        differentElementsPageSelenide.unselectConditionInCheckbox(WIND);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPageSelenide.checkLogsCorrect();
    }
}
