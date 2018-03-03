package io.enjincoin.sdk.client.service.tokens;

import io.enjincoin.sdk.client.vo.token.CreateTokenRequestVO;
import io.enjincoin.sdk.client.vo.token.CreateTokenResponseVO;
import io.enjincoin.sdk.client.vo.token.TokenResponseVO;

/**
 * Tokens service interface.
 */
public interface SynchronousTokensService {

    /**
     * Method to get all tokens.
     *
     * @return - TokenResponseVO
     */
    TokenResponseVO[] getTokensSync();

    /**
     * Method to get a token by id
     * @param tokenId for the token to retrieve
     * @return
     */
    TokenResponseVO getTokenSync(Integer tokenId);

    /**
     * Method to create a token
     * @param createTokenRequestVO
     * @return
     */
    CreateTokenResponseVO createTokenSync(CreateTokenRequestVO createTokenRequestVO);
}
