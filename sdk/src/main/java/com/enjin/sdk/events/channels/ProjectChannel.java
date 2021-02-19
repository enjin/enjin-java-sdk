package com.enjin.sdk.events.channels;

import com.enjin.sdk.models.Platform;
import lombok.NonNull;

/**
 * Represents a channel to subscribe to for Enjin Cloud project events.
 *
 * @see com.enjin.sdk.events.NotificationsService
 */
public class ProjectChannel implements Channel {

    private final Platform platform;
    private final int project;

    /**
     * Constructs a channel for the given network and project.
     *
     * @param platform the platform
     * @param project the project ID
     */
    public ProjectChannel(@NonNull Platform platform, int project) {
        this.platform = platform;
        this.project = project;
    }

    @Override
    public String channel() {
        return String.format("enjincloud.%s.project.%s",
                             platform.getNetwork().toLowerCase(),
                             project);
    }

}
