package enums.differenElementsPageEnums;

public enum Radiobutton {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    public final String name;
    private final String mainPart = ": condition changed to true";

    Radiobutton(String name) {
        this.name = name;
    }

    public String generateLog() {
        return "metal: value changed to " + name;
    }

    public static Radiobutton getRadioEnumByName(String radiobuttonName) {
        if (radiobuttonName.equals(GOLD.name)) {
            return GOLD;
        }
        if (radiobuttonName.equals(SILVER.name)) {
            return SILVER;
        }
        if (radiobuttonName.equals(BRONZE.name)) {
            return BRONZE;
        }
        if (radiobuttonName.equals(SELEN.name)) {
            return SELEN;
        } else {
            throw new UnsupportedOperationException("Radiobutton with such name " + radiobuttonName + " not found!");
        }
    }
}

