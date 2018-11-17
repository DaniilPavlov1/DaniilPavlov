package enums.mobile;

//this enum helps us to avoid hardcode
public enum PropertyFile {

    NATIVE("nativeTests"),
    WEB("webTests");

    private String currentAppType;
    private String path = "src/main/resources/mobile/";

    PropertyFile(String current) {
        this.currentAppType = current;
    }

    // Method return property file name
    public String getFileName() {
        return path + currentAppType + ".properties";
    }
}