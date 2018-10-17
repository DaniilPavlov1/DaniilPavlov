package DataProviders;


import DataForTests.DataForBenefits;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    public Object[][] simpleDataProvider() {
        return new Object[][] {
                {"String1", 1},
                {"String2", 2},
                {"String3", 3}
        };
    }

    @DataProvider(parallel = true)
    public Object[][] benefitsDataProvider() {
        return new Object[][]{
                {"practise", DataForBenefits.PRACTICE.getClaim()},
                {"custom",DataForBenefits.CUSTOM.getClaim()},
                {"multi",DataForBenefits.MULTI.getClaim()},
                {"base",DataForBenefits.BASE.getClaim()}
        };
    }
}
