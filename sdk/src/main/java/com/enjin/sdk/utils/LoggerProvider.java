package com.enjin.sdk.utils;

import lombok.Getter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provider class for a {@link Logger}.
 *
 * @see Logger
 */
public class LoggerProvider {

    /**
     * -- GETTER --
     * Returns the logger object.
     *
     * @return the logger
     */
    @Getter
    private Logger logger;
    private Level defaultLevel;
    /**
     * -- GETTER --
     * Determines if the debug level is used.
     *
     * @return true if the debug level is used, false otherwise
     */
    @Getter
    private boolean debug;
    private Level debugLevel;

    /**
     * Constructs the provider with the specified logger.
     *
     * @param logger the provider
     */
    public LoggerProvider(Logger logger) {
        this(logger, false);
    }

    /**
     * Constructs the provider with the specified logger and sets if debug is enabled.
     *
     * @param logger the provider
     * @param debug  if the debug level is used
     */
    public LoggerProvider(Logger logger, boolean debug) {
        this(logger, debug, Level.FINE);
    }

    /**
     * Constructs the provider with the specified logger and debug settings.
     *
     * @param logger     the logger
     * @param debug      if the debug level is used
     * @param debugLevel the debug log level
     */
    public LoggerProvider(Logger logger, boolean debug, Level debugLevel) {
        this.logger = logger;
        this.defaultLevel = debugLevel;
        this.debug = debug;
        this.debugLevel = debugLevel;
    }

    /**
     * Sets whether the debug level should be used.
     *
     * @param debug if the debug level is used
     */
    public void setDebug(boolean debug) {
        this.debug = debug;

        if (debug)
            logger.setLevel(debugLevel);
        else
            logger.setLevel(defaultLevel);
    }

    /**
     * Logs the message in the logger at the provided log level.
     *
     * @param level   the log level
     * @param message the message
     */
    public void log(Level level, String message) {
        if (logger.isLoggable(level))
            logger.log(level, message);
    }

    /**
     * Logs the message and exception in the logger at the provided log level.
     *
     * @param level   the log level
     * @param message the message
     * @param e       the exception
     */
    public void log(Level level, String message, Exception e) {
        if (logger.isLoggable(level))
            logger.log(level, message, e);
    }

    /**
     * Logs a message at the default level.
     *
     * @param message the message
     */
    public void log(String message) {
        log(defaultLevel, message);
    }

    /**
     * Logs a message at the debug level.
     *
     * @param message the message
     */
    public void debug(String message) {
        log(debugLevel, message);
    }
}
