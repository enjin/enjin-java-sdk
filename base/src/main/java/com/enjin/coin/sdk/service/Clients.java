package com.enjin.coin.sdk.service;

import com.enjin.coin.sdk.config.Config;

/**
 * <p Method to return the necessary client. </p>
 *
 */
public class Clients {

    /**
     * Method to get the sync EnjinCoint client.
     * @param config
     * @return
     */
    public static EnjinCoin sync(Config config) {
        return new EnjinCoinAsyncClient(config);
    }

    /**
     * Method to get the async EnjinCoint client.
     * @param config
     * @return
     */
    public static EnjinCoinAsync async(Config config) {
        return new EnjinCoinAsyncClient(config);
    }

}
