package property;

public final class Properties {

    private Properties(){}

    public static String browser = System.getProperty("browser", "chrome");
    public static String retry = System.getProperty("retry", "no");
    public static String URL = System.getProperty("url","https://www.saucedemo.com/");

}
