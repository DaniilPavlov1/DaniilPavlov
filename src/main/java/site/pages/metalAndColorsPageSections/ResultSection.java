package site.pages.metalAndColorsPageSections;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class ResultSection extends Section {


    //=======================================WEB-ELEMENTS=================================================
    @FindBy(css = "li")
    public TextList resultsList;

}
