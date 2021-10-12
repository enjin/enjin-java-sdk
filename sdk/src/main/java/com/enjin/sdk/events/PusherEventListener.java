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

import com.enjin.sdk.models.NotificationEvent;
import com.enjin.sdk.models.EventType;
import com.enjin.sdk.utils.LogLevel;
import com.enjin.sdk.utils.LoggerProvider;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.channel.SubscriptionEventListener;

/**
 * Event listener class for subscribed pusher events. Used internally.
 *
 * @see PusherEventService
 */
public class PusherEventListener implements SubscriptionEventListener {

    private final PusherEventService service;

    /**
     * Sole constructor.
     *
     * @param service the pusher service
     */
    public PusherEventListener(PusherEventService service) {
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
        final LoggerProvider loggerProvider = service.getLoggerProvider();

        if (service.listeners.isEmpty()) {
            if (loggerProvider != null)
                loggerProvider.log(LogLevel.INFO, "No registered listeners received on event");

            return;
        }

        EventType type = EventType.getFromKey(key);
        if (type == EventType.UNKNOWN) {
            if (loggerProvider != null)
                loggerProvider.log(LogLevel.WARN, String.format("Unknown event type for key %s", key));

            return;
        }

        NotificationEvent notificationEvent = new NotificationEvent(type, channel, message);

        for (EventListenerRegistration registration : service.listeners) {
            if (registration.getEventMatcher().matches(notificationEvent))
                registration.getListener().notificationReceived(notificationEvent);
        }
    }

}
