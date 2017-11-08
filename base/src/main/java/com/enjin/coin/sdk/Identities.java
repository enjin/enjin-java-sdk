package com.enjin.coin.sdk;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.util.JsonRpcUtils;
import com.enjin.coin.sdk.vo.identity.GetIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.GetIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.ListIdentitiesRequestVO;
import com.enjin.coin.sdk.vo.identity.ListIdentitiesResponseVO;

public class Identities {

	private static final Logger LOGGER = LoggerFactory.getLogger(Identities.class);
	
	public static void main(String args[]) {
		String auth = "xxzcxcxz";
		String identityId = "123456";
		String requestId = "1";
		
		Map<String, Object> identityMap = new HashMap<>();
		identityMap.put("identity_id", identityId);
		identityMap.put("test_damien1", "test_damien1_value");
		identityMap.put("test_damien2", "test_damien2_value");
		
		GetIdentityRequestVO getIdentityRequestVO = new GetIdentityRequestVO();
		getIdentityRequestVO.setAuth(auth);
		getIdentityRequestVO.setIdentity(identityMap);
		
		GetIdentityResponseVO getIdentityResponseVO = Identities.getIdentities(getIdentityRequestVO, requestId);
		LOGGER.info("getIdentityResponseVO: {}", getIdentityResponseVO);
		LOGGER.info("getIdentityResponseVO other fields: {}", getIdentityResponseVO.getOtherFields());
		
		ListIdentitiesRequestVO listIdentitiesRequestVO = new ListIdentitiesRequestVO();
		listIdentitiesRequestVO.setAfterIdentityId("after-1");
		listIdentitiesRequestVO.setAuth(auth);
		listIdentitiesRequestVO.setLimit("limit1");
		listIdentitiesRequestVO.setLinked(false);
		listIdentitiesRequestVO.setIdentity(identityMap);
		
		ListIdentitiesResponseVO[] listIdentitiesResponseVOArray = Identities.listIdentities(listIdentitiesRequestVO, requestId);
		LOGGER.info("listIdentitiesResponseVOArray: {}", listIdentitiesResponseVOArray);
		
		for (ListIdentitiesResponseVO listIdentitiesResponseVO : listIdentitiesResponseVOArray) {
			LOGGER.info("listIdentitiesResponseVO.getOtherFields(): {}", listIdentitiesResponseVO.getOtherFields());
		}

	}
	
	
	


	/**
	 * Method to get the identities
	 * @param getIdentityRequestVO
	 * @param requestId
	 * @return
	 */
	public static final GetIdentityResponseVO getIdentities(GetIdentityRequestVO getIdentityRequestVO, String requestId) {
		GetIdentityResponseVO getIdentityResponseVO = null;

		if (getIdentityRequestVO == null || StringUtils.isEmpty(getIdentityRequestVO.getAuth()) || MapUtils.isEmpty(getIdentityRequestVO.getIdentity()) || StringUtils.isEmpty(requestId)) {
			LOGGER.error("getIdentityRequestVO is null or auth, identidyId or requestId passed in are null or empty");
			return getIdentityResponseVO;
		}
		

		Map<String,Object> params = new HashMap<String,Object>();
		params.put("auth",  getIdentityRequestVO.getAuth());
		params.put("identity", getIdentityRequestVO.getIdentity());

		// Construct new request
		String method = Constants.METHOD_IDENTITIES_GET;

		getIdentityResponseVO = (GetIdentityResponseVO) JsonRpcUtils.sendJsonRpcRequest(Constants.IDENTITIES_URL, GetIdentityResponseVO.class, method, params, requestId);

		return getIdentityResponseVO;
	}
	
	/**
	 * Method to list identities
	 * @param listIdentitiesRequestVO
	 * @param requestId
	 * @return
	 */
	private static ListIdentitiesResponseVO[] listIdentities(ListIdentitiesRequestVO listIdentitiesRequestVO, String requestId) {
		ListIdentitiesResponseVO[] listIdentitiesResponseVO = null;

		if (listIdentitiesRequestVO == null || StringUtils.isEmpty(listIdentitiesRequestVO.getAuth()) || MapUtils.isEmpty(listIdentitiesRequestVO.getIdentity()) || StringUtils.isEmpty(requestId)) {
			LOGGER.error("listIdentitiesRequestVO is null or auth, identidyId or requestId passed in are null or empty");
			return listIdentitiesResponseVO;
		}
		

		Map<String,Object> params = new HashMap<String,Object>();
		params.put("auth",  listIdentitiesRequestVO.getAuth());
		params.put("identity", listIdentitiesRequestVO.getIdentity());
		params.put("linked", listIdentitiesRequestVO.getLimit());
		params.put("after_identity_id", listIdentitiesRequestVO.getAfterIdentityId());
		params.put("limit", listIdentitiesRequestVO.getLimit());

		// Construct new request
		String method = Constants.METHOD_IDENTITIES_LIST;

		listIdentitiesResponseVO = (ListIdentitiesResponseVO[]) JsonRpcUtils.sendJsonRpcRequest(Constants.IDENTITIES_URL, ListIdentitiesResponseVO[].class, method, params, requestId);

		return listIdentitiesResponseVO;
	}
}
