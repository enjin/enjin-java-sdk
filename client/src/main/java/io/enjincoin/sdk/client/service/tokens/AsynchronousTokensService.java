package io.enjincoin.sdk.client.service.tokens;

import java.util.concurrent.CompletableFuture;

import io.enjincoin.sdk.client.vo.token.CreateTokenRequestVO;
import io.enjincoin.sdk.client.vo.token.CreateTokenResponseVO;
import io.enjincoin.sdk.client.vo.token.TokenResponseVO;

/**
 * Asynchronous Tokens service interface.
 */
public interface AsynchronousTokensService {

    /**
     * Method to get all tokens.
     *
     *
     * @return - TokenResponseVO
     */
    CompletableFuture<TokenResponseVO[]> getTokensAsync();

    /**
     * Method to get a token by id
     * @param tokenId for the token to retrieve
     * @return
     */
    CompletableFuture<TokenResponseVO> getTokenAsync(Integer tokenId);

    /**
     * Method to create a token
     * @param createTokenRequestVO
     * @return
     */
    CompletableFuture<CreateTokenResponseVO> createTokenAsync(CreateTokenRequestVO createTokenRequestVO);
}
