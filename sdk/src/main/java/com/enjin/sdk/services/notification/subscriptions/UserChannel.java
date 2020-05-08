package com.enjin.sdk.services.notification.subscriptions;

import com.enjin.sdk.models.platform.PlatformDetails;

import lombok.NonNull;

/**
 * Represents a channel to subscribe to for Trusted Platform user events.
 */
public class UserChannel implements Channel {

    private PlatformDetails details;
    private int userId;

    /**
     * Constructs a channel for the platform and user.
     *
     * @param details the platform details
     * @param userId  the user id
     */
    public UserChannel(@NonNull PlatformDetails details, int userId) {
        this.details = details;
        this.userId = userId;
    }

    @Override
    public String channel() {
        return String.format("enjincloud.%s.user.%s",
                             details.getNetwork().toLowerCase(),
                             userId);
    }

}
