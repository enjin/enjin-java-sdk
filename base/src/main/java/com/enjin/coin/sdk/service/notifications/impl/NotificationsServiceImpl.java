package com.enjin.coin.sdk.service.notifications.impl;

import java.util.logging.Logger;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.config.Notifications;
import com.enjin.coin.sdk.service.BaseService;
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
     * Class constructor.
     *
     * @param config - the config to use
     */
    public NotificationsServiceImpl(final Config config) {
        super(config);

        initNotificationsService(config.getNotifications());
    }

    /**
     * Method to initialize the notifications service.
     * @param notifications
     */
    private void initNotificationsService(Notifications notifications) {

        if (notifications == null) {
            LOGGER.warning("Notifications config is null.");
            return ;
        }

        String appId         = notifications.getAppId();
        String appKey        = notifications.getAppKey();
        String appSecret     = notifications.getAppSecret();
        String cluster       = notifications.getCluster();
        String appChannel    = notifications.getAppChannel();
        Long activityTimeout = notifications.getActivityTimeout();

        //Setup the thirdPartyNotificationService to use the pusher service.
        thirdPartyNotificationService = new PusherServiceImpl();

        boolean initPusherResult = thirdPartyNotificationService.initializeNotificationService(appId, appKey, appSecret, cluster, appChannel, activityTimeout);
        if (BooleanUtils.isNotTrue(initPusherResult)) {
            LOGGER.warning("A problem occured initializing the pusher library");
        }
    }

}
