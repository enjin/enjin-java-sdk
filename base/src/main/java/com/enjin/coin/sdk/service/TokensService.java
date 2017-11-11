package com.enjin.coin.sdk.service;

import com.enjin.coin.sdk.config.EnjinConfig;
import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.util.ValidationUtils;
import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenResponseVO;
import com.enjin.coin.sdk.vo.token.ListTokensRequestVO;
import com.enjin.coin.sdk.vo.token.ListTokensResponseVO;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class TokensService extends BaseService {

    private static final Logger LOGGER = Logger.getLogger(TokensService.class.getName());

    /**
     * Class constructor
     *
     * @param enjinConfig
     */
    public TokensService(EnjinConfig enjinConfig) {
        super(enjinConfig);
    }

    /**
     * Method to get a token
     *
     * @param getTokenRequestVO
     * @return
     */
    public GetTokenResponseVO getToken(GetTokenRequestVO getTokenRequestVO) {
        GetTokenResponseVO getTokenResponseVO = null;

        if (getTokenRequestVO == null || ValidationUtils.isEmpty(getTokenRequestVO.getTokenId())) {
            LOGGER.warning("getTokenRequestVO is null or tokenId passed in are null or empty");
            return getTokenResponseVO;
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("token_id", getTokenRequestVO.getTokenId());

        // Construct new request
        String method = Constants.METHOD_TOKENS_GET;

        getTokenResponseVO = (GetTokenResponseVO) jsonRpcUtils.sendJsonRpcRequest(getTokensUrl(), GetTokenResponseVO.class, method, params);

        return getTokenResponseVO;
    }

    /**
     * Method to list the tokens
     *
     * @param listTokensRequestVO
     * @return
     */
    public ListTokensResponseVO listTokens(ListTokensRequestVO listTokensRequestVO) {
        ListTokensResponseVO listTokensResponseVO = null;

        if (listTokensRequestVO == null || ValidationUtils.isEmpty(listTokensRequestVO.getAppId()) || ValidationUtils.isEmpty(listTokensRequestVO.getAfterTokenId()) || ValidationUtils.isEmpty(listTokensRequestVO.getLimit())) {
            LOGGER.warning("listTokensRequestVO is null, appId, afterTokenId or limit passed in are null or empty");
            return listTokensResponseVO;
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("app_id", listTokensRequestVO.getAppId());
        params.put("after_token_id", listTokensRequestVO.getAfterTokenId());
        params.put("limit", listTokensRequestVO.getLimit());

        // Construct new request
        String method = Constants.METHOD_TOKENS_LIST;

        GetTokenResponseVO[] getTokenResponseVOArray = (GetTokenResponseVO[]) jsonRpcUtils.sendJsonRpcRequest(getTokensUrl(), GetTokenResponseVO[].class, method, params);
        if (ValidationUtils.isEmpty(getTokenResponseVOArray)) {
            LOGGER.warning("No tokens returned");
            return listTokensResponseVO;
        }
        listTokensResponseVO = new ListTokensResponseVO();
        listTokensResponseVO.setGetTokensResponseVOArray(getTokenResponseVOArray);

        return listTokensResponseVO;
    }
}
