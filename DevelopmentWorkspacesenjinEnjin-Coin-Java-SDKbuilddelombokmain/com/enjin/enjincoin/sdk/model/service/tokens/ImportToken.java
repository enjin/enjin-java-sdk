package com.enjin.enjincoin.sdk.model.service.tokens;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

public class ImportToken extends GraphQLRequest.Builder {

    public ImportToken withTokenId(String tokenId) {
        withParameter("token_id", tokenId);
        return this;
    }

}
