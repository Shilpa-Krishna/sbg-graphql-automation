package com.sbg.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    private static PropertiesUtil propertiesUtil;
    private static Properties properties;

    private PropertiesUtil() {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String propertyKey) {
        return properties.getProperty(propertyKey);
    }

    public static PropertiesUtil getInstance() {
        if (propertiesUtil == null) {
            propertiesUtil = new PropertiesUtil();
        }
        return propertiesUtil;
    }
}
