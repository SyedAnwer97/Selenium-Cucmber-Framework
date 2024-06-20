package utils;

import static java.lang.String.format;

public final class DynamicXpathUtils {

    private DynamicXpathUtils() {
    }

    public static String getDynamicXpath(String xpath, String value) {
        return format(xpath, value);
    }

    public static String getDynamicXpath(String xpath, String value1, String value2) {
        return format(xpath, value1, value2);
    }

}
