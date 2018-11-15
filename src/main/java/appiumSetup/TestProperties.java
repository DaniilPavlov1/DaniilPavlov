package appiumSetup;

import enums.mobile.PropertyFile;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    String propertyFile;
    Properties currentProps = new Properties();

    protected void setPropertyFile(PropertyFile propertyFile) {
        this.propertyFile = propertyFile.getFileName();
    }

    Properties getCurrentProps() throws IOException {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(propertyFile))) {
            currentProps.load(in);
        }
        return currentProps;
    }

    protected String getProp(String propKey) throws IOException {
        if (!currentProps.containsKey(propKey)) currentProps = getCurrentProps();
        return currentProps.getProperty(propKey, null);
    }
}
