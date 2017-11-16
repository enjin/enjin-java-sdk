package com.enjin.coin.sdk.service.identities.impl;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.identities.IdentitiesAsyncService;
import com.enjin.coin.sdk.vo.identity.*;

import java.util.concurrent.Future;
import java.util.logging.Logger;

/**
 * <p>Asynchronous implementation of IdentitiesService</p>
 */
public class IdentitiesAsyncServiceImpl extends IdentitiesServiceImpl implements IdentitiesAsyncService {

    private static final Logger LOGGER = Logger.getLogger(IdentitiesAsyncServiceImpl.class.getName());

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
