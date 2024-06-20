package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class AddToCartSteps {

    @Given("User should login as {string} and {string}")
    public void userShouldLoginAsAnd(String username, String password) {
        new LoginPage().login(username, password);
    }

    @Given("User should add the {string} to the cart")
    public void userShouldAddTheToTheCart(String product) {
        new HomePage().addToCart(product);
    }

    @Then("The cart badge should be updated")
    public void theCartBadgeShouldBeUpdated() {
        String text = new HomePage().badgeUpdate();
        Assert.assertEquals(Integer.parseInt(text) > 0, true);
    }

}
