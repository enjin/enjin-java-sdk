package com.enjin.enjincoin.sdk.model.service.notifications;

import com.enjin.enjincoin.sdk.model.service.requests.TransactionType;
import com.enjin.enjincoin.sdk.serialization.TransactionTypeDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Represents a trusted platform event.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.notifications.NotificationsService
 * @see NotificationType
 */
@ToString
@Getter
@Builder
public class NotificationEvent {

    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(TransactionType.class, new TransactionTypeDeserializer())
            .create();

    /**
     * The type of notification.
     *
     * -- GETTER --
     *
     * @return the type.
     * -- SETTER --
     * @param type the notification type.
     * @return the builder.
     */
    private NotificationType type;

    /**
     * The channel the notification was received.
     *
     * -- GETTER --
     *
     * @return the channel.
     * -- SETTER --
     * @param channel the channel.
     * @return the builder.
     */
    private String channel;

    /**
     * The notification data.
     *
     * -- GETTER --
     *
     * @return the data.
     * -- SETTER --
     * @param data the notification data.
     * @return the builder.
     */
    private String data;

    /**
     * -- GETTER --
     * The deserialized data. Lazy loaded.
     *
     * @return the deserialized data
     * -- SETTER --
     * @param event the deserialized event data.
     * @return the builder.
     */
    @Getter(lazy = true)
    private final Event event = event();

    private Event event() {
        return GSON.fromJson(data, Event.class);
    }

}
