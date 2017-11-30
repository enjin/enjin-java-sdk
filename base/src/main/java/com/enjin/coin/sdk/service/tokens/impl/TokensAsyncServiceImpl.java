package com.enjin.coin.sdk.service.tokens.impl;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.tokens.TokensAsyncService;
import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenResponseVO;

/**
 * <p>
 * Contains services related to tokens.
 * </p>
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
    public CompletableFuture<GetTokenResponseVO[]> getTokenAsync(final GetTokenRequestVO request) {
        return CompletableFuture.supplyAsync(() -> getToken(request), getExecutorService());
    }

}
