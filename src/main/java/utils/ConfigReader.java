package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    public Properties init() throws IOException {
        properties = new Properties();
        FileInputStream ip = new FileInputStream(".\\src\\test\\resources\\config.properties");
        properties.load(ip);

        return properties;
    }

}
