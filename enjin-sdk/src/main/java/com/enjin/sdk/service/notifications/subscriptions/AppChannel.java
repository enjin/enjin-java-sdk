package com.enjin.sdk.service.notifications.subscriptions;

import com.enjin.sdk.model.service.platform.PlatformDetails;

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
        return String.format("enjin.server.%s.%s.%s",
                             details.getNetwork().toLowerCase(),
                             details.getId(),
                             appId);
    }

}
