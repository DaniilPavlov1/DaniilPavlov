package enums;

import java.util.Arrays;
import java.util.List;

public enum ServiceCategories {
    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX("Complex Table"),
    SIMPLE("Simple Table"),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT("Different elements");

    public final String text;

    ServiceCategories(String text) {
        this.text = text;
    }

    public static List<String> getList() {
        String[] texts = {
                SUPPORT.text,
                DATES.text,
                SIMPLE.text,
                COMPLEX.text,
                TABLE_WITH_PAGES.text,
                DIFFERENT.text
        };
        List<String> content = Arrays.asList(texts);
        return content;
    }

}
