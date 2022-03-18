package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class CreateOperaDriver extends DriverFactory {

    public ThreadLocal<WebDriver> createOperaDriver() {

        WebDriverManager.operadriver().setup();
        tlDriver.set(new OperaDriver(getOptions()));

        return tlDriver;
    }

    private OperaOptions getOptions() {
        OperaOptions  options = new OperaOptions();
        options.addArguments("-disable-cache"
                ,"--incognito"
                ,"start-maximized"
                , "--no-sandbox"
                ,"--disable-gpu"
                ,"--disable-dev-shm-usage"
                ,"--disable-infobars"
                ,"--disable-notifications"
                ,"--enable-automation"
                ,"--ignore-certificate-errors"
                ,"--ignore-ssl-errors"
                ,"--disable-cache");

        options.setExperimentalOption("useAutomationExtension", false);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        return options;
    }
}
