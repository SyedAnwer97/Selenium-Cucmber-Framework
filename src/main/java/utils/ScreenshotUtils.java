package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static driver.DriverManager.getDriver;

public final class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static byte[] takeScreenShot() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
