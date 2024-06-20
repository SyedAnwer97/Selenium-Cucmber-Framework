package driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager() {
    }

    private final static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return tDriver.get();
    }

    public static void settDriver(WebDriver driver) {
        tDriver.set(driver);
    }

    public static void unload() {
        tDriver.remove();
    }

}
