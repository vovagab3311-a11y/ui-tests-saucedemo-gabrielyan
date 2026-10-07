package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

@Epic("UI Saucedemo")
@Feature("Checkout")
@Owner("Gabrielyan Vladimir")
public class CheckoutTest extends BaseTest {

    @Test(description = "Оформление заказа")
    @Story("Complete order")
    @Severity(SeverityLevel.BLOCKER)
    public void completeCheckout() {
        new LoginPage(driver).openPage()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();

        InventoryPage inventory = new InventoryPage(driver);
        inventory.addBackpackToCart();
        inventory.goToCart();

        new CartPage(driver).clickCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillForm("Ivan", "Petrov", "123456");
        checkout.finish();

        Assert.assertEquals(checkout.getCompleteHeader(),
                "Thank you for your order!");
    }
}