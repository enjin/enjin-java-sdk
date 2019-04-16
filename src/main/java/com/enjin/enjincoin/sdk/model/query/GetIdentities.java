package com.enjin.enjincoin.sdk.model.query;

import com.enjin.enjincoin.sdk.model.request.GraphQLRequest;

public class GetIdentities extends GraphQLRequest.Builder {

    public GetIdentities withIdentityId(int identityId) {
        withParameter("id", identityId);
        return this;
    }

    public GetIdentities withEthereumAddress(String ethereumAddress) {
        withParameter("ethereum_address", ethereumAddress);
        return this;
    }

    public GetIdentities withLinkingCode(String linkingCode) {
        withParameter("linking_code", linkingCode);
        return this;
    }

}
