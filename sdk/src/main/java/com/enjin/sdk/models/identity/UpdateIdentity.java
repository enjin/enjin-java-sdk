package com.enjin.sdk.models.identity;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.services.identity.IdentitiesService;

/**
 * An object class for updating an identity on the Trusted Platform.
 *
 * @author Evan Lindsay
 * @see IdentitiesService
 */
public class UpdateIdentity extends GraphQLRequest<UpdateIdentity> implements IdentityFragment<UpdateIdentity> {

    /**
     * The identity id.
     *
     * @param identityId the identity id.
     *
     * @return this request.
     */
    public UpdateIdentity identityId(int identityId) {
        set("id", identityId);
        return this;
    }

    /**
     * The linking code for the identity.
     *
     * @param linkingCode the linking code.
     *
     * @return this request.
     */
    public UpdateIdentity linkingCode(String linkingCode) {
        set("linkingCode", linkingCode);
        return this;
    }

    /**
     * The Ethereum address linked to the identity.
     *
     * @param ethAddr the Ethereum address.
     *
     * @return this request.
     */
    public UpdateIdentity ethAddr(String ethAddr) {
        set("ethAddress", ethAddr);
        return this;
    }

}
