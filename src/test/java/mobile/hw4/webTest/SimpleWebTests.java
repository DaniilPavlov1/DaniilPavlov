package mobile.hw4.webTest;

import appiumBase.Hooks;
import enums.mobile.enumsWeb.WebSectionsLinks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

import static enums.mobile.enumsWeb.MainComponents.*;
import static enums.mobile.enumsWeb.PageTitles.IANA_PAGE;
import static enums.mobile.enumsWeb.WebHeaderElements.*;
import static enums.mobile.enumsWeb.WebSections.getSectionTexts;
import static enums.mobile.enumsWeb.WebSections.getSectionsTitles;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test(groups = "web")
public class SimpleWebTests extends Hooks {

    @Test(description = "Open website")
    public void webTest() throws Exception {

        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT + "/"));

        //Check page title
        assertEquals(driver().getTitle(), IANA_PAGE.title);

        //Check that header is displayed
        assertTrue(driver().findElement(FOOTER.getByCss()).isDisplayed());

        //Check that logo is displayed
        assertTrue(driver().findElement(LABEL.getByCss()).isDisplayed());

        //Check that header text is displayed and have proper text
        assertTrue(driver().findElement(HEADER_TEXT.getByCss()).isDisplayed());
        assertEquals(driver().findElement(HEADER_TEXT.getByCss()).getText(), HEADER_TEXT.value);

        //Check that header link is displayed and have proper text
        assertTrue(driver().findElement(HEADER_LINK.getByCss()).isDisplayed());
        assertEquals(driver().findElement(HEADER_LINK.getByCss()).getText(), HEADER_LINK.value);


        //Check that there are 3 sections, they are displayed and have proper content
        List<WebElement> sections = driver().findElements(HOME_PANEL.getByCss());

        assertEquals(sections.size(), 3);
        for (WebElement section : sections) {
            assertTrue(section.isDisplayed());
        }

        int countLinks = 0;
        for (WebElement section : sections) {
            //Check that each section have title
            assertTrue(getSectionsTitles().contains
                    (section.findElement(By.cssSelector("h2 > a")).getText()));

            //Check that each section have text
            assertTrue(getSectionTexts().contains
                    (section.findElement(By.cssSelector("p")).getText()));

            //Check that each section have links
            List<WebElement> links = section.findElements(By.cssSelector("ul a"));
            countLinks += links.size();
            for (WebElement link : links) {
                assertTrue(WebSectionsLinks.getAllLinks().contains(link.getText()));
            }
        }
        assertEquals(countLinks, 10);

        //Check search panel is present
        WebElement searchPanel = driver().findElement(SEARCH_PANEL.getByCss());
        assertTrue(searchPanel.isDisplayed());

        // Check footer is displayed
        WebElement footer = driver().findElement(FOOTER.getByCss());
        assertTrue(footer.isDisplayed());
    }
}
