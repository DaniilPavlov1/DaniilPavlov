package enums.mobile.enumsWeb;

import java.util.Arrays;
import java.util.List;

public enum WebSectionsLinks {

    //================================Domain Names links===================================
    ROOT_LINK("Root Zone Management"),
    DATABASE_LINK("Database of Top Level Domains"),
    INT_LINK(".int Registry"),
    ARPA_LINK(".arpa Registry"),
    IDN("IDN Practices Repository"),

    //================================Number Resources links===================================

    NUMBERS_LINK("IP Addresses & AS Numbers"),
    ABUSE_LINK("Network abuse information"),

    //================================Protocol Assignments links===================================

    PROTOCOLS_LINK("Protocol Registries"),
    APPLY_LINK("Apply for an assignment"),
    TIME_ZONES_LINK("Time Zone Database");

    public final String value;

    WebSectionsLinks(String value) {
        this.value = value;
    }

    public static List<String> getAllLinks() {
        return Arrays.asList(ROOT_LINK.value, DATABASE_LINK.value, INT_LINK.value,
                ARPA_LINK.value, IDN.value, NUMBERS_LINK.value, ABUSE_LINK.value,
                PROTOCOLS_LINK.value, APPLY_LINK.value, TIME_ZONES_LINK.value);
    }
}
