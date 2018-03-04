package io.enjincoin.sdk.client;

import io.enjincoin.sdk.client.config.Config;

/**
 * <p> Method to return the necessary client.</p>
 */
public class LegacyClients {

    /**
     * Class constructor.
     */
    protected LegacyClients() {

    }


    /**
     * Method to get the create EnjinCoin client.
     *
     * @param config to use
     *
     * @return Client
     */
    public static LegacyClient create(final Config config) {
        return new LegacyClientImpl(config);
    }

}
