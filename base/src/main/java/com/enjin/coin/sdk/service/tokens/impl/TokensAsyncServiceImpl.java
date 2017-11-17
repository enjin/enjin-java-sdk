package com.enjin.coin.sdk.service.tokens.impl;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.tokens.TokensAsyncService;
import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenResponseVO;
import com.enjin.coin.sdk.vo.token.ListTokensRequestVO;
import com.enjin.coin.sdk.vo.token.ListTokensResponseVO;

import java.util.concurrent.Future;

/**
 * <p>Contains services related to tokens</p>
 */
public class TokensAsyncServiceImpl extends TokensServiceImpl implements TokensAsyncService {

    /**
     * Class constructor
     *
     * @param config - the config to use
     */
    public TokensAsyncServiceImpl(Config config) {
        super(config);
    }

    public Future<GetTokenResponseVO> getTokenAsync(GetTokenRequestVO request) {
        return executorService.submit(() -> getToken(request));
    }

    public Future<ListTokensResponseVO> listTokensAsync(ListTokensRequestVO request) {
        return executorService.submit(() -> listTokens(request));
    }

}
