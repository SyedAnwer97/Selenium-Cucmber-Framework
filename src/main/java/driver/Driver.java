package driver;

import java.util.Objects;

import static driver.DriverManager.*;
import static factory.DriverFactory.getBrowser;
import static property.Properties.browser;

public final class Driver {

    private Driver() {
    }

    public static void initDriver() {
        if (Objects.isNull(getDriver())) {
            settDriver(getBrowser(browser));
            getDriver().manage().window().maximize();
        }
    }

    public static void tearDown() {
        if (Objects.nonNull(getDriver())) {
            getDriver().quit();
            unload();
        }
    }

}
