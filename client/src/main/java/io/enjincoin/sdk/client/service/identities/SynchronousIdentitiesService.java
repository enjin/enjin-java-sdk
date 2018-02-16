package io.enjincoin.sdk.client.service.identities;

import io.enjincoin.sdk.client.vo.identity.*;

/**
 * Identities service interface.
 */
public interface SynchronousIdentitiesService {

    /**
     * Method to get an identity.
     *
     * @param request - get identity request vo
     *
     * @return - GetIdentityResponseVO
     */
    GetIdentityResponseVO[] getIdentitiesSync(GetIdentityRequestVO request);

    /**
     * Method to create an identity.
     *
     * @param request - create identity request vo
     *
     * @return - CreateIdentityResponseVO
     */
    CreateIdentityResponseVO createIdentitySync(CreateIdentityRequestVO request);

    /**
     * Method to update an identity.
     *
     * @param request - update identity request vo
     *
     * @return - UpdateIdentityResponseVO
     */
    UpdateIdentityResponseVO updateIdentitySync(UpdateIdentityRequestVO request);

    /**
     * Method to delete an identity.
     *
     * @param request - delete identity request vo
     *
     * @return - DeleteIdentityResponseVO
     */
    DeleteIdentityResponseVO deleteIdentitySync(DeleteIdentityRequestVO request);

}
