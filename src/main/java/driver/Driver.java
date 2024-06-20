package driver;

import java.time.Duration;
import java.util.Objects;

import static driver.DriverManager.*;
import static factory.DriverFactory.getBrowser;
import static property.Properties.browser;

public class Driver {

    public static void initDriver() {
        if (Objects.isNull(getDriver())) {
            settDriver(getBrowser(browser));
            getDriver().manage().window().maximize();
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        }
    }

    public static void tearDown() {
        if (Objects.nonNull(getDriver())) {
            getDriver().quit();
            unload();
        }
    }

}
