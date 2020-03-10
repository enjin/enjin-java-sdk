package com.enjin.sdk.http;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lombok.NonNull;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

public class SessionCookieJar implements CookieJar {

    private final Map<String, List<Cookie>> serverCookieStore = new ConcurrentHashMap<>();
    private final Map<String, List<Cookie>> clientCookieStore = new ConcurrentHashMap<>();

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        serverCookieStore.put(url.host(), new ArrayList<>(cookies));
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> serverCookies = serverCookieStore.get(url.host());

        if (serverCookies == null) {
            serverCookies = new ArrayList<>();
        }

        List<Cookie> clientCookies = clientCookieStore.get(url.host());

        if (clientCookies != null) {
            serverCookies.addAll(clientCookies);
        }

        return serverCookies;
    }

    public List<Cookie> getCookies(@NonNull String url) {
        return new ArrayList<>(clientCookieStore.get(HttpUrl.get(url).host()));
    }

    public List<Cookie> getCookies(@NonNull HttpUrl url) {
        return new ArrayList<>(clientCookieStore.get(url.host()));
    }

    public void setCookie(@NonNull String url, @NonNull Cookie cookie) {
        setCookie(HttpUrl.get(url), cookie);
    }

    /**
     * Sets a cookie for the provided url.
     *
     * @param url    the url
     * @param cookie the cookie
     */
    public void setCookie(@NonNull HttpUrl url, @NonNull Cookie cookie) {
        String host = url.host();

        List<Cookie> cookieStore = clientCookieStore.get(host);

        if (cookieStore == null) {
            cookieStore = new ArrayList<>();
            clientCookieStore.put(host, cookieStore);
        }

        putCookie(cookieStore, cookie);
    }

    public void setCookie(@NonNull String url, @NonNull String name, @NonNull String value) {
        setCookie(HttpUrl.get(url), name, value);
    }

    /**
     * Sets a cookie with the provided name and value for the url.
     *
     * @param url   the url
     * @param name  the cookie name
     * @param value the cookie value
     */
    public void setCookie(@NonNull HttpUrl url, @NonNull String name, @NonNull String value) {
        setCookie(url, Cookie.parse(url, name + "=" + value));
    }

    public void removeCookie(String url, String name) {
        removeCookie(HttpUrl.get(url), name);
    }

    /**
     * Removes a cookie with the provided name from the url.
     *
     * @param url  the url
     * @param name the cookie name
     */
    public void removeCookie(HttpUrl url, String name) {
        List<Cookie> cookieStore = clientCookieStore.get(url.host());

        if (cookieStore != null) {
            Cookie cookie = null;

            for (Cookie stored : cookieStore) {
                if (stored.name().equals(name)) {
                    cookie = stored;
                    break;
                }
            }

            if (cookie != null) {
                cookieStore.remove(cookie);
            }
        }
    }

    private void putCookie(List<Cookie> cookieStore, Cookie newCookie) {
        Cookie oldCookie = null;
        String newCookieKey = newCookie.name() + newCookie.path();

        for (Cookie storedCookie : cookieStore) {
            String storedCookieKey = storedCookie.name() + storedCookie.path();

            if (storedCookieKey.equals(newCookieKey)) {
                oldCookie = storedCookie;
                break;
            }
        }

        if (oldCookie != null) {
            cookieStore.remove(oldCookie);
        }

        cookieStore.add(newCookie);
    }

}
