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
 * <p>Asynchronous implementation of IdentitiesService.</p>
 */
public final class IdentitiesAsyncServiceImpl extends IdentitiesServiceImpl implements IdentitiesAsyncService {

    /**
     * Class constructor.
     *
     * @param config - the config to use
     */
    public IdentitiesAsyncServiceImpl(final Config config) {
        super(config);
    }

    @Override
    public Future<GetIdentityResponseVO> getIdentityAsync(final GetIdentityRequestVO request) {
        return getExecutorService().submit(() -> getIdentity(request));
    }

    @Override
    public Future<ListIdentitiesResponseVO[]> listIdentitiesAsync(final ListIdentitiesRequestVO request) {
        return getExecutorService().submit(() -> listIdentities(request));
    }

    @Override
    public Future<CreateIdentityResponseVO> createIdentityAsync(final CreateIdentityRequestVO request) {
        return getExecutorService().submit(() -> createIdentity(request));
    }

    @Override
    public Future<UpdateIdentityResponseVO> updateIdentityAsync(final UpdateIdentityRequestVO request) {
        return getExecutorService().submit(() -> updateIdentity(request));
    }

    @Override
    public Future<DeleteIdentityResponseVO> deleteIdentityAsync(final DeleteIdentityRequestVO request) {
        return getExecutorService().submit(() -> deleteIdentity(request));
    }

}
