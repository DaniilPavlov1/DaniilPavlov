package DataForTests;

public enum DataForBenefits {
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

    private final String claim;

    DataForBenefits(String claim) {
        this.claim = claim;
    }

    public String getClaim() {
        return claim;
    }
}
