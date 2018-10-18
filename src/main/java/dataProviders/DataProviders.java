package dataProviders;


import dataForTests.DataForBenefits;
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
                {DataForBenefits.PRACTICE.getClaim(),
                        DataForBenefits.CUSTOM.getClaim(),
                        DataForBenefits.MULTI.getClaim(),
                        DataForBenefits.BASE.getClaim()};
    }
}