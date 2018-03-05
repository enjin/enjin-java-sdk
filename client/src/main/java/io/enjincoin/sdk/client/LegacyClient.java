package io.enjincoin.sdk.client;

import io.enjincoin.sdk.client.service.legacy.events.EventsService;
import io.enjincoin.sdk.client.service.legacy.notifications.NotificationsService;
import io.enjincoin.sdk.client.service.legacy.platform.PlatformService;

/**
 * <p>Interface for the SyncClient create client.</p>
 */
public interface LegacyClient {

    /**
     * Method to get the eventsService.
     *
     * @return - SynchronousEventsService
     */
    EventsService getEventsService();

    /**
     * Method to get the notificationsService.
     *
     * @return - NotificationsService
     */
    NotificationsService getNotificationsService();

    /**
     * Method to get the platformService.
     *
     * @return - PlatformService
     */
    PlatformService getPlatformService();

    /**
     * Closes all active resources.
     */
    void close();
}
