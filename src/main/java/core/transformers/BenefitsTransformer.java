package core.transformers;

import core.wrappers.WrapperForBenefits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BenefitsTransformer {

    public static List<WrapperForBenefits> wrap(List<WebElement> elements, WebDriver driver) {
        if (elements.isEmpty()) {
            return Collections.<WrapperForBenefits>emptyList();
        }
        List<WrapperForBenefits> bars = new ArrayList<WrapperForBenefits>();
        for (WebElement bar : elements) {
            bars.add(new WrapperForBenefits(bar, driver));
        }
        return bars;
    }
}

