package com.enjin.sdk.events;

import com.enjin.sdk.models.NotificationEvent;
import com.enjin.sdk.models.EventType;
import com.enjin.sdk.utils.LogLevel;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.channel.SubscriptionEventListener;

/**
 * Event listener class for subscribed pusher events. Used internally.
 *
 * @see PusherNotificationService
 */
public class PusherEventListener implements SubscriptionEventListener {

    private final PusherNotificationService service;

    /**
     * Sole constructor.
     *
     * @param service the pusher service
     */
    public PusherEventListener(PusherNotificationService service) {
        this.service = service;
    }

    @Override
    public void onEvent(PusherEvent event) {
        String eventName = event.getEventName();
        String channelName = event.getChannelName();
        String data = event.getData();

        service.getLoggerProvider().debug(String.format("Received event %s on channel %s with results %s",
                                                        eventName,
                                                        channelName,
                                                        data));
        call(eventName, channelName, data);
    }

    private void call(String key, String channel, String message) {
        if (service.listeners.isEmpty()) {
            service.getLoggerProvider().log(LogLevel.INFO, "No registered listeners received on event");
            return;
        }

        EventType type = EventType.getFromKey(key);
        if (type == EventType.UNKNOWN) {
            service.getLoggerProvider().log(LogLevel.WARN, String.format("Unknown event type for key %s", key));
            return;
        }

        NotificationEvent notificationEvent = new NotificationEvent(type, channel, message);

        for (NotificationListenerRegistration registration : service.listeners) {
            if (registration.getEventMatcher().matches(notificationEvent))
                registration.getListener().notificationReceived(notificationEvent);
        }
    }

}
