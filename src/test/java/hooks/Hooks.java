package hooks;

import driver.DriverManager;
import io.cucumber.java.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        WebDriver driver = new ChromeDriver();
        DriverManager.settDriver(driver);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @After(value = "@cleanup", order = 1)
    public void cleanup() {
        boolean displayed = DriverManager.getDriver().findElement(By.xpath("//span[@class='shopping_cart_badge']")).isDisplayed();
        System.out.println("info-----> + " + displayed);
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("reset_sidebar_link"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-cross-btn"))).click();
        try {
            DriverManager.getDriver().findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        } catch (NoSuchElementException exception) {
            Assert.assertTrue(true);
        }
    }

    @After(order = 0)
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) DriverManager.getDriver();
            byte[] screenshotAs = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotAs, "image/png", "screenshot");
        }
        DriverManager.getDriver().quit();
        DriverManager.unload();
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
