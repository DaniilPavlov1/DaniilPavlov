package enums.mobile;

import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

public enum NativeElements {

    //================================buttons===================================

    ADD_BTN("addContactButton"),
    SAVE_BTN("contactSaveButton"),

    //================================spinners===================================

    TARGET_ACCOUNT_SPINNER("accountSpinner"),
    CONTACT_PHONE_TYPE_SPINNER("contactPhoneTypeSpinner"),
    CONTACT_EMAIL_TYPE_SPINNER("contactEmailTypeSpinner"),

    //================================fields===================================
    CONTACT_NAME_FIELD("contactNameEditText"),
    CONTACT_PHONE_FIELD("contactPhoneEditText"),
    CONTACT_EMAIL_FIELD("contactEmailEditText");

    public final String id;

    NativeElements(String id) {
        this.id = id;
    }

    public By getId() {
        String app_package_name = "com.example.android.contactmanager:id/";
        return By.id(app_package_name + id);
    }

    public static List<By> getFieldsIdList() {
        return Arrays.asList(CONTACT_NAME_FIELD.getId(),
                CONTACT_PHONE_FIELD.getId(),
                CONTACT_EMAIL_FIELD.getId());
    }

    public static List<By> getSpinnersIdList() {
        return Arrays.asList(TARGET_ACCOUNT_SPINNER.getId(),
                CONTACT_PHONE_TYPE_SPINNER.getId(),
                CONTACT_EMAIL_TYPE_SPINNER.getId());
    }
}
