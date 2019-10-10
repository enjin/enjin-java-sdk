package com.enjin.sdk;

import java.io.IOException;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockWebServer;

public class MockWebServerTestRule extends TestWatcher {

    public static final Integer PORT            = 8080;
    public static final String  MOCK_URL_STRING = String.format("http://localhost:%s/", PORT);
    public static final HttpUrl MOCK_URL        = HttpUrl.get(MOCK_URL_STRING);

    private MockWebServer mockWebServer;

    @Override
    protected void starting(Description description) {
        try {
            mockWebServer = new MockWebServer();
            mockWebServer.start(PORT);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void finished(Description description) {
        try {
            mockWebServer.shutdown();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public MockWebServer getMockWebServer() {
        return mockWebServer;
    }

    public static TrustedPlatformClient.Builder clientBuilder() {
        return TrustedPlatformClient.builder()
                                    .baseUrl(MOCK_URL_STRING);
    }

}
