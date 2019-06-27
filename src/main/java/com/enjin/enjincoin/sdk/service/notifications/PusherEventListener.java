package com.enjin.enjincoin.sdk.service.notifications;

import com.enjin.enjincoin.sdk.model.service.notifications.NotificationEvent;
import com.enjin.enjincoin.sdk.model.service.notifications.NotificationType;
import com.enjin.java_commons.CollectionUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.pusher.client.channel.SubscriptionEventListener;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class PusherEventListener implements SubscriptionEventListener {

    private static final Gson GSON = new GsonBuilder().create();
    private static final String EVENT_TYPE_KEY = "event_type";

    private PusherNotificationService service;

    public PusherEventListener(PusherNotificationService service) {
        this.service = service;
    }

    @Override
    public void onEvent(String channelName, String eventName, String data) {
        PusherEventListener.log.debug(String.format("Received event %s on channel %s with results %s ",
                                                    eventName,
                                                    channelName,
                                                    data));
        call(data, channelName, eventName);
    }

    private void call(String sourceData, String channel, String eventType) {
        if (CollectionUtils.isEmpty(service.listeners)) return;

        JsonElement      dataElement      = GSON.fromJson(sourceData, JsonElement.class);
        NotificationType notificationType = NotificationType.UNKNOWN_EVENT;

        if (dataElement == null ||
                !dataElement.isJsonObject() ||
                !dataElement.getAsJsonObject().has(EVENT_TYPE_KEY)) {
            return;
        }

        JsonObject  dataObject       = dataElement.getAsJsonObject();
        JsonElement eventTypeElement = dataObject.get(EVENT_TYPE_KEY);
        String      eventTypeString  = eventTypeElement.getAsString();

        for (NotificationType type : NotificationType.values()) {
            if (type.getEventType().equalsIgnoreCase(eventTypeString)) {
                notificationType = type;
                break;
            }
        }

        if (notificationType == NotificationType.UNKNOWN_EVENT) {
            PusherEventListener.log.warn(String.format("UNKNOWN_EVENT NotificationType %s returned for the eventType of %s",
                                                       eventTypeString, eventType));
            return;
        }

        NotificationEvent notificationEvent = NotificationEvent.builder()
                                                               .type(notificationType)
                                                               .channel(channel)
                                                               .data(sourceData)
                                                               .build();

        for (NotificationListenerRegistration registration : service.listeners) {
            if (registration.getEventMatcher().matches(notificationEvent)) {
                registration.getListener().notificationReceived(notificationEvent);
            }
        }

    }

}
