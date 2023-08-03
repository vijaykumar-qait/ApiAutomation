package Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingUtil {
    private static final Logger logger = LoggerFactory.getLogger(LoggingUtil.class);
    /*Info message*/
    public static void info(String message) {
        logger.info(message);
    }
    /*Warning message*/
    public static void warn(String message) {
        logger.warn(message);
    }
    /*Error message*/
    public static void error(String message) {
        logger.error(message);
    }
}
