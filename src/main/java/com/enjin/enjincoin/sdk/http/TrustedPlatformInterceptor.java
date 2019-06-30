package com.enjin.enjincoin.sdk.http;

import com.enjin.enjincoin.sdk.TrustedPlatformClient;
import okhttp3.Cookie;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class TrustedPlatformInterceptor implements Interceptor {

    private static final String[] COOKIES = {
            TrustedPlatformClient.APP_ID,
            TrustedPlatformClient.USER_ID,
            TrustedPlatformClient.IDENTITY_ID
    };

    private SessionCookieJar cookieJar;

    public TrustedPlatformInterceptor(SessionCookieJar cookieJar) {
        this.cookieJar = cookieJar;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder builder = original.newBuilder();

        List<Cookie> cookieStore = cookieJar.getCookies(original.url());

        for (Cookie stored : cookieStore) {
            if (match(stored)) {
                builder.header(stored.name(), stored.value());
            }
        }

        return chain.proceed(builder.build());
    }

    private boolean match(Cookie cookie) {
        for (String name : COOKIES) {
            if (name.equals(cookie.name())) {
                return true;
            }
        }

        return false;
    }

}
