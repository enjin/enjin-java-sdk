package io.enjincoin.sdk.client.service.identities;

import io.enjincoin.sdk.client.vo.identity.CreateIdentityRequestVO;
import io.enjincoin.sdk.client.vo.identity.CreateIdentityResponseVO;
import io.enjincoin.sdk.client.vo.identity.DeleteIdentityRequestVO;
import io.enjincoin.sdk.client.vo.identity.DeleteIdentityResponseVO;
import io.enjincoin.sdk.client.vo.identity.GetIdentityResponseVO;
import io.enjincoin.sdk.client.vo.identity.UpdateIdentityRequestVO;
import io.enjincoin.sdk.client.vo.identity.UpdateIdentityResponseVO;

/**
 * Identities service interface.
 */
public interface SynchronousIdentitiesService {

    /**
     * Method to get all identities.
     *
     *
     * @return - GetIdentityResponseVO
     */
    GetIdentityResponseVO[] getIdentitiesSync();

    /**
     * Method to get an entity by identityId
     * @param identityId
     * @return
     */
    GetIdentityResponseVO getIdentitySync(Integer identityId);

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
