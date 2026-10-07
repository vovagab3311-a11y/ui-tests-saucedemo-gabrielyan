package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

@Epic("UI Saucedemo")
@Feature("Login")
@Owner("Gabrielyan Vladimir")
public class LoginTest extends BaseTest {

    @Test(description = "Позитивный вход standard_user")
    @Story("Positive login")
    @Severity(SeverityLevel.CRITICAL)
    public void positiveLogin() {
        new LoginPage(driver).openPage()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();

        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"),
                "URL должен содержать /inventory.html. Фактически: " + driver.getCurrentUrl());
    }

    @Test(description = "Негативный вход locked_out_user")
    @Story("Negative login")
    @Severity(SeverityLevel.NORMAL)
    public void negativeLoginLockedUser() {
        LoginPage page = new LoginPage(driver).openPage()
                .enterUsername("locked_out_user")
                .enterPassword("secret_sauce");
        page.clickLogin();

        String error = page.getErrorMessage();
        Assert.assertTrue(error.contains("Sorry, this user has been locked out"),
                "Ожидалось сообщение о блокировке. Фактически: " + error);
    }
}