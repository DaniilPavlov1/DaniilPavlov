package utils.appium;

import appiumSetup.Device;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonReader {

    public static Device getDevice(String path) throws FileNotFoundException {
        JsonObject jDevice = new JsonParser().parse(new FileReader
                (path)).getAsJsonObject();
        return new Gson().fromJson(jDevice, Device.class);
    }
}
