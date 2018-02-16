package io.enjincoin.sdk.client.service.identities.impl;

import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.BaseService;
import io.enjincoin.sdk.client.service.identities.IdentitiesService;
import io.enjincoin.sdk.client.util.Constants;
import io.enjincoin.sdk.client.util.MapUtils;
import io.enjincoin.sdk.client.util.ObjectUtils;
import io.enjincoin.sdk.client.util.StringUtils;
import io.enjincoin.sdk.client.vo.identity.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

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

    @Override
    public final GetIdentityResponseVO[] getIdentitiesSync(final GetIdentityRequestVO request) {
        GetIdentityResponseVO[] response = null;

        if (ObjectUtils.isNull(request)) {
            LOGGER.warning("Identities.get request is null.");
            return response;
        }

        if (StringUtils.isEmpty(request.getAuth()) || MapUtils.isEmpty(request.getIdentityMap())) {
            LOGGER.warning("1. Identities.get parameters may be empty or null.");
            return response;
        }

        if (StringUtils.isEmpty(request.getAfterIdentityId()) || StringUtils.isEmpty(request.getLimit())) {
            LOGGER.warning("2. Identities.get parameters may be empty or null.");
            return response;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", request.getAuth().get());
        params.put("identity", request.getIdentityMap().get());
        params.put("linked", request.getLinked().get());
        params.put("after_identity_id", request.getAfterIdentityId().get());
        params.put("limit", request.getLimit().get());

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_GET;

        response = (GetIdentityResponseVO[]) this.getJsonRpcUtils().sendJsonRpcRequest(this.getIdentitiesUrl(), GetIdentityResponseVO[].class, method, params);

        return response;
    }

    @Override
    public final CreateIdentityResponseVO createIdentitySync(final CreateIdentityRequestVO request) {
        CreateIdentityResponseVO response = null;

        if (ObjectUtils.isNull(request)) {
            LOGGER.warning("Identities.create request is null.");
            return response;
        }

        if (StringUtils.isEmpty(request.getAuth()) || MapUtils.isEmpty(request.getIdentityMap())) {
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

        if (StringUtils.isEmpty(request.getAuth()) || MapUtils.isEmpty(request.getIdentityMap()) || MapUtils.isEmpty(request.getUpdateMap())) {
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

        if (StringUtils.isEmpty(request.getAuth()) || MapUtils.isEmpty(request.getIdentityMap())) {
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
    public CompletableFuture<GetIdentityResponseVO[]> getIdentitiesAsync(final GetIdentityRequestVO request) {
        return CompletableFuture.supplyAsync(() -> this.getIdentitiesSync(request), this.getExecutorService());
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
