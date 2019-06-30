package com.enjin.enjincoin.sdk.model.service.tokens;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

public class DeleteToken extends GraphQLRequest<DeleteToken> {

    public DeleteToken withTokenId(String tokenId) {
        withParameter("token_id", tokenId);
        return this;
    }

}
