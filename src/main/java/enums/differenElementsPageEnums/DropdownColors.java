package enums.differenElementsPageEnums;

public enum DropdownColors {
    YELLOW("Yellow"),
    BLUE("Blue"),
    GREEN("Green"),
    RED("Red");

    public final String name;

    DropdownColors(String name) {
        this.name = name;
    }

    public String generateLog() {
        return "Colors: value changed to " + name;
    }

    public static DropdownColors getColorEnumByName(String colorName) {
        if (colorName.equals(YELLOW.name)) {
            return YELLOW;
        }
        if (colorName.equals(BLUE.name)) {
            return BLUE;
        }
        if (colorName.equals(GREEN.name)) {
            return GREEN;
        }
        if (colorName.equals(RED.name)) {
            return RED;
        } else {
            throw new UnsupportedOperationException("Dropdown with such name " + colorName + " not found!");
        }
    }
}
