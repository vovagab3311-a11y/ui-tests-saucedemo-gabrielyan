package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage {

    private final By pageTitle = By.className("title");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartLink = By.className("shopping_cart_link");
    private final By sortDropdown = By.className("product_sort_container");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText().trim();
    }

    public String getCartBadge() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge)).getText().trim();
    }

    public void addBackpackToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addBackpackButton)).click();
    }

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }

    public void selectSort(String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortDropdown));
        new Select(driver.findElement(sortDropdown)).selectByValue(value);
    }
}