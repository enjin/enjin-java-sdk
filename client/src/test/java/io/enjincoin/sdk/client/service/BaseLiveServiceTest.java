package io.enjincoin.sdk.client.service;

import org.junit.Before;

import io.enjincoin.sdk.client.ClientImpl;
import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.config.ImmutableConfig;
import io.enjincoin.sdk.client.config.ImmutablePlatform;
import io.enjincoin.sdk.client.config.Platform;

public class BaseLiveServiceTest {

    protected ClientImpl client;
    protected Config config;

    @Before
    public void setUp() {
        Platform trustedPlatform = ImmutablePlatform.builder()
                .setHost("enjin.v16studios.co.uk")
                .setPort(443)
                .setProtocol("https")
                .setBaseApiEndpoint("api/v1")
                .build();
        this.config = ImmutableConfig.builder()
                .setTotalExecutors(1)
                .setTrustedPlatform(trustedPlatform)
                .build();

        this.client = new ClientImpl(this.config);
    }

}
