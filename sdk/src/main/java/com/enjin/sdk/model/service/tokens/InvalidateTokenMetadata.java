package com.enjin.sdk.model.service.tokens;

import com.enjin.sdk.graphql.GraphQLRequest;

public class InvalidateTokenMetadata extends GraphQLRequest<InvalidateTokenMetadata> {

    public InvalidateTokenMetadata tokenId(String id) {
        withVariable("id", id);
        return this;
    }

}
