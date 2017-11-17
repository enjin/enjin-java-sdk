package com.enjin.coin.sdk.service.tokens;

import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenResponseVO;
import com.enjin.coin.sdk.vo.token.ListTokensRequestVO;
import com.enjin.coin.sdk.vo.token.ListTokensResponseVO;

public interface TokensService {

    /**
     * Method to get a token
     *
     * @param request - token request object
     * @return - GetTokenResponseVO
     */
    GetTokenResponseVO getToken(GetTokenRequestVO request);

    /**
     * Method to list the tokens
     *
     * @param request - list tokens request object
     * @return - ListTokensResponseVO
     */
    ListTokensResponseVO listTokens(ListTokensRequestVO request);

}
