package com.enjin.enjincoin.sdk.model.service.tokens;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

/**
 * The result of importing a token from the blockchain.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.tokens.TokensService
 */
public class ImportToken extends GraphQLRequest.Builder {

    /**
     * The token id.
     *
     * @param tokenId the token id.
     * @return the builder.
     */
    public ImportToken withTokenId(String tokenId) {
        withParameter("token_id", tokenId);
        return this;
    }

}
