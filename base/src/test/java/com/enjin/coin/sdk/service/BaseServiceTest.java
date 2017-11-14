package com.enjin.coin.sdk.service;

import com.enjin.coin.sdk.config.EnjinConfig;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class BaseServiceTest {

    BaseService baseAction;
    EnjinConfig enjinConfig;

    @Before
    public void setUp() {
        enjinConfig = new EnjinConfig();
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
        enjinConfig.setInTestMode(true);
        enjinConfig.setTrustedPlatformUrl("http://localhost:8080");
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
        baseAction.setTrustedPlatformUrl("http://localhost:8081");
        String identitiesURL = baseAction.getIdentitiesUrl();
        assertThat(identitiesURL).isNotEmpty();
    }

    @Test
    public void testGetIdentitiesUrl3() {
        baseAction.setTrustedPlatformUrl("http://localhost:8081/");
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
        baseAction.setTrustedPlatformUrl("http://localhost:8081");
        String tokensURL = baseAction.getTokensUrl();
        assertThat(tokensURL).isNotEmpty();
    }

    @Test
    public void testGetTokensUrl3() {
        baseAction.setTrustedPlatformUrl("http://localhost:8081/");
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
        baseAction.setTrustedPlatformUrl("http://localhost:8081");
        String transactionRequestsURL = baseAction.getTransactionRequestsUrl();
        assertThat(transactionRequestsURL).isNotEmpty();
    }

    @Test
    public void testGetTransactionRequestsUrl3() {
        baseAction.setTrustedPlatformUrl("http://localhost:8081/");
        String transactionRequestsURL = baseAction.getTransactionRequestsUrl();
        assertThat(transactionRequestsURL).isNotEmpty();
    }

    @Test
    public void testGetTrustedPlatformUrl_Null() {
        String trustedPlatformURL = baseAction.getTrustedPlatformUrl();
        assertThat(trustedPlatformURL).isNull();
    }

    @Test
    public void testGetTrustedPlatformUrl_Success() {
        baseAction.setTrustedPlatformUrl("http://localhost:8081/");
        String trustedPlatformURL = baseAction.getTrustedPlatformUrl();
        assertThat(trustedPlatformURL).isNotEmpty();
    }

}
