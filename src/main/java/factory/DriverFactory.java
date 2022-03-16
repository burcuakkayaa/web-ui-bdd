package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static WebDriver driver = null;

    public WebDriver getDriverManager(String browser) {

        switch (browser) {
            case "firefox":
                driver = WebDriverManager.firefoxdriver().create();
                break;
            case "opera":
                driver = WebDriverManager.operadriver().create();
                break;
            case "safari":
                driver = WebDriverManager.safaridriver().create();
                break;
            case  "chrome":
            default:
                driver = WebDriverManager.chromedriver().create();
        }

        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
