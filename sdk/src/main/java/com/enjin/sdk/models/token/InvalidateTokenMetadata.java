package com.enjin.sdk.models.token;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.services.token.TokensService;

/**
 * An object class for invalidating a token's cached metadata on the Trusted Platform.
 *
 * @see TokensService
 */
public class InvalidateTokenMetadata extends GraphQLRequest<InvalidateTokenMetadata> {

    /**
     * The token id.
     *
     * @param id the token id
     * @return   this request
     */
    public InvalidateTokenMetadata tokenId(String id) {
        set("id", id);
        return this;
    }

}
