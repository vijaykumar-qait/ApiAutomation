package Utilities;

import java.util.Properties;

public class ConfigReader {
    /*Code to read data from config.properties file in resourse folder*/
    private Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getPaymentApplicationUrl() {
        return properties.getProperty("baseUrl");
    }

    public String getBookingApplicationUrl() {
        return properties.getProperty("bookingApplicationUrl");
    }

    public String getAuthenticationToken() {
        return properties.getProperty("authorization");
    }
}
