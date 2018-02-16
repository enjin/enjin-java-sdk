package io.enjincoin.sdk.client;

import io.enjincoin.sdk.client.config.Config;

/**
 * <p> Method to return the necessary client.</p>
 */
public class Clients {

    /**
     * Class constructor.
     */
    protected Clients() {

    }


    /**
     * Method to get the create EnjinCoin client.
     *
     * @param config to use
     *
     * @return Client
     */
    public static Client create(final Config config) {
        return new ClientImpl(config);
    }

}
