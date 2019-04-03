package com.enjin.enjincoin.sdk.service.notifications;

public enum ChannelEvent {

    IDENTITY("EnjinCoin\\Events\\EnjinEventIdentity"),
    TOKEN("EnjinCoin\\Events\\EnjinEventTokenEvent"),
    TRANSACTION("EnjinCoin\\Events\\EnjinEventTransaction"),
    UPDATE_BALANCE("EnjinCoin\\Events\\EnjinEventUpdateBalance");

    private String key;

    ChannelEvent(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
