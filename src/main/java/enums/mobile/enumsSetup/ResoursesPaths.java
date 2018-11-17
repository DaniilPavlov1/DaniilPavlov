package enums.mobile.enumsSetup;

public enum ResoursesPaths {
    PATH_TO_RESOURCES("./src/main/resources/mobile"),
    HTTPS_PREFIX("https://");

    public String value;

    ResoursesPaths(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
