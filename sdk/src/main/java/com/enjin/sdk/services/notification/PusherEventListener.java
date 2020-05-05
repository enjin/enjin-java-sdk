package com.enjin.sdk.services.notification;

import java.util.logging.Level;

import com.enjin.sdk.models.notification.NotificationEvent;
import com.enjin.sdk.models.notification.EventType;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.channel.SubscriptionEventListener;

/**
 * Event listener class for subscribed pusher events.
 *
 * @see PusherNotificationService
 * @see PusherEvent
 */
public class PusherEventListener implements SubscriptionEventListener {

    private PusherNotificationService service;

    /**
     * Constructs a pusher event listener for the pusher service.
     *
     * @param service the notification service
     */
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
        if (service.listeners.isEmpty()) {
            service.getLoggerProvider().log(Level.INFO, "No registered listeners received on event");
            return;
        }

        EventType eventType = null;

        for (EventType type : EventType.values()) {
            if (type.getEventType().equals(eventName)) {
                eventType = type;
                break;
            }
        }

        if (eventType == null) {
            service.getLoggerProvider().log(Level.WARNING, String.format("UNKNOWN_EVENT event type of %s", eventName));
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
