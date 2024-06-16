package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();

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
