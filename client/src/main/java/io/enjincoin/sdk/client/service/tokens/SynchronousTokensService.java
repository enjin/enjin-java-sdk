package io.enjincoin.sdk.client.service.tokens;

import io.enjincoin.sdk.client.vo.token.GetTokenBalanceRequestVO;
import io.enjincoin.sdk.client.vo.token.GetTokenBalanceResponseVO;
import io.enjincoin.sdk.client.vo.token.GetTokenRequestVO;
import io.enjincoin.sdk.client.vo.token.GetTokenResponseVO;

/**
 * Tokens service interface.
 */
public interface SynchronousTokensService {

    /**
     * Method to get a token.
     *
     * @param getTokenRequestVO - token request object
     *
     * @return - GetTokenResponseVO
     */
    GetTokenResponseVO[] getTokensSync(GetTokenRequestVO getTokenRequestVO);

    /**
     * Method to get the token balance.
     *
     * @param getTokenBalanceRequestVO - token balance request object
     *
     * @return - GetTokenBalanceResponseVO
     */
    GetTokenBalanceResponseVO[] getTokenBalancesSync(GetTokenBalanceRequestVO getTokenBalanceRequestVO);
}
