package com.enjin.coin.sdk.service.tokens;

import java.util.concurrent.Future;

import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenResponseVO;

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
    Future<GetTokenResponseVO> getTokenAsync(GetTokenRequestVO request);

}
