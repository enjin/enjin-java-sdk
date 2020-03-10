package com.enjin.sdk.model.service.identities;

import com.enjin.sdk.model.service.PaginationRequest;
import com.enjin.sdk.service.identities.IdentitiesService;

/**
 * A builder for getting identities from the Trusted platform.
 *
 * @author Evan Lindsay
 * @see IdentitiesService
 */
public class GetIdentities extends PaginationRequest<GetIdentities> {

    /**
     * The identity id.
     *
     * @param identityId the identity id.
     *
     * @return the builder.
     */
    public GetIdentities identityId(Integer identityId) {
        withParameter("id", identityId);
        return this;
    }

    public GetIdentities appId(Integer appId) {
        withParameter("appId", appId);
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
        withParameter("ethAddress", ethAddr);
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
        withParameter("linkingCode", linkingCode);
        return this;
    }

}
