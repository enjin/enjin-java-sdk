package com.enjin.coin.sdk.service.notifications.impl;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.notifications.NotificationsAsyncService;

/**
 *
 *<p>NotificationsService - Asynchronous.</p>
 *
 */
public class NotificationsAsyncServiceImpl extends NotificationsServiceImpl implements NotificationsAsyncService {

    /**
     * Class constructor.
     *
     * @param config - the config to use
     */
    public NotificationsAsyncServiceImpl(final Config config) {
        super(config);
    }

}
