package pageObjects.hw4;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pageObjects.hw4.Base.LogsSelenide;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.datesPageSelenideEnums.Logs.FROM;
import static enums.datesPageSelenideEnums.Logs.TO;


public class DatesPageSelenide {

    private final LogsSelenide logsSelenide = new LogsSelenide();

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

    @Step("Open through the header menu Service -> Dates Page")
    public void openPage() {
        serviceDropdown.click();
        datesButton.click();
    }

    @Step("Drag and drop left slider to {0}")
    public void dragAndDropLeftSlider(double to) {
        dragAndDrop(to, leftSlider);
        logsSelenide.addLog(FROM.generateLog((int) to));
    }

    @Step("Drag and drop right slider to {0}")
    public void dragAndDropRightSlider(double to) {
        dragAndDrop(to, rightSlider);
        logsSelenide.addLog(TO.generateLog((int) to));
    }

    private void dragAndDrop(double to, SelenideElement slider) {
        Actions actions = new Actions(getWebDriver());
        int size = sliderTrack.getSize().width;
        double position = Double.parseDouble(slider.getCssValue("left").replaceAll("px", ""));
        Double vector = (to / 100) * size - position;
        int xOffset = vector.intValue() - 1;
        actions.dragAndDropBy(slider, xOffset, 0).perform();
    }

    @Step("Check that logs ar correct")
    public void checkLogsCorrect() {
        logsSelenide.checkLogsCorrect();
    }
}
