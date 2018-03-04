package io.enjincoin.sdk.client.service.legacy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.ExecutorService;

import org.junit.Before;
import org.junit.Test;

import io.enjincoin.sdk.client.BaseTestHelper;
import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.config.ImmutableConfig;
import io.enjincoin.sdk.client.config.ImmutablePlatform;
import io.enjincoin.sdk.client.config.Platform;
import io.enjincoin.sdk.client.service.legacy.BaseService;
import io.enjincoin.sdk.client.service.legacy.identities.impl.IdentitiesServiceImpl;
import io.enjincoin.sdk.client.service.legacy.platform.SynchronousPlatformService;
import io.enjincoin.sdk.client.util.http.Protocol;

public class BaseServiceTest {

    BaseService baseAction;
    Config enjinConfig;

    @Before
    public void setUp() {
        this.enjinConfig = BaseTestHelper.getEnjinConfig();
        this.baseAction = new IdentitiesServiceImpl(this.enjinConfig);
    }

    @Test
    public void testContructor_EnjinConfigIsNull() {
        this.enjinConfig = null;
        this.baseAction = new IdentitiesServiceImpl(this.enjinConfig);
        assertThat(this.baseAction).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }

    @Test
    public void testContructor1() {
        this.baseAction = new IdentitiesServiceImpl(this.enjinConfig);
        assertThat(this.baseAction).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }

    @Test
    public void testContructor2() {
        this.enjinConfig = ImmutableConfig.builder()
                .setTrustedPlatform(ImmutablePlatform.builder()
                        .setHost("localhost")
                        .setPort(8080)
                        .setProtocol(Protocol.HTTP)
                        .build())
                .build();
        this.baseAction = new IdentitiesServiceImpl(this.enjinConfig);
        assertThat(this.baseAction).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }

    @Test
    public void testGetIdentitiesUrl1() {
        String identitiesURL = this.baseAction.getIdentitiesUrl();
        assertThat(identitiesURL).isNotEmpty();
    }

    @Test
    public void testGetIdentitiesUrl2() {
        this.baseAction.setTrustedPlatform(ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(8081)
                .setProtocol(Protocol.HTTP)
                .build());
        String identitiesURL = this.baseAction.getIdentitiesUrl();
        assertThat(identitiesURL).isNotEmpty();
    }

    @Test
    public void testGetIdentitiesUrl3() {
        this.baseAction.setTrustedPlatform(ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(8081)
                .setProtocol(Protocol.HTTP)
                .build());
        String identitiesURL = this.baseAction.getIdentitiesUrl();
        assertThat(identitiesURL).isNotEmpty();
    }

    @Test
    public void testGetIdentitiesUrl_TrustedPlatformIsNull() {
        this.baseAction.setTrustedPlatform(null);
        String identitiesURL = this.baseAction.getIdentitiesUrl();
        assertThat(identitiesURL).isNotEmpty();
    }

    @Test
    public void testGetTokensUrl1() {
        String tokensURL = this.baseAction.getTokensUrl();
        assertThat(tokensURL).isNotEmpty();
    }

    @Test
    public void testGetTokensUrl2() {
        this.baseAction.setTrustedPlatform(ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(8081)
                .setProtocol(Protocol.HTTP)
                .build());
        String tokensURL = this.baseAction.getTokensUrl();
        assertThat(tokensURL).isNotEmpty();
    }

    @Test
    public void testGetTokensUrl3() {
        this.baseAction.setTrustedPlatform(ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(8081)
                .setProtocol(Protocol.HTTP)
                .build());
        String tokensURL = this.baseAction.getTokensUrl();
        assertThat(tokensURL).isNotEmpty();
    }

    @Test
    public void testGetTokensUrl_TrustedPlatformIsNull() {
        this.baseAction.setTrustedPlatform(null);
        String tokensURL = this.baseAction.getTokensUrl();
        assertThat(tokensURL).isNotEmpty();
    }

    @Test
    public void testGetTransactionRequestsUrl1() {
        String transactionRequestsURL = this.baseAction.getTransactionRequestsUrl();
        assertThat(transactionRequestsURL).isNotEmpty();
    }

