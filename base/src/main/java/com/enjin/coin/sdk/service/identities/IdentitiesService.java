package com.enjin.coin.sdk.service.identities;

import com.enjin.coin.sdk.vo.identity.*;

public interface IdentitiesService {

    /**
     * Method to get an identity
     *
     * @param getIdentityRequestVO - get identity request vo
     * @return - GetIdentityResponseVO
     */
    GetIdentityResponseVO getIdentity(GetIdentityRequestVO getIdentityRequestVO);

    /**
     * Method to list the identities
     *
     * @param listIdentitiesRequestVO - list identities request vo
     * @return - ListIdentitiesResponseVO array
     */
    ListIdentitiesResponseVO[] listIdentities(ListIdentitiesRequestVO listIdentitiesRequestVO);

    /**
     * Method to create an identity
     *
     * @param createIdentityRequestVO - create identity request vo
     * @return - CreateIdentityResponseVO
     */
    CreateIdentityResponseVO createIdentity(CreateIdentityRequestVO createIdentityRequestVO);

    /**
     * Method to update an identity
     *
     * @param updateIdentityRequestVO - update identity request vo
     * @return - UpdateIdentityResponseVO
     */
    UpdateIdentityResponseVO updateIdentity(UpdateIdentityRequestVO updateIdentityRequestVO);

    /**
     * Method to delete an identity
     *
     * @param deleteIdentityRequestVO - delete identity request vo
     * @return - DeleteIdentityResponseVO
     */
    DeleteIdentityResponseVO deleteIdentity(DeleteIdentityRequestVO deleteIdentityRequestVO);

}
