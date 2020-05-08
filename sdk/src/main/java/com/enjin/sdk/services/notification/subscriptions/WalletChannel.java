package com.enjin.sdk.services.notification.subscriptions;

import com.enjin.sdk.models.platform.PlatformDetails;

/**
 * Represents a channel to subscribe to for Trusted Platform wallet events.
 */
public class WalletChannel implements Channel {

    private PlatformDetails details;
    private String ethAddress;

    /**
     * Constructs a channel for the platform and wallet.
     *
     * @param details    the platform details
     * @param ethAddress the wallet's Ethereum address
     */
    public WalletChannel(PlatformDetails details, String ethAddress) {
        this.details = details;
        this.ethAddress = ethAddress;
    }

    @Override
    public String channel() {
        return String.format("enjincloud.%s.wallet.%s",
                             details.getNetwork().toLowerCase(),
                             ethAddress);
    }

}
