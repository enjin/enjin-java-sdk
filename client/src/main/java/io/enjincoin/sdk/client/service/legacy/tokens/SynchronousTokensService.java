package io.enjincoin.sdk.client.service.legacy.tokens;

import io.enjincoin.sdk.client.service.tokens.vo.Token;
import io.enjincoin.sdk.client.vo.token.CreateTokenRequestVO;
import io.enjincoin.sdk.client.vo.token.CreateTokenResponseVO;
import io.enjincoin.sdk.client.vo.token.UpdateTokenRequestVO;

/**
 * Tokens service interface.
 */
public interface SynchronousTokensService {

    /**
     * Method to get all tokens.
     *
     * @return - TokenResponseVO
     */
    Token[] getTokensSync();

    /**
     * Method to get a token by id
     * @param tokenId for the token to retrieve
     * @return
     */
    Token getTokenSync(Integer tokenId);

    /**
     * Method to create a token
     * @param createTokenRequestVO - the new token details
     * @return
     */
    CreateTokenResponseVO createTokenSync(CreateTokenRequestVO createTokenRequestVO);

    /**
     * Method to update a token
     * @param  updateTokenRequestVO - the updated token details
     * @param tokenId the token to update
     * @return TokenResponseVO
     */
    Token updateTokenSync(UpdateTokenRequestVO updateTokenRequestVO, Integer tokenId);

    /**
     * Method to delete a token
     * @param tokenId the token to delete
     * @return Boolean
     */
    Boolean deleteTokenSync(Integer tokenId);
}
