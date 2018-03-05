package io.enjincoin.sdk.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.config.ImmutableConfig;
import io.enjincoin.sdk.client.config.ImmutablePlatform;
import io.enjincoin.sdk.client.config.Platform;
import io.enjincoin.sdk.client.service.legacy.events.SynchronousEventsService;
import io.enjincoin.sdk.client.service.legacy.notifications.NotificationsService;
import io.enjincoin.sdk.client.service.legacy.platform.SynchronousPlatformService;
import io.enjincoin.sdk.client.service.legacy.tokens.SynchronousTokensService;

public class ClientTest {

    private LegacyClientImpl client;
    private Config config;

    //TODO: Damien - temp details added for testing
    @Before
    public void setUp() {
        Platform trustedPlatform = ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(80)
                .setProtocol("http")
                .setBaseApiEndpoint("api")
                .build();
        this.config = ImmutableConfig.builder()
                .setTotalExecutors(1)
                .setTrustedPlatform(trustedPlatform)
                .build();

        this.client = new LegacyClientImpl(this.config);
    }

    @Test
    public void testContructor_EnjinConfigIsNull() {
        this.config = null;
        this.client = new LegacyClientImpl(this.config);
        assertThat(this.client).isNotNull();
    }

    @Test
    public void testContructor() {
        this.client = new LegacyClientImpl(this.config);
        assertThat(this.client).isNotNull();
    }

    @Test
    public void testGetEventsService() {
        SynchronousEventsService eventsService = this.client.getEventsService();
        assertThat(eventsService).isNotNull();

        //Second time around - the existing service should be returned
        SynchronousEventsService eventsService2 = this.client.getEventsService();
        assertThat(eventsService2).isNotNull().isSameAs(eventsService);
    }


    @Test
    public void testGetTokensService() {
        SynchronousTokensService tokensService = this.client.getTokensService();
        assertThat(tokensService).isNotNull();

        //Second time around - the existing service should be returned
        SynchronousTokensService tokensService2 = this.client.getTokensService();
        assertThat(tokensService2).isNotNull().isSameAs(tokensService);
    }

    @Test
    public void testGetNotificationsService() {
        NotificationsService notificationsService = this.client.getNotificationsService();
        assertThat(notificationsService).isNotNull();

        //Second time around - the existing service should be returned
        NotificationsService notificationsService2 = this.client.getNotificationsService();
        assertThat(notificationsService2).isNotNull().isSameAs(notificationsService);
    }

    @Test
    public void testGetPlatformService() {
        SynchronousPlatformService platformService = this.client.getPlatformService();
        assertThat(platformService).isNotNull();

        //Second time around - the existing service should be returned
        SynchronousPlatformService platformService2 = this.client.getPlatformService();
        assertThat(platformService2).isNotNull().isSameAs(platformService2);
    }
}
