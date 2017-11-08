package com.enjin.coin.sdk;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.util.JsonRpcUtils;
import com.enjin.coin.sdk.vo.GetIdentityResponseVO;

public class Identities {

	private static final Logger LOGGER = LoggerFactory.getLogger(Identities.class);
	
	public static void main(String args[]) {
		String auth = "xxzcxcxz";
		String identityId = "123456";
		String requestId = "1";
		GetIdentityResponseVO getIdentityResponseVO = Identities.getIdentities(auth, identityId, requestId);
		LOGGER.info("getIdentityResponseVO: {}", getIdentityResponseVO);
		LOGGER.info("getIdentityResponseVO other fields: {}", getIdentityResponseVO.getOtherFields());
	}
	
	
	/**
	 * Method to get the identities
	 * @param auth
	 * @param identityId
	 * @param requestId
	 * @return
	 */
	public static final GetIdentityResponseVO getIdentities(String auth, String identityId, String requestId) {

		GetIdentityResponseVO getIdentityResponseVO = null;

		if (StringUtils.isEmpty(auth) || StringUtils.isEmpty(identityId) || StringUtils.isEmpty(requestId)) {
			LOGGER.error("auth, identidyId or requestId passed in are null or empty");
			return getIdentityResponseVO;
		}
		
		// The required parameters to pass
		Map<String,Object> identityMap = new HashMap<String,Object>();
		identityMap.put("identity_id", identityId);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("auth",  auth);
		params.put("identity", identityMap);

		// Construct new request
		String method = "Identities.get";

		getIdentityResponseVO = (GetIdentityResponseVO) JsonRpcUtils.sendJsonRpcRequest(Constants.IDENTITIES_URL, GetIdentityResponseVO.class, method, params, requestId);

		return getIdentityResponseVO;
	}
}
