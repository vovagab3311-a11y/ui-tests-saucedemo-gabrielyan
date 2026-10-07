package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By checkoutButton = By.id("checkout");
    private final By itemName = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получить название товара в корзине")
    public String getItemName() {
        return el(itemName).getText().trim();
    }

    @Step("Нажать Checkout")
    public void clickCheckout() {
        click(checkoutButton);
    }
}