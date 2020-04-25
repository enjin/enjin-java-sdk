package com.enjin.sdk.services.notification.subscriptions;

import com.enjin.sdk.models.platform.PlatformDetails;

import lombok.NonNull;

public class AppChannel implements Channel {

    private PlatformDetails details;
    private int appId;

    public AppChannel(@NonNull PlatformDetails details, int appId) {
        this.details = details;
        this.appId = appId;
    }

    @Override
    public String channel() {
        return String.format("enjincloud.%s.app.%s",
                             details.getNetwork().toLowerCase(),
                             appId);
    }

}
