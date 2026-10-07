package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    private final By checkoutButton = By.id("checkout");
    private final By itemName = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getItemName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(itemName)).getText().trim();
    }

    public void clickCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }
}