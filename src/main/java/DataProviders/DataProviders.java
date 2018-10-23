package dataProviders;


import enums.mainPageEnums.Benefits;
import org.testng.annotations.DataProvider;

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
}