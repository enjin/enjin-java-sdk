package com.enjin.coin.sdk.service.tokens;

import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenResponseVO;

import java.util.concurrent.CompletableFuture;

/**
 * Asynchronous Tokens service interface.
 */
public interface TokensAsyncService extends TokensService {

    /**
     * Method to get a token.
     *
     * @param request - token request object
     * @return - GetTokenResponseVO
     */
    CompletableFuture<GetTokenResponseVO[]> getTokenAsync(GetTokenRequestVO request);

}
