package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Dika Brenda Angkasa on 23/05/2022
 */

public class LogUtils {
    
    private final static Logger LOGGER = LogManager.getLogger(LogUtils.class);

    public static void info(String message){
        LOGGER.info(message);
    }

    public static void warn(String message) {
        LOGGER.warn(message);
    }

    public static void debug(String message) {
        LOGGER.debug(message);
    }

    public static void trace(String message) {
        LOGGER.trace(message);
    }

    public static void error(String message) {
        LOGGER.error(message);
    }

    public static void error(String message, Throwable throwable) {
        LOGGER.error(message, throwable);
    }
}
