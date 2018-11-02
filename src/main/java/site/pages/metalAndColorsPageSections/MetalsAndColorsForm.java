package site.pages.metalAndColorsPageSections;

import com.epam.jdi.uitests.core.interfaces.complex.ICheckList;
import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import enums.jdi.ColorsList;
import enums.jdi.MetalsList;
import enums.jdi.Nature;
import enums.jdi.VegetablesList;
import jsonPojo.TestData;
import org.openqa.selenium.support.FindBy;
import site.sections.Summary;

import java.util.List;

import static enums.jdi.DefaultDropDownValues.DEFAULT_VEGETABLES;

public class MetalsAndColorsForm extends Form<TestData> {

    //=======================================WEB-ELEMENTS AND CONSTANTS=================================================

    @FindBy(id = "summary-block")
    private Summary summary;

    @JDropdown(
            jroot = @JFindBy(css = ".colors"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".filter-option"))
    private IDropDown<ColorsList> colors;

    @JDropdown(
            jroot = @JFindBy(css = ".metals"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".filter-option"),
            jexpand = @JFindBy(css = ".caret"))
    private IDropDown<MetalsList> metals;

    @JDropdown(
            root = @FindBy(id = "salad-dropdown"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button")
    )
    private IDropDown<VegetablesList> vegetables;

    @FindBy(css = "#elements-checklist p")
    private ICheckList<Nature> nature = new CheckList<Nature>();

    @FindBy(id = "submit-button")
    private Button submitBtn;


    //==============================================================ACTIONS==============================================

    public void fill(TestData entity) {
        selectSummary(entity.getSummaryOdd(), entity.getSummaryEven());
        selectElements(entity.getElements());
        selectColor(entity.getColor());
        selectMetal(entity.getMetal());
        selectVegetables(entity.getVegetables());
    }

    private void selectVegetables(List<String> salad) {
        if (!salad.contains(DEFAULT_VEGETABLES.value)) {
            vegetables.select(DEFAULT_VEGETABLES.value);
        }
        for (String vegetable : salad) {
            if (vegetable.equals(DEFAULT_VEGETABLES.value)) continue;
            vegetables.select(vegetable);
        }
    }

    private void selectSummary(int... summaryRadios) {
        for (int radio : summaryRadios) {
            summary.select(radio);
        }
    }

    private void selectElements(String... elements) {
        for (String elem : elements) {
            nature.select(elem);
        }
    }

    private void selectColor(String color) {
        colors.select(color);
    }

    private void selectMetal(String metal) {
        metals.select(metal);
    }

    public void submit() {
        submitBtn.click();
    }


}
