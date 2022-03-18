package utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public Properties init() throws IOException {
        Properties properties = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
            properties.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert ip != null;
            ip.close();
        }


        return properties;
    }

}
