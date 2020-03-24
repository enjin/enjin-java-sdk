package com.enjin.sdk.models.identity;

import com.enjin.sdk.models.PaginationRequest;
import com.enjin.sdk.services.identity.IdentitiesService;

/**
 * A builder for getting identities from the Trusted platform.
 *
 * @author Evan Lindsay
 * @see IdentitiesService
 */
public class GetIdentities extends PaginationRequest<GetIdentities> implements IdentityFragment<GetIdentities> {

    /**
     * The identity id.
     *
     * @param identityId the identity id.
     *
     * @return the builder.
     */
    public GetIdentities identityId(Integer identityId) {
        set("id", identityId);
        return this;
    }

    public GetIdentities appId(Integer appId) {
        set("appId", appId);
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
        set("ethAddress", ethAddr);
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
        set("linkingCode", linkingCode);
        return this;
    }

}
