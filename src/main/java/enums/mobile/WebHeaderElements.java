package enums.mobile;

import org.openqa.selenium.By;

public enum WebHeaderElements {

    LABEL("h1", ""),
    HEADER_TEXT("header p", "The global coordination of the DNS Root, " +
            "IP addressing, and other Internet protocol resources is performed " +
            "as the Internet Assigned Numbers Authority (IANA) functions. Learn more."),
    HEADER_LINK("header p > a", "Learn more.");

    public final String css;
    public final String value;

    WebHeaderElements(String css, String value) {
        this.css = css;
        this.value = value;
    }

    public By getByCss() {
        return By.cssSelector(css);
    }
}
