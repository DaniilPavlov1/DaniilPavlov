package dataProviders;


import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import enums.mainPageEnums.Benefits;
import jsonPojo.TestData;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static enums.jdi.DataWay.JSON_PATH_JDI;

public class DataProviders {

    @DataProvider
    public Object[][] simpleDataProvider() {
        return new Object[][]{
                {"String1", 1},
                {"String2", 2},
                {"String3", 3}
        };
    }

    @DataProvider(parallel = true)
    public Object[] benefitsDataProvider() {
        return new Object[]
                {Benefits.PRACTICE.text,
                        Benefits.CUSTOM.text,
                        Benefits.MULTI.text,
                        Benefits.BASE.text};
    }

    @DataProvider
    public Object[][] checkMetalsAndColorsPageDataProvider() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonElement jsonData = new JsonParser().parse(new FileReader(JSON_PATH_JDI.path));
        JsonObject dataSet = jsonData.getAsJsonObject();
        List<TestData> testData = new ArrayList<>();
        for (String key : dataSet.keySet()) {
            testData.add(gson.fromJson(dataSet.get(key), new TypeToken<TestData>() {
            }.getType()));
        }
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }
}