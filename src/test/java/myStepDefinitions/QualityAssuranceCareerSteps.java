package myStepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QualityAssuranceCareerSteps implements BaseSteps {

    @Then("user should see Quality Assurance Careers page")
    public void userShouldSeeQualityAssuranceCareersPage() {
       qualityPage.verifyQualityAssurancePageIsOpened();
    }

    @When("user clicks see all QA jobs")
    public void userClicksSeeAllQAJobs() {
        qualityPage.clickQaAllJobsButton();
    }
}
