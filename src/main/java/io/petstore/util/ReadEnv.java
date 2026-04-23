package io.petstore.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadEnv {

    static Properties properties;

    static
    {
        String fileName = System.getProperty("env") == null ? "qa.properties" : System.getProperty("env") + ".properties";

        properties = new Properties();
        InputStream inputStream = ReadEnv.class.getClassLoader().getResourceAsStream(fileName);

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
