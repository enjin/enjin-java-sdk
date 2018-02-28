package io.enjincoin.sdk.client.service.notifications.impl;

import com.enjin.java_commons.*;
import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.SubscriptionEventListener;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.ConnectionStateChange;
import io.enjincoin.sdk.client.config.Notification;
import io.enjincoin.sdk.client.enums.NotificationType;
import io.enjincoin.sdk.client.service.notifications.NotificationListenerRegistration;
import io.enjincoin.sdk.client.service.notifications.ThirdPartyNotificationService;
import io.enjincoin.sdk.client.vo.notifications.ImmutableNotificationEvent;
import io.enjincoin.sdk.client.vo.notifications.NotificationEvent;
import io.enjincoin.sdk.client.vo.platform.GetPlatformAuthDetailsResponseVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * <p>Service to implement methods that interact with the pusher library.</p>
 */
public class PusherNotificationServiceImpl implements ThirdPartyNotificationService {

    /**
     * Logger used by this class.
     */
    private static final Logger LOGGER = Logger.getLogger(PusherNotificationServiceImpl.class.getName());

    /**
     * Local pusher variable.
     **/
    private Pusher pusher;

    /**
     * Local channel variable .
     **/
    private Channel channel;

    /**
     * Local variable holding all the notification listener registrations.
     */
    private List<NotificationListenerRegistration> notificationListenerRegistrations = new ArrayList<>();

    /**
     * Local notificationConfig variable.
     */
    private Notification notificationConfig;

    /**
     * Class constructor.
     *
     * @param notificationConfig to use
     */
    public PusherNotificationServiceImpl(final Notification notificationConfig) {
        this.notificationConfig = notificationConfig;
    }

    /**
     * Method to initialize the notification service.
     *
     * @param getPlatformAuthDetailsResponseVO notification details config
     *
     * @return boolean
     */
    @Override
    public boolean init(final GetPlatformAuthDetailsResponseVO getPlatformAuthDetailsResponseVO) {
        boolean initializeResult = false;

        if (getPlatformAuthDetailsResponseVO == null) {
            LOGGER.warning("getPlatformAuthDetailsResponseVO passed in is null");
            return initializeResult;
        }

        if (getPlatformAuthDetailsResponseVO.getClientInfoMap() == null
                || BooleanUtils.isFalse(getPlatformAuthDetailsResponseVO.getClientInfoMap().isPresent())) {
            LOGGER.warning("clientInfoMap passed in is null or not present");
            return initializeResult;
        }
        if (getPlatformAuthDetailsResponseVO.getChannelsMap() == null || BooleanUtils.isFalse(getPlatformAuthDetailsResponseVO.getChannelsMap().isPresent())) {
            LOGGER.warning("channelsMap passed in is null or not present");
            return initializeResult;
        }

        Map<String, Object> clientInfoMap = getPlatformAuthDetailsResponseVO.getClientInfoMap().get();
        Map<String, Object> channelsMap = getPlatformAuthDetailsResponseVO.getChannelsMap().get();

        if (MapUtils.isEmpty(clientInfoMap) || MapUtils.isEmpty(channelsMap)) {
            LOGGER.warning("clientInfoMap or channelsMap are null or empty");
            return initializeResult;
        }

        String appKey = MapUtils.mapKeyValueToString(clientInfoMap, "app_key");
        String cluster = MapUtils.mapKeyValueToString(clientInfoMap, "cluster");
        String appChannel = MapUtils.mapKeyValueToString(channelsMap, "server");
        Long activityTimeout = this.notificationConfig.getActivityTimeout();

        if (StringUtils.isEmpty(appKey) ||StringUtils.isEmpty(cluster)) {
            LOGGER.warning("appId, appKey, appSecret or cluster is null or empty");
            return initializeResult;
        }

        if (StringUtils.isEmpty(appChannel)) {
            LOGGER.warning("appChannel is null or empty");
            return initializeResult;
        }

        // Create a new Pusher instance
        PusherOptions options = new PusherOptions()
                .setCluster(cluster)
                .setActivityTimeout(activityTimeout);
        this.pusher = new Pusher(appKey, options);

        //Connect to pusher
        this.pusher.connect(new ConnectionEventListener() {
            /**
             * Method call on connection state change.
             * @param change
             */
            @Override
            public void onConnectionStateChange(final ConnectionStateChange change) {
                LOGGER.fine(String.format("State changed to %s from %s ", change.getCurrentState(), change.getPreviousState()));
            }

            /**
             * Method call on connection error
             * @param message
             * @param code
             * @param exception
             */
            @Override
            public void onError(final String message, final String code, final Exception exception) {
                LOGGER.warning(String.format("There was a problem connecting!. Exception: %s", ExceptionUtils.exceptionToString(exception)));
            }
        }, ConnectionState.ALL);


        // Subscribe to a channel
        this.channel = this.pusher.subscribe(appChannel);

        //Convert an enum to an array of strings
        //String[] eventTypes = Arrays.stream(NotificationTypeEnum.values()).map(NotificationTypeEnum::name).toArray(String[]::new);

        for (NotificationType notificationTypeEnum : NotificationType.values()) {
            String eventType = notificationTypeEnum.getEventType();

            // Bind to listen for events that match the eventType and appChannel
            this.channel.bind(eventType, new SubscriptionEventListener() {
                /**
                 * Method called on new events from the channel.
                 * @param channel
                 * @param event
                 * @param data
                 */
                @Override
                public void onEvent(final String channel, final String event, final String data) {
                    PusherNotificationServiceImpl.this.fireNotification(data, channel, event);
                    LOGGER.fine(String.format("Received eventType %s, event %s with data %s ", eventType, event, data));
                }
            });
        }

        initializeResult = true;
        return initializeResult;
    }

    @Override
    public void shutdown() {
        if (this.pusher != null)
            this.pusher.disconnect();
    }

    /**
     * Method to fire a notification.
     *
     * @param sourceData the sourceData received from the notification
     * @param channel    the channel the notification was received from
     * @param eventType  the type of event we received
     */
    private void fireNotification(final String sourceData, final String channel, final String eventType) {

        if (CollectionUtils.isEmpty(this.notificationListenerRegistrations)) {
            LOGGER.warning("No listeners are currently registered");
            return;
        }

        NotificationType notificationTypeEnum = NotificationType.valueOfEnum(eventType.toUpperCase());
        if (notificationTypeEnum == NotificationType.UNKNOWN_EVENT) {
            LOGGER.warning(String.format("UNKNOWN_EVENT NotificationType returned for the eventType of %s", eventType));
            return;
        }

        NotificationEvent notificationEvent = ImmutableNotificationEvent.builder()
                .setSourceData(sourceData)
                .setChannel(channel)
                .setNotificationType(notificationTypeEnum)
                .build();

        for (NotificationListenerRegistration registration : this.notificationListenerRegistrations) {
            if (registration.getEventMatcher().matches(notificationEvent)) {
                registration.getListener().notificationReceived(notificationEvent);
            }
        }

    }

    /**
     * Method to set the notification listeners.
     *
     * @param argNotificationListeners - list of listeners to set as the new listeners
     */
    @Override
    public synchronized void setNotificationListeners(final List<NotificationListenerRegistration> argNotificationListeners) {
        this.notificationListenerRegistrations = argNotificationListeners;
    }
}
