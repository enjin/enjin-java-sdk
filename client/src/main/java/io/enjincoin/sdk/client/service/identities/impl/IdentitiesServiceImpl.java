package io.enjincoin.sdk.client.service.identities.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

import com.enjin.java_commons.ObjectUtils;
import com.enjin.java_commons.OptionalUtils;
import com.enjin.java_commons.StringUtils;

import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.BaseService;
import io.enjincoin.sdk.client.service.identities.IdentitiesService;
import io.enjincoin.sdk.client.util.Constants;
import io.enjincoin.sdk.client.util.GsonUtils;
import io.enjincoin.sdk.client.util.JsonUtils;
import io.enjincoin.sdk.client.vo.identity.CreateIdentityRequestVO;
import io.enjincoin.sdk.client.vo.identity.CreateIdentityResponseVO;
import io.enjincoin.sdk.client.vo.identity.GetIdentityResponseVO;
import io.enjincoin.sdk.client.vo.legacy.identity.UpdateIdentityRequestVO;
import io.enjincoin.sdk.client.vo.legacy.identity.UpdateIdentityResponseVO;

/**
 * <p>
 * Synchronous implementation of IdentitiesService.
 * </p>
 */
public class IdentitiesServiceImpl extends BaseService implements IdentitiesService {

    /**
     * Logger used by this class.
     */
    private static final Logger LOGGER = Logger.getLogger(IdentitiesServiceImpl.class.getName());

    /**
     * Class constructor.
     *
     * @param config - the config to use
     */
    public IdentitiesServiceImpl(final Config config) {
        super(config);
    }

    /**
     * Method to get all identities.
     *
     *
     * @return - GetIdentityResponseVO
     */
    @Override
    public final GetIdentityResponseVO[] getIdentitiesSync() {
        GetIdentityResponseVO[] getIdentitiesResponse = null;

        // Get the identities url
        String getIdentitiesUrl = getIdentitiesUrl();

        String responseJsonString = performGetCall(getIdentitiesUrl);
        if (StringUtils.isEmpty(responseJsonString)) {
            LOGGER.warning("No response returned from the getIdentities call");
            return getIdentitiesResponse;
        }
        getIdentitiesResponse = (GetIdentityResponseVO[]) JsonUtils.convertJsonToObject(GsonUtils.GSON, responseJsonString, GetIdentityResponseVO[].class);

        return getIdentitiesResponse;
    }



    /**
     * Method to get an entity by identityId
     * @param identityId
     * @return
     */
    @Override
    public GetIdentityResponseVO getIdentitySync(final Integer identityId) {
        GetIdentityResponseVO getIdentityResponse = null;

        if (identityId == null) {
            LOGGER.warning("Identity passed in is null");
            return getIdentityResponse;
        }

        // Get the identities url and append the identityId
        String getIdentityByIdUrl = String.format("%s/%d", getIdentitiesUrl(), identityId);

        String responseJsonString = performGetCall(getIdentityByIdUrl);
        if (StringUtils.isEmpty(responseJsonString)) {
            LOGGER.warning("No response returned from the getIdentity call");
            return getIdentityResponse;
        }

        getIdentityResponse = (GetIdentityResponseVO) JsonUtils.convertJsonToObject(GsonUtils.GSON, responseJsonString, GetIdentityResponseVO.class);

        return getIdentityResponse;
    }

