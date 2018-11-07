package enums.jdi;

public enum DataWay {
    JSON_PATH_JDI("src/test/resources/JDI_ex8_metalsColorsDataSet.json");

    public String path;

    DataWay(java.lang.String path) {
        this.path = path;
    }
}
