package enums.jdi;

import java.util.List;

public enum Fields {
    ELEMENTS("Elements: %s"),
    SUMMARY("Summary: %s"),
    COLOR("Color: %s"),
    METAL("Metal: %s"),
    VEGETABLES("Vegetables: %s");

    public String mask;

    Fields(String mask) {
        this.mask = mask;
    }

    public String getFields(String[] text) {
        return String.format(mask, String.join(", ", text));
    }

    public String getFields(List<String> text) {
        return String.format(mask, String.join(", ", text));
    }

    public String getField(String text) {
        return String.format(mask, text);
    }
}
