package com.enjin.sdk.model.service.identities;

import com.enjin.sdk.model.service.PaginationRequest;
import com.enjin.sdk.service.identities.IdentitiesService;

/**
 * A builder for getting identities from the Trusted platform.
 *
 * @author Evan Lindsay
 * @see IdentitiesService
 */
public class GetIdentity extends PaginationRequest<GetIdentity> {

    /**
     * The identity id.
     *
     * @param identityId the identity id.
     *
     * @return the builder.
     */
    public GetIdentity id(Integer identityId) {
        withParameter("id", identityId);
        return this;
    }

}
