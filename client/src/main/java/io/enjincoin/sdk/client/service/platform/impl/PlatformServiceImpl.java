package io.enjincoin.sdk.client.service.platform.impl;

import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.BaseService;
import io.enjincoin.sdk.client.service.platform.PlatformService;
import io.enjincoin.sdk.client.util.Constants;
import io.enjincoin.sdk.client.util.ObjectUtils;
import io.enjincoin.sdk.client.util.StringUtils;
import io.enjincoin.sdk.client.vo.platform.GetPlatformAuthRequestVO;
import io.enjincoin.sdk.client.vo.platform.GetPlatformAuthResponseVO;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Platform service interface.
 */
public class PlatformServiceImpl extends BaseService implements PlatformService {

    /**
     * Logger used by this class.
     */
    private static final Logger LOGGER = Logger.getLogger(PlatformServiceImpl.class.getName());

    /**
     * Class constructor.
     *
     * @param config - the config to use
     */
    public PlatformServiceImpl(final Config config) {
        super(config);
    }

    /**
     * Method to get the auth details.
     *
     * @param platformAuthRequestVO - get platform auth request vo
     * @return - GetPlatformAuthResponseVO
     */
    @Override
    public GetPlatformAuthResponseVO getAuth(final GetPlatformAuthRequestVO platformAuthRequestVO) {
        GetPlatformAuthResponseVO response = null;

        if (ObjectUtils.isNull(platformAuthRequestVO)) {
            LOGGER.warning("Platform.auth request is null.");
            return response;
        }

        if (StringUtils.isEmpty(platformAuthRequestVO.getAuth())) {
            LOGGER.warning("Platform.auth - auth is null or empty.");
            return response;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", platformAuthRequestVO.getAuth().get());

        // Construct new request
        String method = Constants.METHOD_PLATFORM_AUTH;

        response = (GetPlatformAuthResponseVO) getJsonRpcUtils().sendJsonRpcRequest(getPlatformUrl(), GetPlatformAuthResponseVO.class, method, params);

        return response;
    }
}
