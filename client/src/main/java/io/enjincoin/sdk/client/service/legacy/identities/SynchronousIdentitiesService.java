package io.enjincoin.sdk.client.service.legacy.identities;

import java.util.Map;

import io.enjincoin.sdk.client.vo.identity.CreateIdentityRequestVO;
import io.enjincoin.sdk.client.vo.identity.CreateIdentityResponseVO;
import io.enjincoin.sdk.client.vo.identity.GetIdentityResponseVO;
import io.enjincoin.sdk.client.vo.identity.LinkIdentityRequestVO;
import io.enjincoin.sdk.client.vo.identity.LinkIdentityResponseVO;
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
     * Method to get all identities - supplying a filter also.
     * @param filterMap - the map with the data to use for filtering
     *
     * @return - GetIdentityResponseVO
     */
    GetIdentityResponseVO[] getIdentitiesSync(Map<String, Object> filterMap);

    /**
     * Method to get an entity by identityId
     * @param identityId - identity to get
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
     * @param identityId - identity to update
     * @return - UpdateIdentityResponseVO
     */
    UpdateIdentityResponseVO updateIdentitySync(UpdateIdentityRequestVO request, Integer identityId);

    /**
     * Method to delete an identity
     * @param identityId - the identity to delete
     * @return Boolean
     */
    Boolean deleteIdentitySync(final Integer identityId);

    /**
     * Method to link an identity.
     *
     * @param linkIdentityRequestVO - link identity request vo
     * @param linkingCode - code to use
     * @return - LinkIdentityResponseVO
     */
    LinkIdentityResponseVO linkIdentitySync(LinkIdentityRequestVO linkIdentityRequestVO, String linkingCode);
}
