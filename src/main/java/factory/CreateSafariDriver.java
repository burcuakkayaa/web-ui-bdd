package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class CreateSafariDriver extends DriverFactory {

    public ThreadLocal<WebDriver> createSafariDriver() {

        WebDriverManager.safaridriver().setup();
        tlDriver.set(new SafariDriver(getOptions()));

        return tlDriver;
    }

    private SafariOptions getOptions() {
        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setCapability("disable-infobars", true);
        safariOptions.setCapability("incognito", true);
        safariOptions.setCapability("enable-automation", true);
        safariOptions.setCapability("start-maximized", true);
        safariOptions.setCapability("disable-cache", true);
        safariOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        safariOptions.setUseTechnologyPreview(false);

        return safariOptions;
    }
}
