package io.enjincoin.sdk.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.config.ImmutableConfig;
import io.enjincoin.sdk.client.config.ImmutablePlatform;
import io.enjincoin.sdk.client.config.Platform;

public class ClientsTest {

    private LegacyClients clients;
    private Config config;

    @Before
    public void setUp() {
        Platform trustedPlatform = ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(80)
                .setProtocol("http")
                .build();

        this.config = ImmutableConfig.builder()
                .setTotalExecutors(1)
                .setTrustedPlatform(trustedPlatform)
                .build();
    }

    @Test
    public void testContructor() {
        this.clients = new LegacyClients();
        assertThat(this.clients).isNotNull();
    }

    @Test
    public void testLoadSyncClient() {
        LegacyClient client = LegacyClients.create(this.config);
        assertThat(client).isNotNull();
    }

    @Test
    public void testLoadAsyncClient() {
        LegacyClient enjinCoinAsync = LegacyClients.create(this.config);
        assertThat(enjinCoinAsync).isNotNull();
    }
}
