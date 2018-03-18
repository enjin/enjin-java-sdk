package io.enjincoin.sdk.client;

public class Clients {

    public static Client createClient(String baseUrl, int appId, boolean log) {
        if (appId < 2)
            throw new IllegalStateException("App ID must have a value greater than 2.");
        return new ClientImpl(baseUrl, appId, log);
    }

}
