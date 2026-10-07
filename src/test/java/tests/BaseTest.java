package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.AllureAttachments;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        driver = createDriver(browser);
        driver.manage().window().maximize();
    }

    private WebDriver createDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "firefox" -> {
                FirefoxOptions fo = new FirefoxOptions();
                return new FirefoxDriver(fo);
            }
            case "edge" -> {
                EdgeOptions eo = new EdgeOptions();
                return new EdgeDriver(eo);
            }
            default -> {
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--window-size=1920,1080");
                co.addArguments("--disable-features=PasswordLeakDetection");
                co.addArguments("--disable-save-password-bubble");
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("profile.password_manager_leak_detection", false);
                co.setExperimentalOption("prefs", prefs);
                return new ChromeDriver(co);
            }
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (driver != null && !result.isSuccess()) {
            AllureAttachments.screenshot(driver, "Failure screenshot");
            AllureAttachments.pageSource(driver, "Page source on failure");
        }
        if (driver != null) driver.quit();
    }
}