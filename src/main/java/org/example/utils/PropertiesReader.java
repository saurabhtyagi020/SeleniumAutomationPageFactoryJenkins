package org.example.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static String path= System.getProperty("user.dir")+"/src/main/resources/config.properties";

    public static String readKey(String key)  {
        try {
            FileInputStream file = new FileInputStream(path);
            Properties prop = new Properties();
            prop.load(file);
            return prop.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
