package com.enjin.sdk.model.service.balances;

import com.enjin.sdk.model.service.PaginationRequest;

import java.util.List;

public class GetBalances extends PaginationRequest<GetBalances> {

    public GetBalances appIds(List<Integer> ids) {
        withParameter("appIds", ids);
        return this;
    }

    public GetBalances ethAddr(String ethAddr) {
        withParameter("ethAddress", ethAddr);
        return this;
    }

    public GetBalances tokenId(String tokenId) {
        withParameter("tokenId", tokenId);
        return this;
    }

    public GetBalances value(Integer value) {
        withParameter("value", value);
        return this;
    }

    public GetBalances valueGreaterThan(Integer value) {
        withParameter("value_gt", value);
        return this;
    }

    public GetBalances valueGreaterThanOrEqual(Integer value) {
        withParameter("value_gte", value);
        return this;
    }

    public GetBalances valueLessThan(Integer value) {
        withParameter("value_lt", value);
        return this;
    }

    public GetBalances valueLessThanOrEqual(Integer value) {
        withParameter("value_lte", value);
        return this;
    }

}
