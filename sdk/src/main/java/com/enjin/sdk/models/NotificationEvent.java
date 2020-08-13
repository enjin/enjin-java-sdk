package com.enjin.sdk.models;

import com.enjin.sdk.serialization.RequestTypeDeserializer;
import com.enjin.sdk.services.notification.NotificationsService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Represents a Trusted Platform Event.
 *
 * @author Evan Lindsay
 * @see NotificationsService
 * @see EventType
 */
@ToString
@Getter
@Builder
public class NotificationEvent {

    /**
     * The Gson instance used to deserialize event data.
     *
     * -- GETTER --
     * @return the Gson instance used to deserialize event data.
     */
    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(RequestType.class, new RequestTypeDeserializer())
            .create();

    /**
     * The event type.
     *
     * @param type the notification type.
     * @return the builder.
     *
     * -- GETTER --
     * @return the type.
     */
    private EventType type;
    /**
     * The notification channel.
     *
     * @param channel the channel.
     * @return the builder.
     *
     * -- GETTER --
     * @return the notification channel.
     */
    private String channel;
    /**
     * The data.
     *
     * @param data the notification data.
     * @return the builder.
     *
     * -- GETTER --
     * @return the data.
     */
    private String data;
    /**
     * -- GETTER --
     * @return the deserialized data. Lazy loaded.
     */
    @Getter(lazy = true)
    private final JsonObject eventData = eventData();

    private JsonObject eventData() {
        return GSON.fromJson(data, JsonObject.class);
    }

}
