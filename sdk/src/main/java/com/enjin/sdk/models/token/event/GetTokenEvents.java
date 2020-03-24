package com.enjin.sdk.models.token.event;

import com.enjin.sdk.models.PaginationRequest;

public class GetTokenEvents extends PaginationRequest<GetTokenEvents> implements TokenEventFragment<GetTokenEvents> {

    public GetTokenEvents id(int id) {
        set("id", id);
        return this;
    }

    public GetTokenEvents tokenId(String tokenId) {
        set("tokenId", tokenId);
        return this;
    }

    public GetTokenEvents eventType(TokenEventType event) {
        set("event", event);
        return this;
    }

    public GetTokenEvents blockNumber(int blockNumber) {
        set("blockNumber", blockNumber);
        return this;
    }

}
