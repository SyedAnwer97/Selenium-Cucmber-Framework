package pages;

import org.openqa.selenium.By;

import static driver.DriverManager.getDriver;
import static enums.Locators.ID;
import static enums.Locators.XPATH;
import static enums.Waits.CLICK;
import static utils.DynamicXpathUtils.getDynamicXpath;
import static utils.LocatorUtils.byLocator;

public final class HomePage extends PageActions {

    private final String productsAddToCart = "//div[normalize-space()='%s']//following::button[.='Add to cart'][1]";

    private final By shoppingCartBadge = byLocator(XPATH, "//*[@data-test='shopping-cart-badge']");
    private final By imageLogo = byLocator(XPATH, "//div[@class='app_logo']");
    private final By buttonBurgerMenu = byLocator(ID, "react-burger-menu-btn");
    private final By linkResetSidebarLink = byLocator(ID, "reset_sidebar_link");
    private final By buttonBurgerCrossButton = byLocator(ID, "react-burger-cross-btn");
    private final By linkLogout = byLocator(ID, "logout_sidebar_link");

    public boolean logoDisplayed() {
        return getDriver().findElement(imageLogo).isDisplayed();
    }

    public HomePage addToCart(String productName) {
        click(CLICK, byLocator(XPATH, getDynamicXpath(productsAddToCart, productName)));
        return this;
    }

    public String badgeUpdate() {
        return (String) driverActions(a -> findElement(shoppingCartBadge).getText());
    }

    public HomePage cartCleanup() {
        if (getDriver().findElement(shoppingCartBadge).isDisplayed()) {
            click(CLICK, buttonBurgerMenu);
            click(CLICK, linkResetSidebarLink);
            click(CLICK, buttonBurgerCrossButton);
        }
        return new HomePage();
    }

    public HomePage clickButtonBurgerMenu() {
        click(CLICK, buttonBurgerMenu);
        return this;
    }

    public LoginPage clickLogoutLink() {
        click(CLICK, linkLogout);
        return new LoginPage();
    }

}
