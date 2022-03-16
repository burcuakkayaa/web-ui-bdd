package myStepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myHooks.BaseHooks;
import org.openqa.selenium.WebDriver;
import utils.Constants;

public class HomePageSteps  {

    DriverFactory factory = new DriverFactory();
    WebDriver driver =  factory.getDriver();

    @Given("user is on homepage")
    public void userIsOnHomepage() {
         driver.get(Constants.url);
    }

    @Then("user should see page title")
    public void userShouldSeePageTitle() {
       System.out.println(driver.getTitle());
    }

    @When("user deniyor")
    public void userDeniyor() {
    }
}
