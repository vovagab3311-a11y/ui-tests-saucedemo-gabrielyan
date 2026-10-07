package tests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

import java.util.List;
import java.util.stream.Collectors;

@Epic("UI Saucedemo")
@Feature("Sorting")
@Owner("Gabrielyan Vladimir")
public class SortTest extends BaseTest {

    @Test(description = "Сортировка A → Z")
    @Story("Sort A→Z")
    @Severity(SeverityLevel.NORMAL)
    public void sortByNameAToZ() {
        new LoginPage(driver).openPage()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();

        new InventoryPage(driver).selectSort("az");

        List<String> names = driver.findElements(By.className("inventory_item_name"))
                .stream().map(WebElement::getText).collect(Collectors.toList());

        List<String> sorted = names.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(names, sorted, "Список должен быть отсортирован A→Z");
    }
}