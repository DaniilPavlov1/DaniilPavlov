package enums.mainPageEnums;

import java.util.Arrays;
import java.util.List;

public enum Benefits {
    PRACTICE("To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM project"),
    CUSTOM("To be flexible and\n" +
            "customizable"),
    MULTI("To be multiplatform"),
    BASE("Already have good base\n" +
            "(about 20 internal and\n" +
            "some external projects),\n" +
            "wish to get more…");

    public final String text;

    Benefits(String text) {
        this.text = text;
    }

    public static List<String> getList() {
        String[] texts = {
                BASE.text,
                CUSTOM.text,
                MULTI.text,
                PRACTICE.text
        };
        List<String> content = Arrays.asList(texts);
        return content;
    }
}
