package myStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CareersSteps implements BaseSteps {


    @Then("user should see Careers page is opened")
    public void userShouldSeeCareersPageIsOpened() {
        careersPage.checkCareersPageIsOpened();
    }

    @And("user should see teams section is opened")
    public void userShouldSeeTeamsSectionIsOpened() {
        careersPage.checkTeamsSectionIsOpened();
    }

    @And("user should see location section is opened")
    public void userShouldSeeLocationSectionIsOpened() {
        careersPage.checkLocationIsOpened();
    }

    @And("user should see life at Insider section is opened")
    public void userShouldSeeLifeAtInsiderSectionIsOpened() {
        careersPage.checkLifeSectionIsOpened();
    }

    @When("user clicks see all teams button")
    public void userClicksSeeAllTeamsButton() {
        careersPage.clickSeeAllTeamsButton();
    }

    @And("user selects Quality Assurance")
    public void userSelectsQualityAssurance() {
        careersPage.selectQualityAssuranceOption();
    }

}
