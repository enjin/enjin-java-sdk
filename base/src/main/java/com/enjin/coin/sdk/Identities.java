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
import com.enjin.coin.sdk.vo.identity.DeleteIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.DeleteIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.GetIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.GetIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.ListIdentitiesRequestVO;
import com.enjin.coin.sdk.vo.identity.ListIdentitiesResponseVO;
import com.enjin.coin.sdk.vo.identity.UpdateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.UpdateIdentityResponseVO;

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
		
		// Test the update identity request
		Map<String, Object> updateMap = new HashMap<>();
		updateMap.put("player_name", null);
		updateMap.put("ethereum_address", "0x1111111111111111111111111111111111111111");
		
		UpdateIdentityRequestVO updateIdentityRequestVO = new UpdateIdentityRequestVO();
		updateIdentityRequestVO.setAuth(auth);
		updateIdentityRequestVO.setIdentity(identityMap);
		updateIdentityRequestVO.setUpdate(updateMap);

		UpdateIdentityResponseVO updateIdentityResponseVO = Identities.updateIdentity(updateIdentityRequestVO);
		LOGGER.info("updateIdentityResponseVO other fields: {}", updateIdentityResponseVO.getOtherFields());	
		
		// Test the delete identity request
		DeleteIdentityRequestVO deleteIdentityRequestVO = new DeleteIdentityRequestVO();
		deleteIdentityRequestVO.setAuth(auth);
		deleteIdentityRequestVO.setIdentity(identityMap);

		DeleteIdentityResponseVO deleteIdentityResponseVO = Identities.deleteIdentity(deleteIdentityRequestVO);
		LOGGER.info("deleteIdentityResponseVO result: {}", deleteIdentityResponseVO.getResult());
	}
	
	/**
	 * Method to get an identity
	 * @param getIdentityRequestVO
	 * @return
	 */
	public static final GetIdentityResponseVO getIdentity(GetIdentityRequestVO getIdentityRequestVO) {
		GetIdentityResponseVO getIdentityResponseVO = null;

		if (getIdentityRequestVO == null || StringUtils.isEmpty(getIdentityRequestVO.getAuth()) || MapUtils.isEmpty(getIdentityRequestVO.getIdentity())) {
			LOGGER.error("getIdentityRequestVO is null, auth or identidyId passed in are null or empty");
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
			LOGGER.error("listIdentitiesRequestVO is null, auth or identity passed in are null or empty");
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
			LOGGER.error("createIdentityRequestVO is null, auth or identity passed in are null or empty");
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
	
	/**
	 * Method to update an identity
	 * @param updateIdentityRequestVO
	 * @return
	 */
	public static final UpdateIdentityResponseVO updateIdentity(UpdateIdentityRequestVO updateIdentityRequestVO) {
		UpdateIdentityResponseVO updateIdentityResponseVO = null;

		if (updateIdentityRequestVO == null || StringUtils.isEmpty(updateIdentityRequestVO.getAuth()) || MapUtils.isEmpty(updateIdentityRequestVO.getIdentity()) || MapUtils.isEmpty(updateIdentityRequestVO.getUpdate())) {
			LOGGER.error("updateIdentityRequestVO is null or auth, identidy or update passed in are null or empty");
			return updateIdentityResponseVO;
		}
		

		Map<String,Object> params = new HashMap<String,Object>();
		params.put("auth",  updateIdentityRequestVO.getAuth());
		params.put("identity", updateIdentityRequestVO.getIdentity());
		params.put("update", updateIdentityRequestVO.getUpdate());

		// Construct new request
		String method = Constants.METHOD_IDENTITIES_UPDATE;

		updateIdentityResponseVO = (UpdateIdentityResponseVO) JsonRpcUtils.sendJsonRpcRequest(Constants.IDENTITIES_URL, UpdateIdentityResponseVO.class, method, params);

		return updateIdentityResponseVO;
	}
	
	/**
	 * Method to delete an identity
	 * @param deleteIdentityRequestVO
	 * @return
	 */
	public static final DeleteIdentityResponseVO deleteIdentity(DeleteIdentityRequestVO deleteIdentityRequestVO) {
		DeleteIdentityResponseVO deleteIdentityResponseVO = null;

		if (deleteIdentityRequestVO == null || StringUtils.isEmpty(deleteIdentityRequestVO.getAuth()) || MapUtils.isEmpty(deleteIdentityRequestVO.getIdentity())) {
			LOGGER.error("deleteIdentityRequestVO is null, auth or identity passed in are null or empty");
			return deleteIdentityResponseVO;
		}
		

		Map<String,Object> params = new HashMap<String,Object>();
		params.put("auth",  deleteIdentityRequestVO.getAuth());
		params.put("identity", deleteIdentityRequestVO.getIdentity());

		// Construct new request
		String method = Constants.METHOD_IDENTITIES_DELETE;

		deleteIdentityResponseVO = new DeleteIdentityResponseVO();
		Boolean result = (Boolean) JsonRpcUtils.sendJsonRpcRequest(Constants.IDENTITIES_URL, Boolean.class, method, params);
		deleteIdentityResponseVO.setResult(result);
		return deleteIdentityResponseVO;
	}	
}
