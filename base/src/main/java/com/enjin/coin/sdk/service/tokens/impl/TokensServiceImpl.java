package com.enjin.coin.sdk.service.tokens.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.BaseService;
import com.enjin.coin.sdk.service.tokens.TokensService;
import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.util.MapUtils;
import com.enjin.coin.sdk.util.ObjectUtils;
import com.enjin.coin.sdk.util.StringUtils;
import com.enjin.coin.sdk.vo.token.GetTokenBalanceRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenBalanceResponseVO;
import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenResponseVO;

/**
 * <p>
 * Contains services related to tokens.
 * </p>
 */
public class TokensServiceImpl extends BaseService implements TokensService {

    /**
     * Logger used by this class.
     */
    private static final Logger LOGGER = Logger.getLogger(TokensServiceImpl.class.getName());

    /**
     * Class constructor.
     *
     * @param config - the config to use
     */
    public TokensServiceImpl(final Config config) {
        super(config);
    }

    @Override
    public final GetTokenResponseVO[] getToken(final GetTokenRequestVO getTokenRequestVO) {
        GetTokenResponseVO[] getTokenResponseVO = null;

        if (ObjectUtils.isNull(getTokenRequestVO)) {
            LOGGER.warning("Tokens.get request is null.");
            return getTokenResponseVO;
        }

        Map<String, Object> params = new HashMap<>();
        if (StringUtils.isNotEmpty(getTokenRequestVO.getAppId())) {
            getTokenRequestVO.getAppId().ifPresent(id -> params.put("app_id", id));
        }

        if (StringUtils.isNotEmpty(getTokenRequestVO.getAfterTokenId())) {
            getTokenRequestVO.getAppId().ifPresent(afterId -> params.put("after_token_id", afterId));
        }

        if (StringUtils.isNotEmpty(getTokenRequestVO.getLimit())) {
            getTokenRequestVO.getAppId().ifPresent(limit -> params.put("limit", limit));
        }

        // Construct new request
        String method = Constants.METHOD_TOKENS_GET;

        getTokenResponseVO = (GetTokenResponseVO[]) getJsonRpcUtils().sendJsonRpcRequest(getTokensUrl(), GetTokenResponseVO[].class, method, params);

        return getTokenResponseVO;
    }

    /**
     * Method to get the token balance.
     *
     * @param getTokenBalanceRequestVO - the get token request object
     * @return - GetTokenBalanceResponseVO
     */
    @Override
    public GetTokenBalanceResponseVO[] getTokenBalance(final GetTokenBalanceRequestVO getTokenBalanceRequestVO) {
        GetTokenBalanceResponseVO[] getTokenBalanceResponseVO = null;

        if (ObjectUtils.isNull(getTokenBalanceRequestVO)) {
            LOGGER.warning("Tokens.getBalance request is null.");
            return getTokenBalanceResponseVO;
        }

        if (MapUtils.isEmpty(getTokenBalanceRequestVO.getIdentityMap()) || MapUtils.isEmpty(getTokenBalanceRequestVO.getTokenIdsMap())) {
            LOGGER.warning("Tokens.getBalance parameters may be empty or null.");
            return getTokenBalanceResponseVO;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("identity", getTokenBalanceRequestVO.getIdentityMap().get());
        params.put("token_ids", getTokenBalanceRequestVO.getTokenIdsMap().get());

        // Construct new request
        String method = Constants.METHOD_TOKENS_GET_BALANCE;

        getTokenBalanceResponseVO = (GetTokenBalanceResponseVO[])
                getJsonRpcUtils().sendJsonRpcRequest(getTokensUrl(), GetTokenBalanceResponseVO[].class, method, params);

        return getTokenBalanceResponseVO;
    }
}
