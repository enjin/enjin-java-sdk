package com.enjin.sdk.services.notification.subscriptions;

import com.enjin.sdk.models.platform.PlatformDetails;

/**
 * Represents a channel to subscribe to for Trusted Platform token events.
 */
public class TokenChannel implements Channel {

    private PlatformDetails details;
    private String tokenId;

    /**
     * Constructs a channel for the platform and token.
     *
     * @param details the platform details
     * @param tokenId the token id
     */
    public TokenChannel(PlatformDetails details, String tokenId) {
        this.details = details;
        this.tokenId = tokenId;
    }

    @Override
    public String channel() {
        return String.format("enjincloud.%s.token.%s",
                             details.getNetwork().toLowerCase(),
                             tokenId);
    }

}
