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
