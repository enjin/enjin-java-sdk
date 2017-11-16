package com.enjin.coin.sdk.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.config.Platform;
import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.util.JsonRpcUtils;
import com.enjin.coin.sdk.util.ObjectUtils;

import java.util.logging.Logger;

/**
 * <p>Provides Services used by the main service classes</p>
 *
 * @author damien
 */
public abstract class BaseService {

    private static final Logger LOGGER = Logger.getLogger(BaseService.class.getName());

    private Platform trustedPlatform;
    private boolean isInTestMode;
    protected JsonRpcUtils jsonRpcUtils;
    protected ExecutorService executorService;
    
    /**
     * Class contructor
     *
     * @param enjinConfig - enjinConfig to use
     */
    public BaseService(Config enjinConfig) {
        if (enjinConfig == null) {
            LOGGER.warning("The enjinConfig passed in is null");
            return;
        }

        trustedPlatform = enjinConfig.getTrustedPlatform();
        isInTestMode = enjinConfig.isInTestMode() == null ? false : enjinConfig.isInTestMode();
        Integer totalExecutors = enjinConfig.getTotalExecutors();
        executorService = Executors.newFixedThreadPool(totalExecutors);
        
        jsonRpcUtils = new JsonRpcUtils();
        jsonRpcUtils.setIsInTestMode(isInTestMode);
    }

    /**
     * Method to get the identities url
     *
     * @return - the identities url
     */
    protected String getIdentitiesUrl() {
        return getJsonRpcURL(Constants.IDENTITIES_URL);
    }

    /**
     * Method to get the tokens url
     *
     * @return - the tokens url
     */
    protected String getTokensUrl() {
        return getJsonRpcURL(Constants.TOKENS_URL);
    }

    /**
     * Method to get the Transaction Requests url
     *
     * @return - the transaction requests url
     */
    protected String getTransactionRequestsUrl() {
        return getJsonRpcURL(Constants.TRANSACTION_REQUESTS_URL);
    }

    /**
     * Method to get the Events url
     *
     * @return - the events url
     */
    protected String getEventsUrl() {
        return getJsonRpcURL(Constants.EVENTS_URL);
    }

    /**
     * Method to get the rpc url to use
     *
     * @param endpoint - the base endpoint
     * @return - the final base endpoint to use
     */
    private String getJsonRpcURL(String endpoint) {
        String baseURL = Constants.TRUSTED_PLATFORM_BASE_URL;

        if (ObjectUtils.isNotNull(trustedPlatform)) {
            baseURL = trustedPlatform.toString();
        }

        String jsonRpcURL = baseURL + endpoint;

        return jsonRpcURL;
    }

    public Platform getTrustedPlatform() {
        return trustedPlatform;
    }

    public void setTrustedPlatform(Platform trustedPlatformUrl) {
        this.trustedPlatform = trustedPlatformUrl;
    }

    @Override
    public String toString() {
        return "BaseAction [trustedPlatform=" + trustedPlatform + "]";
    }

}
