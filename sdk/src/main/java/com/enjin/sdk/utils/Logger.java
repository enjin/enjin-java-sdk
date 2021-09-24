/* Copyright 2021 Enjin Pte Ltd.
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
