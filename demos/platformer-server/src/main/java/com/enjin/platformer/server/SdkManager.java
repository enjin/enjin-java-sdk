package com.enjin.platformer.server;

import com.enjin.platformer.server.conf.Config;
import com.enjin.sdk.TrustedPlatformClient;
import com.enjin.sdk.TrustedPlatformClientBuilder;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.AuthTokens;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.TimeUnit;

public class SdkManager extends Thread {

    private static final long AUTH_INTERVAL = TimeUnit.HOURS.toMillis(6);

    private final Config config;
    @Getter
    private final TrustedPlatformClient sdk;

    private long acquiredAuthTokenTime;
    private int authFailures;
    @Setter(AccessLevel.PROTECTED)
    private boolean running = true;

    public SdkManager(Config config) {
        this.config = config;
        this.sdk = new TrustedPlatformClientBuilder().baseUrl(TrustedPlatformClientBuilder.KOVAN)
                                                     .build();
    }

    @Override
    public void run() {
        while (running) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - acquiredAuthTokenTime >= AUTH_INTERVAL) {
                HttpResponse<GraphQLResponse<AuthTokens>> httpResponse = sdk.authAppSync(config.getAppId(), config.getAppSecret());
                GraphQLResponse<AuthTokens> graphQLResponse = httpResponse.body();

                if (!(httpResponse.isSuccess() && graphQLResponse.isSuccess())) {
                    authFailures += 1;

                    try {
                        sleep(TimeUnit.MINUTES.toMillis(authFailures));
                    } catch (InterruptedException e) {
                        App.getInstance().exit();
                        return;
                    }

                    continue;
                }

                authFailures = 0;
                acquiredAuthTokenTime = System.currentTimeMillis();

                System.out.println("SDK Client Authenticated!");
            }
        }
    }

}
