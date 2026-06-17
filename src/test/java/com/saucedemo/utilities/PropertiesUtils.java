package com.saucedemo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.saucedemo.constants.GlobalConstants.PROPERTIES_PATH;

public class PropertiesUtils {
    public static String readFromProperties(String key) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(PROPERTIES_PATH);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String value = properties.getProperty(key);
        fileInputStream.close();
        return value;

    }
}
