package com.enjin.enjincoin.sdk.model.service.balances;

import com.enjin.enjincoin.sdk.model.service.PaginationRequest;

public class GetBalances extends PaginationRequest<GetBalances> {

    public GetBalances withEthereumAddress(String ethAddr) {
        withParameter("ethereum_address", ethAddr);
        return this;
    }

    public GetBalances withTokenId(String tokenId) {
        withParameter("token_id", tokenId);
        return this;
    }

    public GetBalances withShowZeroBalance(boolean showZeroBalance) {
        withParameter("show_zero_balance", showZeroBalance);
        return this;
    }

}
