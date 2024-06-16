package hooks;

import driver.DriverManager;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        //TODO
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) DriverManager.getDriver();
            byte[] screenshotAs = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotAs, "image/png", "screenshot");
        }
        DriverManager.getDriver().quit();
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
