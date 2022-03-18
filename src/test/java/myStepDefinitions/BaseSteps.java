package myStepDefinitions;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import pages.CareersPage;
import pages.HomePage;
import pages.OpenPositionCareerPage;
import pages.QualityAssuranceCareersPage;

public interface BaseSteps {

    WebDriver driver =  DriverFactory.getDriver();
    HomePage homePage = new HomePage(driver);
    CareersPage careersPage = new CareersPage(driver);
    QualityAssuranceCareersPage qualityPage = new QualityAssuranceCareersPage(driver);
    OpenPositionCareerPage openPosition = new OpenPositionCareerPage(driver);

}
