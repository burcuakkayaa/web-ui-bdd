package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Constants;

public class OpenPositionCareerPage extends BasePage {

    private final By locationFilter = By.xpath("//span[contains(@id , 'filter-by-location')]");
    private final By locationSelectFilter = By.cssSelector("#filter-by-location");
    private final By clicklocation = By.cssSelector("span[aria-labelledby='select2-filter-by-location-container']");
    private final By locationOptionsList = By.xpath("//ul[@id = 'select2-filter-by-location-results']/li");
    private final By departmentFilter = By.xpath("//span[contains(@id , 'department-container')]");
    private final By clickDepartment = By.cssSelector("span[aria-labelledby='select2-filter-by-department-container']");
    private final By departmentOptionsList = By.xpath("//ul[@id = 'select2-filter-by-department-results']/li");
    private final By departmentSelectFilter = By.id("filter-by-department");
    private final By openPositions = By.xpath("//div[contains(@class , 'position-list-item-wrapper')]");
    private final By positionsDepartmentDetails = By.xpath("//span[contains(@class , 'position-department')]");
    private final By positionLocationDetails = By.xpath("//*[contains(@class , 'position-location')]");
    private final By applyNowButton = By.cssSelector("#jobs-list a");

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
        findAndScrollElement(locationFilter, 15);
        waitUntilElementIsDisplayed(locationFilter);

        waitForJQueryLoad();
        waitUntilElementIsLocated(locationSelectFilter);

        actionClick(clicklocation);


        waitForJQueryLoad();

        for (WebElement options : getWebElements(locationOptionsList)) {
            if (options.getText().contains(location)) {
                options.click();
                break;
            }

        }
    }

    public void checkLocationIsSelected(String location) {
        waitUntilVisible(locationFilter);
        waitUntilElementIsDisplayed(locationFilter);
        String filterValue = getAttribute(locationFilter, "title");
        Assert.assertEquals(filterValue, location);

    }

    public void userFiltersByDepartment(String department) {
        waitUntilElementIsDisplayed(departmentFilter);
        findAndScrollElement(departmentFilter, 15);
        waitUntilElementIsDisplayed(departmentFilter);

        waitForJQueryLoad();
        waitUntilElementIsLocated(departmentSelectFilter);

        actionClick(clickDepartment);

        waitForJQueryLoad();
        for (WebElement options : getWebElements(departmentOptionsList)) {
            if (options.getText().contains(department)) {
                options.click();
                break;
            }

        }
    }

    public void checkDepartmentIsSelected(String department) {
        waitUntilVisible(departmentFilter);
        String filterValue = getAttribute(departmentFilter, "title");
        Assert.assertEquals(filterValue, department);
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

        for (WebElement element : getWebElements(positionLocationDetails)) {
            findAndScrollElement(element, 3);
            waitUntilVisible(element);
            waitForJQueryLoad();
            waitUntilJSReady();
            if (!element.getText().equalsIgnoreCase(location))
                Assert.fail("Location filter and job locations are not mismatch..");
        }
    }

    public void checkFilterAndPositionsDepartment(String department) {
        waitUntilElementIsDisplayed(positionsDepartmentDetails);
        findAndScrollElement(positionsDepartmentDetails, 5);

        for (WebElement element : getWebElements(positionsDepartmentDetails)) {
            findAndScrollElement(element, 3);
            waitUntilVisible(element);
            waitForJQueryLoad();
            if (!element.getText().equalsIgnoreCase(department))
                Assert.fail("Location filter and job departments are not mismatch..");
        }
    }

    public void checkApplyNotButtons() {
        waitForLoad();
        Assert.assertEquals(positionCount, getWebElements(applyNowButton).size());
    }

    public void clickApplyNotButton(int positionCount) {
        waitUntilVisible(getWebElements(openPositions).get(positionCount - 1));
        waitUntilJSReady();
        WebElement applyButtonElement = getWebElements(applyNowButton).get(positionCount - 1);
        scrollInTheMiddleOfElement(applyButtonElement);
        forceClick(applyNowButton);
    }

    public void checkNewWindowIsOpened() {
        waitForLoad();
        implicitWait(5000);
        moveToNewTab(Constants.applicationPageUrl);
        waitUntilUrlContains(Constants.applicationPageUrl);
    }
}
