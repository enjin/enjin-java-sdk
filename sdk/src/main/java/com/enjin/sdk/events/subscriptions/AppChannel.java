package com.enjin.sdk.events.subscriptions;

import com.enjin.sdk.models.Platform;
import lombok.NonNull;

/**
 * Represents a channel to subscribe to for Enjin Cloud application events.
 */
public class AppChannel implements Channel {

    private final Platform platform;
    private final int appId;

    /**
     * Constructs a channel for the given network and application.
     *
     * @param platform the platform
     * @param appId    the app id
     */
    public AppChannel(@NonNull Platform platform, int appId) {
        this.platform = platform;
        this.appId = appId;
    }

    @Override
    public String channel() {
        return String.format("enjincloud.%s.app.%s",
                             platform.getNetwork().toLowerCase(),
                             appId);
    }

}
