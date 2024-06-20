package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static driver.DriverManager.getDriver;
import static enums.Locators.ID;
import static enums.Locators.XPATH;
import static utils.DynamicXpathUtils.getDynamicXpath;
import static utils.LocatorUtils.byLocator;

public final class HomePage {

    private String productsAddToCart = "//div[normalize-space()='%s']//following::button[.='Add to cart'][1]";

    private final By shoppingCartBadge = byLocator(XPATH, "//*[@data-test='shopping-cart-badge']");
    private final By imageLogo = byLocator(XPATH, "//div[@class='app_logo']");
    private final By buttonBurgerMenu = byLocator(ID, "react-burger-menu-btn");
    private final By linkResetSidebarLink = byLocator(ID, "reset_sidebar_link");
    private final By buttonBurgerCrossButton = byLocator(ID, "react-burger-cross-btn");

    public boolean logoDisplayed() {
        return getDriver().findElement(imageLogo).isDisplayed();
    }

    public HomePage addToCart(String productName) {
        getDriver().findElement(byLocator(XPATH, getDynamicXpath(productsAddToCart, productName))).click();
        return this;
    }

    public String badgeUpdate() {
        return getDriver().findElement(shoppingCartBadge).getText();
    }

    public HomePage cartCleanup() {
        if (getDriver().findElement(shoppingCartBadge).isDisplayed()) {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(buttonBurgerMenu)).click();
            wait.until(ExpectedConditions.elementToBeClickable(linkResetSidebarLink)).click();
            wait.until(ExpectedConditions.elementToBeClickable(buttonBurgerCrossButton)).click();
        }
        return new HomePage();
    }
}
