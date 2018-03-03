package io.enjincoin.sdk.client.service.identities;

import java.util.concurrent.CompletableFuture;

import io.enjincoin.sdk.client.vo.identity.CreateIdentityRequestVO;
import io.enjincoin.sdk.client.vo.identity.CreateIdentityResponseVO;
import io.enjincoin.sdk.client.vo.identity.GetIdentityResponseVO;
import io.enjincoin.sdk.client.vo.legacy.identity.UpdateIdentityRequestVO;
import io.enjincoin.sdk.client.vo.legacy.identity.UpdateIdentityResponseVO;

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
    CompletableFuture<CreateIdentityResponseVO> createIdentityAsync(CreateIdentityRequestVO request);

    /**
     * Method to update an identity.
     *
     * @param request - update identity request vo
     *
     * @return - UpdateIdentityResponseVO
     */
    CompletableFuture<UpdateIdentityResponseVO> updateIdentityAsync(UpdateIdentityRequestVO request);

    /**
     * Method to delete an identity
     * @param identityId - the identity to delete
     * @return Boolean
     */
    CompletableFuture<Boolean> deleteIdentityAsync(final Integer identityId);

}
