package io.enjincoin.sdk.client.service.tokens;

import io.enjincoin.sdk.client.vo.token.GetTokenBalanceRequestVO;
import io.enjincoin.sdk.client.vo.token.GetTokenBalanceResponseVO;
import io.enjincoin.sdk.client.vo.token.GetTokenRequestVO;
import io.enjincoin.sdk.client.vo.token.GetTokenResponseVO;

import java.util.concurrent.CompletableFuture;

/**
 * Asynchronous Tokens service interface.
 */
public interface AsynchronousTokensService {

    /**
     * Method to get a token.
     *
     * @param getTokenRequestVO - token request object
     *
     * @return - GetTokenResponseVO
     */
    CompletableFuture<GetTokenResponseVO[]> getTokensAsync(GetTokenRequestVO getTokenRequestVO);

    /**
     * Method to get the token balance.
     *
     * @param getTokenBalanceRequestVO - token balance request object
     *
     * @return - GetTokenBalanceResponseVO
     */
    CompletableFuture<GetTokenBalanceResponseVO[]> getTokenBalancesAsync(GetTokenBalanceRequestVO getTokenBalanceRequestVO);
}
