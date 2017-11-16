package com.enjin.coin.sdk.service.identities.impl;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.BaseService;
import com.enjin.coin.sdk.service.identities.IdentitiesService;
import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.util.MapUtils;
import com.enjin.coin.sdk.util.StringUtils;
import com.enjin.coin.sdk.vo.identity.*;

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
     * @param enjinConfig - the enjinConfig to use
     */
    public IdentitiesServiceImpl(Config enjinConfig) {
        super(enjinConfig);
    }

    @Override
    public GetIdentityResponseVO getIdentity(GetIdentityRequestVO getIdentityRequestVO) {
        GetIdentityResponseVO getIdentityResponseVO = null;

        if (getIdentityRequestVO == null || StringUtils.isEmpty(getIdentityRequestVO.getAuth())
                || MapUtils.isEmpty(getIdentityRequestVO.getIdentity())) {
            LOGGER.warning("getIdentityRequestVO is null, auth or identidyId passed in are null or empty");
            return getIdentityResponseVO;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", getIdentityRequestVO.getAuth().get());
        params.put("identity", getIdentityRequestVO.getIdentity().get());

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_GET;

        getIdentityResponseVO = (GetIdentityResponseVO) jsonRpcUtils.sendJsonRpcRequest(getIdentitiesUrl(), GetIdentityResponseVO.class, method, params);

        return getIdentityResponseVO;
    }

    @Override
    public ListIdentitiesResponseVO[] listIdentities(ListIdentitiesRequestVO listIdentitiesRequestVO) {
        ListIdentitiesResponseVO[] listIdentitiesResponseVO = null;

        if (listIdentitiesRequestVO == null || StringUtils.isEmpty(listIdentitiesRequestVO.getAuth())
                || MapUtils.isEmpty(listIdentitiesRequestVO.getIdentity())) {
            LOGGER.warning("listIdentitiesRequestVO is null, auth or identity passed in are null or empty");
            return listIdentitiesResponseVO;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", listIdentitiesRequestVO.getAuth().get());
        params.put("identity", listIdentitiesRequestVO.getIdentity().get());
        if (listIdentitiesRequestVO.getLinked().isPresent()) {
            params.put("linked", listIdentitiesRequestVO.getLinked().get());
        }
        if (listIdentitiesRequestVO.getAfterIdentityId().isPresent()) {
            params.put("after_identity_id", listIdentitiesRequestVO.getAfterIdentityId().get());
        }
        if (listIdentitiesRequestVO.getLimit().isPresent()) {
            params.put("limit", listIdentitiesRequestVO.getLimit().get());
        }

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_LIST;

        listIdentitiesResponseVO = (ListIdentitiesResponseVO[]) jsonRpcUtils.sendJsonRpcRequest(getIdentitiesUrl(), ListIdentitiesResponseVO[].class, method, params);
        return listIdentitiesResponseVO;
    }

    @Override
    public CreateIdentityResponseVO createIdentity(CreateIdentityRequestVO createIdentityRequestVO) {
        CreateIdentityResponseVO createIdentityResponseVO = null;

        if (createIdentityRequestVO == null || StringUtils.isEmpty(createIdentityRequestVO.getAuth())
                || MapUtils.isEmpty(createIdentityRequestVO.getIdentity())) {
            LOGGER.warning("createIdentityRequestVO is null, auth or identity passed in are null or empty");
            return createIdentityResponseVO;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", createIdentityRequestVO.getAuth().get());
        params.put("identity", createIdentityRequestVO.getIdentity().get());

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_CREATE;

        createIdentityResponseVO = (CreateIdentityResponseVO) jsonRpcUtils.sendJsonRpcRequest(getIdentitiesUrl(), CreateIdentityResponseVO.class, method, params);

        return createIdentityResponseVO;
    }

    @Override
    public UpdateIdentityResponseVO updateIdentity(UpdateIdentityRequestVO updateIdentityRequestVO) {
        UpdateIdentityResponseVO updateIdentityResponseVO = null;

        if (updateIdentityRequestVO == null || StringUtils.isEmpty(updateIdentityRequestVO.getAuth())
                || MapUtils.isEmpty(updateIdentityRequestVO.getIdentity())
                || MapUtils.isEmpty(updateIdentityRequestVO.getUpdate())) {
            LOGGER.warning("updateIdentityRequestVO is null or auth, identidy or update passed in are null or empty");
            return updateIdentityResponseVO;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", updateIdentityRequestVO.getAuth().get());
        params.put("identity", updateIdentityRequestVO.getIdentity().get());
        params.put("update", updateIdentityRequestVO.getUpdate().get());

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_UPDATE;

        updateIdentityResponseVO = (UpdateIdentityResponseVO) jsonRpcUtils.sendJsonRpcRequest(getIdentitiesUrl(), UpdateIdentityResponseVO.class, method, params);

        return updateIdentityResponseVO;
    }

    @Override
    public DeleteIdentityResponseVO deleteIdentity(DeleteIdentityRequestVO deleteIdentityRequestVO) {
        DeleteIdentityResponseVO deleteIdentityResponseVO = null;

        if (deleteIdentityRequestVO == null || StringUtils.isEmpty(deleteIdentityRequestVO.getAuth())
                || MapUtils.isEmpty(deleteIdentityRequestVO.getIdentity())) {
            LOGGER.warning("deleteIdentityRequestVO is null, auth or identity passed in are null or empty");
            return deleteIdentityResponseVO;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", deleteIdentityRequestVO.getAuth().get());
        params.put("identity", deleteIdentityRequestVO.getIdentity().get());

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_DELETE;

        Boolean result = (Boolean) jsonRpcUtils.sendJsonRpcRequest(getIdentitiesUrl(), Boolean.class, method, params);
        deleteIdentityResponseVO = ImmutableDeleteIdentityResponseVO.builder()
                .setResult(result)
                .build();
        return deleteIdentityResponseVO;
    }

}
