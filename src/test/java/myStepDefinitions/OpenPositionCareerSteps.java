package myStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpenPositionCareerSteps implements BaseSteps {

    private String location;
    private String department;

    @Then("user should see Open Position Page")
    public void userShouldSeeOpenPositionPage() {
        openPosition.verifyOpenPositionUrl();
    }

    @When("user filters job by location {string}")
    public void userFiltersJobByLocation(String location) {
        this.location = location;
        openPosition.userFilterByLocation(location);

    }

    @Then("user should see location filter are selected")
    public void userShouldSeeLocationFilterAreSelected() {
        openPosition.checkLocationIsSelected(location);
    }

    @And("user filters jobs by department {string}")
    public void userFiltersJobsByDepartment(String department) {
        this.department = department;
        openPosition.userFiltersByDepartment(department);
    }

    @Then("user should see department filter are selected")
    public void userShouldSeeDepartmentFilterAreSelected() {
        openPosition.checkDepartmentIsSelected(department);
    }

    @Then("user should see open positions")
    public void userShouldSeeOpenPositions() {
        openPosition.checkOpenPositionsAreDisplayed();
    }

    @And("user should see locations of open positions are same with filter")
    public void userShouldSeeLocationsOfOpenPositionsAreSameWithFilter() {
        openPosition.checkFilterAndPositionsLocation(location);
    }

    @And("user should see department of open positions are same with filter")
    public void userShouldSeeDepartmentOfOpenPositionsAreSameWithFilter() {
        openPosition.checkFilterAndPositionsDepartment(department);
    }

    @And("user should see apply now buttons")
    public void userShouldSeeApplyNowButtons() {
        openPosition.checkApplyNotButtons();
    }

    @When("user clicks {int}. position apply now button")
    public void userClicksPositionApplyNowButton(int positionCount) {
        openPosition.clickApplyNotButton(positionCount);
    }

    @Then("user should see new Application redirect page")
    public void userShouldSeeNewApplicationRedirectPage() {
        openPosition.checkNewWindowIsOpened();
    }
}
