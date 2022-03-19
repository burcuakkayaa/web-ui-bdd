package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Constants;
import utils.MenuEnum;

public class HomePage extends BasePage {

    private final By iconCloseButton = By.id("close-button-1454703945249");
    private final By acceptAllCookies = By.id("wt-cli-accept-all-btn");
    private final By megamenuList = By.xpath("//*[@id='mega-menu-1']");
    private final By aboutUs = By.xpath("//h5[text()  = '" + MenuEnum.AboutUs.getValue() + "']");
    private final By partners = By.xpath("//h5[text()  = '" + MenuEnum.Partners.getValue() + "']");
    private final By careers = By.xpath("//h5[text()  = '" + MenuEnum.Careers.getValue() + "']");
    private final By contactUs = By.xpath("//h5[text()  = '" + MenuEnum.ContactUs.getValue() + "']");
    private final By glossary = By.xpath("//h5[text()  = '" + MenuEnum.Glossary.getValue() + "']");
    private final By newsroom = By.xpath("//h5[text()  = '" + MenuEnum.Newsroom.getValue() + "']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void getHomePage() {
        waitForLoad();
        getUrl();
        waitUntilUrlContains(Constants.url);
        waitForJQueryLoad();
    }

    public void clickAcceptsCookies() {
        waitUntilClickableAndClick(acceptAllCookies);
    }

    public void closeInsiderModal() {
        if(isElementPresent(iconCloseButton)) {
            moveToActiveElement();
            waitUntilClickableAndClick(iconCloseButton);
        }

    }

    public void clickMoreMenu() {
        WebElement element = getWebElements(megamenuList).get(5);
        if(!isElementPresent(element))
            waitUntilClickableAndClick(iconCloseButton);


        waitUntilVisible(element);
        waitUntilClickableAndClick(element);
    }

    public void checkAllCategoriesAreDisplayed() {

        Assert.assertTrue(waitUntilElementIsDisplayed(aboutUs));
        Assert.assertTrue(waitUntilElementIsDisplayed(partners));
        Assert.assertTrue(waitUntilElementIsDisplayed(careers));
        Assert.assertTrue(waitUntilElementIsDisplayed(contactUs));
        Assert.assertTrue(waitUntilElementIsDisplayed(glossary));
        Assert.assertTrue(waitUntilElementIsDisplayed(newsroom));

    }

    public void selectMenu(String menu) {
         if(menu.equalsIgnoreCase(MenuEnum.AboutUs.getValue()))
             waitUntilClickableAndClick(aboutUs);
         else if(menu.equalsIgnoreCase(MenuEnum.Partners.getValue()))
             waitUntilClickableAndClick(partners);
         else if(menu.equalsIgnoreCase(MenuEnum.Careers.getValue()))
             waitUntilClickableAndClick(careers);
         else if(menu.equalsIgnoreCase(MenuEnum.ContactUs.getValue()))
             waitUntilClickableAndClick(contactUs);
         else if(menu.equalsIgnoreCase(MenuEnum.Glossary.getValue()))
             waitUntilClickableAndClick(glossary);
         else if(menu.equalsIgnoreCase(MenuEnum.Newsroom.getValue()))
             waitUntilClickableAndClick(newsroom);
         else
             Assert.fail("Please select valid menu");

    }
}
