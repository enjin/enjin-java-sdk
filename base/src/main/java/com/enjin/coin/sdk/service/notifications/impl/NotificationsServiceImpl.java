package com.enjin.coin.sdk.service.notifications.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.BaseService;
import com.enjin.coin.sdk.service.notifications.NotificationListener;
import com.enjin.coin.sdk.service.notifications.NotificationListenerRegistration;
import com.enjin.coin.sdk.service.notifications.NotificationsService;
import com.enjin.coin.sdk.service.notifications.ThirdPartyNotificationService;
import com.enjin.coin.sdk.util.BooleanUtils;
import com.enjin.coin.sdk.util.ObjectUtils;

/**
 *
 *<p>NotificationsService - Synchronous.</p>
 *
 */
public class NotificationsServiceImpl extends BaseService implements NotificationsService {

    /**
     * Logger used by this class.
     */
    private static final Logger LOGGER = Logger.getLogger(NotificationsServiceImpl.class.getName());

    /**
     * Local variable for the third party notification service.
     */
    private ThirdPartyNotificationService thirdPartyNotificationService;

    /**
     * Local variable holding all the notification listeners.
     */
    protected List<NotificationListenerRegistration> notificationListeners = new ArrayList<>();

    /**
     * Class constructor.
     *
     * @param config - the config to use
     */
    public NotificationsServiceImpl(final Config config) {
        super(config);
    }

    /**
     * Method to initialize the notifications service.
     * @return boolean
     */
    @Override
    public boolean initNotificationsService() {
        boolean initResult = false;

        //Setup the thirdPartyNotificationService to use the pusher service.
        thirdPartyNotificationService = new PusherNotificationServiceImpl(getNotification());

        boolean initPusherResult = thirdPartyNotificationService.initializeNotificationService();
        if (BooleanUtils.isNotTrue(initPusherResult)) {
            LOGGER.warning("A problem occured initializing the pusher library");
            return initResult;
        }
        return initPusherResult;
    }

    /**
     * Method to add a notification listener.
     * @param argNotificationListeners - listener to add
     */
    @Override
    public synchronized void addNotificationListener(final NotificationListener argNotificationListeners) {
        if (ObjectUtils.isNull(argNotificationListeners)) {
            LOGGER.warning("Could not add a NotificationListener because it was null.");
            return;
        }

        long count = notificationListeners.stream()
                .filter(registration -> registration.getListener() == argNotificationListeners)
                .count();

        if (count == 0) {
            NotificationListenerRegistration registration = new NotificationListenerRegistration(argNotificationListeners);
            notificationListeners.add(registration);

            thirdPartyNotificationService.setNotificationListeners(notificationListeners);
        } else {
            LOGGER.warning("Could not add a NotificationListener because it was already registered.");
        }
    }

    /**
     * Method to remove a notification listener.
     * @param argNotificationListeners - listener to remove
     */
    @Override
    public synchronized void removeNotificationListener(final NotificationListener argNotificationListeners) {
        if (ObjectUtils.isNull(argNotificationListeners)) {
            LOGGER.warning("Could not remove a NotificationListener because it was null.");
            return;
        }

        List<NotificationListenerRegistration> matching = notificationListeners.stream()
                .filter(registration -> registration.getListener() == argNotificationListeners)
                .collect(Collectors.toList());
        if (matching.size() > 0) {
            matching.forEach(registration -> notificationListeners.remove(registration));

            thirdPartyNotificationService.setNotificationListeners(notificationListeners);
        } else {
            LOGGER.warning("Could not remove a NotificationListener because it wasn't already registered.");
        }
    }
}
