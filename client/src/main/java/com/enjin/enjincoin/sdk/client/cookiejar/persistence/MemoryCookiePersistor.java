package com.enjin.enjincoin.sdk.client.cookiejar.persistence;

import okhttp3.Cookie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MemoryCookiePersistor implements CookiePersistor {

    private List<Cookie> storage = new ArrayList<>();

    @Override
    public List<Cookie> loadAll() {
        return storage;
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
