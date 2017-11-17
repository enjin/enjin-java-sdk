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

/**
 * Identities service interface.
 */
public interface IdentitiesService {

    /**
     * Method to get an identity.
     *
     * @param request - get identity request vo
     * @return - GetIdentityResponseVO
     */
    GetIdentityResponseVO getIdentity(GetIdentityRequestVO request);

    /**
     * Method to list the identities.
     *
     * @param request - list identities request vo
     * @return - ListIdentitiesResponseVO array
     */
    ListIdentitiesResponseVO[] listIdentities(ListIdentitiesRequestVO request);

    /**
     * Method to create an identity.
     *
     * @param request - create identity request vo
     * @return - CreateIdentityResponseVO
     */
    CreateIdentityResponseVO createIdentity(CreateIdentityRequestVO request);

    /**
     * Method to update an identity.
     *
     * @param request - update identity request vo
     * @return - UpdateIdentityResponseVO
     */
    UpdateIdentityResponseVO updateIdentity(UpdateIdentityRequestVO request);

    /**
     * Method to delete an identity.
     *
     * @param request - delete identity request vo
     * @return - DeleteIdentityResponseVO
     */
    DeleteIdentityResponseVO deleteIdentity(DeleteIdentityRequestVO request);

}
