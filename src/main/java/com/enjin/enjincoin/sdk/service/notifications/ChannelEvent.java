package com.enjin.enjincoin.sdk.service.notifications;

public enum ChannelEvent {

    IDENTITY("EnjinCoin\\Events\\EnjinEventIdentity"),
    TOKEN("EnjinCoin\\Events\\EnjinEventTokenEvent"),
    TRANSACTION("EnjinCoin\\Events\\EnjinEventTransaction");

    private String key;

    ChannelEvent(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
