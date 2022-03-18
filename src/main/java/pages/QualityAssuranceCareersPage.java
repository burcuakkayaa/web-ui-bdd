package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Constants;

public class QualityAssuranceCareersPage extends BasePage {

    private final By seeAllQaJobs =By.xpath("//a[contains(@href, 'open-positions/?department=qualityassurance')]");

    public QualityAssuranceCareersPage(WebDriver driver) {
        super(driver);
    }

    public void verifyQualityAssurancePageIsOpened() {
        waitForLoad();
        waitUntilUrlContains(Constants.qualityAssuranceOptionCareers);
    }

    public void clickQaAllJobsButton() {
        waitUntilVisible(seeAllQaJobs);
        waitUntilClickableAndClick(seeAllQaJobs);
    }
}
