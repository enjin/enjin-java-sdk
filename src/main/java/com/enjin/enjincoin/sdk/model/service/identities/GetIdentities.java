package com.enjin.enjincoin.sdk.model.service.identities;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

import java.math.BigInteger;

/**
 * A builder for getting identities from the Trusted platform.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.identities.IdentitiesService
 */
public class GetIdentities extends GraphQLRequest<GetIdentities> {

    /**
     * The identity id.
     *
     * @param identityId the identity id.
     *
     * @return the builder.
     */
    public GetIdentities withIdentityId(BigInteger identityId) {
        withParameter("id", identityId);
        return this;
    }

    /**
     * The ethereum address linked to the identity.
     *
     * @param ethAddr the ethereum address.
     *
     * @return the builder.
     */
    public GetIdentities withEthereumAddress(String ethAddr) {
        withParameter("ethereum_address", ethAddr);
        return this;
    }

    /**
     * The linking code associated with the unlinked identity.
     *
     * @param linkingCode the linking code.
     *
     * @return the builder.
     */
    public GetIdentities withLinkingCode(String linkingCode) {
        withParameter("linking_code", linkingCode);
        return this;
    }

}
