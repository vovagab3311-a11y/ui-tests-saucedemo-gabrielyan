package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterPage extends BasePage {

    private final By socialLinks = By.cssSelector(".social a");

    public FooterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверить, что все иконки соцсетей видны")
    public boolean areSocialLinksVisible() {
        return driver.findElements(socialLinks).size() == 3;
    }
}