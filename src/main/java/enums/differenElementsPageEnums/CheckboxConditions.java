package enums.differenElementsPageEnums;

public enum CheckboxConditions {
    WATER("Water"),
    WIND("Wind"),
    EARTH("Earth"),
    SPIRIT("Spirit"),
    FIRE("Fire");

    public final String name;
    private final String mainPart = ": condition changed to true";

    CheckboxConditions(String name) {
        this.name = name;
    }

    public String generateLog(boolean status) {
        return name + ": condition changed to " + status;
    }

    public static CheckboxConditions getCheckboxEnumByName(String conditionName) {
        if (conditionName.equals(WATER.name)) {
            return WATER;
        }
        if (conditionName.equals(WIND.name)) {
            return WIND;
        }
        if (conditionName.equals(EARTH.name)) {
            return EARTH;
        }
        if (conditionName.equals(FIRE.name)) {
            return FIRE;
        } else {
            throw new UnsupportedOperationException("Condition with such name " + conditionName + " not found!");
        }
    }

}

