package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public final class LoginSteps {

    @Given("User should navigate to the application")
    public void userShouldNavigateToTheApplication() {
        new LoginPage().navigateToWebsite();
    }

    @Given("user should enter the username as {string}")
    public void userShouldEnterTheUsernameAs(String username) {
        new LoginPage().enterUsername(username);
    }

    @Given("User should enter the password as {string}")
    public void userShouldEnterThePasswordAs(String password) {
        new LoginPage().enterPassword(password);
    }

    @Given("User should click the login button")
    public void userShouldClickTheLoginButton() {
        new LoginPage().clickLoginButton();
    }

    @Then("login should be success")
    public void loginShouldBeSuccess() {
        boolean displayed = new HomePage().logoDisplayed();
        Assert.assertTrue(displayed);
    }

    @Given("login should be fail")
    public void loginShouldBeFail() {
        boolean displayed = new LoginPage().loginFailNotification();
        Assert.assertTrue(displayed);
    }

}
