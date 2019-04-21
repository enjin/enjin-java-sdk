package com.enjin.enjincoin.sdk.model.service.identities;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

import java.math.BigInteger;

public class GetIdentities extends GraphQLRequest.Builder {

    public GetIdentities withIdentityId(BigInteger identityId) {
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
