package com.enjin.sdk.events.channels;

import com.enjin.sdk.models.Platform;
import lombok.NonNull;

/**
 * Represents a channel to subscribe to for Enjin Cloud wallet events.
 */
public class WalletChannel implements Channel {

    private final Platform platform;
    private final String wallet;

    /**
     * Constructs a channel for the given network and wallet.
     *
     * @param platform   the platform
     * @param wallet the wallet's address
     */
    public WalletChannel(@NonNull Platform platform, @NonNull String wallet) {
        this.platform = platform;
        this.wallet = wallet;
    }

    @Override
    public String channel() {
        return String.format("enjincloud.%s.wallet.%s",
                             platform.getNetwork().toLowerCase(),
                             wallet);
    }

}
