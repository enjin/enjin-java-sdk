package com.enjin.sdk.events.channels;

import com.enjin.sdk.models.Platform;
import lombok.NonNull;

/**
 * Represents a channel to subscribe to for Enjin Cloud asset events.
 *
 * @see com.enjin.sdk.events.NotificationsService
 */
public class AssetChannel implements Channel {

    private final Platform platform;
    private final String asset;

    /**
     * Constructs a channel for the given network and asset.
     *
     * @param platform the platform
     * @param asset the asset ID
     */
    public AssetChannel(@NonNull Platform platform, @NonNull String asset) {
        this.platform = platform;
        this.asset = asset;
    }

    @Override
    public String channel() {
        return String.format("enjincloud.%s.asset.%s",
                             platform.getNetwork().toLowerCase(),
                             asset);
    }

}
