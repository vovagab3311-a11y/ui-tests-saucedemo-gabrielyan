package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

@Epic("UI Saucedemo")
@Feature("Cart")
@Owner("Gabrielyan Vladimir")
public class CartTest extends BaseTest {

    @Test(description = "Добавление товара в корзину")
    @Story("Add to cart")
    @Severity(SeverityLevel.CRITICAL)
    public void addToCart() {
        new LoginPage(driver).openPage()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();

        InventoryPage inventory = new InventoryPage(driver);
        Assert.assertEquals(inventory.getPageTitle(), "Products");

        inventory.addBackpackToCart();
        Assert.assertEquals(inventory.getCartBadge(), "1");

        inventory.goToCart();
        Assert.assertEquals(new CartPage(driver).getItemName(), "Sauce Labs Backpack");
    }
}