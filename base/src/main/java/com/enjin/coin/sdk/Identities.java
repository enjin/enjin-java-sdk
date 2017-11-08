package com.enjin.coin.sdk;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.util.JsonRpcUtils;
import com.enjin.coin.sdk.vo.identity.CreateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.CreateIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.GetIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.GetIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.ListIdentitiesRequestVO;
import com.enjin.coin.sdk.vo.identity.ListIdentitiesResponseVO;

public class Identities {

	private static final Logger LOGGER = LoggerFactory.getLogger(Identities.class);
	
	public static void main(String args[]) {
		String auth = "xxzcxcxz";
		String identityId = "123456";
		
		Map<String, Object> identityMap = new HashMap<>();
		identityMap.put("identity_id", identityId);
		identityMap.put("test_damien1", "test_damien1_value");
		identityMap.put("test_damien2", "test_damien2_value");
		
		//Test the get identity request
		GetIdentityRequestVO getIdentityRequestVO = new GetIdentityRequestVO();
		getIdentityRequestVO.setAuth(auth);
		getIdentityRequestVO.setIdentity(identityMap);
		
		GetIdentityResponseVO getIdentityResponseVO = Identities.getIdentity(getIdentityRequestVO);
		LOGGER.info("getIdentityResponseVO other fields: {}", getIdentityResponseVO.getOtherFields());
		
		//Test the list identities request
		String afterIdentityId = "after-1";
		String limit = "limit1";
		boolean linked = false;
		ListIdentitiesRequestVO listIdentitiesRequestVO = new ListIdentitiesRequestVO();
		listIdentitiesRequestVO.setAfterIdentityId(afterIdentityId);
		listIdentitiesRequestVO.setAuth(auth);
		listIdentitiesRequestVO.setLimit(limit);
		listIdentitiesRequestVO.setLinked(linked);
		listIdentitiesRequestVO.setIdentity(identityMap);
		
		ListIdentitiesResponseVO[] listIdentitiesResponseVOArray = Identities.listIdentities(listIdentitiesRequestVO);

		for (ListIdentitiesResponseVO listIdentitiesResponseVO : listIdentitiesResponseVOArray) {
			LOGGER.info("listIdentitiesResponseVO.getOtherFields(): {}", listIdentitiesResponseVO.getOtherFields());
		}

		//Test the create identity request
		CreateIdentityRequestVO createIdentityRequestVO = new CreateIdentityRequestVO();
		createIdentityRequestVO.setAuth(auth);
		createIdentityRequestVO.setIdentity(identityMap);
		
		CreateIdentityResponseVO createIdentityResponseVO = Identities.createIdentity(createIdentityRequestVO);
		LOGGER.info("createIdentityResponseVO other fields: {}", createIdentityResponseVO.getOtherFields());
	}
	
	/**
	 * Method to get an identity
	 * @param getIdentityRequestVO
	 * @return
	 */
	public static final GetIdentityResponseVO getIdentity(GetIdentityRequestVO getIdentityRequestVO) {
		GetIdentityResponseVO getIdentityResponseVO = null;

		if (getIdentityRequestVO == null || StringUtils.isEmpty(getIdentityRequestVO.getAuth()) || MapUtils.isEmpty(getIdentityRequestVO.getIdentity())) {
			LOGGER.error("getIdentityRequestVO is null or auth, identidyId or requestId passed in are null or empty");
			return getIdentityResponseVO;
		}
		

		Map<String,Object> params = new HashMap<String,Object>();
		params.put("auth",  getIdentityRequestVO.getAuth());
		params.put("identity", getIdentityRequestVO.getIdentity());

		// Construct new request
		String method = Constants.METHOD_IDENTITIES_GET;

		getIdentityResponseVO = (GetIdentityResponseVO) JsonRpcUtils.sendJsonRpcRequest(Constants.IDENTITIES_URL, GetIdentityResponseVO.class, method, params);

		return getIdentityResponseVO;
	}
	
	/**
	 * Method to list the identities
	 * @param listIdentitiesRequestVO
	 * @return
	 */
	private static ListIdentitiesResponseVO[] listIdentities(ListIdentitiesRequestVO listIdentitiesRequestVO) {
		ListIdentitiesResponseVO[] listIdentitiesResponseVO = null;

		if (listIdentitiesRequestVO == null || StringUtils.isEmpty(listIdentitiesRequestVO.getAuth()) || MapUtils.isEmpty(listIdentitiesRequestVO.getIdentity())) {
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

		listIdentitiesResponseVO = (ListIdentitiesResponseVO[]) JsonRpcUtils.sendJsonRpcRequest(Constants.IDENTITIES_URL, ListIdentitiesResponseVO[].class, method, params);

		return listIdentitiesResponseVO;
	}
	
	/**
	 * Method to create an identity
	 * @param createIdentityRequestVO
	 * @return
	 */
	public static final CreateIdentityResponseVO createIdentity(CreateIdentityRequestVO createIdentityRequestVO) {
		CreateIdentityResponseVO createIdentityResponseVO = null;

		if (createIdentityRequestVO == null || StringUtils.isEmpty(createIdentityRequestVO.getAuth()) || MapUtils.isEmpty(createIdentityRequestVO.getIdentity())) {
			LOGGER.error("createIdentityRequestVO is null or auth, identidyId or requestId passed in are null or empty");
			return createIdentityResponseVO;
		}
		

		Map<String,Object> params = new HashMap<String,Object>();
		params.put("auth",  createIdentityRequestVO.getAuth());
		params.put("identity", createIdentityRequestVO.getIdentity());

		// Construct new request
		String method = Constants.METHOD_IDENTITIES_CREATE;

		createIdentityResponseVO = (CreateIdentityResponseVO) JsonRpcUtils.sendJsonRpcRequest(Constants.IDENTITIES_URL, CreateIdentityResponseVO.class, method, params);

		return createIdentityResponseVO;
	}
}
