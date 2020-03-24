package com.enjin.sdk.services.notification.subscriptions;

import com.enjin.sdk.models.platform.PlatformDetails;

import lombok.NonNull;

public class UserChannel implements Channel {

    private PlatformDetails details;
    private int userId;

    public UserChannel(@NonNull PlatformDetails details, int userId) {
        this.details = details;
        this.userId = userId;
    }

    @Override
    public String channel() {
        return String.format("enjin.server.%s.%s.user.%s",
                             details.getNetwork().toLowerCase(),
                             details.getId(),
                             userId);
    }

}
