/* Copyright 2021 Enjin Pte. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.enjin.sdk.utils;

import lombok.Getter;

/**
 * Provider class for an object implementing {@link ILogger}.
 *
 * @see ILogger
 */
public class LoggerProvider {

    /**
     * -- GETTER --
     *
     * @return the logger
     */
    @Getter
    private final ILogger logger;

    /**
     * -- GETTER --
     *
     * @return the default logging level
     */
    @Getter
    private final LogLevel defaultLevel;

    /**
     * -- GETTER --
     *
     * @return the debug logging level
     */
    @Getter
    private final LogLevel debugLevel;

    /**
     * Constructs the provider with the given logger.
     * <p>
     * The default logging level is set to {@link LogLevel#INFO} and the debug logging level is set to
     * {@link LogLevel#DEBUG}.
     * </p>
     *
     * @param logger the logger
     */
    public LoggerProvider(final ILogger logger) {
        this(logger, LogLevel.INFO, LogLevel.DEBUG);
    }

    /**
     * Constructs the provider with the given logger and logging levels.
     *
     * @param logger       the logger
     * @param defaultLevel the default logging level
     * @param debugLevel   the debug logging level
     */
    public LoggerProvider(final ILogger logger, final LogLevel defaultLevel, final LogLevel debugLevel) {
        this.logger = logger;
        this.defaultLevel = defaultLevel;
        this.debugLevel = debugLevel;
    }

    /**
     * Logs the message at the default logging level.
     *
     * @param message the message
     */
    public void log(final String message) {
        log(defaultLevel, message);
    }

    /**
     * Logs the message at the debug logging level.
     *
     * @param message the message
     */
    public void debug(final String message) {
        log(debugLevel, message);
    }

    /**
     * Logs the message at the given logging level.
     *
     * @param level   the logging level
     * @param message the message
     */
    public void log(final LogLevel level, final String message) {
        if (logger.isLoggable(level))
            logger.log(level, message);
    }

    /**
     * Formats and logs the message and exception at the default logging level.
     *
     * @param message the message
     * @param e       the exception
     */
    public void log(final String message, final Exception e) {
        log(defaultLevel, message, e);
    }

    /**
     * Formats and logs the message and exception at the debug logging level.
     *
     * @param message the message
     * @param e       the exception
     */
    public void debug(final String message, final Exception e) {
        log(debugLevel, message, e);
    }

    /**
     * Formats and logs the message and exception at the given logging level.
     *
     * @param level   the logging level
     * @param message the message
     * @param e       the exception
     */
    public void log(final LogLevel level, final String message, final Exception e) {
        if (logger.isLoggable(level))
            logger.log(level, message, e);
    }

}
