package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class AddToCartSteps {

    WebDriver driver;
    String URL = "https://www.saucedemo.com/";

    @Given("User should navigate to the application Swag Labs")
    public void userShouldNavigateToTheApplicationSwagLabs() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("User should login as {string} and {string}")
    public void userShouldLoginAsAnd(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    @Given("User should add the {string} to the cart")
    public void userShouldAddTheToTheCart(String product) {
        driver.findElement(By.xpath("//div[normalize-space()='" + product + "']//following::button[.='Add to cart'][1]")).click();
    }

    @Then("The cart badge should be updated")
    public void theCartBadgeShouldBeUpdated() {
        String text = driver.findElement(By.xpath("//*[@data-test='shopping-cart-badge']")).getText();
        Assert.assertEquals(Integer.parseInt(text) > 0, true);
        driver.quit();
    }

}
