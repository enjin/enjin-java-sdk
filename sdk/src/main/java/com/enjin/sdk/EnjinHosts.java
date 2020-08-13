package com.enjin.sdk;

/**
 * TODO
 */
public final class EnjinHosts {

    /**
     * The URL for the main Enjin Cloud.
     */
    public static final String MAIN_NET = "https://cloud.enjin.io/";
    /**
     * The URL for the kovan Enjin Cloud.
     */
    public static final String KOVAN = "https://kovan.cloud.enjin.io/";

    private EnjinHosts() {
        throw new IllegalStateException("Utility class");
    }

}
