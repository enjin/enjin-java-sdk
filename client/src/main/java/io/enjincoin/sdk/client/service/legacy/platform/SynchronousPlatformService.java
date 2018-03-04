package io.enjincoin.sdk.client.service.legacy.platform;

import io.enjincoin.sdk.client.vo.platform.GetPlatformAuthRequestVO;
import io.enjincoin.sdk.client.vo.platform.GetPlatformAuthResponseVO;

/**
 * <p>Platform service interface.</p>
 */
public interface SynchronousPlatformService {

    /**
     * Method to get the auth details.
     *
     * @param platformAuthRequestVO - get platform auth request vo
     *
     * @return GetPlatformAuthResponseVO
     */
    GetPlatformAuthResponseVO getAuthSync(GetPlatformAuthRequestVO platformAuthRequestVO);
}
