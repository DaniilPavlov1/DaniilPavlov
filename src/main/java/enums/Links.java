package enums;

public enum Links {
    SUB_HEADER_LINK_URL("https://github.com/epam/JDI", "JDI GITHUB");

    public final String url;
    public final String text;

    Links(String url, String text) {
        this.url = url;
        this.text = text;
    }
}
