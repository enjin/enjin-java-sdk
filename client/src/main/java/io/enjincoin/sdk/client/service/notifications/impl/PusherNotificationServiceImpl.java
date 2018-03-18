package io.enjincoin.sdk.client.service.notifications.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.enjin.java_commons.CollectionUtils;
import com.enjin.java_commons.ExceptionUtils;
import com.enjin.java_commons.StringUtils;
import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.SubscriptionEventListener;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.ConnectionStateChange;

import io.enjincoin.sdk.client.enums.NotificationType;
import io.enjincoin.sdk.client.service.notifications.NotificationListenerRegistration;
import io.enjincoin.sdk.client.service.notifications.ThirdPartyNotificationService;
import io.enjincoin.sdk.client.service.platform.vo.NotificationDetails;
import io.enjincoin.sdk.client.service.platform.vo.PlatformDetails;
import io.enjincoin.sdk.client.service.platform.vo.PlatformResponseBody;
import io.enjincoin.sdk.client.service.platform.vo.SdkDetails;
import io.enjincoin.sdk.client.util.Constants;
import io.enjincoin.sdk.client.vo.notifications.ImmutableNotificationEvent;
import io.enjincoin.sdk.client.vo.notifications.NotificationEvent;

/**
 * <p>Service to implement methods that interact with the pusher library.</p>
 */
public class PusherNotificationServiceImpl implements ThirdPartyNotificationService {

    /**
     * Logger used by this class.
     */
    private static final Logger LOGGER = Logger.getLogger(PusherNotificationServiceImpl.class.getName());

    private static final Map<String, NotificationType> notificationTypeMapping = new HashMap<String, NotificationType>(){{
        put("EnjinCoin\\Events\\EnjinEventTransaction", NotificationType.TX_EXECUTED);
        put("EnjinCoin\\Events\\EnjinEventTokenEvent", NotificationType.TX_EXECUTED);
    }};

    private int appId;

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
     * Local notification details method
     */
    private PlatformResponseBody platformResponseBody;

    /**
     * Class constructor.
     *
     * @param platformResponseBody to use
     */
    public PusherNotificationServiceImpl(final PlatformResponseBody platformResponseBody, int appId) {
        this.platformResponseBody = platformResponseBody;
        this.appId = appId;
    }

    /**
     * Method to initialize the notification service.
     *
     * @return boolean
     */
    @Override
    public boolean init() {
        boolean initializeResult = false;

        if (platformResponseBody == null || platformResponseBody.getNotificationDetails() == null) {
            LOGGER.warning("platformResponseBody or notificationDetails are null");
            return initializeResult;
        }

        PlatformDetails platformDetails = platformResponseBody.getPlatformDetails();
        if (platformDetails == null ) {
            LOGGER.warning("platformDetails are null");
            return initializeResult;
        }

        NotificationDetails notificationDetails = platformResponseBody.getNotificationDetails();
        if (notificationDetails == null ||notificationDetails.getSdkDetails() == null || notificationDetails.getSdkDetails().getOptions() == null) {
            LOGGER.warning("notificationDetails,the sdk details or the options are null");
            return initializeResult;
        }

        SdkDetails sdkDetails = notificationDetails.getSdkDetails();
        String appKey = sdkDetails.getKey();
        String cluster = sdkDetails.getOptions().getCluster();
        String appChannel = getAppChannel(platformDetails);
        boolean encrypted = sdkDetails.getOptions().getEncrypted();
        System.out.println("appChannel:"+appChannel);
        Long activityTimeout = Constants.FOUR_THOUSAND;

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
                .setActivityTimeout(activityTimeout)
                .setEncrypted(encrypted);
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
                LOGGER.warning(String.format("There was a problem connecting!. Exception: %s", ExceptionUtils.throwableToString(exception)));
            }
        }, ConnectionState.ALL);


        // Subscribe to a channel
        this.channel = this.pusher.subscribe(appChannel);

        //Convert an enum to an array of strings
        //String[] eventTypes = Arrays.stream(NotificationTypeEnum.values()).map(NotificationTypeEnum::name).toArray(String[]::new);

        for (Map.Entry<String, NotificationType> entry : notificationTypeMapping.entrySet()) {
            String eventType = entry.getKey();

            this.channel.bind(eventType, (channel, event, data) -> {
                LOGGER.fine(String.format("Received eventType %s, event %s with data %s ", eventType, event, data));
                PusherNotificationServiceImpl.this.fireNotification(data, channel, event);
            });
        }

        initializeResult = true;
        return initializeResult;
    }

    /**
     * Method to get the app channel
     * @param platformDetails
     * @return
     */
    private String getAppChannel(PlatformDetails platformDetails) {
        String platformId = platformDetails.getId();

        String appChannel = String.format("enjin.server.%s.%s", platformId, appId);
        return appChannel;
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

        NotificationType notificationTypeEnum = notificationTypeMapping.entrySet().stream()
                .filter(entry -> entry.getKey().equalsIgnoreCase(eventType))
                .map(Map.Entry::getValue)
                .findFirst().orElse(NotificationType.UNKNOWN_EVENT);

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
