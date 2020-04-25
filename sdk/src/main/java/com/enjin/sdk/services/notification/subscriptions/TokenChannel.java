package com.enjin.sdk.services.notification.subscriptions;

import com.enjin.sdk.models.platform.PlatformDetails;

public class TokenChannel implements Channel {

    private PlatformDetails details;
    private String tokenId;

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
