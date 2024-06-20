package utils;

import enums.Locators;
import org.openqa.selenium.By;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

public class LocatorUtils {

    private LocatorUtils() {
    }

    private static final Map<Locators, Function<String, By>> map = new EnumMap<>(Locators.class);

    private static final Function<String, By> ID = By::id;
    private static final Function<String, By> NAME = By::name;
    private static final Function<String, By> CLASSNAME = By::className;
    private static final Function<String, By> LINKTEXT = By::linkText;
    private static final Function<String, By> PARTIALLINKTEXT = By::partialLinkText;
    private static final Function<String, By> XPATH = By::xpath;
    private static final Function<String, By> CSSSELECTOR = By::cssSelector;

    static {
        map.put(Locators.ID, ID);
        map.put(Locators.NAME, NAME);
        map.put(Locators.CLASSNAME, CLASSNAME);
        map.put(Locators.LINKTEXT, LINKTEXT);
        map.put(Locators.PARTIALLINKTEXT, PARTIALLINKTEXT);
        map.put(Locators.XPATH, XPATH);
        map.put(Locators.CSSSELECTOR, CSSSELECTOR);
    }

    public static By byLocator(Locators locatorType, String locatorValue) {
        return map.get(locatorType).apply(locatorValue);
    }
}
