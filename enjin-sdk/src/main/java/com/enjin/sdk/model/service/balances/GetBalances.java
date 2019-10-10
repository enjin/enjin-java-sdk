package com.enjin.sdk.model.service.balances;

import com.enjin.sdk.model.service.PaginationRequest;

public class GetBalances extends PaginationRequest<GetBalances> {

    public GetBalances ethAddr(String ethAddr) {
        withParameter("ethereum_address", ethAddr);
        return this;
    }

    public GetBalances tokenId(String tokenId) {
        withParameter("token_id", tokenId);
        return this;
    }

    public GetBalances excludeZeroBalance() {
        withParameter("show_zero_balance", false);
        return this;
    }

}
