package pages;

import org.openqa.selenium.By;

import static driver.DriverManager.getDriver;
import static enums.Locators.ID;
import static enums.Locators.XPATH;
import static enums.Waits.CLICK;
import static enums.Waits.PRESENCE;
import static property.Properties.URL;
import static utils.LocatorUtils.byLocator;

public final class LoginPage extends PageActions {

    private final By textboxUsername = byLocator(ID, "user-name");
    private final By textboxPassword = byLocator(ID, "password");
    private final By buttonLogin = byLocator(ID, "login-button");
    private final By textFailNotification = byLocator(XPATH, "//*[contains(text(),'Username and password do not match')]");

    public LoginPage navigateToWebsite() {
        getDriver().get(URL);
        return this;
    }

    public LoginPage enterUsername(String username) {
        sendKeys(PRESENCE, textboxUsername, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(PRESENCE, textboxPassword, password);
        return this;
    }

    public HomePage clickLoginButton() {
        click(CLICK, buttonLogin);
        return new HomePage();
    }

    public HomePage login(String username, String password) {
        return enterUsername(username).enterPassword(password).clickLoginButton();
    }

    public boolean loginFailNotification() {
        return (boolean) driverActions(a -> findElement(textFailNotification).isDisplayed());
    }

}
