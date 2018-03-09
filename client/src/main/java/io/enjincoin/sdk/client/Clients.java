package io.enjincoin.sdk.client;

public class Clients {

    public static Client createClient(String baseUrl) {
        return new ClientImpl(baseUrl);
    }

}
