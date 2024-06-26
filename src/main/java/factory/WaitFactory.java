package factory;

import enums.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Consumer;

import static driver.DriverManager.getDriver;
import static java.time.Duration.ofSeconds;

public final class WaitFactory {
    
    private WaitFactory(){}

    private static WebElement webElement;

    public static WebElement wait(Waits waitCondition, By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), ofSeconds(10));
        switch (waitCondition) {
            case CLICK:
                webElement = wait.until(ExpectedConditions.elementToBeClickable(by));
            case PRESENCE:
                webElement = wait.until(ExpectedConditions.presenceOfElementLocated(by));
            case VISIBLE:
                webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            case NONE:
                webElement = getDriver().findElement(by);
        }
        return webElement;
    }

    public static void wait(Consumer<WebDriverWait> waitConsumer) {
        waitConsumer.accept(new WebDriverWait(getDriver(), ofSeconds(10)));
    }

}