    @Test
    public void testGetTransactionRequestsUrl2() {
        this.baseAction.setTrustedPlatform(ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(8081)
                .setProtocol(Protocol.HTTP)
                .build());
        String transactionRequestsURL = this.baseAction.getTransactionRequestsUrl();
        assertThat(transactionRequestsURL).isNotEmpty();
    }

    @Test
    public void testGetTransactionRequestsUrl3() {
        this.baseAction.setTrustedPlatform(ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(8081)
                .setProtocol(Protocol.HTTP)
                .build());
        String transactionRequestsURL = this.baseAction.getTransactionRequestsUrl();
        assertThat(transactionRequestsURL).isNotEmpty();
    }

    @Test
    public void testGetTransactionRequestsUrl_TrustedPlatformIsNull() {
        this.baseAction.setTrustedPlatform(null);
        String transactionRequestsURL = this.baseAction.getTransactionRequestsUrl();
        assertThat(transactionRequestsURL).isNotEmpty();
    }

    @Test
    public void testGetEventsUrl1() {
        String identitiesURL = this.baseAction.getEventsUrl();
        assertThat(identitiesURL).isNotEmpty();
    }

    @Test
    public void testGetEventsUrl2() {
        this.baseAction.setTrustedPlatform(ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(8081)
                .setProtocol(Protocol.HTTP)
                .build());
        String identitiesURL = this.baseAction.getEventsUrl();
        assertThat(identitiesURL).isNotEmpty();
    }

    @Test
    public void testGetEventsUrl3() {
        this.baseAction.setTrustedPlatform(ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(8081)
                .setProtocol(Protocol.HTTP)
                .build());
        String identitiesURL = this.baseAction.getEventsUrl();
        assertThat(identitiesURL).isNotEmpty();
    }

    @Test
    public void testGetEventsUrl_TrustedPlatformIsNull() {
        this.baseAction.setTrustedPlatform(null);
        String identitiesURL = this.baseAction.getEventsUrl();
        assertThat(identitiesURL).isNotEmpty();
    }

    @Test
    public void testGetPlatformUrl1() {
        String identitiesURL = this.baseAction.getPlatformUrl();
        assertThat(identitiesURL).isNotEmpty();
    }

    @Test
    public void testGetPlatformUrl2() {
        this.baseAction.setTrustedPlatform(ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(8081)
                .setProtocol(Protocol.HTTP)
                .build());
        String identitiesURL = this.baseAction.getPlatformUrl();
        assertThat(identitiesURL).isNotEmpty();
    }

    @Test
    public void testGetPlatformUrl3() {
        this.baseAction.setTrustedPlatform(ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(8081)
                .setProtocol(Protocol.HTTP)
                .build());
        String identitiesURL = this.baseAction.getPlatformUrl();
        assertThat(identitiesURL).isNotEmpty();
    }

    @Test
    public void testGetPlatformUrl_TrustedPlatformIsNull() {
        this.baseAction.setTrustedPlatform(null);
        String identitiesURL = this.baseAction.getPlatformUrl();
        assertThat(identitiesURL).isNotEmpty();
    }

    @Test
    public void testGetTrustedPlatform_Default() {
        this.baseAction.setTrustedPlatform(ImmutablePlatform.builder().build());
        Platform trustedPlatform = this.baseAction.getTrustedPlatform();
        assertThat(trustedPlatform).isEqualToComparingFieldByField(ImmutablePlatform.builder().build());
    }

    @Test
    public void testGetTrustedPlatform_Success() {
        this.baseAction.setTrustedPlatform(ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(8081)
                .setProtocol(Protocol.HTTP)
                .build());
        Platform trustedPlatform = this.baseAction.getTrustedPlatform();
        assertThat(trustedPlatform).isNotNull();
    }

    @Test
    public void testGetExecutorService() {
        ExecutorService executorService = this.baseAction.getExecutorService();
        assertThat(executorService).isNotNull();
    }


    @Test
    public void testGetPlatformService() {
        SynchronousPlatformService platformService1 = this.baseAction.getPlatformService(this.enjinConfig);
        assertThat(platformService1).isNotNull();

        SynchronousPlatformService platformService2 = this.baseAction.getPlatformService(this.enjinConfig);
        assertThat(platformService2).isNotNull().isSameAs(platformService1);
    }
}
