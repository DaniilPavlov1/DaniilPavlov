package enums.datesPageSelenideEnums;

public enum Logs {
    TO("To"),
    FROM("From");

    public final String text;

    Logs(String text) {
        this.text = text;
    }

    public String generateLog(int to) {
        return "Range 2(" + text + "):" + to + " link clicked";
    }
}
