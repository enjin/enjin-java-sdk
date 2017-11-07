package com.enjin.coin.sdk;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.util.JsonRpcUtils;
import com.enjin.coin.sdk.vo.GetIdentityResponseVO;

public class Identities {

	public static void main(String args[]) {
		String auth = "xxzcxcxz";
		String identityId = "123456";
		GetIdentityResponseVO getIdentityResponseVO = Identities.getIdentities(auth, identityId);
		System.out.println("getIdentityResponseVO:" + getIdentityResponseVO);
	}
	
	
	/**
	 * Method to get the identities
	 * @param auth
	 * @param identityId
	 * @return
	 */
	public static final GetIdentityResponseVO getIdentities(String auth, String identityId) {

		GetIdentityResponseVO getIdentityResponseVO = null;

		if (StringUtils.isEmpty(auth) || StringUtils.isEmpty(identityId)) {
			//TODO: replace System.out with logging framework
			System.out.println("auth or identidyId passed in are null or empty");
			return getIdentityResponseVO;
		}
		
		// The required parameters to pass
		Map<String,Object> identityMap = new HashMap<String,Object>();
		identityMap.put("identity_id", "123456");
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("auth", "xxxxxxx");
		params.put("identity", identityMap);

		// Construct new request
		String method = "Identities.get";
		int requestId = 1;
		
		getIdentityResponseVO = (GetIdentityResponseVO) JsonRpcUtils.sendJsonRpcRequest(Constants.IDENTITIES_URL, GetIdentityResponseVO.class, method, params, requestId);

		return getIdentityResponseVO;
	}
}
