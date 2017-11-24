package com.enjin.coin.sdk.service.tokens;

import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenResponseVO;

/**
 * Tokens service interface.
 */
public interface TokensService {

    /**
     * Method to get a token.
     *
     * @param request - token request object
     * @return - GetTokenResponseVO
     */
    GetTokenResponseVO getToken(GetTokenRequestVO request);
}
