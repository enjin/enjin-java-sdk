package com.enjin.sdk.models.notification;

import com.enjin.sdk.models.request.TransactionType;
import com.enjin.sdk.serialization.TransactionTypeDeserializer;
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
     * Returns the Gson instance used to deserialize event data.
     *
     * @return the Gson instance.
     */
    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(TransactionType.class, new TransactionTypeDeserializer())
            .create();

    /**
     * The event type.
     *
     * @param type the notification type.
     * @return the builder.
     *
     * -- GETTER --
     * Returns the event type.
     *
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
     * Returns the notification channel.
     *
     * @return the channel.
     */
    private String channel;

    /**
     * The data.
     *
     * @param data the notification data.
     * @return the builder.
     *
     * -- GETTER --
     * Returns the data.
     *
     * @return the data.
     */
    private String data;

    /**
     * -- GETTER --
     * The deserialized data. Lazy loaded.
     *
     * @return the deserialized data
     */
    @Getter(lazy = true)
    private final JsonObject eventData = eventData();

    private JsonObject eventData() {
        return GSON.fromJson(data, JsonObject.class);
    }

}
