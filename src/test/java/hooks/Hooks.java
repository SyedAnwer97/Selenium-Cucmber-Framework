package hooks;

import driver.Driver;
import io.cucumber.java.*;
import logger.MyLogger;
import lombok.SneakyThrows;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import pages.HomePage;
import utils.ScenarioStepsUtils;

import static utils.ScreenshotUtils.takeScreenShot;

public class Hooks {

    private int lineCount = 0;

    @Before
    public void beforeScenario(Scenario scenario) {
        MyLogger.startTestCase(scenario.getName());
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
        if (scenario.isFailed()) {
            scenario.attach(takeScreenShot(), "image/png", scenario.getName());
            MyLogger.error(ScenarioStepsUtils.getSteps(scenario) + " is failed");
        }
        Driver.tearDown();
        MyLogger.endTestCase(scenario.getName());
    }

    @SneakyThrows
    @BeforeStep
    public void beforeSteps(Scenario scenario) {
        if (lineCount < ScenarioStepsUtils.getSteps(scenario).size()) {
            MyLogger.info(ScenarioStepsUtils.getSteps(scenario).get(lineCount) + " : step is started ");
        }
    }

    @AfterStep
    public void afterSteps(Scenario scenario) {
        if (lineCount < ScenarioStepsUtils.getSteps(scenario).size()) {
            MyLogger.info(ScenarioStepsUtils.getSteps(scenario).get(lineCount) + " : step is passed");
        }
        lineCount++;
    }

}



