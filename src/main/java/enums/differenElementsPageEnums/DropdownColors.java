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
}
