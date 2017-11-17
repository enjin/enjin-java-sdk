package com.enjin.coin.sdk.service.tokens.impl;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.BaseService;
import com.enjin.coin.sdk.service.tokens.TokensService;
import com.enjin.coin.sdk.util.ArrayUtils;
import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.util.ObjectUtils;
import com.enjin.coin.sdk.util.StringUtils;
import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenResponseVO;
import com.enjin.coin.sdk.vo.token.ImmutableListTokensResponseVO;
import com.enjin.coin.sdk.vo.token.ListTokensRequestVO;
import com.enjin.coin.sdk.vo.token.ListTokensResponseVO;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * <p>Contains services related to tokens</p>
 */
public class TokensServiceImpl extends BaseService implements TokensService {

    private static final Logger LOGGER = Logger.getLogger(TokensServiceImpl.class.getName());

    /**
     * Class constructor
     *
     * @param config - the config to use
     */
    public TokensServiceImpl(Config config) {
        super(config);
    }

    public GetTokenResponseVO getToken(GetTokenRequestVO request) {
        GetTokenResponseVO getTokenResponseVO = null;

        if (ObjectUtils.isNull(request) || StringUtils.isEmpty(request.getTokenId())) {
            LOGGER.warning("getTokenRequestVO is null or tokenId passed in are null or empty");
            return getTokenResponseVO;
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("token_id", request.getTokenId().get());

        // Construct new request
        String method = Constants.METHOD_TOKENS_GET;

        getTokenResponseVO = (GetTokenResponseVO) jsonRpcUtils.sendJsonRpcRequest(getTokensUrl(), GetTokenResponseVO.class, method, params);

        return getTokenResponseVO;
    }

    public ListTokensResponseVO listTokens(ListTokensRequestVO request) {
        ListTokensResponseVO listTokensResponseVO = null;

        if (ObjectUtils.isNull(request) || StringUtils.isEmpty(request.getAppId())
                || StringUtils.isEmpty(request.getAfterTokenId())
                || StringUtils.isEmpty(request.getLimit())) {
            LOGGER.warning("listTokensRequestVO is null, appId, afterTokenId or limit passed in are null or empty");
            return listTokensResponseVO;
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("app_id", request.getAppId().get());
        params.put("after_token_id", request.getAfterTokenId().get());
        params.put("limit", request.getLimit().get());

        // Construct new request
        String method = Constants.METHOD_TOKENS_LIST;

        GetTokenResponseVO[] getTokenResponseVOArray = (GetTokenResponseVO[]) jsonRpcUtils.sendJsonRpcRequest(getTokensUrl(), GetTokenResponseVO[].class, method, params);
        if (ArrayUtils.isEmpty(getTokenResponseVOArray)) {
            LOGGER.warning("No tokens returned");
            return listTokensResponseVO;
        }
        listTokensResponseVO = ImmutableListTokensResponseVO.builder()
                .setGetTokensResponseVOArray(getTokenResponseVOArray)
                .build();

        return listTokensResponseVO;
    }
}
