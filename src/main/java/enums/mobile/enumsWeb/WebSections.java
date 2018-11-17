package enums.mobile.enumsWeb;

import java.util.Arrays;
import java.util.List;

public enum WebSections {

    TITLE1("Domain Names"),
    TITLE2("Number Resources"),
    TITLE3("Protocol Assignments"),

    SECTION_TEXT1("Management of the DNS Root Zone (assignments of ccTLDs and gTLDs) " +
            "along with other functions such as the .int and .arpa zones."),
    SECTION_TEXT2("Coordination of the global IP and AS number spaces, " +
            "such as allocations made to Regional Internet Registries."),
    SECTION_TEXT3("The central repository for protocol name " +
            "and number registries used in many Internet protocols.");

    public String value;

    WebSections(String value) {
        this.value = value;
    }

    public static List<String> getSectionsTitles() {
        return Arrays.asList(TITLE1.value, TITLE2.value, TITLE3.value);
    }

    public static List<String> getSectionTexts() {
        return Arrays.asList(SECTION_TEXT1.value, SECTION_TEXT2.value, SECTION_TEXT3.value);
    }
}
