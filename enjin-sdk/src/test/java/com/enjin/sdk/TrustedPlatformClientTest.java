package com.enjin.sdk;

import com.enjin.sdk.model.service.auth.AuthResult;
import static com.google.common.truth.Truth.*;
import static org.awaitility.Awaitility.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;

import org.junit.Rule;
import org.junit.Test;

import okhttp3.logging.HttpLoggingInterceptor.Level;
import okhttp3.mockwebserver.MockResponse;

public class TrustedPlatformClientTest {

    private static final int    TIMEOUT_SECONDS = 5;
    private static final int    APP_ID          = 100;
    private static final int    USER_ID         = 200;
    private static final int    IDENTITY_ID     = 300;
    private static final String APP_SECRET      = "secret";
    private static final String AUTH_BODY       = "{\"grant_type\":\"client_credentials\",\"client_id\":\"100\",\"client_secret\":\"grant\"}";

    @Rule
    public final MockWebServerTestRule mockWebServerTestRule = new MockWebServerTestRule();

    @Test
    public void baseUrl_returnsMockUrl() {
        TrustedPlatformClient client = MockWebServerTestRule.clientBuilder().build();
        assertThat(client.getBaseUrl()).isEqualTo(MockWebServerTestRule.MOCK_URL);
    }

    @Test
    public void connectTimeout_returnsFiveSecondsInMillis() {
        TrustedPlatformClient client = MockWebServerTestRule.clientBuilder()
                                                            .connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                                                            .build();
        assertThat(client.getHttpClient().connectTimeoutMillis()).isEqualTo(TimeUnit.SECONDS.toMillis(TIMEOUT_SECONDS));
    }

    @Test
    public void callTimeout_returnsFiveSecondsInMillis() {
        TrustedPlatformClient client = MockWebServerTestRule.clientBuilder()
                                                            .callTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                                                            .build();
        assertThat(client.getHttpClient().callTimeoutMillis()).isEqualTo(TimeUnit.SECONDS.toMillis(TIMEOUT_SECONDS));
    }

    @Test
    public void readTimeout_returnsFiveSecondsInMillis() {
        TrustedPlatformClient client = MockWebServerTestRule.clientBuilder()
                                                            .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                                                            .build();
        assertThat(client.getHttpClient().readTimeoutMillis()).isEqualTo(TimeUnit.SECONDS.toMillis(TIMEOUT_SECONDS));
    }

    @Test
    public void writeTimeout_returnsFiveSecondsInMillis() {
        TrustedPlatformClient client = MockWebServerTestRule.clientBuilder()
                                                            .writeTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                                                            .build();
        assertThat(client.getHttpClient().writeTimeoutMillis()).isEqualTo(TimeUnit.SECONDS.toMillis(TIMEOUT_SECONDS));
    }

    @Test
    public void httpLogLevel_returnsBasicLevel() {
        TrustedPlatformClient client = MockWebServerTestRule.clientBuilder()
                                                            .httpLogLevel(Level.BASIC)
                                                            .build();
        assertThat(client.getHttpLogLevel()).isEqualTo(Level.BASIC);
    }

    @Test
    public void setHttpLogLevel_returnsBasicLevel() {
        TrustedPlatformClient client = MockWebServerTestRule.clientBuilder().build();
        client.setHttpLogLevel(Level.BASIC);
        assertThat(client.getHttpLogLevel()).isEqualTo(Level.BASIC);
    }

    @Test
    public void setAppId_returnsAppId() {
        TrustedPlatformClient client = MockWebServerTestRule.clientBuilder().build();
        client.setAppId(APP_ID);
        assertThat(client.getAppId()).isEqualTo(APP_ID);
    }

    @Test
    public void authAppSync_networkResponseIsSuccessful() throws IOException {
        TrustedPlatformClient client = MockWebServerTestRule.clientBuilder().build();

        mockWebServerTestRule.getMockWebServer().enqueue(new MockResponse().setResponseCode(200)
                                                                           .setBody(AUTH_BODY));
        HttpResponse<AuthResult> networkResponse = client.authAppSync(APP_ID, APP_SECRET);

        assertThat(networkResponse.isSuccess()).isTrue();
    }

    @Test
    public void authAppAsync_networkResponseSuccessful() {
        TrustedPlatformClient                           client            = MockWebServerTestRule.clientBuilder().build();
        final AtomicReference<HttpResponse<AuthResult>> responseReference = new AtomicReference<>();

        mockWebServerTestRule.getMockWebServer().enqueue(new MockResponse().setResponseCode(200)
                                                                           .setBody(AUTH_BODY));

        client.authAppAsync(APP_ID, APP_SECRET, new HttpCallback<AuthResult>() {
            @Override
            public void onComplete(HttpResponse<AuthResult> response) {
                responseReference.set(response);
            }
        });

        await().atMost(5, TimeUnit.SECONDS).untilAtomic(responseReference, notNullValue());
        assertThat(responseReference.get().isSuccess()).isTrue();
    }

    @Test
    public void getAppsService_returnNotNull() {
        TrustedPlatformClient client = MockWebServerTestRule.clientBuilder().build();
        assertThat(client.getAppsService()).isNotNull();
    }


    @Test
    public void getAuthService_returnNotNull() {
        TrustedPlatformClient client = MockWebServerTestRule.clientBuilder().build();
        assertThat(client.getAuthService()).isNotNull();
    }

    @Test
    public void getBalancesService_returnNotNull() {
        TrustedPlatformClient client = MockWebServerTestRule.clientBuilder().build();
        assertThat(client.getBalancesService()).isNotNull();
    }

    @Test
    public void getEthereumService_returnNotNull() {
        TrustedPlatformClient client = MockWebServerTestRule.clientBuilder().build();
        assertThat(client.getEthereumService()).isNotNull();
    }

    @Test
    public void getIdentitiesService_returnNotNull() {
        TrustedPlatformClient client = MockWebServerTestRule.clientBuilder().build();
        assertThat(client.getIdentitiesService()).isNotNull();
    }

    @Test
    public void getPlatformService_returnNotNull() {
        TrustedPlatformClient client = MockWebServerTestRule.clientBuilder().build();
        assertThat(client.getPlatformService()).isNotNull();
    }

    @Test
    public void getRequestsService_returnNotNull() {
        TrustedPlatformClient client = MockWebServerTestRule.clientBuilder().build();
        assertThat(client.getRequestsService()).isNotNull();
    }

    @Test
    public void getRolesService_returnNotNull() {
        TrustedPlatformClient client = MockWebServerTestRule.clientBuilder().build();
        assertThat(client.getRolesService()).isNotNull();
    }

    @Test
    public void getTokensService_returnNotNull() {
        TrustedPlatformClient client = MockWebServerTestRule.clientBuilder().build();
        assertThat(client.getTokensService()).isNotNull();
    }

    @Test
    public void getUsersService_returnNotNull() {
        TrustedPlatformClient client = MockWebServerTestRule.clientBuilder().build();
        assertThat(client.getUsersService()).isNotNull();
    }

    @Test
    public void closeClient_returnsTrue() throws IOException {
        TrustedPlatformClient client = MockWebServerTestRule.clientBuilder().build();
        client.close();
        assertThat(client.isClosed()).isTrue();
    }

}
