package com.enjin.coin.sdk.service.tokens.impl;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.tokens.TokensAsyncService;
import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenResponseVO;
import com.enjin.coin.sdk.vo.token.ListTokensRequestVO;
import com.enjin.coin.sdk.vo.token.ListTokensResponseVO;

import java.util.concurrent.Future;

/**
 * <p>Contains services related to tokens.</p>
 */
public final class TokensAsyncServiceImpl extends TokensServiceImpl implements TokensAsyncService {

    /**
     * Class constructor.
     *
     * @param config - the config to use
     */
    public TokensAsyncServiceImpl(final Config config) {
        super(config);
    }

    @Override
    public Future<GetTokenResponseVO> getTokenAsync(final GetTokenRequestVO request) {
        return getExecutorService().submit(() -> getToken(request));
    }

    @Override
    public Future<ListTokensResponseVO> listTokensAsync(final ListTokensRequestVO request) {
        return getExecutorService().submit(() -> listTokens(request));
    }

}
