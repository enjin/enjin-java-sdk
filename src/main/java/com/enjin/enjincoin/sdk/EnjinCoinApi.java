package com.enjin.enjincoin.sdk;

import com.enjin.enjincoin.sdk.service.notifications.NotificationsService;
import lombok.Getter;

public class EnjinCoinApi {

    @Getter
    private TrustedPlatformClient client;
    @Getter
    private NotificationsService notifications;

    public EnjinCoinApi(TrustedPlatformClient client, NotificationsService notifications) {
        this.client = client;
        this.notifications = notifications;
    }

}
