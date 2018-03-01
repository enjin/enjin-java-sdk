package io.enjincoin.sdk.client.service.identities.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

import com.enjin.java_commons.ObjectUtils;
import com.enjin.java_commons.OptionalUtils;

import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.BaseService;
import io.enjincoin.sdk.client.service.identities.IdentitiesService;
import io.enjincoin.sdk.client.util.Constants;
import io.enjincoin.sdk.client.util.GsonUtils;
import io.enjincoin.sdk.client.util.JsonUtils;
import io.enjincoin.sdk.client.vo.identity.CreateIdentityRequestVO;
import io.enjincoin.sdk.client.vo.identity.CreateIdentityResponseVO;
import io.enjincoin.sdk.client.vo.identity.DeleteIdentityRequestVO;
import io.enjincoin.sdk.client.vo.identity.DeleteIdentityResponseVO;
import io.enjincoin.sdk.client.vo.identity.GetIdentityResponseVO;
import io.enjincoin.sdk.client.vo.identity.ImmutableDeleteIdentityResponseVO;
import io.enjincoin.sdk.client.vo.identity.ImmutableGetIdentityResponseVO;
import io.enjincoin.sdk.client.vo.identity.UpdateIdentityRequestVO;
import io.enjincoin.sdk.client.vo.identity.UpdateIdentityResponseVO;
import okhttp3.Request;
import okhttp3.Response;

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
        GetIdentityResponseVO[] response = null;

        // Construct new request
        String getIdentitiesUrl = getIdentitiesUrl();
        System.out.println("getIdentitiesUrl:"+getIdentitiesUrl);

        try {
            Request httpRequest = new Request.Builder().url(getIdentitiesUrl).build();
            Response httpResponse = getOkHttpClient().newCall(httpRequest).execute();
            String jsonString = httpResponse.body().string();
            response = (GetIdentityResponseVO[]) JsonUtils.convertJsonToObject(GsonUtils.GSON, jsonString, ImmutableGetIdentityResponseVO[].class);

        } catch (IOException e) {
            LOGGER.warning("An IOException has occured getting all identities. Exception:" + e);
        }

        return response;
    }

    /**
     * Method to get an entity by identityId
     * @param identityId
     * @return
     */
    @Override
    public GetIdentityResponseVO getIdentitySync(Integer identityId) {
        GetIdentityResponseVO response = null;

        if (identityId == null) {
            LOGGER.warning("Identity passed in is null");
            return response;
        }

        // Construct new request
        String getIdentityByIdUrl = String.format("%s/%d", getIdentitiesUrl(), identityId);
        System.out.println("getIdentityByIdUrl:"+getIdentityByIdUrl);

        try {
            Request httpRequest = new Request.Builder().url(getIdentityByIdUrl).build();
            Response httpResponse = getOkHttpClient().newCall(httpRequest).execute();
            String jsonString = httpResponse.body().string();
            response = (GetIdentityResponseVO) JsonUtils.convertJsonToObject(GsonUtils.GSON, jsonString, ImmutableGetIdentityResponseVO.class);

        } catch (IOException e) {
            LOGGER.warning("An IOException has occured getting identities byId. Exception:" + e);
        }

        return response;
    }

    @Override
    public final CreateIdentityResponseVO createIdentitySync(final CreateIdentityRequestVO request) {
        CreateIdentityResponseVO response = null;

        if (ObjectUtils.isNull(request)) {
            LOGGER.warning("Identities.create request is null.");
            return response;
        }

        if (!OptionalUtils.isStringPresent(request.getAuth()) || !OptionalUtils.isMapPresent(request.getIdentityMap())) {
            LOGGER.warning("Identities.create parameters may be empty or null.");
            return response;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", request.getAuth().get());
        params.put("identity", request.getIdentityMap().get());

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_CREATE;

        response = (CreateIdentityResponseVO) this.getJsonRpcUtils().sendJsonRpcRequest(this.getIdentitiesUrl(), CreateIdentityResponseVO.class, method, params);

        return response;
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
    public final DeleteIdentityResponseVO deleteIdentitySync(final DeleteIdentityRequestVO request) {
        DeleteIdentityResponseVO response = null;

        if (ObjectUtils.isNull(request)) {
            LOGGER.warning("Identities.list request is null.");
            return response;
        }

        if (!OptionalUtils.isStringPresent(request.getAuth()) || !OptionalUtils.isMapPresent(request.getIdentityMap())) {
            LOGGER.warning("Identities.list parameters may be empty or null.");
            return response;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("auth", request.getAuth().get());
        params.put("identity", request.getIdentityMap().get());

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_DELETE;

        Boolean result = (Boolean) this.getJsonRpcUtils().sendJsonRpcRequest(this.getIdentitiesUrl(), Boolean.class, method, params);

        response = ImmutableDeleteIdentityResponseVO.builder().setResult(result).build();

        return response;
    }

    @Override
    public CompletableFuture<GetIdentityResponseVO[]> getIdentitiesAsync() {
        return CompletableFuture.supplyAsync(() -> this.getIdentitiesSync(), this.getExecutorService());
    }

    @Override
    public CompletableFuture<GetIdentityResponseVO> getIdentityAsync(Integer identityId) {
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
    public CompletableFuture<DeleteIdentityResponseVO> deleteIdentityAsync(final DeleteIdentityRequestVO request) {
        return CompletableFuture.supplyAsync(() -> this.deleteIdentitySync(request), this.getExecutorService());
    }

}
