package myStepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class HomePageSteps implements BaseSteps {

    @Given("user is on homepage")
    public void userIsOnHomepage() {
         homePage.getHomePage();
    }

    @When("user accepts all cookies")
    public void userAcceptsAllCookies() {
        homePage.clickAcceptsCookies();
    }

    @And("user closes insider icon")
    public void userClosesInsiderIcon() {
        homePage.closeInsiderModal();

    }

    @And("user clicks More menu in Navigation Bar")
    public void userClicksMoreMenuInNavigationBar() {
        homePage.clickMoreMenu();
    }

    @Then("user should see categories")
    public void userShouldSeeCategories() {
        homePage.checkAllCategoriesAreDisplayed();
    }

    @When("user selects {string}")
    public void userSelects(String menu) {
        homePage.selectMenu(menu);
    }

}
