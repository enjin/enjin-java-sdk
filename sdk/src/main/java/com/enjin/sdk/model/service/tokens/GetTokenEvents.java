package com.enjin.sdk.model.service.tokens;

import com.enjin.sdk.model.service.PaginationRequest;

public class GetTokenEvents extends PaginationRequest<GetTokenEvents> {

    public GetTokenEvents id(int id) {
        withVariable("id", id);
        return this;
    }

    public GetTokenEvents tokenId(String tokenId) {
        withVariable("tokenId", tokenId);
        return this;
    }

    public GetTokenEvents eventType(TokenEventType event) {
        withVariable("event", event);
        return this;
    }

    public GetTokenEvents blockNumber(int blockNumber) {
        withVariable("blockNumber", blockNumber);
        return this;
    }

}
