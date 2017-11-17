package com.enjin.coin.sdk.service.identities;

import com.enjin.coin.sdk.vo.identity.CreateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.CreateIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.DeleteIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.DeleteIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.GetIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.GetIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.ListIdentitiesRequestVO;
import com.enjin.coin.sdk.vo.identity.ListIdentitiesResponseVO;
import com.enjin.coin.sdk.vo.identity.UpdateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.UpdateIdentityResponseVO;

import java.util.concurrent.Future;

public interface IdentitiesAsyncService extends IdentitiesService {

    /**
     * Method to get an identity
     *
     * @param getIdentityRequestVO - get identity request vo
     * @return - GetIdentityResponseVO
     */
    Future<GetIdentityResponseVO> getIdentityAsync(GetIdentityRequestVO getIdentityRequestVO);

    /**
     * Method to list the identities
     *
     * @param listIdentitiesRequestVO - list identities request vo
     * @return - ListIdentitiesResponseVO array
     */
    Future<ListIdentitiesResponseVO[]> listIdentitiesAsync(ListIdentitiesRequestVO listIdentitiesRequestVO);

    /**
     * Method to create an identity
     *
     * @param createIdentityRequestVO - create identity request vo
     * @return - CreateIdentityResponseVO
     */
    Future<CreateIdentityResponseVO> createIdentityAsync(CreateIdentityRequestVO createIdentityRequestVO);

    /**
     * Method to update an identity
     *
     * @param updateIdentityRequestVO - update identity request vo
     * @return - UpdateIdentityResponseVO
     */
    Future<UpdateIdentityResponseVO> updateIdentityAsync(UpdateIdentityRequestVO updateIdentityRequestVO);

    /**
     * Method to delete an identity
     *
     * @param deleteIdentityRequestVO - delete identity request vo
     * @return - DeleteIdentityResponseVO
     */
    Future<DeleteIdentityResponseVO> deleteIdentityAsync(DeleteIdentityRequestVO deleteIdentityRequestVO);

}
