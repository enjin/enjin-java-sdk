package com.enjin.enjincoin.sdk.http;

import com.enjin.enjincoin.sdk.model.service.auth.AuthResult;
import com.enjin.java_commons.StringUtils;
import lombok.Getter;
import lombok.Setter;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class TrustedPlatformInterceptor implements Interceptor {

    public static final String APP_ID      = "X-App-Id";
    public static final String USER_ID     = "user_id";
    public static final String IDENTITY_ID = "identity_id";
    public static final String AUTHORIZATION      = "Authorization";

    @Setter
    private String tokenType;
    @Setter
    private String token;
    @Getter
    @Setter
    private Integer appId;
    @Getter
    @Setter
    private Integer userId;
    @Getter
    @Setter
    private Integer identityId;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();

        if (appId != null) {
            builder.header(APP_ID, String.valueOf(appId));
        }

        if (userId != null) {
            builder.header(USER_ID, String.valueOf(userId));
        }

        if (identityId != null) {
            builder.header(IDENTITY_ID, String.valueOf(identityId));
        }

        if (!StringUtils.isEmpty(tokenType) && !StringUtils.isEmpty(token)) {
            builder.header(AUTHORIZATION, String.format("%s %s", tokenType, token));
        }

        return chain.proceed(builder.build());
    }

    public void auth(AuthResult result) {
        tokenType = result.getTokenType();
        token = result.getAccessToken();
    }

}
