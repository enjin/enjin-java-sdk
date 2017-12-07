package com.enjin.coin.sdk.service.platform;

import com.enjin.coin.sdk.vo.platform.GetPlatformAuthRequestVO;
import com.enjin.coin.sdk.vo.platform.GetPlatformAuthResponseVO;

/**
 * Platform service interface.
 */
public interface PlatformService {

    /**
     * Method to get the auth details.
     *
     * @param request - get platform auth request vo
     * @return - GetPlatformAuthResponseVO
     */
    GetPlatformAuthResponseVO getAuth(GetPlatformAuthRequestVO request);
}
