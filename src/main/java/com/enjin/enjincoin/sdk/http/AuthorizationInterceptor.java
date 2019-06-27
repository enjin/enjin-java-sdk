package com.enjin.enjincoin.sdk.http;

import com.enjin.enjincoin.sdk.model.service.auth.AuthResult;
import com.enjin.java_commons.StringUtils;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AuthorizationInterceptor implements Interceptor {

    public static final String AUTHORIZATION      = "Authorization";

    private String tokenType;
    private String token;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder request = chain.request().newBuilder();

        if (!StringUtils.isEmpty(tokenType) && !StringUtils.isEmpty(token)) {
            request.header(AUTHORIZATION, String.format("%s %s", tokenType, token));
        }

        return chain.proceed(request.build());
    }

    public void auth(AuthResult result) {
        tokenType = result.getTokenType();
        token = result.getAccessToken();
    }

}
