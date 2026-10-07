package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FooterPage;
import pages.LoginPage;

@Epic("UI Saucedemo")
@Feature("Footer")
@Owner("Gabrielyan Vladimir")
public class FooterTest extends BaseTest {

    @Test(description = "Проверить, что иконки соцсетей видны на странице Products")
    @Story("Social links")
    @Severity(SeverityLevel.MINOR)
    public void shouldShowSocialLinks() {
        new LoginPage(driver).openPage()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();

        FooterPage footer = new FooterPage(driver);
        Assert.assertTrue(footer.areSocialLinksVisible(),
                "Все иконки соцсетей должны быть видны");
    }
}