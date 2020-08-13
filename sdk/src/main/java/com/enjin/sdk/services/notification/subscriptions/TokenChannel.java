package com.enjin.sdk.services.notification.subscriptions;

import com.enjin.sdk.models.Platform;
import lombok.NonNull;

/**
 * Represents a channel to subscribe to for Enjin Cloud token events.
 */
public class TokenChannel implements Channel {

    private final Platform platform;
    private final String tokenId;

    /**
     * Constructs a channel for the given network and token.
     *
     * @param platform the platform
     * @param tokenId  the token id
     */
    public TokenChannel(@NonNull Platform platform, @NonNull String tokenId) {
        this.platform = platform;
        this.tokenId = tokenId;
    }

    @Override
    public String channel() {
        return String.format("enjincloud.%s.token.%s",
                             platform.getNetwork().toLowerCase(),
                             tokenId);
    }

}
