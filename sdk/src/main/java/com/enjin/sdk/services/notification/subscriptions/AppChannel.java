package com.enjin.sdk.services.notification.subscriptions;

import com.enjin.sdk.models.platform.PlatformDetails;

import lombok.NonNull;

/**
 * Represents a channel to subscribe to for Trusted Platform application events.
 */
public class AppChannel implements Channel {

    private PlatformDetails details;
    private int appId;

    /**
     * Constructs a channel for the platform and application.
     *
     * @param details the platform details
     * @param appId   the app id
     */
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
