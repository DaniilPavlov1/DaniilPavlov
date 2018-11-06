package dataProviders;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import enums.mainPageEnums.Benefits;
import jsonPojo.TestData;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;

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
        JsonObject jDataSet = new JsonParser().parse(new FileReader
                ("src/test/resources/JDI_ex8_metalsColorsDataSet.json")).getAsJsonObject();
        Object[][] result = new Object[jDataSet.size()][1];
        int i = 0;
        for (String key : jDataSet.keySet()) {
            result[i++][0] = gson.fromJson(jDataSet.get(key), TestData.class);
        }
        return result;
    }
}