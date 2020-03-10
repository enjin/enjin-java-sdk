package com.enjin.sdk.model.service.tokens;

import com.enjin.sdk.model.service.PaginationRequest;

public class GetTokenEvents extends PaginationRequest<GetTokenEvents> {

    public GetTokenEvents id(int id) {
        withParameter("id", id);
        return this;
    }

    public GetTokenEvents tokenId(String tokenId) {
        withParameter("tokenId", tokenId);
        return this;
    }

    public GetTokenEvents eventType(TokenEventType event) {
        withParameter("event", event);
        return this;
    }

    public GetTokenEvents blockNumber(int blockNumber) {
        withParameter("blockNumber", blockNumber);
        return this;
    }

}
