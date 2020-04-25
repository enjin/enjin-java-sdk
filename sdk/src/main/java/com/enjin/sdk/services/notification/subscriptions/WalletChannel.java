package com.enjin.sdk.services.notification.subscriptions;

import com.enjin.sdk.models.platform.PlatformDetails;

public class WalletChannel implements Channel {

    private PlatformDetails details;
    private String ethAddress;

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
