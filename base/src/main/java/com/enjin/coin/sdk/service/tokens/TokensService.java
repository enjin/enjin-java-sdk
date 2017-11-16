package com.enjin.coin.sdk.service.tokens;

import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenResponseVO;
import com.enjin.coin.sdk.vo.token.ListTokensRequestVO;
import com.enjin.coin.sdk.vo.token.ListTokensResponseVO;

public interface TokensService {

    /**
     * Method to get a token
     *
     * @param getTokenRequestVO - token request object
     * @return - GetTokenResponseVO
     */
    GetTokenResponseVO getToken(GetTokenRequestVO getTokenRequestVO);

    /**
     * Method to list the tokens
     *
     * @param listTokensRequestVO - list tokens request object
     * @return - ListTokensResponseVO
     */
    ListTokensResponseVO listTokens(ListTokensRequestVO listTokensRequestVO);

}
