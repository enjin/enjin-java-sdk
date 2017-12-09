package com.enjin.coin.sdk.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.config.ImmutableConfig;
import com.enjin.coin.sdk.config.ImmutablePlatform;
import com.enjin.coin.sdk.config.Platform;

public class ClientsTest {

    Clients clients;
    Config enjinConfig;

    @Before
    public void setUp() {
        Platform trustedPlatform = ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(80)
                .setProtocol("http")
                .build();

        enjinConfig = ImmutableConfig.builder()
                .setInTestMode(false)
                .setTotalExecutors(1)
                .setTrustedPlatform(trustedPlatform)
                .build();
    }

    @Test
    public void testContructor() {
        clients = new Clients();
        assertThat(clients).isNotNull();
    }

    @Test
    public void testLoadSyncClient() {
        EnjinCoin enjinCoin = Clients.sync(enjinConfig);
        assertThat(enjinCoin).isNotNull();
    }

    @Test
    public void testLoadAsyncClient() {
        EnjinCoinAsync enjinCoinAsync = Clients.async(enjinConfig);
        assertThat(enjinCoinAsync).isNotNull();
    }
}
