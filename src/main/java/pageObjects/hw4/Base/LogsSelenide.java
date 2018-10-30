package pageObjects.hw4.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.AssertJUnit.assertEquals;

public class LogsSelenide {

    //Collection for reference logs
    private Deque<String> testLogs = new ArrayDeque<>();

    //================================checks===================================
    public void addLog(String log){
        testLogs.addFirst(log);
    }

    public void checkLogsCorrect() {
        //Get list with logs on the page
        List<WebElement> logs = getWebDriver().findElements(By.cssSelector("ul[class~='logs'] > li"));

        //Check logs with reference logs in cicle
        int i = 0;
        for (String str : testLogs) {
            assertEquals(str, logs.get(i++).getText().replaceAll("[0-2][0-9]:[0-5][0-9]:[0-5][0-9] ", ""));
        }
    }
}
