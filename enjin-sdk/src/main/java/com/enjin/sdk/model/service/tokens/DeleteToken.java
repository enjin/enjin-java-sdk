package com.enjin.sdk.model.service.tokens;

import com.enjin.sdk.graphql.GraphQLRequest;

public class DeleteToken extends GraphQLRequest<DeleteToken> {

    public DeleteToken tokenId(String tokenId) {
        withParameter("token_id", tokenId);
        return this;
    }

}
