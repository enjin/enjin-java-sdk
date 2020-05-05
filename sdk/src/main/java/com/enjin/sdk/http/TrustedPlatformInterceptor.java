package com.enjin.sdk.http;

import java.io.IOException;

import com.enjin.sdk.TrustedPlatformClient;
import com.enjin.sdk.models.AccessToken;
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
     * Sets the access token type.
     *
     * @param tokenType the new access token type
     */
    @Setter
    private String tokenType;
    /**
     * -- SETTER --
     * Sets the access token.
     *
     * @param token the new access token.
     */
    @Setter
    private String token;
    /**
     * -- GETTER --
     * Returns the application id.
     *
     * @return the app id.
     *
     * -- SETTER --
     * Sets the application id.
     *
     * @param appId the new app id.
     */
    @Getter
    @Setter
    private Integer appId;

    /**
     * Rewrites calls to the Trusted Platform.
     *
     * @param chain the chain
     * @return      the response
     *
     * @throws IOException if the chain fails to proceed
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();

        builder.header(USER_AGENT, String.format(USER_AGENT_VAL, TrustedPlatformClient.version()));

        if (tokenType != null && !tokenType.isEmpty() && token != null && !token.isEmpty()) {
            builder.header(AUTHORIZATION, String.format("%s %s", tokenType, token));
        }

        return chain.proceed(builder.build());
    }

    /**
     * Sets the authentication data.
     *
     * @param data the data
     */
    public void auth(AccessToken data) {
        tokenType = "Bearer";
        token = data.getAccessToken();
    }

    /**
     * Determines if the sdk is authenticated.
     *
     * @return true if authenticated, false otherwise
     */
    public boolean isAuthenticated() {
        return !(token == null || token.isEmpty());
    }

}
