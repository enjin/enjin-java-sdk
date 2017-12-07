package com.enjin.coin.sdk.service.platform.impl;

import java.util.concurrent.CompletableFuture;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.platform.PlatformAsyncService;
import com.enjin.coin.sdk.vo.platform.GetPlatformAuthRequestVO;
import com.enjin.coin.sdk.vo.platform.GetPlatformAuthResponseVO;

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
