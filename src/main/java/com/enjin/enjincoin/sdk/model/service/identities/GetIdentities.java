package com.enjin.enjincoin.sdk.model.service.identities;

import com.enjin.enjincoin.sdk.model.service.PaginationRequest;

import java.math.BigInteger;

/**
 * A builder for getting identities from the Trusted platform.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.identities.IdentitiesService
 */
public class GetIdentities extends PaginationRequest<GetIdentities> {

    /**
     * The identity id.
     *
     * @param identityId the identity id.
     *
     * @return the builder.
     */
    public GetIdentities identityId(BigInteger identityId) {
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
    public GetIdentities ethAddr(String ethAddr) {
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
    public GetIdentities linkingCode(String linkingCode) {
        withParameter("linking_code", linkingCode);
        return this;
    }

}
