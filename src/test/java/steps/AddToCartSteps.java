package steps;

import driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class AddToCartSteps {


    @Given("User should login as {string} and {string}")
    public void userShouldLoginAsAnd(String username, String password) {
        DriverManager.getDriver().findElement(By.id("user-name")).sendKeys(username);
        DriverManager.getDriver().findElement(By.id("password")).sendKeys(password);
        DriverManager.getDriver().findElement(By.id("login-button")).click();
    }

    @Given("User should add the {string} to the cart")
    public void userShouldAddTheToTheCart(String product) {
        DriverManager.getDriver().findElement(By.xpath("//div[normalize-space()='" + product + "']//following::button[.='Add to cart'][1]")).click();
    }

    @Then("The cart badge should be updated")
    public void theCartBadgeShouldBeUpdated() {
        String text = DriverManager.getDriver().findElement(By.xpath("//*[@data-test='shopping-cart-badge']")).getText();
        Assert.assertEquals(Integer.parseInt(text) > 0, true);
    }

}
