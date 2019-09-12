package com.enjin.sdk.model.service.tokens;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.service.tokens.TokensService;

/**
 * The result of importing a token from the blockchain.
 *
 * @author Evan Lindsay
 * @see TokensService
 */
public class CreateToken extends GraphQLRequest<CreateToken> {

    /**
     * The token id.
     *
     * @param tokenId the token id.
     *
     * @return the builder.
     */
    public CreateToken tokenId(String tokenId) {
        withParameter("token_id", tokenId);
        return this;
    }

}
