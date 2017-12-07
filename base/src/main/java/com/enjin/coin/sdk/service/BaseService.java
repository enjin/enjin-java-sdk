package com.enjin.coin.sdk.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.config.Notification;
import com.enjin.coin.sdk.config.Platform;
import com.enjin.coin.sdk.service.platform.PlatformService;
import com.enjin.coin.sdk.service.platform.impl.PlatformServiceImpl;
import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.util.JsonRpcUtils;
import com.enjin.coin.sdk.util.ObjectUtils;

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
     * Notification config.
     */
    private Notification notification;

    /**
     * Platform Service.
     */
    private PlatformService platformService;

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

        trustedPlatform        = config.getTrustedPlatform();
        isInTestMode           = config.isInTestMode();
        Integer totalExecutors = config.getTotalExecutors();
        executorService        = Executors.newFixedThreadPool(totalExecutors);
        notification           = config.getNotification();
        jsonRpcUtils           = new JsonRpcUtils();
        jsonRpcUtils.setIsInTestMode(isInTestMode);
    }

    /**
     * Method to get the identities url.
     *
     * @return - the identities url
     */
    protected String getIdentitiesUrl() {
        return getJsonRpcURL(Constants.IDENTITIES_URL);
    }

    /**
     * Method to get the tokens url.
     *
     * @return - the tokens url
     */
    protected String getTokensUrl() {
        return getJsonRpcURL(Constants.TOKENS_URL);
    }

    /**
     * Method to get the Transaction Requests url.
     *
     * @return - the transaction requests url
     */
    protected String getTransactionRequestsUrl() {
        return getJsonRpcURL(Constants.TRANSACTION_REQUESTS_URL);
    }

    /**
     * Method to get the Events url.
     *
     * @return - the events url
     */
    protected String getEventsUrl() {
        return getJsonRpcURL(Constants.EVENTS_URL);
    }

    /**
     * Method to get the platform url.
     *
     * @return - the platform url
     */
    protected String getPlatformUrl() {
        return getJsonRpcURL(Constants.PLATFORM_URL);
    }

    /**
     * Method to get the rpc url to use.
     *
     * @param endpoint - the base endpoint
     * @return - the final base endpoint to use
     */
    private String getJsonRpcURL(final String endpoint) {
        String baseURL = Constants.TRUSTED_PLATFORM_BASE_URL;

        if (ObjectUtils.isNotNull(trustedPlatform)) {
            baseURL = trustedPlatform.toString();
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
        return trustedPlatform;
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
        return jsonRpcUtils;
    }

    /**
     * Method to get the ExecutorService.
     *
     * @return - the ExecutorService.
     */
    public ExecutorService getExecutorService() {
        return executorService;
    }


    /**
     * Method to get the notification config.
     * @return Notification
     */
    public Notification getNotification() {
        return notification;
    }

    /**
     * Method to get the platformService.
     * @param config to use
     * @return PlatformService
     */
    public PlatformService getPlatformService(final Config config) {
        if (platformService == null) {
            platformService = new PlatformServiceImpl(config);
        }
        return platformService;
    }

    /**
     * toString method.
     * @return String
     */
    @Override
    public String toString() {
        return "BaseService [trustedPlatform=" + trustedPlatform + "]";
    }

}
