package enums.mobile.enumsWeb;

import org.openqa.selenium.By;

public enum MainComponents {

    HEADER("header"),
    FOOTER("footer"),
    SEARCH_PANEL("#home-panel-search"),
    HOME_PANEL(".home-panel");

    public final String css;

    MainComponents(String css) {
        this.css = css;
    }

    public By getByCss() {
        return By.cssSelector(css);
    }
}
