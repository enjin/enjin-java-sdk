package com.enjin.sdk.services.notification.subscriptions;

import com.enjin.sdk.models.Platform;
import lombok.NonNull;

/**
 * Represents a channel to subscribe to for Enjin Cloud wallet events.
 */
public class WalletChannel implements Channel {

    private final Platform platform;
    private final String ethAddress;

    /**
     * Constructs a channel for the given network and wallet.
     *
     * @param platform   the platform
     * @param ethAddress the wallet's Ethereum address
     */
    public WalletChannel(@NonNull Platform platform, @NonNull String ethAddress) {
        this.platform = platform;
        this.ethAddress = ethAddress;
    }

    @Override
    public String channel() {
        return String.format("enjincloud.%s.wallet.%s",
                             platform.getNetwork().toLowerCase(),
                             ethAddress);
    }

}
