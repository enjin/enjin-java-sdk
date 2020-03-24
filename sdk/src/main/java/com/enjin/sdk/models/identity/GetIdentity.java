package com.enjin.sdk.models.identity;

import com.enjin.sdk.models.PaginationRequest;
import com.enjin.sdk.services.identity.IdentitiesService;

/**
 * A builder for getting identities from the Trusted platform.
 *
 * @author Evan Lindsay
 * @see IdentitiesService
 */
public class GetIdentity extends PaginationRequest<GetIdentity> implements IdentityFragment<GetIdentity> {

    /**
     * The identity id.
     *
     * @param identityId the identity id.
     *
     * @return the builder.
     */
    public GetIdentity id(Integer identityId) {
        set("id", identityId);
        return this;
    }

}
