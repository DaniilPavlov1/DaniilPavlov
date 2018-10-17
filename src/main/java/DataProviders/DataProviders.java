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
                {".//div[child::span[contains(@class, 'practise')]]", DataForBenefits.PRACTICE.getClaim()},
                {".//div[child::span[contains(@class, 'custom')]]",DataForBenefits.CUSTOM.getClaim()},
                {".//div[child::span[contains(@class, 'multi')]]",DataForBenefits.MULTI.getClaim()},
                {".//div[child::span[contains(@class, 'base')]]",DataForBenefits.BASE.getClaim()}
        };
    }
}
