package pageObjects.hw4;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pageObjects.hw4.Base.LogsSelenide;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.datesPageSelenideEnums.Logs.FROM;
import static enums.datesPageSelenideEnums.Logs.TO;


public class DatesPageSelenide extends LogsSelenide {

    //================================single elements===================================

    @FindBy(css = "ul[class~='m-l8'] li.dropdown")
    private SelenideElement serviceDropdown;

    @FindBy(css = "li[class~='open'] a[href = 'dates.html']")
    private SelenideElement datesButton;

    @FindBy(css = "div+[class~='ui-corner-all']")
    private SelenideElement rightSlider;

    @FindBy(css = "[class~='ui-corner-all']:first-child")
    private SelenideElement leftSlider;

    @FindBy(css = "div[class~='uui-slider']")
    private SelenideElement sliderTrack;

    //================================methods===================================

    public void openPage() {
        serviceDropdown.click();
        datesButton.click();
    }

    public void dragAndDropLeftSlider(double to) {
        dragAndDrop(to, leftSlider);
        testLogs.addFirst(FROM.generateLog((int) to));
    }

    public void dragAndDropRightSlider(double to) {
        dragAndDrop(to, rightSlider);
        testLogs.addFirst(TO.generateLog((int) to));
    }

    private void dragAndDrop(double to, SelenideElement slider) {
        //Create example of class Actions
        Actions actions = new Actions(getWebDriver());

        //Get width slider's track
        int size = sliderTrack.getSize().width;

        //Get current position of slider
        double position = Double.parseDouble(slider.getCssValue("left").replaceAll("px", ""));

        //Covert incoming value to pixels and subtract current position
        Double vector = (to / 100) * size - position;

        //Convert Double to Int
        int xOffset = vector.intValue() - 1;

        //Drag slider to required position
        actions.dragAndDropBy(slider, xOffset, 0).perform();
    }
}
