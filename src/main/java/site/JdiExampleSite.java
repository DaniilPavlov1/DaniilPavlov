package site;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import com.epam.web.matcher.junit.Assert;
import entities.User;
import ru.yandex.qatools.allure.annotations.Step;
import site.pages.HomePageJdi;
import site.pages.MetalAndColorsPageJdi;
import site.sections.HeaderMenu;
import site.sections.LoginForm;

@JSite("https://epam.github.io/JDI/")
public class JdiExampleSite extends WebSite {
    public static HomePageJdi homePage;
    public static MetalAndColorsPageJdi metalAndColorsPage;

    public static LoginForm loginForm;
    public static HeaderMenu headerMenu;


    @Step
    public static void login(User user) {
        headerMenu.profilePhoto.click();
        loginForm.loginAs(user);
    }

    @Step
    public static void checkLoggedInUserName(User user) {
        Assert.areEquals(headerMenu.loggedUserName.getText(), user.getDisplayedName());
    }

    @Step
    public static void openMetalAndColorsPageByHeader() {
        headerMenu.navigation.clickOn("Metals & Colors");
    }
}
