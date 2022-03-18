package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Constants;

public class CareersPage extends BasePage {
    public CareersPage(WebDriver driver) {
        super(driver);
    }

    private final By locationArea = By.id("career-our-location");
    private final By lifeAtInsiderArea = By.xpath("//div[@data-id = '21cea83']");
    private final By teamsArea = By.id("career-find-our-calling");
    private final By seeAllTeamsButton = By.xpath("//section[@id = 'career-find-our-calling']//child::a[contains(@class ,'btn')]");
    private final By qualityAssurance = By.xpath("//h3[text() = 'Quality Assurance']");

    public void checkCareersPageIsOpened() {
        waitForLoad();
        waitUntilUrlContains(Constants.careersUrl);
    }

    public void checkTeamsSectionIsOpened() {
        findAndScrollElement(teamsArea,15);
        Assert.assertTrue(isElementPresent(teamsArea));
    }

    public void checkLocationIsOpened() {
        waitUntilJSReady();
        waitForJQueryLoad();
        findAndScrollElement(locationArea,15);
        Assert.assertTrue(isElementPresent(locationArea));
    }

    public void checkLifeSectionIsOpened() {
        findAndScrollElement(lifeAtInsiderArea,15);
        Assert.assertTrue(isElementPresent(lifeAtInsiderArea));
    }

    public void clickSeeAllTeamsButton() {
        waitForLoad();
        waitUntilVisible(seeAllTeamsButton);
        findAndScrollElement(seeAllTeamsButton,15);
        waitUntilClickable(seeAllTeamsButton);
        waitUntilElementIsDisplayed(seeAllTeamsButton);
        forceClick(seeAllTeamsButton);

    }

    public void selectQualityAssuranceOption() {
        waitForLoad();
        waitUntilVisible(qualityAssurance);
        waitUntilClickable(qualityAssurance);
        waitUntilElementIsDisplayed(qualityAssurance);
        forceClick(qualityAssurance);

    }
}
