package com.enjin.enjincoin.sdk.model.service.tokens;

import com.enjin.enjincoin.sdk.model.service.PaginationRequest;

public class GetTokenEvents extends PaginationRequest<GetTokenEvents> {

    public GetTokenEvents withId(int id) {
        withParameter("id", id);
        return this;
    }

    public GetTokenEvents withTokenId(String tokenId) {
        withParameter("token_id", tokenId);
        return this;
    }

    public GetTokenEvents withEvent(TokenEventType event) {
        withParameter("event", event);
        return this;
    }

    public GetTokenEvents withParam1(String param) {
        withParameter("param1", param);
        return this;
    }

    public GetTokenEvents withParam2(String param) {
        withParameter("param2", param);
        return this;
    }

    public GetTokenEvents withParam3(String param) {
        withParameter("param3", param);
        return this;
    }

    public GetTokenEvents withParam4(String param) {
        withParameter("param4", param);
        return this;
    }

    public GetTokenEvents withBlockNumber(int blockNumber) {
        withParameter("blockNumber", blockNumber);
        return this;
    }

}
