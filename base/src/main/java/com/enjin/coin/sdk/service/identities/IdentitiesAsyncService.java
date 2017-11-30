package com.enjin.coin.sdk.service.identities;

import com.enjin.coin.sdk.vo.identity.CreateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.CreateIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.DeleteIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.DeleteIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.GetIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.GetIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.UpdateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.UpdateIdentityResponseVO;

import java.util.concurrent.CompletableFuture;

/**
 * Asynchronous Identities service interface.
 */
public interface IdentitiesAsyncService extends IdentitiesService {

    /**
     * Method to get an identity.
     *
     * @param request - get identity request vo
     * @return - GetIdentityResponseVO
     */
    CompletableFuture<GetIdentityResponseVO[]> getIdentityAsync(GetIdentityRequestVO request);

    /**
     * Method to create an identity.
     *
     * @param request - create identity request vo
     * @return - CreateIdentityResponseVO
     */
    CompletableFuture<CreateIdentityResponseVO> createIdentityAsync(CreateIdentityRequestVO request);

    /**
     * Method to update an identity.
     *
     * @param request - update identity request vo
     * @return - UpdateIdentityResponseVO
     */
    CompletableFuture<UpdateIdentityResponseVO> updateIdentityAsync(UpdateIdentityRequestVO request);

    /**
     * Method to delete an identity.
     *
     * @param request - delete identity request vo
     * @return - DeleteIdentityResponseVO
     */
    CompletableFuture<DeleteIdentityResponseVO> deleteIdentityAsync(DeleteIdentityRequestVO request);

}
