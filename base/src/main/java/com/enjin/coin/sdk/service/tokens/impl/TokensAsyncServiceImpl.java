package com.enjin.coin.sdk.service.tokens.impl;

import java.util.concurrent.CompletableFuture;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.tokens.TokensAsyncService;
import com.enjin.coin.sdk.vo.token.GetTokenBalanceRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenBalanceResponseVO;
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

    /**
     * Method to get a token.
     *
     * @param getTokenRequestVO - token request object
     * @return - GetTokenResponseVO
     */
    @Override
    public CompletableFuture<GetTokenResponseVO[]> getTokenAsync(final GetTokenRequestVO getTokenRequestVO) {
        return CompletableFuture.supplyAsync(() -> getToken(getTokenRequestVO), getExecutorService());
    }

    /**
     * Method to get the token balance.
     * @param getTokenBalanceRequestVO - token balance request object
     * @return - GetTokenBalanceResponseVO
     */
    @Override
    public CompletableFuture<GetTokenBalanceResponseVO[]> getTokenBalanceAsync(final GetTokenBalanceRequestVO getTokenBalanceRequestVO) {
        return CompletableFuture.supplyAsync(() -> getTokenBalance(getTokenBalanceRequestVO), getExecutorService());
    }

}
