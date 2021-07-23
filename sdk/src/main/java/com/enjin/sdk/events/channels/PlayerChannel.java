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
    private final String project;
    private final String player;

    /**
     * Constructs a channel for the given network and player on a project.
     *
     * @param platform the platform
     * @param project the project's UUID
     * @param player the identity ID
     */
    public PlayerChannel(@NonNull Platform platform, String project, String player) {
        this.platform = platform;
        this.project = project;
        this.player = player;
    }

    @Override
    public String channel() {
        return String.format("enjincloud.%s.project.%s.player.%s",
                             platform.getNetwork().toLowerCase(),
                             project,
                             player);
    }

}
