package core.wrappers;

public enum DataForBenefits {
    TEXT1("To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM project"),
    TEXT2("To be flexible and\n" +
            "customizable"),
    TEXT3("To be multiplatform"),
    TEXT4("Already have good base\n" +
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
