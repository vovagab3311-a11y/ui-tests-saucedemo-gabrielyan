package pages;

import io.qameta.allure.Step;
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

    @Step("Получить заголовок страницы")
    public String getPageTitle() {
        return el(pageTitle).getText().trim();
    }

    @Step("Получить счётчик корзины")
    public String getCartBadge() {
        return el(cartBadge).getText().trim();
    }

    @Step("Добавить Sauce Labs Backpack в корзину")
    public void addBackpackToCart() {
        click(addBackpackButton);
    }

    @Step("Перейти в корзину")
    public void goToCart() {
        click(cartLink);
    }

    @Step("Выбрать сортировку: {value}")
    public void selectSort(String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortDropdown));
        new Select(driver.findElement(sortDropdown)).selectByValue(value);
    }
}