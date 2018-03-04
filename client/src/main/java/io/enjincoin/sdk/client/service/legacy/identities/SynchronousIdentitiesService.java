package io.enjincoin.sdk.client.service.legacy.identities;

import io.enjincoin.sdk.client.service.identities.vo.*;
import io.enjincoin.sdk.client.vo.identity.*;

import java.util.Map;

/**
 * Identities service interface.
 */
public interface SynchronousIdentitiesService {

    /**
     * Method to get all identities.
     *
     * @return - GetIdentityResponseVO
     */
    GetIdentityResponseBody[] getIdentitiesSync();

    /**
     * Method to get all identities - supplying a filter also.
     *
     * @param filterMap - the map with the data to use for filtering
     *
     * @return - GetIdentityResponseVO
     */
    GetIdentityResponseBody[] getIdentitiesSync(Map<String, Object> filterMap);

    /**
     * Method to get an entity by identityId
     *
     * @param identityId - identity to get
     *
     * @return
     */
    GetIdentityResponseBody getIdentitySync(Integer identityId);

    /**
     * Method to create an identity.
     *
     * @param request - create identity request vo
     *
     * @return - CreateIdentityResponseVO
     */
    CreateIdentityResponseBody createIdentitySync(CreateIdentityRequestVO request);

    /**
     * Method to update an identity.
     *
     * @param request    - update identity request vo
     * @param identityId - identity to update
     *
     * @return - UpdateIdentityResponseVO
     */
    UpdateIdentityResponseBody updateIdentitySync(UpdateIdentityRequestBody request, Integer identityId);

    /**
     * Method to delete an identity
     *
     * @param identityId - the identity to delete
     *
     * @return Boolean
     */
    Boolean deleteIdentitySync(final Integer identityId);

    /**
     * Method to link an identity.
     *
     * @param linkIdentityRequestVO - link identity request vo
     * @param linkingCode           - code to use
     *
     * @return - LinkIdentityResponseVO
     */
    LinkIdentityResponseBody linkIdentitySync(LinkIdentityRequestBody linkIdentityRequestVO, String linkingCode);
}
