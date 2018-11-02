package utils;

import com.epam.web.matcher.testng.Assert;
import jsonPojo.TestData;

import java.util.Arrays;
import java.util.List;

import static enums.jdi.Fields.*;
import static site.JdiExampleSite.metalAndColorsPage;

public class MetalAndColorPageResultsChecker {

    //==============================================ACTIONS=============================================================
    private static List<String> getActual() {
        return metalAndColorsPage.results.resultsList.getTextList();
    }

    private static List<String> getExpected(TestData data) {
        String summaryRow = SUMMARY.getField(String.valueOf(data.getSummaryOdd() + data.getSummaryEven()));
        String elementsRow = ELEMENTS.getFields(data.getElements());
        String vegetablesRow = VEGETABLES.getFields(data.getVegetables());
        String colorRow = COLOR.getField(data.getColor());
        String metalRow = METAL.getField(data.getMetal());
        return Arrays.asList(summaryRow, elementsRow, colorRow, metalRow, vegetablesRow);
    }

    public static void checkResult(TestData data) {
        Assert.assertEquals(getActual(), getExpected(data));
    }
}
