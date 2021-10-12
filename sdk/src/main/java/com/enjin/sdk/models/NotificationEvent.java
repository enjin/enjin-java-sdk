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

package com.enjin.sdk.models;

import com.enjin.sdk.serialization.RequestTypeDeserializer;
import com.enjin.sdk.events.IEventService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.JsonObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * Container class for notification data from the platform.
 *
 * @see IEventService
 * @see EventType
 */
@EqualsAndHashCode
@Getter
@ToString
public class NotificationEvent {

    /**
     * -- GETTER --
     * @return the Gson instance used to deserialize event data.
     */
    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(RequestType.class, new RequestTypeDeserializer())
            .create();

    /**
     * -- GETTER --
     * @return the event type
     */
    private final EventType type;

    /**
     * -- GETTER --
     * @return the notification channel
     */
    private final String channel;

    /**
     * -- GETTER --
     * @return the raw data
     */
    private final String message;

    /**
     * -- GETTER --
     * @return the deserialized data. Lazy loaded
     */
    @Getter(lazy = true)
    private final JsonObject data = eventData();

    /**
     * Constructor for internal use.
     *
     * @param type the notification type
     * @param channel the channel
     * @param message the notification data
     */
    public NotificationEvent(@NonNull EventType type, @NonNull String channel, @NonNull String message) {
        this.type = type;
        this.channel = channel;
        this.message = message;
    }

    private JsonObject eventData() {
        return GSON.fromJson(message, JsonObject.class);
    }

}
