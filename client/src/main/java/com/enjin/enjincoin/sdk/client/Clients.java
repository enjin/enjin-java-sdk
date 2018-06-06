package com.enjin.enjincoin.sdk.client;

public final class Clients {

    private Clients() {
        super();
    }

    public static Client createClient(final String baseUrl, final int appId, final boolean log) {
        if (appId < 2) {
            throw new IllegalStateException("App ID must have a value greater than 2.");
        }
        return new ClientImpl(baseUrl, String.valueOf(appId), log);
    }

}
