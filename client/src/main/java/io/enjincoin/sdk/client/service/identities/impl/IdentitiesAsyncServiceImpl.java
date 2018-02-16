package io.enjincoin.sdk.client.service.identities.impl;

import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.identities.IdentitiesAsyncService;
import io.enjincoin.sdk.client.vo.identity.*;

import java.util.concurrent.CompletableFuture;

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
