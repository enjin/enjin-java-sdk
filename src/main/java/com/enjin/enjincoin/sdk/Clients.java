package com.enjin.enjincoin.sdk;

/**
 * Factory class for creating new instances of {@link Client}.
 */
public final class Clients {

    private Clients() {
        super();
    }

    /**
     * Creates a new {@link Client} instance.
     *
     * @param baseUrl the Trusted Platform base url.
     * @param appId the app id.
     * @param log whether or not to enable sdk logging.
     * @return a new instance of {@link Client}.
     * @throws IllegalStateException if appId is less than 2.
     */
    public static Client createClient(final String baseUrl, final int appId, final boolean log) {
        if (appId < 2) {
            throw new IllegalStateException("App ID must have a value greater than 2.");
        }
        return new ClientImpl(baseUrl, String.valueOf(appId), log);
    }

}
