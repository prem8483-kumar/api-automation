package com.api.automation.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfig {

    public static Properties properties;

    static
    {
        String fileName = System.getenv("env") == null ? "env.properties" : System.getenv("env") + ".properties";

        properties = new Properties();
        InputStream inputStream = ReadConfig.class.getClassLoader().getResourceAsStream(fileName);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static  String getProperty(String key) {
        return properties.getProperty(key);
    }
}
