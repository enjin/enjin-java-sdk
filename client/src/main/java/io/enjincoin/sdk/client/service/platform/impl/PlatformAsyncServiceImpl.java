package io.enjincoin.sdk.client.service.platform.impl;

import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.platform.PlatformAsyncService;
import io.enjincoin.sdk.client.vo.platform.GetPlatformAuthRequestVO;
import io.enjincoin.sdk.client.vo.platform.GetPlatformAuthResponseVO;

import java.util.concurrent.CompletableFuture;

/**
 * Asynchronous Events service interface.
 */
public class PlatformAsyncServiceImpl extends PlatformServiceImpl implements PlatformAsyncService {

    /**
     * Class constructor.
     *
     * @param config - the config to use
     */
    public PlatformAsyncServiceImpl(final Config config) {
        super(config);
    }

    /**
     * Method to get the auth details.
     *
     * @param request - get platform auth request vo
     * @return - GetPlatformAuthResponseVO
     */
    @Override
    public CompletableFuture<GetPlatformAuthResponseVO> getAuthAsync(final GetPlatformAuthRequestVO request) {
        return CompletableFuture.supplyAsync(() -> getAuth(request), getExecutorService());
    }

}
