package io.enjincoin.sdk.client.service.tokens.impl;

import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.tokens.TokensAsyncService;
import io.enjincoin.sdk.client.vo.token.GetTokenBalanceRequestVO;
import io.enjincoin.sdk.client.vo.token.GetTokenBalanceResponseVO;
import io.enjincoin.sdk.client.vo.token.GetTokenRequestVO;
import io.enjincoin.sdk.client.vo.token.GetTokenResponseVO;

import java.util.concurrent.CompletableFuture;

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
