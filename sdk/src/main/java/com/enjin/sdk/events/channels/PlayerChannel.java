package com.enjin.sdk.events.channels;

import com.enjin.sdk.models.Platform;
import lombok.NonNull;

/**
 * Represents a channel to subscribe to for Enjin Cloud player events.
 *
 * @see com.enjin.sdk.events.NotificationsService
 */
public class PlayerChannel implements Channel {

    private final Platform platform;
    private final int app;
    private final String player;

    /**
     * Constructs a channel for the given network and player on a application.
     *
     * @param platform the platform
     * @param app the app ID
     * @param player the identity ID
     */
    public PlayerChannel(@NonNull Platform platform, int app, String player) {
        this.platform = platform;
        this.app = app;
        this.player = player;
    }

    @Override
    public String channel() {
        return String.format("enjincloud.%s.app.%s.player.%s",
                             platform.getNetwork().toLowerCase(),
                             app,
                             player);
    }

}
