package com.enjin.sdk.utils;

/**
 * Logger interface to be implemented for use by the SDK.
 */
public interface ILogger {
    /**
     * Logs the message at the given logging level.
     *
     * @param level the logging level
     * @param message the message
     */
    void log(LogLevel level, String message);

    /**
     * Formats and logs the message and exception at the logging level.
     *
     * @param level the logging level
     * @param message the message
     * @param e the exception
     */
    void log(LogLevel level, String message, Exception e);

    /**
     * Determines if the given logging level is enabled for this logger.
     *
     * @param level the logging level
     *
     * @return whether this logger is enabled for the given logging level
     */
    boolean isLoggable(LogLevel level);
}
