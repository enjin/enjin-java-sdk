package com.enjin.enjincoin.sdk.client.authentication;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class AuthenticationInterceptor implements Interceptor {

    private CookieJar cookieJar;

    public AuthenticationInterceptor(CookieJar cookieJar) {
        this.cookieJar = cookieJar;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request         userRequest    = chain.request();
        Request.Builder requestBuilder = userRequest.newBuilder();

        List<Cookie> cookies = this.cookieJar.loadForRequest(userRequest.url());
        if (cookies.size() > 0) {
            Cookie laravelSessionTypeCookie = cookies.stream()
                                                     .filter(cookie -> cookie.name()
                                                                             .equalsIgnoreCase("laravel_session_type"))
                                                     .findFirst().orElse(null);
            Cookie laravelSessionCookie = cookies.stream()
                                                 .filter(cookie -> cookie.name().equalsIgnoreCase("laravel_session"))
                                                 .findFirst().orElse(null);
            if (laravelSessionTypeCookie != null && laravelSessionCookie != null) {
                requestBuilder.header("authorization", String.format("%s %s",
                                                                     laravelSessionTypeCookie.value(),
                                                                     laravelSessionCookie.value()));
            }
        }

        return chain.proceed(requestBuilder.build());
    }
}
