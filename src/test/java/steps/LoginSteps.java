package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {

    WebDriver driver;
    String URL = "https://www.saucedemo.com/";

    @Given("User should navigate to the application")
    public void userShouldNavigateToTheApplication() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("user should enter the username as {string}")
    public void userShouldEnterTheUsernameAs(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }
    @Given("User should enter the password as {string}")
    public void userShouldEnterThePasswordAs(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Given("User should click the login button")
    public void userShouldClickTheLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("login should be success")
    public void loginShouldBeSuccess() {
        boolean displayed = driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
        System.out.println(displayed);
        Assert.assertTrue(displayed);
        driver.quit();
    }

    @Given("login should be fail")
    public void loginShouldBeFail() {
        boolean displayed = driver.findElement(By.xpath("//*[contains(text(),'Username and password do not match')]")).isDisplayed();
        Assert.assertTrue(displayed);
        driver.quit();
    }

}
