package pageObjects.hw4.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.AssertJUnit.assertEquals;

public class LogsSelenide {

    //Collection for reference logs
    private Deque<String> testLogs = new ArrayDeque<>();

    //================================checks===================================
    public void addLog(String log) {
        testLogs.addFirst(log);
    }

    public void checkLogsCorrect() {
        List<WebElement> logs = getWebDriver().findElements(By.cssSelector("ul[class~='logs'] > li"));

        int i = 0;
        for (String str : testLogs) {
            assertEquals(str, logs.get(i++).getText().replaceAll("[0-2][0-9]:[0-5][0-9]:[0-5][0-9] ", ""));
        }
    }

    public List<String> getActualLogs() {
        List<WebElement> logs = getWebDriver().findElements(By.cssSelector("ul[class~='logs'] > li"));

        List<String> actualLogs = new ArrayList<>();
        int i = 0;
        for (WebElement log : logs) {
            actualLogs.add(logs.get(i++).getText().replaceAll("[0-2][0-9]:[0-5][0-9]:[0-5][0-9] ", ""));
        }
        return actualLogs;
    }
}
