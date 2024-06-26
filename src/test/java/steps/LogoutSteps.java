package steps;

import driver.DriverManager;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import pages.HomePage;
import property.Properties;

public final class LogoutSteps {

    @Given("User should click the hamburger menu button")
    public void userShouldClickTheHamburgerMenuButton() {
        new HomePage().clickButtonBurgerMenu();
    }

    @Given("User click the logout button")
    public void userClickTheLogoutButton() {
        new HomePage().clickLogoutLink();
    }

    @Given("User should logout from Swag Labs")
    public void userShouldLogoutFromSwagLabs() {
        System.out.println(DriverManager.getDriver().getCurrentUrl());
        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(), Properties.URL);
    }

}
