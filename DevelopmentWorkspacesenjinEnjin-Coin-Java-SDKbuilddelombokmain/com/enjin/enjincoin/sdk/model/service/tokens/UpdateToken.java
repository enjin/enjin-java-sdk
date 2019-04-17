package com.enjin.enjincoin.sdk.model.service.tokens;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

public class UpdateToken extends GraphQLRequest.Builder {

    public UpdateToken withTokenId(String tokenId) {
        withParameter("token_id", tokenId);
        return this;
    }

    public UpdateToken withAppId(int appId) {
        withParameter("app_id", appId);
        return this;
    }

    public UpdateToken withFromBlockchain(boolean fromBlockchain) {
        withParameter("fromBlockchain", fromBlockchain);
        return this;
    }

}
