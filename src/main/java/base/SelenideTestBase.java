package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class SelenideTestBase {

    @BeforeSuite
    public void deforSuite() {
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
    }
}
