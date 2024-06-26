package utils;

import enums.ConfigProperties;
import exception.PropertyFileUsageException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils() {
    }

    private static final String PROPERTYFILEPATH = System.getProperty("user.dir") + "/src/test/resources/config.properties";
    private static Properties properties = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();

    static {
        try (FileInputStream fis = new FileInputStream(PROPERTYFILEPATH)) {
            properties.load(fis);
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                CONFIGMAP.put(String.valueOf(entry.getKey()).toLowerCase(), String.valueOf(entry.getValue()).trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static String get(ConfigProperties key) {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
            throw new PropertyFileUsageException("Property name " + key + " is not found. Please check config.properties");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }
}
