package com.enjin.sdk.events.subscriptions;

import com.enjin.sdk.models.Platform;
import lombok.NonNull;

/**
 * Represents a channel to subscribe to for Enjin Cloud player events.
 */
public class PlayerChannel implements Channel {

    private final Platform platform;
    private final int appId;
    private final int playerId;

    /**
     * Constructs a channel for the given network and player for the application.
     *
     * @param platform the platform
     * @param appId    the app id
     * @param playerId the identity id
     */
    public PlayerChannel(@NonNull Platform platform, int appId, int playerId) {
        this.platform = platform;
        this.appId = appId;
        this.playerId = playerId;
    }

    @Override
    public String channel() {
        return String.format("enjincloud.%s.app.%s.player.%s",
                             platform.getNetwork().toLowerCase(),
                             appId,
                             playerId);
    }

}
