package com.enjin.sdk.model.service.balances;

import com.enjin.sdk.model.service.PaginationRequest;

import java.util.List;

public class GetBalances extends PaginationRequest<GetBalances> {

    public GetBalances appIds(List<Integer> ids) {
        withVariable("appIds", ids);
        return this;
    }

    public GetBalances ethAddr(String ethAddr) {
        withVariable("ethAddress", ethAddr);
        return this;
    }

    public GetBalances tokenId(String tokenId) {
        withVariable("tokenId", tokenId);
        return this;
    }

    public GetBalances value(Integer value) {
        withVariable("value", value);
        return this;
    }

    public GetBalances valueGreaterThan(Integer value) {
        withVariable("value_gt", value);
        return this;
    }

    public GetBalances valueGreaterThanOrEqual(Integer value) {
        withVariable("value_gte", value);
        return this;
    }

    public GetBalances valueLessThan(Integer value) {
        withVariable("value_lt", value);
        return this;
    }

    public GetBalances valueLessThanOrEqual(Integer value) {
        withVariable("value_lte", value);
        return this;
    }

}
