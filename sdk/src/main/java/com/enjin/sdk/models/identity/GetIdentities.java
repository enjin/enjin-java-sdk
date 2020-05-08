package com.enjin.sdk.models.identity;

import com.enjin.sdk.models.PaginationRequest;
import com.enjin.sdk.services.identity.IdentitiesService;

/**
 * An object class for getting identities from the Trusted Platform.
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
     * @return this request.
     */
    public GetIdentities identityId(Integer identityId) {
        set("id", identityId);
        return this;
    }

    /**
     * The id of the application.
     *
     * @param appId the app id.
     *
     * @return this request.
     */
    public GetIdentities appId(Integer appId) {
        set("appId", appId);
        return this;
    }

    /**
     * The Ethereum address linked to the identity.
     *
     * @param ethAddr the Ethereum address.
     *
     * @return this request.
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
     * @return this request.
     */
    public GetIdentities linkingCode(String linkingCode) {
        set("linkingCode", linkingCode);
        return this;
    }

}
