package io.enjincoin.sdk.client.service;

import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.config.ImmutableConfig;
import io.enjincoin.sdk.client.config.ImmutablePlatform;
import io.enjincoin.sdk.client.config.Platform;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
