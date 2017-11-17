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
 * <p>Contains services related to tokens.</p>
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
    public final GetTokenResponseVO getToken(final GetTokenRequestVO request) {
        GetTokenResponseVO response = null;

        if (ObjectUtils.isNull(request)) {
            LOGGER.warning("Tokens.get request is null.");
            return response;
        }

        if (StringUtils.isEmpty(request.getTokenId())) {
            LOGGER.warning("Tokens.get parameters may be empty or null.");
            return response;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("token_id", request.getTokenId().get());

        // Construct new request
        String method = Constants.METHOD_TOKENS_GET;

        response = (GetTokenResponseVO) getJsonRpcUtils()
                .sendJsonRpcRequest(getTokensUrl(), GetTokenResponseVO.class, method, params);

        return response;
    }

    @Override
    public final ListTokensResponseVO listTokens(final ListTokensRequestVO request) {
        ListTokensResponseVO response = null;

        if (ObjectUtils.isNull(request)) {
            LOGGER.warning("Tokens.list request is null.");
            return response;
        }

        if (StringUtils.isEmpty(request.getAppId()) || StringUtils.isEmpty(request.getAfterTokenId())
                || StringUtils.isEmpty(request.getLimit())) {
            LOGGER.warning("Tokens.list parameters may be empty or null.");
            return response;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("app_id", request.getAppId().get());
        params.put("after_token_id", request.getAfterTokenId().get());
        params.put("limit", request.getLimit().get());

        // Construct new request
        String method = Constants.METHOD_TOKENS_LIST;

        GetTokenResponseVO[] array = (GetTokenResponseVO[]) getJsonRpcUtils()
                .sendJsonRpcRequest(getTokensUrl(), GetTokenResponseVO[].class, method, params);

        if (ArrayUtils.isEmpty(array)) {
            LOGGER.warning("No tokens were retrieved.");
            return response;
        }

        response = ImmutableListTokensResponseVO.builder()
                .setGetTokensResponseVOArray(array)
                .build();

        return response;
    }
}
