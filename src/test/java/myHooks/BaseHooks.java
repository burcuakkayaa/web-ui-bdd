package myHooks;


import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;




public class BaseHooks {

    protected static DriverFactory factory;

    public BaseHooks() {
        factory = new DriverFactory();
    }

    @Before("@chrome")
    public void launchBrowserAsChrome()  {
        factory.getDriverManager("chrome");

    }

    @Before("@firefox")
    public void launchBrowserAsFirefox() {
        factory.getDriverManager("firefox");
    }

    @Before("@safari")
    public void launchBrowserAsSafari()  {
        factory.getDriverManager("safari");
    }

    @Before("@opera")
    public void launchBrowserAsOpera()  {
        factory.getDriverManager("opera");
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {

            if(scenario.isFailed()) {
                //take screenshot
                String screenshotName=  scenario.getName().replaceAll(" ", "_");

                byte[] sourcePath = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);

                scenario.attach(sourcePath, "image/png", screenshotName);

            }

    }


    @After(order = 0)
    public void AfterSteps() {
        DriverFactory.getDriver().quit();
    }
}
