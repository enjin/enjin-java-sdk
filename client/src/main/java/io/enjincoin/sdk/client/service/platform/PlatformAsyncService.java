package io.enjincoin.sdk.client.service.platform;

import io.enjincoin.sdk.client.vo.platform.GetPlatformAuthRequestVO;
import io.enjincoin.sdk.client.vo.platform.GetPlatformAuthResponseVO;

import java.util.concurrent.CompletableFuture;

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
