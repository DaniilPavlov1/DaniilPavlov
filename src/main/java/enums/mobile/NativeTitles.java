package enums.mobile;

import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

public enum NativeTitles {

    //================================titles===================================

    TARGET_ACCOUNT_TITLE("Target Account", "Target Account"),
    CONTACT_NAME_TITLE("Contact Name", "Contact Name"),
    CONTACT_PHONE_TITLE("Contact Phone", "Contact Phone"),
    CONTACT_EMAIL_TITLE("Contact Email", "Contact Email"),
    ADD_CONTACT_TITLE("android:id/title", "Add Contact");

    public final String id;
    public final String value;

    NativeTitles(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public By getId() {
        return By.id(id);
    }

    public static List<By> getListId() {
        return Arrays.asList(TARGET_ACCOUNT_TITLE.getId(),
                CONTACT_NAME_TITLE.getId(),
                CONTACT_PHONE_TITLE.getId(),
                CONTACT_EMAIL_TITLE.getId());
    }

    public static List<String> getListValues() {
        return Arrays.asList(TARGET_ACCOUNT_TITLE.value,
                CONTACT_NAME_TITLE.value,
                CONTACT_PHONE_TITLE.value,
                CONTACT_EMAIL_TITLE.value);
    }
}
