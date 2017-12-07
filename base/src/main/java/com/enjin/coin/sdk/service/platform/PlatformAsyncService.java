package com.enjin.coin.sdk.service.platform;

import java.util.concurrent.CompletableFuture;

import com.enjin.coin.sdk.vo.platform.GetPlatformAuthRequestVO;
import com.enjin.coin.sdk.vo.platform.GetPlatformAuthResponseVO;

/**
 * Asynchronous Events service interface.
 */
public interface PlatformAsyncService extends PlatformService {


    /**
     * Method to get the auth details.
     *
     * @param request - get platform auth request vo
     * @return - GetPlatformAuthResponseVO
     */
    CompletableFuture<GetPlatformAuthResponseVO> getAuthAsync(GetPlatformAuthRequestVO request);

}
