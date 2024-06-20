package hooks;

import driver.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import pages.HomePage;

import static utils.ScreenshotUtils.takeScreenShot;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        Driver.initDriver();
    }

    @After(value = "@cleanup", order = 1)
    public void cleanup() {
        try {
            new HomePage().cartCleanup().badgeUpdate();
        } catch (NoSuchElementException exception) {
            Assert.assertTrue(true);
        }
    }

    @After(order = 0)
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) scenario.attach(takeScreenShot(), "image/png", scenario.getName());
        Driver.tearDown();
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
