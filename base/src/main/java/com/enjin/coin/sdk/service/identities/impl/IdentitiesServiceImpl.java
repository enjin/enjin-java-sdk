package com.enjin.coin.sdk.service.identities.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.BaseService;
import com.enjin.coin.sdk.service.identities.IdentitiesService;
import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.util.MapUtils;
import com.enjin.coin.sdk.util.ObjectUtils;
import com.enjin.coin.sdk.util.StringUtils;
import com.enjin.coin.sdk.vo.identity.CreateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.CreateIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.DeleteIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.DeleteIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.GetIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.GetIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.ImmutableDeleteIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.UpdateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.UpdateIdentityResponseVO;

/**
 * <p>Synchronous implementation of IdentitiesService.</p>
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
    public final GetIdentityResponseVO getIdentity(final GetIdentityRequestVO request) {
        GetIdentityResponseVO response = null;

        if (ObjectUtils.isNull(request)) {
            LOGGER.warning("Identities.get request is null.");
            return response;
        }

        if (StringUtils.isEmpty(request.getAuth()) || MapUtils.isEmpty(request.getIdentity())) {
            LOGGER.warning("Identities.get parameters may be empty or null.");
            return response;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", request.getAuth().get());
        params.put("identity", request.getIdentity().get());

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_GET;

        response = (GetIdentityResponseVO) getJsonRpcUtils()
                .sendJsonRpcRequest(getIdentitiesUrl(), GetIdentityResponseVO.class, method, params);

        return response;
    }


    @Override
    public final CreateIdentityResponseVO createIdentity(final CreateIdentityRequestVO request) {
        CreateIdentityResponseVO response = null;

        if (ObjectUtils.isNull(request)) {
            LOGGER.warning("Identities.create request is null.");
            return response;
        }

        if (StringUtils.isEmpty(request.getAuth()) || MapUtils.isEmpty(request.getIdentity())) {
            LOGGER.warning("Identities.create parameters may be empty or null.");
            return response;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", request.getAuth().get());
        params.put("identity", request.getIdentity().get());

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_CREATE;

        response = (CreateIdentityResponseVO) getJsonRpcUtils()
                .sendJsonRpcRequest(getIdentitiesUrl(), CreateIdentityResponseVO.class, method, params);

        return response;
    }

    @Override
    public final UpdateIdentityResponseVO updateIdentity(final UpdateIdentityRequestVO request) {
        UpdateIdentityResponseVO response = null;

        if (ObjectUtils.isNull(request)) {
            LOGGER.warning("Identities.update request is null.");
            return response;
        }

        if (StringUtils.isEmpty(request.getAuth()) || MapUtils.isEmpty(request.getIdentity())
                || MapUtils.isEmpty(request.getUpdate())) {
            LOGGER.warning("Identities.update parameters may be empty or null.");
            return response;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", request.getAuth().get());
        params.put("identity", request.getIdentity().get());
        params.put("update", request.getUpdate().get());

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_UPDATE;

        response = (UpdateIdentityResponseVO) getJsonRpcUtils()
                .sendJsonRpcRequest(getIdentitiesUrl(), UpdateIdentityResponseVO.class, method, params);

        return response;
    }

    @Override
    public final DeleteIdentityResponseVO deleteIdentity(final DeleteIdentityRequestVO request) {
        DeleteIdentityResponseVO response = null;

        if (ObjectUtils.isNull(request)) {
            LOGGER.warning("Identities.list request is null.");
            return response;
        }

        if (StringUtils.isEmpty(request.getAuth()) || MapUtils.isEmpty(request.getIdentity())) {
            LOGGER.warning("Identities.list parameters may be empty or null.");
            return response;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("auth", request.getAuth().get());
        params.put("identity", request.getIdentity().get());

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_DELETE;

        Boolean result = (Boolean) getJsonRpcUtils().sendJsonRpcRequest(getIdentitiesUrl(), Boolean.class, method, params);

        response = ImmutableDeleteIdentityResponseVO.builder()
                .setResult(result)
                .build();

        return response;
    }

}
