package com.enjin.sdk.model.service.tokens;

import com.enjin.sdk.model.service.PaginationRequest;

public class GetTokenEvents extends PaginationRequest<GetTokenEvents> {

    public GetTokenEvents id(int id) {
        withParameter("id", id);
        return this;
    }

    public GetTokenEvents tokenId(String tokenId) {
        withParameter("token_id", tokenId);
        return this;
    }

    public GetTokenEvents eventType(TokenEventType event) {
        withParameter("event", event);
        return this;
    }

    public GetTokenEvents param1(String param) {
        withParameter("param1", param);
        return this;
    }

    public GetTokenEvents param2(String param) {
        withParameter("param2", param);
        return this;
    }

    public GetTokenEvents param3(String param) {
        withParameter("param3", param);
        return this;
    }

    public GetTokenEvents param4(String param) {
        withParameter("param4", param);
        return this;
    }

    public GetTokenEvents blockNumber(int blockNumber) {
        withParameter("blockNumber", blockNumber);
        return this;
    }

}
