package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть страницу логина")
    public LoginPage openPage() {
        open("");
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        return this;
    }

    @Step("Ввести логин: {username}")
    public LoginPage enterUsername(String username) {
        type(usernameField, username);
        return this;
    }

    @Step("Ввести пароль")
    public LoginPage enterPassword(String password) {
        type(passwordField, password);
        return this;
    }

    @Step("Нажать Login")
    public void clickLogin() {
        click(loginButton);
    }

    @Step("Получить текст ошибки")
    public String getErrorMessage() {
        return el(errorMessage).getText().trim();
    }
}