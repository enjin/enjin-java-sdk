package com.enjin.enjincoin.sdk.http;

import okhttp3.Cookie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Persists {@link Cookie} in memory.
 *
 * @author Evan Lindsay
 * @see Cookie
 */
public class MemoryCookiePersistor implements CookiePersistor {

    private List<Cookie> storage = new ArrayList<>();

    @Override
    public List<Cookie> loadAll() {
        return storage;
    }

    @Override
    public void save(Cookie cookie) {
        storage.add(cookie);
    }

    @Override
    public void saveAll(Collection<Cookie> cookies) {
        storage.addAll(cookies);
    }

    @Override
    public void removeAll(Collection<Cookie> cookies) {
        storage.removeAll(cookies);
    }

    @Override
    public void clear() {
        storage.clear();
    }
}
