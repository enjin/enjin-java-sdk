package com.enjin.coin.sdk;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

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

public class IdentitiesTestsAgainstMockServer {

	private Identities identities;
	
	private String auth;
	private String identityId;	
	private Map<String, Object> identityMap;
	private Map<String, Object> updateMap;
	@Before
	public void setUp() {
		identities = new Identities("http://localhost:8080/");
		auth = "xxzcxcxz";
		identityId = "123456";
		
		identityMap = new HashMap<>();
		identityMap.put("identity_id", identityId);
		identityMap.put("test_damien1", "test_damien1_value");
		identityMap.put("test_damien2", "test_damien2_value");
		
		updateMap = new HashMap<>();
		updateMap.put("player_name", null);
		updateMap.put("ethereum_address", "0x1111111111111111111111111111111111111111");
	}
	
	@Test
	public void testGetIdentity() {		
		GetIdentityRequestVO getIdentityRequestVO = new GetIdentityRequestVO();
		getIdentityRequestVO.setAuth(auth);
		getIdentityRequestVO.setIdentity(identityMap);
		
		GetIdentityResponseVO getIdentityResponseVO = identities.getIdentity(getIdentityRequestVO);
		assertNotNull(getIdentityResponseVO);
		assertNotNull(getIdentityResponseVO.getOtherFields());
	}
	
	@Test
	public void testListIdentities() {		
		String afterIdentityId = "after-1";
		String limit = "limit1";
		boolean linked = false;
		ListIdentitiesRequestVO listIdentitiesRequestVO = new ListIdentitiesRequestVO();
		listIdentitiesRequestVO.setAfterIdentityId(afterIdentityId);
		listIdentitiesRequestVO.setAuth(auth);
		listIdentitiesRequestVO.setLimit(limit);
		listIdentitiesRequestVO.setLinked(linked);
		listIdentitiesRequestVO.setIdentity(identityMap);
		
		ListIdentitiesResponseVO[] listIdentitiesResponseVOArray = identities.listIdentities(listIdentitiesRequestVO);

		for (ListIdentitiesResponseVO listIdentitiesResponseVO : listIdentitiesResponseVOArray) {
			assertNotNull(listIdentitiesResponseVO);
			assertNotNull(listIdentitiesResponseVO.getOtherFields());
		}
	}
	
	@Test
	public void testCreateIdentity() {		
		//Test the create identity request
		CreateIdentityRequestVO createIdentityRequestVO = new CreateIdentityRequestVO();
		createIdentityRequestVO.setAuth(auth);
		createIdentityRequestVO.setIdentity(identityMap);
		
		CreateIdentityResponseVO createIdentityResponseVO = identities.createIdentity(createIdentityRequestVO);
		assertNotNull(createIdentityResponseVO);
		assertNotNull(createIdentityResponseVO.getOtherFields());	
	}
	
	@Test
	public void testUpdateIdentity() {		
		UpdateIdentityRequestVO updateIdentityRequestVO = new UpdateIdentityRequestVO();
		updateIdentityRequestVO.setAuth(auth);
		updateIdentityRequestVO.setIdentity(identityMap);
		updateIdentityRequestVO.setUpdate(updateMap);

		UpdateIdentityResponseVO updateIdentityResponseVO = identities.updateIdentity(updateIdentityRequestVO);
		assertNotNull(updateIdentityResponseVO);
		assertNotNull(updateIdentityResponseVO.getOtherFields());
	}
	
	@Test
	public void testDeleteIdentity() {		
		// Test the delete identity request
		DeleteIdentityRequestVO deleteIdentityRequestVO = new DeleteIdentityRequestVO();
		deleteIdentityRequestVO.setAuth(auth);
		deleteIdentityRequestVO.setIdentity(identityMap);

		DeleteIdentityResponseVO deleteIdentityResponseVO = identities.deleteIdentity(deleteIdentityRequestVO);
		assertNotNull(deleteIdentityResponseVO);
		assertNotNull(deleteIdentityResponseVO.getOtherFields());
		assertNotNull(deleteIdentityResponseVO.getResult());	
	}
}
