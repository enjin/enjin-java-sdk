package com.enjin.coin.sdk.service;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.enjin.coin.sdk.config.EnjinConfig;
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

public class IdentitiesService extends BaseService {

    private static final Logger LOGGER = Logger.getLogger(IdentitiesService.class.getName());

    /**
     * Class constructor
     *
     * @param enjinConfig
     */
    protected IdentitiesService(EnjinConfig enjinConfig) {
        super(enjinConfig);
    }

    /**
     * Method to get an identity
     *
     * @param getIdentityRequestVO
     * @return
     */
    public GetIdentityResponseVO getIdentity(GetIdentityRequestVO getIdentityRequestVO) {
        GetIdentityResponseVO getIdentityResponseVO = null;

        if (getIdentityRequestVO == null || StringUtils.isEmpty(getIdentityRequestVO.getAuth())
                || MapUtils.isEmpty(getIdentityRequestVO.getIdentity())) {
            LOGGER.warning("getIdentityRequestVO is null, auth or identidyId passed in are null or empty");
            return getIdentityResponseVO;
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("auth", getIdentityRequestVO.getAuth());
        params.put("identity", getIdentityRequestVO.getIdentity());

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_GET;

        getIdentityResponseVO = (GetIdentityResponseVO) jsonRpcUtils.sendJsonRpcRequest(getIdentitiesUrl(), GetIdentityResponseVO.class, method, params);

        return getIdentityResponseVO;
    }

    /**
     * Method to list the identities
     *
     * @param listIdentitiesRequestVO
     * @return
     */
    public ListIdentitiesResponseVO[] listIdentities(ListIdentitiesRequestVO listIdentitiesRequestVO) {
        ListIdentitiesResponseVO[] listIdentitiesResponseVO = null;

        if (listIdentitiesRequestVO == null || StringUtils.isEmpty(listIdentitiesRequestVO.getAuth())
                || MapUtils.isEmpty(listIdentitiesRequestVO.getIdentity())) {
            LOGGER.warning("listIdentitiesRequestVO is null, auth or identity passed in are null or empty");
            return listIdentitiesResponseVO;
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("auth", listIdentitiesRequestVO.getAuth());
        params.put("identity", listIdentitiesRequestVO.getIdentity());
        params.put("linked", listIdentitiesRequestVO.getLinked());
        params.put("after_identity_id", listIdentitiesRequestVO.getAfterIdentityId());
        params.put("limit", listIdentitiesRequestVO.getLimit());

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_LIST;

        listIdentitiesResponseVO = (ListIdentitiesResponseVO[]) jsonRpcUtils.sendJsonRpcRequest(getIdentitiesUrl(), ListIdentitiesResponseVO[].class, method, params);
        return listIdentitiesResponseVO;
    }

    /**
     * Method to create an identity
     *
     * @param createIdentityRequestVO
     * @return
     */
    public CreateIdentityResponseVO createIdentity(CreateIdentityRequestVO createIdentityRequestVO) {
        CreateIdentityResponseVO createIdentityResponseVO = null;

        if (createIdentityRequestVO == null || StringUtils.isEmpty(createIdentityRequestVO.getAuth())
                || MapUtils.isEmpty(createIdentityRequestVO.getIdentity())) {
            LOGGER.warning("createIdentityRequestVO is null, auth or identity passed in are null or empty");
            return createIdentityResponseVO;
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("auth", createIdentityRequestVO.getAuth());
        params.put("identity", createIdentityRequestVO.getIdentity());

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_CREATE;

        createIdentityResponseVO = (CreateIdentityResponseVO) jsonRpcUtils.sendJsonRpcRequest(getIdentitiesUrl(), CreateIdentityResponseVO.class, method, params);

        return createIdentityResponseVO;
    }

    /**
     * Method to update an identity
     *
     * @param updateIdentityRequestVO
     * @return
     */
    public UpdateIdentityResponseVO updateIdentity(UpdateIdentityRequestVO updateIdentityRequestVO) {
        UpdateIdentityResponseVO updateIdentityResponseVO = null;

        if (updateIdentityRequestVO == null || StringUtils.isEmpty(updateIdentityRequestVO.getAuth())
                || MapUtils.isEmpty(updateIdentityRequestVO.getIdentity())
                || MapUtils.isEmpty(updateIdentityRequestVO.getUpdate())) {
            LOGGER.warning("updateIdentityRequestVO is null or auth, identidy or update passed in are null or empty");
            return updateIdentityResponseVO;
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("auth", updateIdentityRequestVO.getAuth());
        params.put("identity", updateIdentityRequestVO.getIdentity());
        params.put("update", updateIdentityRequestVO.getUpdate());

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_UPDATE;

        updateIdentityResponseVO = (UpdateIdentityResponseVO) jsonRpcUtils.sendJsonRpcRequest(getIdentitiesUrl(), UpdateIdentityResponseVO.class, method, params);

        return updateIdentityResponseVO;
    }

    /**
     * Method to delete an identity
     *
     * @param deleteIdentityRequestVO
     * @return
     */
    public DeleteIdentityResponseVO deleteIdentity(DeleteIdentityRequestVO deleteIdentityRequestVO) {
        DeleteIdentityResponseVO deleteIdentityResponseVO = null;

        if (deleteIdentityRequestVO == null || StringUtils.isEmpty(deleteIdentityRequestVO.getAuth())
                || MapUtils.isEmpty(deleteIdentityRequestVO.getIdentity())) {
            LOGGER.warning("deleteIdentityRequestVO is null, auth or identity passed in are null or empty");
            return deleteIdentityResponseVO;
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("auth", deleteIdentityRequestVO.getAuth());
        params.put("identity", deleteIdentityRequestVO.getIdentity());

        // Construct new request
        String method = Constants.METHOD_IDENTITIES_DELETE;

        Boolean result = (Boolean) jsonRpcUtils.sendJsonRpcRequest(getIdentitiesUrl(), Boolean.class, method, params);
        deleteIdentityResponseVO = ImmutableDeleteIdentityResponseVO.builder()
                .setResult(result)
                .build();
        return deleteIdentityResponseVO;
    }

}
