package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.Selector;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import enums.jdi.Even;
import enums.jdi.Odds;
import org.openqa.selenium.support.FindBy;

public class Summary extends Section {
    @FindBy(css = "#odds-selector p")
    public Selector<Odds> odds;
    @FindBy(css = "#even-selector p")
    public Selector<Even> even;

    public void select(int radio) {
        if (radio % 2 == 0) {
            even.select(String.valueOf(radio));
        } else {
            odds.select(String.valueOf(radio));
        }
    }
}