package com.enjin.coin.sdk.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.config.ImmutableConfig;
import com.enjin.coin.sdk.config.ImmutableNotification;
import com.enjin.coin.sdk.config.ImmutablePlatform;
import com.enjin.coin.sdk.config.Notification;
import com.enjin.coin.sdk.config.Platform;

public class ClientsTest {

    Clients clients;
    Config enjinConfig;

    @Before
    public void setUp() {
        Notification notification = ImmutableNotification.builder()
                .setActivityTimeout(4000l)
                .setAppChannel("testChannel")
                .setAppId("437770")
                .setAppKey("505648a2c40940a286e2")
                .setAppSecret("f4fbf11d052fe6a64988")
                .setCluster("eu")
                .build();
        Platform trustedPlatform = ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(80)
                .setProtocol("http")
                .build();

        enjinConfig = ImmutableConfig.builder()
                .setInTestMode(false)
                .setNotification(notification)
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
