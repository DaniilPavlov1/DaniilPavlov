package utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DragAndDrop {

    public static void dragAndDrop(double to, SelenideElement slider, SelenideElement sliderTrack) {
        Actions actions = new Actions(getWebDriver());
        int size = sliderTrack.getSize().width;
        double position = Double.parseDouble(slider.getCssValue("left").replaceAll("px", ""));
        Double vector = (to / 100) * size - position;
        int xOffset = vector.intValue() - 1;
        actions.dragAndDropBy(slider, xOffset, 0).perform();
    }

}
