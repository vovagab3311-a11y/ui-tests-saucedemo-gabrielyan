package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By completeHeader = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Заполнить форму: {first} {last}, {zip}")
    public void fillForm(String first, String last, String zip) {
        type(firstName, first);
        type(lastName, last);
        type(postalCode, zip);
        click(continueButton);
        wait.until(ExpectedConditions.elementToBeClickable(finishButton));
    }

    @Step("Нажать Finish")
    public void finish() {
        click(finishButton);
    }

    @Step("Получить заголовок завершения заказа")
    public String getCompleteHeader() {
        return el(completeHeader).getText().trim();
    }
}