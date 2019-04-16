package com.enjin.enjincoin.sdk.model.query;

import com.enjin.enjincoin.sdk.model.request.GraphQLRequest;

public class ImportToken extends GraphQLRequest.Builder {

    public ImportToken withTokenId(String tokenId) {
        withParameter("token_id", tokenId);
        return this;
    }

}
