package com.enjin.coin.sdk.service.identities.impl;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.BaseService;
import com.enjin.coin.sdk.service.identities.IdentitiesService;
import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.util.MapUtils;
import com.enjin.coin.sdk.util.StringUtils;
import com.enjin.coin.sdk.vo.identity.CreateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.CreateIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.DeleteIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.DeleteIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.GetIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.GetIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.ImmutableDeleteIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.ListIdentitiesRequestVO;
import com.enjin.coin.sdk.vo.identity.ListIdentitiesResponseVO;
import com.enjin.coin.sdk.vo.identity.UpdateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.UpdateIdentityResponseVO;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * <p>Synchronous implementation of IdentitiesService</p>
 */
public class IdentitiesServiceImpl extends BaseService implements IdentitiesService {

    private static final Logger LOGGER = Logger.getLogger(IdentitiesServiceImpl.class.getName());

    /**
     * Class constructor
     *
     * @param config - the config to use
     */
    public IdentitiesServiceImpl(Config config) {
        super(config);
    }

    @Override
    public GetIdentityResponseVO getIdentity(GetIdentityRequestVO request) {
        GetIdentityResponseVO getIdentityResponseVO = null;

        if (request == null || StringUtils.isEmpty(request.getAuth())
                || MapUtils.isEmpty(request.getIdentity())) {
            LOGGER.warning("getIdentityRequestVO is null, auth or identidyId passed in are null or empty");
            return getIdentityResponseVO;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", request.getAuth().get());
        params.put("identity", request.getIdentity().get());

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_GET;

        getIdentityResponseVO = (GetIdentityResponseVO) jsonRpcUtils.sendJsonRpcRequest(getIdentitiesUrl(), GetIdentityResponseVO.class, method, params);

        return getIdentityResponseVO;
    }

    @Override
    public ListIdentitiesResponseVO[] listIdentities(ListIdentitiesRequestVO request) {
        ListIdentitiesResponseVO[] listIdentitiesResponseVO = null;

        if (request == null || StringUtils.isEmpty(request.getAuth())
                || MapUtils.isEmpty(request.getIdentity())) {
            LOGGER.warning("listIdentitiesRequestVO is null, auth or identity passed in are null or empty");
            return listIdentitiesResponseVO;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", request.getAuth().get());
        params.put("identity", request.getIdentity().get());
        if (request.getLinked().isPresent()) {
            params.put("linked", request.getLinked().get());
        }
        if (request.getAfterIdentityId().isPresent()) {
            params.put("after_identity_id", request.getAfterIdentityId().get());
        }
        if (request.getLimit().isPresent()) {
            params.put("limit", request.getLimit().get());
        }

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_LIST;

        listIdentitiesResponseVO = (ListIdentitiesResponseVO[]) jsonRpcUtils.sendJsonRpcRequest(getIdentitiesUrl(), ListIdentitiesResponseVO[].class, method, params);
        return listIdentitiesResponseVO;
    }

    @Override
    public CreateIdentityResponseVO createIdentity(CreateIdentityRequestVO request) {
        CreateIdentityResponseVO createIdentityResponseVO = null;

        if (request == null || StringUtils.isEmpty(request.getAuth())
                || MapUtils.isEmpty(request.getIdentity())) {
            LOGGER.warning("createIdentityRequestVO is null, auth or identity passed in are null or empty");
            return createIdentityResponseVO;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", request.getAuth().get());
        params.put("identity", request.getIdentity().get());

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_CREATE;

        createIdentityResponseVO = (CreateIdentityResponseVO) jsonRpcUtils.sendJsonRpcRequest(getIdentitiesUrl(), CreateIdentityResponseVO.class, method, params);

        return createIdentityResponseVO;
    }

    @Override
    public UpdateIdentityResponseVO updateIdentity(UpdateIdentityRequestVO request) {
        UpdateIdentityResponseVO updateIdentityResponseVO = null;

        if (request == null || StringUtils.isEmpty(request.getAuth())
                || MapUtils.isEmpty(request.getIdentity())
                || MapUtils.isEmpty(request.getUpdate())) {
            LOGGER.warning("updateIdentityRequestVO is null or auth, identidy or update passed in are null or empty");
            return updateIdentityResponseVO;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", request.getAuth().get());
        params.put("identity", request.getIdentity().get());
        params.put("update", request.getUpdate().get());

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_UPDATE;

        updateIdentityResponseVO = (UpdateIdentityResponseVO) jsonRpcUtils.sendJsonRpcRequest(getIdentitiesUrl(), UpdateIdentityResponseVO.class, method, params);

        return updateIdentityResponseVO;
    }

    @Override
    public DeleteIdentityResponseVO deleteIdentity(DeleteIdentityRequestVO request) {
        DeleteIdentityResponseVO deleteIdentityResponseVO = null;

        if (request == null || StringUtils.isEmpty(request.getAuth())
                || MapUtils.isEmpty(request.getIdentity())) {
            LOGGER.warning("deleteIdentityRequestVO is null, auth or identity passed in are null or empty");
            return deleteIdentityResponseVO;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", request.getAuth().get());
        params.put("identity", request.getIdentity().get());

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_DELETE;

        Boolean result = (Boolean) jsonRpcUtils.sendJsonRpcRequest(getIdentitiesUrl(), Boolean.class, method, params);
        deleteIdentityResponseVO = ImmutableDeleteIdentityResponseVO.builder()
                .setResult(result)
                .build();
        return deleteIdentityResponseVO;
    }

}
