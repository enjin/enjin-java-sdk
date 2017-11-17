package com.enjin.coin.sdk.service.identities.impl;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.identities.IdentitiesAsyncService;
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

/**
 * <p>Asynchronous implementation of IdentitiesService</p>
 */
public class IdentitiesAsyncServiceImpl extends IdentitiesServiceImpl implements IdentitiesAsyncService {

	/**
     * Class constructor
     *
     * @param enjinConfig - the enjinConfig to use
     */
    public IdentitiesAsyncServiceImpl(Config enjinConfig) {
        super(enjinConfig);
    }

    @Override
    public Future<GetIdentityResponseVO> getIdentityAsync(GetIdentityRequestVO getIdentityRequestVO) {
        return executorService.submit(() -> getIdentity(getIdentityRequestVO));
    }

    @Override
    public Future<ListIdentitiesResponseVO[]> listIdentitiesAsync(ListIdentitiesRequestVO listIdentitiesRequestVO) {
        return executorService.submit(() -> listIdentities(listIdentitiesRequestVO));
    }

    @Override
    public Future<CreateIdentityResponseVO> createIdentityAsync(CreateIdentityRequestVO createIdentityRequestVO) {
        return executorService.submit(() -> createIdentity(createIdentityRequestVO));
    }

    @Override
    public Future<UpdateIdentityResponseVO> updateIdentityAsync(UpdateIdentityRequestVO updateIdentityRequestVO) {
        return executorService.submit(() -> updateIdentity(updateIdentityRequestVO));
    }

    @Override
    public Future<DeleteIdentityResponseVO> deleteIdentityAsync(DeleteIdentityRequestVO deleteIdentityRequestVO) {
        return executorService.submit(() -> deleteIdentity(deleteIdentityRequestVO));
    }

}
