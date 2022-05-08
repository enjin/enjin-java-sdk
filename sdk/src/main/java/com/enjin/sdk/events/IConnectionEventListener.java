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

package com.enjin.sdk.events;

/**
 * Interface for receiving notifications about the connection state of the event service.
 *
 * @see IEventService
 */
public interface IConnectionEventListener {

    /**
     * Callback used when the service connects to the server.
     */
    default void onConnect() {
    }

    /**
     * Callback used when the service disconnects from the server.
     */
    default void onDisconnect() {
    }

    /**
     * Callback used when the service encounters an error with its connection to the server.
     *
     * @param e the exception
     */
    default void onError(Exception e) {
    }

}
