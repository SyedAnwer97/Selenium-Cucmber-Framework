package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static io.github.bonigarcia.wdm.WebDriverManager.*;

public final class DriverFactory {

    private DriverFactory() {
    }

    private final static Map<String, Supplier<WebDriver>> map = new HashMap<>();
    private static WebDriver driver = null;

    private final static Supplier<WebDriver> chrome = () -> {
        chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--incognito");
        co.addArguments("headless");
        driver = new ChromeDriver(co);
        return driver;
    };

    private final static Supplier<WebDriver> firefox = () -> {
        firefoxdriver().setup();
        FirefoxOptions fo = new FirefoxOptions();
        fo.addArguments("-private");
        fo.addArguments("--headless");
        driver = new FirefoxDriver(fo);
        return driver;
    };

    private final static Supplier<WebDriver> edge = () -> {
        edgedriver().setup();
        EdgeOptions eo = new EdgeOptions();
        eo.addArguments("-private");
        eo.addArguments("--headless");
        driver = new EdgeDriver(eo);
        return driver;
    };

    static {
        map.put("chrome", chrome);
        map.put("firefox", firefox);
        map.put("edge", edge);
    }

    public static WebDriver getBrowser(String Browser) {
        return map.get(Browser.toLowerCase()).get();
    }

}
