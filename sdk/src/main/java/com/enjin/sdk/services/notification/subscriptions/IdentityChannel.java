package com.enjin.sdk.services.notification.subscriptions;

import com.enjin.sdk.models.platform.PlatformDetails;

import lombok.NonNull;

/**
 * Represents a channel to subscribe to for Trusted Platform identity events.
 */
public class IdentityChannel implements Channel {

    private PlatformDetails details;
    private int identityId;

    /**
     * Constructs a channel for the platform and identity.
     *
     * @param details    the platform details
     * @param identityId the identity id
     */
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
