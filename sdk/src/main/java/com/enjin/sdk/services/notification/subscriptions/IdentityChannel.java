package com.enjin.sdk.services.notification.subscriptions;

import com.enjin.sdk.models.platform.PlatformDetails;

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
        return String.format("enjincloud.%s.identity.%s",
                             details.getNetwork().toLowerCase(),
                             identityId);
    }

}
