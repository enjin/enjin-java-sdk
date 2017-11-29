package com.enjin.coin.sdk.service.notifications.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.config.Notification;
import com.enjin.coin.sdk.service.BaseService;
import com.enjin.coin.sdk.service.notifications.NotificationListener;
import com.enjin.coin.sdk.service.notifications.NotificationsService;
import com.enjin.coin.sdk.service.notifications.ThirdPartyNotificationService;
import com.enjin.coin.sdk.util.BooleanUtils;

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
     * Local variable holding all the notification listeners
     */
    private List<NotificationListener> _notificationListeners = new ArrayList<NotificationListener>();


    /**
     * Class constructor.
     *
     * @param config - the config to use
     */
    public NotificationsServiceImpl(final Config config) {
        super(config);

        initNotificationsService(config.getNotification());
    }

    /**
     * Method to initialize the notifications service.
     * @param notifications
     */
    private void initNotificationsService(Notification notification) {

        if (notification == null) {
            LOGGER.warning("notification config is null.");
            return ;
        }

        //Setup the thirdPartyNotificationService to use the pusher service.
        thirdPartyNotificationService = new PusherServiceImpl();

        boolean initPusherResult = thirdPartyNotificationService.initializeNotificationService(notification);
        if (BooleanUtils.isNotTrue(initPusherResult)) {
            LOGGER.warning("A problem occured initializing the pusher library");
        }
    }

    /**
     * Method to add a notification listener.
     * @param notificationListener
     */
    @Override
    public synchronized void addNotificationListener(NotificationListener notificationListener) {
        _notificationListeners.add(notificationListener);
        thirdPartyNotificationService.setNotificationListeners(_notificationListeners);
    }

    /**
     * Method to remove a notification listener.
     * @param notificationListener
     */
    @Override
    public synchronized void removeNotificationListener(NotificationListener notificationListener) {
        _notificationListeners.remove(notificationListener);
        thirdPartyNotificationService.setNotificationListeners(_notificationListeners);
    }
}
