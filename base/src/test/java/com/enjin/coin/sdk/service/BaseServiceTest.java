package com.enjin.coin.sdk.service;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.config.ImmutableConfig;
import com.enjin.coin.sdk.config.ImmutablePlatform;
import com.enjin.coin.sdk.config.Platform;
import com.enjin.coin.sdk.util.http.Protocol;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class BaseServiceTest {

    BaseService baseAction;
    Config enjinConfig;

    @Before
    public void setUp() {
        enjinConfig = new Config();
        baseAction = new IdentitiesService(enjinConfig);
    }

    @Test
    public void testContructor_EnjinConfigIsNull() {
        enjinConfig = null;
        baseAction = new IdentitiesService(enjinConfig);
        assertThat(baseAction).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }

    @Test
    public void testContructor1() {
        baseAction = new IdentitiesService(enjinConfig);
        assertThat(baseAction).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }

    @Test
    public void testContructor2() {
        enjinConfig = ImmutableConfig.builder()
                .setTrustedPlatform(ImmutablePlatform.builder()
                        .setHost("localhost")
                        .setPort(8080)
                        .setProtocol(Protocol.HTTP)
                        .build())
                .setInTestMode(true)
                .build();
        baseAction = new IdentitiesService(enjinConfig);
        assertThat(baseAction).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }

    @Test
    public void testGetIdentitiesUrl1() {
        String identitiesURL = baseAction.getIdentitiesUrl();
        assertThat(identitiesURL).isNotEmpty();
    }

    @Test
    public void testGetIdentitiesUrl2() {
        baseAction.setTrustedPlatform(ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(8081)
                .setProtocol(Protocol.HTTP)
                .build());
        String identitiesURL = baseAction.getIdentitiesUrl();
        assertThat(identitiesURL).isNotEmpty();
    }

    @Test
    public void testGetIdentitiesUrl3() {
        baseAction.setTrustedPlatform(ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(8081)
                .setProtocol(Protocol.HTTP)
                .build());
        String identitiesURL = baseAction.getIdentitiesUrl();
        assertThat(identitiesURL).isNotEmpty();
    }

    @Test
    public void testGetTokensUrl1() {
        String tokensURL = baseAction.getTokensUrl();
        assertThat(tokensURL).isNotEmpty();
    }

    @Test
    public void testGetTokensUrl2() {
        baseAction.setTrustedPlatform(ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(8081)
                .setProtocol(Protocol.HTTP)
                .build());
        String tokensURL = baseAction.getTokensUrl();
        assertThat(tokensURL).isNotEmpty();
    }

    @Test
    public void testGetTokensUrl3() {
        baseAction.setTrustedPlatform(ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(8081)
                .setProtocol(Protocol.HTTP)
                .build());
        String tokensURL = baseAction.getTokensUrl();
        assertThat(tokensURL).isNotEmpty();
    }

    @Test
    public void testGetTransactionRequestsUrl1() {
        String transactionRequestsURL = baseAction.getTransactionRequestsUrl();
        assertThat(transactionRequestsURL).isNotEmpty();
    }

    @Test
    public void testGetTransactionRequestsUrl2() {
        baseAction.setTrustedPlatform(ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(8081)
                .setProtocol(Protocol.HTTP)
                .build());
        String transactionRequestsURL = baseAction.getTransactionRequestsUrl();
        assertThat(transactionRequestsURL).isNotEmpty();
    }

    @Test
    public void testGetTransactionRequestsUrl3() {
        baseAction.setTrustedPlatform(ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(8081)
                .setProtocol(Protocol.HTTP)
                .build());
        String transactionRequestsURL = baseAction.getTransactionRequestsUrl();
        assertThat(transactionRequestsURL).isNotEmpty();
    }

    @Test
    public void testGetTrustedPlatform_Default() {
        Platform trustedPlatform = baseAction.getTrustedPlatform();
        assertThat(trustedPlatform).isEqualToComparingFieldByField(ImmutablePlatform.builder().build());
    }

    @Test
    public void testGetTrustedPlatform_Success() {
        baseAction.setTrustedPlatform(ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(8081)
                .setProtocol(Protocol.HTTP)
                .build());
        Platform trustedPlatform = baseAction.getTrustedPlatform();
        assertThat(trustedPlatform).isNotNull();
    }

}
