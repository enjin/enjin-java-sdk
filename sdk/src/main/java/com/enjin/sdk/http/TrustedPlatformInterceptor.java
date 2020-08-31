package com.enjin.sdk.http;

import java.io.IOException;

import com.enjin.sdk.schemas.BaseSchema;
import lombok.Getter;
import lombok.Setter;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A interceptor class for the Trusted Platform.
 */
public class TrustedPlatformInterceptor implements Interceptor {

    /**
     * The authorization key.
     */
    public static final String AUTHORIZATION = "Authorization";

    /**
     * The user-agent key.
     */
    public static final String USER_AGENT = "User-Agent";

    /**
     * The user-agent value key.
     */
    public static final String USER_AGENT_VAL = "Enjin Java SDK v%s";

    /**
     * -- SETTER --
     * @param tokenType the new access token type
     */
    @Setter
    private String tokenType;

    /**
     * -- SETTER --
     * @param token the new access token
     */
    @Setter
    private String token;

    /**
     * -- GETTER --
     * @return the app ID
     * -- SETTER --
     * @param appId the new app ID
     */
    @Getter
    @Setter
    private Integer appId;

    /**
     * Rewrites calls to the Trusted Platform.
     *
     * @param chain the chain
     * @return the response
     * @throws IOException if the chain fails to proceed
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();

        builder.header(USER_AGENT, String.format(USER_AGENT_VAL, BaseSchema.version()));

        if (tokenType != null && !tokenType.isEmpty() && token != null && !token.isEmpty()) {
            builder.header(AUTHORIZATION, String.format("%s %s", tokenType, token));
        }

        return chain.proceed(builder.build());
    }

    /**
     * Sets the authentication credentials of the SDK.
     *
     * @param token the access token
     */
    public void auth(String token) {
        this.tokenType = "Bearer";
        this.token = token;
    }

    /**
     * Determines if the SDK is authenticated.
     *
     * @return true if authenticated, false otherwise
     */
    public boolean isAuthenticated() {
        return !(token == null || token.isEmpty());
    }

    /**
     * Clears the authentication credentials of the SDK.
     */
    public void clearAuth() {
        token = null;
        tokenType = null;
        appId = null;
    }

}
