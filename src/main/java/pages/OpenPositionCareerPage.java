package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Constants;

public class OpenPositionCareerPage extends BasePage {

    private final By locationFilter = By.xpath("//span[contains(@id , 'filter-by-location')]");
    private final By locationOptions = By.xpath("//select[@id = 'filter-by-location']/option");
    private final By departmentFilter = By.xpath("//span[contains(@id , 'department-container')]");
    private final By departmentOptions = By.xpath("//ul[contains(@id , 'department-results')]/li");
    private final By openPositions = By.xpath("//div[contains(@class , 'position-list-item-wrapper')]");
    private final By positionsDepartmentDetails = By.xpath("//span[contains(@class , 'position-department')]");
    private final By positionLocationDetails = By.xpath("//*[contains(@class , 'position-location')]");
    private final By applyNowButton = By.xpath("//a[text() = 'Apply Now']");


    private int positionCount;

    public OpenPositionCareerPage(WebDriver driver) {
        super(driver);
    }

    public void verifyOpenPositionUrl() {
        waitForLoad();
        waitUntilUrlContains(Constants.openPositionUrl);
    }

    public void userFilterByLocation(String location) {
        waitUntilElementIsDisplayed(locationFilter);
        findAndScrollElement(locationFilter,15);
        waitUntilElementIsDisplayed(locationFilter);

        for(WebElement options : getWebElements(locationOptions)) {
            if(options.getText().contains(location)) {
                options.click();
                break;
            }

        }

    }

    public void checkLocationIsSelected(String location) {
        waitUntilVisible(locationFilter);
        waitUntilElementIsDisplayed(locationFilter);
        String filterValue = getAttribute(locationFilter,"title");
        Assert.assertEquals(location,filterValue);

    }

    public void userFiltersByDepartment(String department) {
        waitUntilElementIsDisplayed(departmentFilter);
        findAndScrollElement(departmentFilter,15);
        waitUntilElementIsDisplayed(departmentFilter);

        for(WebElement options : getWebElements(departmentOptions)) {
            if(options.getText().contains(department)) {
                options.click();
                break;
            }

        }
    }

    public void checkDepartmentIsSelected(String department) {
        waitUntilVisible(departmentFilter);
        String filterValue = getAttribute(departmentFilter,"title");
        Assert.assertEquals(department,filterValue);
    }

    public void checkOpenPositionsAreDisplayed() {
        waitForLoad();
        waitForJQueryLoad();
        waitUntilJSReady();
        Assert.assertTrue(isElementPresent(openPositions));
        positionCount = getWebElements(openPositions).size();

    }

    public void checkFilterAndPositionsLocation(String location) {
        waitUntilElementIsDisplayed(positionLocationDetails);
        findAndScrollElement(positionLocationDetails, 5);

        for(WebElement element : getWebElements(positionLocationDetails)) {
            findAndScrollElement(element, 3);
            waitUntilVisible(element);
            waitForJQueryLoad();
            waitUntilJSReady();
            if(!element.getText().equalsIgnoreCase(location))
                Assert.fail("Location filter and job locations are not mismatch..");
        }
    }

    public void checkFilterAndPositionsDepartment(String department) {
        waitUntilElementIsDisplayed(positionsDepartmentDetails);
        findAndScrollElement(positionsDepartmentDetails, 5);

        for(WebElement element : getWebElements(positionsDepartmentDetails)) {
            findAndScrollElement(element, 3);
            waitUntilVisible(element);
            waitForJQueryLoad();
            if(!element.getText().equalsIgnoreCase(department))
                Assert.fail("Location filter and job departments are not mismatch..");
        }
    }

    public void checkApplyNotButtons() {
        waitForLoad();
        Assert.assertEquals(positionCount, getWebElements(applyNowButton).size());
    }

    public void clickApplyNotButton(int positionCount) {
        waitUntilVisible(getWebElements(openPositions).get(positionCount-1));
        waitUntilJSReady();
        WebElement applyButtonElement = getWebElements(applyNowButton).get(positionCount-1);
        scrollInTheMiddleOfElement(applyButtonElement);
        actionClickAndHold(applyButtonElement);
    }

    public void checkNewWindowIsOpened()  {
        waitForLoad();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        moveToNewTab(Constants.applicationPageUrl);
        waitUntilUrlContains(Constants.applicationPageUrl);
    }
}
