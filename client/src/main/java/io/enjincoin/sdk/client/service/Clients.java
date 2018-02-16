package io.enjincoin.sdk.client.service;

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
     * Method to get the sync EnjinCoint client.
     *
     * @param config to use
     * @return EnjinCoin
     */
    public static EnjinCoin sync(final Config config) {
        return new EnjinCoinAsyncClient(config);
    }

    /**
     * Method to get the async EnjinCoint client.
     *
     * @param config to use
     * @return EnjinCoinAsync
     */
    public static EnjinCoinAsync async(final Config config) {
        return new EnjinCoinAsyncClient(config);
    }

}
