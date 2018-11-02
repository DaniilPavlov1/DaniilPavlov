package site.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.support.FindBy;
import site.pages.metalAndColorsPageSections.MetalsAndColorsForm;
import site.pages.metalAndColorsPageSections.ResultSection;

@JPage(url = "/metals-colors.html", title = "Metal and Colors")
public class MetalAndColorsPageJdi extends WebPage {


    //=======================================WEB-ELEMENTS=================================================
    @FindBy(css = ".results")
    public ResultSection results;

    @FindBy(css = ".form")
    public MetalsAndColorsForm metalsAndColorsForm;

}

