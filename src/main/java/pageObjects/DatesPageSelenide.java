package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.AssertJUnit.assertEquals;


public class DatesPageSelenide {

    private Deque<String> testLogs = new ArrayDeque<>();


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

    //================================lists of elements===================================

//    @FindBy(css = "ul[class~='logs'] > li")
//    private ArrayList<SelenideElement> logs;

    //================================methods===================================

    @Step("5 - Open through the header menu Service -> Dates Page")
    public void openPage() {
        serviceDropdown.click();
        datesButton.click();
    }

    public void dragAndDropLeftSlider(double to) {
        dragAndDrop(to, leftSlider);

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        testLogs.addFirst(formatter.format(date) + " Range 2(From):" + (int) to + " link clicked");
    }

    public void dragAndDropRightSlider(double to) {
        dragAndDrop(to, rightSlider);

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        testLogs.addFirst(formatter.format(date) + " Range 2(To):" + (int) to + " link clicked");
    }

    private void dragAndDrop(double to, SelenideElement slider) {

        //Create example of class Actions
        Actions actions = new Actions(getWebDriver());

        //Get width slider's track
        int size = sliderTrack.getSize().width;

        //Get current position of slider
        double position = Integer.parseInt(slider.getCssValue("left").replaceAll("px", ""));

        //Covert incoming value to pixels and subtract current position
        Double vector = (to / 100) * size - position;

        //Convert Double to Int
        int xOffset = vector.intValue() - 1;

        //Drag slider to required position
        actions.dragAndDropBy(slider, xOffset, 0).perform();


    }

    //================================checks===================================

    @Step("7 - Assert that for \"From\" and \"To\" sliders there are logs rows with corresponding values")
    public void checkLogsCorrect() {
        int i = 0;
        List<WebElement> logs = getWebDriver().findElements(By.cssSelector("ul[class~='logs'] > li"));
        for (String str : testLogs) {
            assertEquals(str, logs.get(i++).getText());
        }
    }
}
