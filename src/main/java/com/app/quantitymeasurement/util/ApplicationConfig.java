package com.app.quantitymeasurement.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents ApplicationConfig.
 */
public class ApplicationConfig {
    /**
     * Property logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);
    /**
     * Property properties.
     */
    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    /**
     * Execution logic for loadProperties.
     */
    private static void loadProperties() {
        try (InputStream input = ApplicationConfig.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                logger.warn("Unable to find application.properties. Using default values.");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            logger.error("Error loading application.properties", ex);
        }
    }

    /**
     * Execution logic for getProperty.
     */
    public static String getProperty(String key, String defaultValue) {
        String sysProp = System.getProperty(key);
        if (sysProp != null) {
            return sysProp;
        }
        return properties.getProperty(key, defaultValue);
    }

    /**
     * Execution logic for getProperty.
     */
    public static String getProperty(String key) {
        return getProperty(key, null);
    }
}
