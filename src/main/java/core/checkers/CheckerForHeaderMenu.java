package core.checkers;

import core.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class CheckerForHeaderMenu extends HelperBase {

    private HashMap<String, Boolean> mapOfElems = new HashMap<String, Boolean>();

    { mapOfElems.put( "HOME", false);
        mapOfElems.put( "CONTACT FORM", false);
        mapOfElems.put( "SERVICE", false);
        mapOfElems.put( "METALS & COLORS", false);
    }

    public CheckerForHeaderMenu(WebDriver driver) {
        super(driver);
    }

    public void checkElements(){

        List<WebElement> list = driver.findElements(By.xpath(".//header//ul[contains(@class,'m-l8')]/li"));
        for(WebElement i : list){
            if (mapOfElems.containsKey(i.getText()) && i.isDisplayed()) {mapOfElems.put(i.getText(), true);}
        }
        if (!mapOfElems.get("HOME")) {throw new IllegalArgumentException("From MainPage - Page element HOME not found!");}
        if (!mapOfElems.get("CONTACT FORM")) {throw new IllegalArgumentException("From MainPage - Page element CONTACT FORM not found!");}
        if (!mapOfElems.get("SERVICE")) {throw new IllegalArgumentException("From MainPage - Page element SERVICE not found!");}
        if (!mapOfElems.get("METALS & COLORS")) {throw new IllegalArgumentException("From MainPage - Page element METALS & COLORS not found!");}
    }

    protected void check() {

    }
}
