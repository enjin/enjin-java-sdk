package com.enjin.sdk.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

/**
 * Basic logger class for logging messages to the console.
 */
public class Logger implements ILogger {
    private final org.apache.logging.log4j.Logger logger;

    /**
     * Sole constructor.
     */
    public Logger() {
        logger = LogManager.getLogger("Console");
    }

    @Override
    public void log(LogLevel level, String message) {
        logger.log(convertLogLevel(level), message);
    }

    @Override
    public void log(LogLevel level, String message, Exception e) {
        logger.log(convertLogLevel(level), message, e);
    }

    @Override
    public boolean isLoggable(LogLevel level) {
        switch (level) {
            case TRACE:
                return logger.isTraceEnabled();
            case DEBUG:
                return logger.isDebugEnabled();
            case INFO:
                return logger.isInfoEnabled();
            case WARN:
                return logger.isWarnEnabled();
            case ERROR:
                return logger.isErrorEnabled();
            case SEVERE:
                return logger.isFatalEnabled();
            default:
                return false;
        }
    }

    private static Level convertLogLevel(LogLevel level) {
        switch (level) {
            case TRACE:
                return Level.TRACE;
            case DEBUG:
                return Level.DEBUG;
            case INFO:
                return Level.INFO;
            case WARN:
                return Level.WARN;
            case ERROR:
                return Level.ERROR;
            case SEVERE:
                return Level.FATAL;
            default:
                return Level.OFF;
        }
    }
}
