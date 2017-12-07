package com.enjin.coin.sdk.service.platform;

import com.enjin.coin.sdk.vo.platform.GetPlatformAuthRequestVO;
import com.enjin.coin.sdk.vo.platform.GetPlatformAuthResponseVO;

/**
 * <p>Platform service interface.</p>
 */
public interface PlatformService {

    /**
     * Method to get the auth details.
     *
     * @param platformAuthRequestVO - get platform auth request vo
     * @return GetPlatformAuthResponseVO
     */
    GetPlatformAuthResponseVO getAuth(GetPlatformAuthRequestVO platformAuthRequestVO);
}