    @Override
    public final CreateIdentityResponseVO createIdentitySync(final CreateIdentityRequestVO createIdentityRequest) {
        CreateIdentityResponseVO createIdentityResponseVO = null;

        if (ObjectUtils.isNull(createIdentityRequest)) {
            LOGGER.warning("Identities.create request is null.");
            return createIdentityResponseVO;
        }

        if (!OptionalUtils.isStringPresent(createIdentityRequest.getEthereumAddress())) {
            LOGGER.warning("Identities.create parameters may be empty or null.");
            return createIdentityResponseVO;
        }

        //Convert the request object to json
        String requestJsonString = JsonUtils.convertObjectToJson(GsonUtils.GSON, createIdentityRequest);
        if (StringUtils.isEmpty(requestJsonString)) {
            LOGGER.warning("Identities.create failed to convert request object to json.");
        }
         // Get the identities url
        String createIdentitiesUrl = getIdentitiesUrl();

        String responseJsonString = performPostCall(createIdentitiesUrl, requestJsonString);
        if (StringUtils.isEmpty(responseJsonString)) {
            LOGGER.warning("No response returned from the createIdentity call");
            return createIdentityResponseVO;
        }
        createIdentityResponseVO = (CreateIdentityResponseVO) JsonUtils.convertJsonToObject(GsonUtils.GSON, responseJsonString, CreateIdentityResponseVO.class);

        return createIdentityResponseVO;
    }

    /**
     * Method to delete an identity
     * @param identityId - the identity to delete
     * @return
     */
    @Override
    public final Boolean deleteIdentitySync(final Integer identityId) {
        Boolean deleteIdentityResponseVO = false;

        if (identityId == null) {
            LOGGER.warning("Identities.delete identityId is null.");
            return deleteIdentityResponseVO;
        }


        // Get the identities url and append the identityId
        String deleteIdentityByIdUrl = String.format("%s/%d", getIdentitiesUrl(), identityId);

        String responseJsonString = performDeleteCall(deleteIdentityByIdUrl);
        if (StringUtils.isEmpty(responseJsonString)) {
            LOGGER.warning("No response returned from the deleteIdentity call");
            return deleteIdentityResponseVO;
        }
        if (responseJsonString.equalsIgnoreCase("true")) {
            deleteIdentityResponseVO = true;
        }

        return deleteIdentityResponseVO;
    }

    @Override
    public final UpdateIdentityResponseVO updateIdentitySync(final UpdateIdentityRequestVO request) {
        UpdateIdentityResponseVO response = null;

        if (ObjectUtils.isNull(request)) {
            LOGGER.warning("Identities.update request is null.");
            return response;
        }

        if (!OptionalUtils.isStringPresent(request.getAuth()) || !OptionalUtils.isMapPresent(request.getIdentityMap())
                || !OptionalUtils.isMapPresent(request.getUpdateMap())) {
            LOGGER.warning("Identities.update parameters may be empty or null.");
            return response;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", request.getAuth().get());
        params.put("identity", request.getIdentityMap().get());
        params.put("update", request.getUpdateMap().get());

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_UPDATE;

        response = (UpdateIdentityResponseVO) this.getJsonRpcUtils().sendJsonRpcRequest(this.getIdentitiesUrl(), UpdateIdentityResponseVO.class, method, params);

        return response;
    }



    @Override
    public CompletableFuture<GetIdentityResponseVO[]> getIdentitiesAsync() {
        return CompletableFuture.supplyAsync(() -> this.getIdentitiesSync(), this.getExecutorService());
    }

    @Override
    public CompletableFuture<GetIdentityResponseVO> getIdentityAsync(final Integer identityId) {
        return CompletableFuture.supplyAsync(() -> this.getIdentitySync(identityId), this.getExecutorService());
    }

    @Override
    public CompletableFuture<CreateIdentityResponseVO> createIdentityAsync(final CreateIdentityRequestVO request) {
        return CompletableFuture.supplyAsync(() -> this.createIdentitySync(request), this.getExecutorService());
    }

    @Override
    public CompletableFuture<UpdateIdentityResponseVO> updateIdentityAsync(final UpdateIdentityRequestVO request) {
        return CompletableFuture.supplyAsync(() -> this.updateIdentitySync(request), this.getExecutorService());
    }

    @Override
    public CompletableFuture<Boolean> deleteIdentityAsync(final Integer identityId) {
        return CompletableFuture.supplyAsync(() -> this.deleteIdentitySync(identityId), this.getExecutorService());
    }

}
