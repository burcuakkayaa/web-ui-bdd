package factory;

import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class DriverFactory {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private final ConfigReader reader = new ConfigReader();

    public WebDriver getDriverManager(String browser) {

        switch (browser) {
            case "firefox":
               CreateFirefoxDriver firefox = new CreateFirefoxDriver();
               tlDriver = firefox.createFirefoxDriver();
                break;
            case "opera":
                CreateOperaDriver opera = new CreateOperaDriver();
                tlDriver = opera.createOperaDriver();
                break;
            case "safari":
                CreateSafariDriver safari = new CreateSafariDriver();
                tlDriver = safari.createSafariDriver();
                break;
            case  "chrome":
            default:
                CreateChromeDriver chrome = new CreateChromeDriver();
                tlDriver = chrome.createChromeDriver();
                break;
        }

        WebDriver driver = tlDriver.get();
        Properties properties = null;
        try {
            properties = reader.init();
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        assert properties != null;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(properties.getProperty("default_implicitWait"))));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(Long.parseLong(properties.getProperty("default_pageLoadWait"))));

        return driver;
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }
}
