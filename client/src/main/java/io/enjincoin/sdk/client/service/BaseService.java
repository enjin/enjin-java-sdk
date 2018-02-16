package io.enjincoin.sdk.client.service;

import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.config.Platform;
import io.enjincoin.sdk.client.service.platform.SynchronousPlatformService;
import io.enjincoin.sdk.client.service.platform.impl.PlatformServiceImpl;
import io.enjincoin.sdk.client.util.Constants;
import io.enjincoin.sdk.client.util.JsonRpcUtils;
import io.enjincoin.sdk.client.util.ObjectUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * <p>Provides Services used by the main service classes.</p>
 */
public abstract class BaseService {

    /**
     * Logger used by this class.
     */
    private static final Logger LOGGER = Logger.getLogger(BaseService.class.getName());

    /**
     * Trusted Platform.
     */
    private Platform trustedPlatform;
    /**
     * Test mode toggle.
     */
    private boolean isInTestMode;
    /**
     * Json RPC Helper.
     */
    private JsonRpcUtils jsonRpcUtils;
    /**
     * Executor service.
     */
    private ExecutorService executorService;

    /**
     * Platform Service.
     */
    private SynchronousPlatformService platformService;

    /**
     * Class contructor.
     *
     * @param config - config to use
     */
    public BaseService(final Config config) {
        if (ObjectUtils.isNull(config)) {
            LOGGER.warning("The supplied config is null.");
            return;
        }

        this.trustedPlatform = config.getTrustedPlatform();
        this.isInTestMode = config.isInTestMode();
        Integer totalExecutors = config.getTotalExecutors();
        this.executorService = Executors.newFixedThreadPool(totalExecutors);
        this.jsonRpcUtils = new JsonRpcUtils();
        this.jsonRpcUtils.setIsInTestMode(this.isInTestMode);
    }

    /**
     * Method to get the identities url.
     *
     * @return - the identities url
     */
    protected String getIdentitiesUrl() {
        return this.getJsonRpcURL(Constants.IDENTITIES_URL);
    }

    /**
     * Method to get the tokens url.
     *
     * @return - the tokens url
     */
    protected String getTokensUrl() {
        return this.getJsonRpcURL(Constants.TOKENS_URL);
    }

    /**
     * Method to get the Transaction Requests url.
     *
     * @return - the transaction requests url
     */
    protected String getTransactionRequestsUrl() {
        return this.getJsonRpcURL(Constants.TRANSACTION_REQUESTS_URL);
    }

    /**
     * Method to get the Events url.
     *
     * @return - the events url
     */
    protected String getEventsUrl() {
        return this.getJsonRpcURL(Constants.EVENTS_URL);
    }

    /**
     * Method to get the platform url.
     *
     * @return - the platform url
     */
    protected String getPlatformUrl() {
        return this.getJsonRpcURL(Constants.PLATFORM_URL);
    }

    /**
     * Method to get the rpc url to use.
     *
     * @param endpoint - the base endpoint
     *
     * @return - the final base endpoint to use
     */
    private String getJsonRpcURL(final String endpoint) {
        String baseURL = Constants.TRUSTED_PLATFORM_BASE_URL;

        if (ObjectUtils.isNotNull(this.trustedPlatform)) {
            baseURL = this.trustedPlatform.toString();
        }

        String jsonRpcURL = baseURL + endpoint;

        return jsonRpcURL;
    }

    /**
     * Method to get the trusted platform.
     *
     * @return - the trusted platform
     */
    public Platform getTrustedPlatform() {
        return this.trustedPlatform;
    }

    /**
     * Method to set the trusted platform.
     *
     * @param platform the platform
     */
    public void setTrustedPlatform(final Platform platform) {
        this.trustedPlatform = platform;
    }

    /**
     * Method to get the JsonRpcUtils.
     *
     * @return - the JsonRpcUtils
     */
    public JsonRpcUtils getJsonRpcUtils() {
        return this.jsonRpcUtils;
    }

    /**
     * Method to get the ExecutorService.
     *
     * @return - the ExecutorService.
     */
    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    /**
     * Method to get the platformService.
     *
     * @param config to use
     *
     * @return PlatformService
     */
    public SynchronousPlatformService getPlatformService(final Config config) {
        if (this.platformService == null) {
            this.platformService = new PlatformServiceImpl(config);
        }
        return this.platformService;
    }

    /**
     * toString method.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "BaseService [trustedPlatform=" + this.trustedPlatform + "]";
    }

}
