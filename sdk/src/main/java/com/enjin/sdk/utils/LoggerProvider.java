package com.enjin.sdk.utils;

import lombok.Getter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerProvider {

    @Getter
    private Logger logger;
    private Level defaultLevel;
    @Getter
    private boolean debug;
    private Level debugLevel;

    public LoggerProvider(Logger logger) {
        this(logger, false);
    }

    public LoggerProvider(Logger logger, boolean debug) {
        this(logger, debug, Level.FINE);
    }

    public LoggerProvider(Logger logger, boolean debug, Level debugLevel) {
        this.logger = logger;
        this.defaultLevel = debugLevel;
        this.debug = debug;
        this.debugLevel = debugLevel;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;

        if (debug)
            logger.setLevel(debugLevel);
        else
            logger.setLevel(defaultLevel);
    }

    public void log(Level level, String message) {
        if (logger.isLoggable(level))
            logger.log(level, message);
    }

    public void log(Level level, String message, Exception e) {
        if (logger.isLoggable(level))
            logger.log(level, message, e);
    }

    public void log(String message) {
        log(defaultLevel, message);
    }

    public void debug(String message) {
        log(debugLevel, message);
    }
}
