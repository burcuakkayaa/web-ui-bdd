package pages;

import factory.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import utils.Constants;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait jsWait;
    private JavascriptExecutor jsExec;
    private final int timeOut = 60;


    public BasePage(WebDriver driver)  {
        this.driver = DriverFactory.getDriver();
        jsWait = new WebDriverWait(this.driver, 10);
        jsExec = (JavascriptExecutor) this.driver;

    }

    public void getUrl()  {
        driver.get(Constants.url);
    }

    public WebElement getWebElement(By locator) {

        return  driver.findElement(locator);

    }

    public List<WebElement> getWebElements(By locator) {

        return driver.findElements(locator);
    }


    public void  selectElementBySelectValue(By locator, String value) {
        Select select = new Select(getWebElement(locator));
        select.selectByValue(value);
    }

    public boolean isElementPresent(By locator) {
        try {
            jsWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            jsWait = new WebDriverWait(driver, timeOut);
            return true;
        } catch (Throwable e) {
            jsWait = new WebDriverWait(driver, timeOut);
            return false;
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            jsWait.until(ExpectedConditions.visibilityOf(element));
            jsWait = new WebDriverWait(driver, timeOut);
            return true;
        } catch (Throwable e) {
            jsWait = new WebDriverWait(driver, timeOut);
            return false;
        }
    }

    public void forceClick(By locator) {
        WebElement element = getWebElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("var evt = document.createEvent('MouseEvents');"
                + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
                + "arguments[0].dispatchEvent(evt);", element);
    }

    public void forceClick(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("var evt = document.createEvent('MouseEvents');"
                + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
                + "arguments[0].dispatchEvent(evt);", element);
    }

    public void sendKey(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }


    public void actionClick(By locator) {
        WebElement element = getWebElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void actionClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void actionClickAndHold(By locator) {
        WebElement element = getWebElement(locator);
        Actions actions = new Actions(driver);
        actions.clickAndHold(element);
        actions.moveToElement(element).click().perform();
    }

    public void actionClickAndHold(WebElement element) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(element);
        actions.moveToElement(element).click().perform();
    }
    public String getText(By locator) {
        WebElement element = getWebElement(locator);
        return element.getText();
    }

    public String getAttribute(By locator, String attributeName) {
        WebElement element = getWebElement(locator);
        return element.getAttribute(attributeName);
    }


    public void findAndScrollElement(By locator, int scrollAmount) {
        WebElement element = getWebElement(locator);
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/" + scrollAmount + "));";
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(scrollElementIntoMiddle, element);
    }

    public void findAndScrollElement(WebElement element, int scrollAmount) {

        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/" + scrollAmount + "));";
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(scrollElementIntoMiddle, element);
    }

    public void waitUntilClickableAndClick(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofMillis(10)).ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void waitUntilClickableAndClick(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofMillis(10)).ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitUntilClickable(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofMillis(10)).ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilClickable(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofMillis(10)).ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public synchronized boolean waitUntilUrlContains(String expectedValue) {

        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofMillis(1000)).ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        boolean urlExists = wait.until(ExpectedConditions.urlContains(expectedValue));
        if (urlExists) {


            System.out.println("Waited until for URL and contains expected value: " + expectedValue);

        }

        return true;
    }

    public synchronized boolean waitUntilUrlNotContains(String expectedValue)  {

        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofMillis(1000)).ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        boolean urlExists = wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(expectedValue)));
        if (urlExists) {
            System.out.println("Waited until for URL and  not contains expected value: " + expectedValue);
        }

        return true;
    }


    public void waitUntilVisible(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofMillis(10)).ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilVisible(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofMillis(10)).ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public Boolean waitUntilElementIsDisplayed(By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofMillis(10)).ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(locator)).isDisplayed();
    }

    public Boolean waitUntilElementIsDisplayed(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofMillis(10)).ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(element)).isDisplayed();
    }

    public Boolean waitUntilElementIsSelected(By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofMillis(10)).ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(locator)).isSelected();
    }

    public Boolean waitUntilElementIsEnabled(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofMillis(10)).ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(locator)).isEnabled();
    }

    public void waitForLoad() {

        try {
            ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                }
            };
            WebDriverWait wait = new WebDriverWait(driver, 240);
            wait.until(pageLoadCondition);
        }catch(Exception e) {
            new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                    ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        }

    }

    public void clickAndHold(WebElement element) {

        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.clickAndHold().perform();
    }

    public Boolean checkElementIsDisplayed(WebElement element) {
        Boolean flag = element.isDisplayed();

        return flag;
    }

    public void moveToActiveElement() {
        driver.switchTo().activeElement();
    }

    public void waitForJQueryLoad() {
        try {
            ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) this.driver)
                    .executeScript("return jQuery.active") == 0);
            boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");
            if (!jqueryReady) {
                jsWait.until(jQueryLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }

    public void waitUntilJSReady() {
        try {
            ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) this.driver)
                    .executeScript("return document.readyState").toString().equals("complete");
            boolean jsReady = jsExec.executeScript("return document.readyState").toString().equals("complete");
            if (!jsReady) {
                jsWait.until(jsLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }


    public void moveToNewTab(String url) {
        Set s=driver.getWindowHandles(); //this method will gives you the handles of all opened windows

        Iterator ite=s.iterator();

        while(ite.hasNext())
        {
            String popupHandle=ite.next().toString();
            if(!popupHandle.contains(url))
            {
                driver.switchTo().window(popupHandle);
            }
        }

    }


    public void scrollInTheMiddleOfElement(WebElement element) {
        //scroll to middle with Javascript Executor
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", element);
    }
}
