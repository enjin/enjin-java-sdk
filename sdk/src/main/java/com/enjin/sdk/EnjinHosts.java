package com.enjin.sdk;

import okhttp3.HttpUrl;

/**
 * TODO
 */
public final class EnjinHosts {

    /**
     * The URL for the main Enjin Cloud.
     */
    public static final HttpUrl MAIN_NET = HttpUrl.get("https://cloud.enjin.io/");
    /**
     * The URL for the kovan Enjin Cloud.
     */
    public static final HttpUrl KOVAN = HttpUrl.get("https://kovan.cloud.enjin.io/");

    private EnjinHosts() {
        throw new IllegalStateException(/* TODO: Exception message. */);
    }

}
