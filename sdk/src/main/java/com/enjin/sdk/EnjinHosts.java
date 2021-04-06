package com.enjin.sdk;

/**
 * The network hosts used by the Enjin Cloud.
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

    /**
     * The URL for the JumpNet network.
     */
    public static final String JUMP_NET = "https://jumpnet.cloud.enjin.io/";

    private EnjinHosts() {
        throw new IllegalStateException("Utility class");
    }

}
