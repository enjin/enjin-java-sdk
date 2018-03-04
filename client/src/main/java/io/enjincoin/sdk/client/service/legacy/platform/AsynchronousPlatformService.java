package io.enjincoin.sdk.client.service.legacy.platform;

import io.enjincoin.sdk.client.vo.platform.GetPlatformAuthRequestVO;
import io.enjincoin.sdk.client.vo.platform.GetPlatformAuthResponseVO;

import java.util.concurrent.CompletableFuture;

/**
 * Asynchronous Events service interface.
 */
public interface AsynchronousPlatformService extends SynchronousPlatformService {


    /**
     * Method to get the auth details.
     *
     * @param request - get platform auth request vo
     *
     * @return - GetPlatformAuthResponseVO
     */
    CompletableFuture<GetPlatformAuthResponseVO> getAuthAsync(GetPlatformAuthRequestVO request);

}
