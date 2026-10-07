package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public final class AllureAttachments {

    private AllureAttachments() {}

    public static void screenshot(WebDriver driver, String name) {
        if (driver == null) return;
        try {
            byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(name, new ByteArrayInputStream(bytes));
        } catch (Exception ignored) {}
    }

    public static void pageSource(WebDriver driver, String name) {
        if (driver == null) return;
        try {
            Allure.addAttachment(name, "text/html", driver.getPageSource(), ".html");
        } catch (Exception ignored) {}
    }
}