package io.enjincoin.sdk.client.service;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import com.enjin.java_commons.ObjectUtils;
import com.enjin.java_commons.StringUtils;

import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.config.Platform;
import io.enjincoin.sdk.client.service.platform.SynchronousPlatformService;
import io.enjincoin.sdk.client.service.platform.impl.PlatformServiceImpl;
import io.enjincoin.sdk.client.util.Constants;
import io.enjincoin.sdk.client.util.HttpClient;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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
     * Executor service.
     */
    private ExecutorService executorService;

    /**
     * Platform Service.
     */
    private SynchronousPlatformService platformService;

    /**
     * Private OKHttpClient instance
     */
    private OkHttpClient okHttpClient;

    /**
     * Media Type for json
     */
    private static final MediaType MEDIATYPE_JSON = MediaType.parse("application/json; charset=utf-8");

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
        Integer totalExecutors = config.getTotalExecutors();
        this.executorService = Executors.newFixedThreadPool(totalExecutors);

        okHttpClient = new OkHttpClient();
        okHttpClient = HttpClient.trustAllSslClient(okHttpClient);
    }

    /**
     * Method to get the okHttpClient
     * @return
     */
    private OkHttpClient getHttpClient() {
        return okHttpClient;
    }


    /**
     * Method to perform a get call
     * @param urlToCall - url to call
     * @return
     */
    protected String performGetCall(String urlToCall) {
        String responseJsonString = null;

        if (StringUtils.isEmpty(urlToCall)) {
            LOGGER.warning("performGetCall. urlToCall cannot be null or empty");
            return responseJsonString;
        }

        try {
            Request httpRequest = new Request.Builder().url(urlToCall).build();
            Response httpResponse = getHttpClient().newCall(httpRequest).execute();
            int responseCode = httpResponse.code();
            if (responseCode != Constants.SUCCESS_HTTP_CODE) {
                LOGGER.warning("performGetCall. responseCode returned '"+responseCode+"' from the url '"+urlToCall+"' is not valid");
                return responseJsonString;
            }

            responseJsonString = httpResponse.body().string();
        } catch (IOException e) {
            LOGGER.warning("performGetCall. An IOException has occured calling the url "+urlToCall+". Exception:" + e);
        }
        return responseJsonString;
    }

    /**
     * Method to perform a post call
     * @param urlToCall - url to call
     * @param requestJsonString - the request to send
     * @return
     */
    protected String performPostCall(String urlToCall, String requestJsonString) {
        String responseJsonString = null;

        if (StringUtils.isEmpty(urlToCall) || StringUtils.isEmpty(requestJsonString)) {
            LOGGER.warning("performPostCall. urlToCall or requestJsonString cannot be null or empty");
            return responseJsonString;
        }

        try {
            RequestBody requestBody = RequestBody.create(MEDIATYPE_JSON, requestJsonString);
            Request httpRequest = new Request.Builder().url(urlToCall).post(requestBody).build();
            Response httpResponse = getHttpClient().newCall(httpRequest).execute();
            int responseCode = httpResponse.code();
            if (responseCode != Constants.SUCCESS_HTTP_CODE) {
                LOGGER.warning("performPostCall. responseCode returned '"+responseCode+"' from the url '"+urlToCall+"' is not valid");
                return responseJsonString;
            }

            responseJsonString = httpResponse.body().string();
        } catch (IOException e) {
            LOGGER.warning("performPostCall. An IOException has occured calling the url "+urlToCall+". Exception:" + e);
        }
        return responseJsonString;
    }
    /**
     * Method to perform a put call
     * @param urlToCall - url to call
     * @param requestJsonString - the request to send
     * @return
     */
    protected String performPutCall(String urlToCall, String requestJsonString) {
        String responseJsonString = null;

        if (StringUtils.isEmpty(urlToCall) || StringUtils.isEmpty(requestJsonString)) {
            LOGGER.warning("performPutCall. urlToCall or requestJsonString cannot be null or empty");
            return responseJsonString;
        }

        try {
            RequestBody requestBody = RequestBody.create(MEDIATYPE_JSON, requestJsonString);
            Request httpRequest = new Request.Builder().url(urlToCall).put(requestBody).build();
            Response httpResponse = getHttpClient().newCall(httpRequest).execute();
            int responseCode = httpResponse.code();
            if (responseCode != Constants.SUCCESS_HTTP_CODE) {
                LOGGER.warning("performPutCall. responseCode returned '"+responseCode+"' from the url '"+urlToCall+"' is not valid");
                return responseJsonString;
            }

            responseJsonString = httpResponse.body().string();
        } catch (IOException e) {
            LOGGER.warning("performPutCall. An IOException has occured calling the url "+urlToCall+". Exception:" + e);
        }
        return responseJsonString;
    }
    /**
     * Method to perform a delete call
     * @param urlToCall - url to call
     * @return
     */
    protected String performDeleteCall(String urlToCall) {
        String responseJsonString = null;

        if (StringUtils.isEmpty(urlToCall)) {
            LOGGER.warning("performDeleteCall. urlToCall cannot be null or empty");
            return responseJsonString;
        }

        try {
            Request httpRequest = new Request.Builder().url(urlToCall).delete().build();
            Response httpResponse = getHttpClient().newCall(httpRequest).execute();
            int responseCode = httpResponse.code();
            if (responseCode != Constants.SUCCESS_HTTP_CODE) {
                LOGGER.warning("performDeleteCall. responseCode returned '"+responseCode+"' from the url '"+urlToCall+"' is not valid");
                return responseJsonString;
            }

            responseJsonString = httpResponse.body().string();
        } catch (IOException e) {
            LOGGER.warning("performDeleteCall. An IOException has occured calling the url "+urlToCall+". Exception:" + e);
        }
        return responseJsonString;
    }

    /**
     * Method to get the identities url.
     *
     * @return - the identities url
     */
    protected String getIdentitiesUrl() {
        return this.getRestURL(Constants.IDENTITIES_URL);
    }

    /**
     * Method to get the link wallet url.
     *
     * @return - the link wallet url
     */
    protected String getLinkWalletUrl() {
        return this.getRestURL(Constants.LINK_WALLET_URL);
    }


    /**
     * Method to get the tokens url.
     *
     * @return - the tokens url
     */
    protected String getTokensUrl() {
        return this.getRestURL(Constants.TOKENS_URL);
    }

    /**
     * Method to get the Transaction Requests url.
     *
     * @return - the transaction requests url
     */
    protected String getTransactionRequestsUrl() {
        return this.getRestURL(Constants.TRANSACTION_REQUESTS_URL);
    }

    /**
     * Method to get the Events url.
     *
     * @return - the events url
     */
    protected String getEventsUrl() {
        return this.getRestURL(Constants.EVENTS_URL);
    }

    /**
     * Method to get the platform url.
     *
     * @return - the platform url
     */
    protected String getPlatformUrl() {
        return this.getRestURL(Constants.PLATFORM_URL);
    }

    /**
     * Method to get the rest url to use.
     *
     * @param endpoint - the base endpoint
     *
     * @return - the final base endpoint to use
     */
    private String getRestURL(final String endpoint) {
        String restUrl = null;
        if (ObjectUtils.isNull(this.trustedPlatform)) {
            LOGGER.warning("TraustedPlatform is not set");
            return restUrl;
        }

        restUrl = String.format("%s://%s:%d/api/v1/%s", trustedPlatform.getProtocol(), trustedPlatform.getHost(), trustedPlatform.getPort(), endpoint);

        return restUrl;
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
