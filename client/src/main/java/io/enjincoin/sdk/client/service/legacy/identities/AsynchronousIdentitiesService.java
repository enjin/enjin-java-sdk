package io.enjincoin.sdk.client.service.legacy.identities;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import io.enjincoin.sdk.client.vo.identity.CreateIdentityRequestVO;
import io.enjincoin.sdk.client.service.identities.vo.CreateIdentityResponseBody;
import io.enjincoin.sdk.client.vo.identity.GetIdentityResponseVO;
import io.enjincoin.sdk.client.vo.identity.LinkIdentityRequestVO;
import io.enjincoin.sdk.client.vo.identity.LinkIdentityResponseVO;
import io.enjincoin.sdk.client.vo.identity.UpdateIdentityRequestVO;
import io.enjincoin.sdk.client.vo.identity.UpdateIdentityResponseVO;

/**
 * Asynchronous Identities service interface.
 */
public interface AsynchronousIdentitiesService {

    /**
     * Method to get all identities.
     *
     *
     * @return - GetIdentityResponseVO
     */
    CompletableFuture<GetIdentityResponseVO[]> getIdentitiesAsync();

    /**
     * Method to get all identities - supplying a filter also.
     * @param filterMap - the map with the data to use for filtering
     *
     * @return - GetIdentityResponseVO
     */
    CompletableFuture<GetIdentityResponseVO[]> getIdentitiesAsync(Map<String, Object> filterMap);

    /**
     * Method to get an entity by identityId
     * @param identityId
     * @return
     */
    CompletableFuture<GetIdentityResponseVO> getIdentityAsync(Integer identityId);


    /**
     * Method to create an identity.
     *
     * @param request - create identity request vo
     *
     * @return - CreateIdentityResponseVO
     */
    CompletableFuture<CreateIdentityResponseBody> createIdentityAsync(CreateIdentityRequestVO request);

    /**
     * Method to update an identity.
     *
     * @param request - update identity request vo
     * @param identityId - identity to update
     * @return - UpdateIdentityResponseVO
     */
    CompletableFuture<UpdateIdentityResponseVO> updateIdentityAsync(UpdateIdentityRequestVO request, Integer identityId);

    /**
     * Method to delete an identity
     * @param identityId - the identity to delete
     * @return Boolean
     */
    CompletableFuture<Boolean> deleteIdentityAsync(final Integer identityId);

    /**
     * Method to link an identity.
     *
     * @param linkIdentityRequestVO - link identity request vo
     * @param linkingCode - code to use
     * @return - LinkIdentityResponseVO
     */
    CompletableFuture<LinkIdentityResponseVO> linkIdentityAsync(LinkIdentityRequestVO linkIdentityRequestVO, String linkingCode);

}
