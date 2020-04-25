package com.enjin.sdk.services.notification;

import java.util.logging.Level;

import com.enjin.sdk.models.notification.NotificationEvent;
import com.enjin.sdk.models.notification.EventType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.channel.SubscriptionEventListener;

public class PusherEventListener implements SubscriptionEventListener {

    private static final Gson GSON = new GsonBuilder().create();
    private static final String EVENT_TYPE_KEY = "event_type";

    private PusherNotificationService service;

    public PusherEventListener(PusherNotificationService service) {
        this.service = service;
    }

    @Override
    public void onEvent(PusherEvent event) {
        String eventName = event.getEventName();
        String channelName = event.getChannelName();
        String data = event.getData();

        service.getLoggerProvider().debug(String.format("Received event %s on channel %s with results %s", eventName, channelName, data));
        call(data, channelName, eventName);
    }

    private void call(String sourceData, String channel, String eventName) {
        if (service.listeners.isEmpty())
            return;

        JsonElement dataElement = GSON.fromJson(sourceData, JsonElement.class);
        EventType eventType = EventType.UNKNOWN_EVENT;

        if (dataElement == null || !dataElement.isJsonObject())
            return;

        JsonObject dataObject = dataElement.getAsJsonObject();
        JsonElement eventTypeElement = dataObject.get(EVENT_TYPE_KEY);
        String eventTypeString = eventTypeElement.getAsString();

        for (EventType type : EventType.values()) {
            if (type.getEventType().equalsIgnoreCase(eventTypeString)) {
                eventType = type;
                break;
            }
        }

        if (eventType == EventType.UNKNOWN_EVENT) {
            service.getLoggerProvider().log(Level.WARNING, String.format("UNKNOWN_EVENT NotificationType %s returned for eventType of %s", eventTypeString, eventName));
            return;
        }

        NotificationEvent notificationEvent = NotificationEvent.builder()
                                                               .type(eventType)
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
