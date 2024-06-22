package pages;

import enums.Waits;
import factory.WaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.function.Function;

import static driver.DriverManager.getDriver;

public class PageActions {

    protected void click(Waits waits, By by) {
        WaitFactory.wait(waits, by).click();
    }

    protected void sendKeys(Waits waits, By by, String value) {
        WaitFactory.wait(waits, by).sendKeys(value);
    }

    protected WebElement findElement(By by) {
        return getDriver().findElement(by);
    }

    protected Object driverActions(Function<WebDriver, Object> function) {
        return function.apply(getDriver());
    }

}
