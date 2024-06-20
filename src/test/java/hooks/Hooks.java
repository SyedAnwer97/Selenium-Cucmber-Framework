package hooks;

import io.cucumber.java.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;

import java.time.Duration;

import static driver.DriverManager.*;
import static utils.ScreenshotUtils.takeScreenShot;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        WebDriver driver = new ChromeDriver();
        settDriver(driver);
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @After(value = "@cleanup", order = 1)
    public void cleanup() {
        try {
            new HomePage().cartCleanup().badgeUpdate();
        }catch (NoSuchElementException exception) {
            Assert.assertTrue(true);
        }
        /*boolean displayed = getDriver().findElement(By.xpath("//span[@class='shopping_cart_badge']")).isDisplayed();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("reset_sidebar_link"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-cross-btn"))).click();
        try {
            getDriver().findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        } catch (NoSuchElementException exception) {
            Assert.assertTrue(true);
        }*/
    }

    @After(order = 0)
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) scenario.attach(takeScreenShot(), "image/png", scenario.getName());
        getDriver().quit();
        unload();
    }

    @BeforeStep
    public void beforeSteps(Scenario scenario) {
        //TODO
    }

    @AfterStep
    public void afterSteps(Scenario scenario) {
        //TODO
    }

}
