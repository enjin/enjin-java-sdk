package com.enjin.coin.sdk.service.tokens;

import java.util.concurrent.CompletableFuture;

import com.enjin.coin.sdk.vo.token.GetTokenBalanceRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenBalanceResponseVO;
import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenResponseVO;

/**
 * Asynchronous Tokens service interface.
 */
public interface TokensAsyncService extends TokensService {

    /**
     * Method to get a token.
     *
     * @param getTokenRequestVO - token request object
     * @return - GetTokenResponseVO
     */
    CompletableFuture<GetTokenResponseVO[]> getTokenAsync(GetTokenRequestVO getTokenRequestVO);

    /**
     * Method to get the token balance.
     * @param getTokenBalanceRequestVO - token balance request object
     * @return - GetTokenBalanceResponseVO
     */
    CompletableFuture<GetTokenBalanceResponseVO[]> getTokenBalanceAsync(GetTokenBalanceRequestVO getTokenBalanceRequestVO);
}
