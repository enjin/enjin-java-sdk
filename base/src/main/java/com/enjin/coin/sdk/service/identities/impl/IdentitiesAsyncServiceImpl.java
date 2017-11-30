package com.enjin.coin.sdk.service.identities.impl;

import java.util.concurrent.CompletableFuture;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.identities.IdentitiesAsyncService;
import com.enjin.coin.sdk.vo.identity.CreateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.CreateIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.DeleteIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.DeleteIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.GetIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.GetIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.UpdateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.UpdateIdentityResponseVO;

/**
 * <p>
 * Asynchronous implementation of IdentitiesService.
 * </p>
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
    public CompletableFuture<GetIdentityResponseVO[]> getIdentityAsync(final GetIdentityRequestVO request) {
        return CompletableFuture.supplyAsync(() -> getIdentity(request), getExecutorService());
    }

    @Override
    public CompletableFuture<CreateIdentityResponseVO> createIdentityAsync(final CreateIdentityRequestVO request) {
        return CompletableFuture.supplyAsync(() -> createIdentity(request), getExecutorService());
    }

    @Override
    public CompletableFuture<UpdateIdentityResponseVO> updateIdentityAsync(final UpdateIdentityRequestVO request) {
        return CompletableFuture.supplyAsync(() -> updateIdentity(request), getExecutorService());
    }

    @Override
    public CompletableFuture<DeleteIdentityResponseVO> deleteIdentityAsync(final DeleteIdentityRequestVO request) {
        return CompletableFuture.supplyAsync(() -> deleteIdentity(request), getExecutorService());
    }

}
