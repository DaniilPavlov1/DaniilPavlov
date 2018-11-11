package utils;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class UserTableHelper {

    //================================single elements===================================

    private SelenideElement dropListElements;

    private SelenideElement userTable = $("tbody");

    //================================methods===================================

    private SelenideElement getTableRowByName(String name) {
        return userTable.$(byText(name)).closest("tr");
    }

    public void selectVipCheckBox(String user) {
        getTableRowByName(user).$("input").click();
    }

    public void openTypeDropDown(String user) {
        getTableRowByName(user).$("select").click();
        dropListElements = getTableRowByName(user).$("select");
    }

    public List<String> getDropListContent() {
        return dropListElements.$$("option").texts();
    }

}
