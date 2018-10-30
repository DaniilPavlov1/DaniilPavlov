package enums.differenElementsPageEnums;

public enum CheckBoxConditions {
    WATER("Water"),
    WIND("Wind"),
    EARTH("Earth"),
    FIRE("Fire");

    public final String name;
    private final String mainPart = ": condition changed to true";

    CheckBoxConditions(String name) {
        this.name = name;
    }

    public String generateLog(boolean status) {
        return name + ": condition changed to " + status;
    }

}

