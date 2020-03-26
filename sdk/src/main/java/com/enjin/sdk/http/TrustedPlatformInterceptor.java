package com.enjin.sdk.http;

import java.io.IOException;

import com.enjin.sdk.TrustedPlatformClient;
import com.enjin.sdk.models.AuthTokens;
import lombok.Getter;
import lombok.Setter;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TrustedPlatformInterceptor implements Interceptor {

    public static final String AUTHORIZATION = "Authorization";
    public static final String USER_AGENT = "User-Agent";
    public static final String USER_AGENT_VAL = "Enjin Java SDK v%s";

    @Setter
    private String tokenType;
    @Setter
    private String token;
    @Getter
    @Setter
    private Integer appId;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();

        builder.header(USER_AGENT, String.format(USER_AGENT_VAL, TrustedPlatformClient.version()));

        if (tokenType != null && !tokenType.isEmpty() && token != null && !token.isEmpty()) {
            builder.header(AUTHORIZATION, String.format("%s %s", tokenType, token));
        }

        return chain.proceed(builder.build());
    }

    public void auth(AuthTokens data) {
        tokenType = "Bearer";
        token = data.getAccessToken();
    }

    public boolean isAuthenticated() {
        return !(token == null || token.isEmpty());
    }

}
