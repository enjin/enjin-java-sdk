package com.enjin.sdk.service.notifications;

/**
 * The channels specified by the trusted platform.
 *
 * @author Evan Lindsay
 */
public enum ChannelEvent {

    IDENTITY("EnjinCoin\\Events\\EnjinEventIdentity"),
    TOKEN("EnjinCoin\\Events\\EnjinEventTokenEvent"),
    TRANSACTION("EnjinCoin\\Events\\EnjinEventTransaction"),
    UPDATE_BALANCE("EnjinCoin\\Events\\EnjinEventUpdateBalance");

    private final String key;

    ChannelEvent(String key) {
        this.key = key;
    }

    /**
     * The channel event key.
     *
     * @return the key.
     */
    public String getKey() {
        return this.key;
    }
}
