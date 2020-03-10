package com.enjin.sdk.service.notifications.subscriptions;

import com.enjin.sdk.model.service.platform.PlatformDetails;

import lombok.NonNull;

public class IdentityChannel implements Channel {

    private PlatformDetails details;
    private int identityId;

    public IdentityChannel(@NonNull PlatformDetails details, int identityId) {
        this.details = details;
        this.identityId = identityId;
    }

    @Override
    public String channel() {
        return String.format("enjin.server.%s.%s.identity.%s",
                             details.getNetwork().toLowerCase(),
                             details.getId(),
                             identityId);
    }

}
