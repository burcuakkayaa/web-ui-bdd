package myHooks;

import com.google.common.io.Files;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;
import java.io.IOException;



public class BaseHooks {

    protected static DriverFactory factory;

    public BaseHooks() {
        this.factory = new DriverFactory();
    }

    @Before("@chrome")
    public void launchBrowserAsChrome() throws IOException {
        factory.getDriverManager("chrome");

    }

    @Before("@firefox")
    public void launchBrowserAsFirefox() throws IOException {
        factory.getDriverManager("firefox");
    }

    @Before("@safari")
    public void launchBrowserAsSafari() throws IOException {
        factory.getDriverManager("safari");
    }

    @Before("@opera")
    public void launchBrowserAsOpera() throws IOException {
        factory.getDriverManager("opera");
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {

            if(scenario.isFailed()) {
                //take screenshot
                String screenshotName=  scenario.getName().replaceAll(" ", "_");

                byte[] sourcePath = ((TakesScreenshot)factory.getDriver()).getScreenshotAs(OutputType.BYTES);

                scenario.attach(sourcePath, "image/png", screenshotName);

            }

    }


    @After(order = 0)
    public void AfterSteps() {
        factory.getDriver().quit();
    }
}
