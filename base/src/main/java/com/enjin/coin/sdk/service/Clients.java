package com.enjin.coin.sdk.service;

import com.enjin.coin.sdk.config.Config;

public class Clients {

    public static EnjinCoin sync(Config config) {
        return new EnjinCoinAsyncClient(config);
    }

    public static EnjinCoinAsync async(Config config) {
        return new EnjinCoinAsyncClient(config);
    }

}
