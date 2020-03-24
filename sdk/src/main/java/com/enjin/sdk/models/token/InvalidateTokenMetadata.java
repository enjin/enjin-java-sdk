package com.enjin.sdk.models.token;

import com.enjin.sdk.graphql.GraphQLRequest;

public class InvalidateTokenMetadata extends GraphQLRequest<InvalidateTokenMetadata> {

    public InvalidateTokenMetadata tokenId(String id) {
        set("id", id);
        return this;
    }

}
