package com.enjin.coin.sdk.service.notifications;

public interface ThirdPartyNotificationService {

    /**
     * Method to initialize the notification service.
     * @param appId
     * @param appKey
     * @param appSecret
     * @param cluster
     * @param appChannel
     * @param activityTimeout
     * @return
     */
    boolean initializeNotificationService(String appId, String appKey, String appSecret, String cluster, String appChannel, Long activityTimeout);

}
