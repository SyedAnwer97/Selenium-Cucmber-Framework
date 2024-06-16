package steps;

import driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {

    //WebDriver driver;
    String URL = "https://www.saucedemo.com/";

    @Given("User should navigate to the application")
    public void userShouldNavigateToTheApplication() {
        WebDriver driver = new ChromeDriver();
        DriverManager.settDriver(driver);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().get(URL);
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("user should enter the username as {string}")
    public void userShouldEnterTheUsernameAs(String username) {
        DriverManager.getDriver().findElement(By.id("user-name")).sendKeys(username);
    }

    @Given("User should enter the password as {string}")
    public void userShouldEnterThePasswordAs(String password) {
        DriverManager.getDriver().findElement(By.id("password")).sendKeys(password);
    }

    @Given("User should click the login button")
    public void userShouldClickTheLoginButton() {
        DriverManager.getDriver().findElement(By.id("login-button")).click();
    }

    @Then("login should be success")
    public void loginShouldBeSuccess() {
        boolean displayed = DriverManager.getDriver().findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
        Assert.assertTrue(displayed);
    }

    @Given("login should be fail")
    public void loginShouldBeFail() {
        boolean displayed = DriverManager.getDriver().findElement(By.xpath("//*[contains(text(),'Username and password do not match')]")).isDisplayed();
        Assert.assertTrue(displayed);
    }

}
