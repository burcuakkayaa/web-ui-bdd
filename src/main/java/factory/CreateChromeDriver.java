package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateChromeDriver extends DriverFactory {



      public ThreadLocal<WebDriver> createChromeDriver() {

          WebDriverManager.chromedriver().setup();
          tlDriver.set(new ChromeDriver(getOptions()));

          return tlDriver;
      }

      private ChromeOptions getOptions() {
          ChromeOptions chromeOptions = new ChromeOptions();
          chromeOptions.addArguments("-disable-cache"
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

          chromeOptions.setExperimentalOption("useAutomationExtension", false);
          chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

          return chromeOptions;
      }
}
