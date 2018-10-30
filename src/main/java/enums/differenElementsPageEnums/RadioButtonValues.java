package enums.differenElementsPageEnums;

public enum RadioButtonValues {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    public final String name;
    private final String mainPart = ": condition changed to true";

    RadioButtonValues(String name) {
        this.name = name;
    }

    public String generateLog() {
        return "metal: value changed to " + name;
    }

}

