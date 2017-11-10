package com.enjin.coin.sdk.mockServer;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.enjin.coin.sdk.service.IdentitiesService;
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

public class IdentitiesServiceTestsAgainstMockServer extends BaseMockServer{

	private IdentitiesService identities;

	@Before
	public void init() {
		identities = new IdentitiesService(getURL(), true);
	}
	
	@Test
	public void testGetIdentity() {
		
		Map<String, Object> identityMap = new HashMap<>();
		identityMap.put("identity_id", "123456");
		identityMap.put("test_damien1", "test_damien1_value");
		identityMap.put("test_damien2", "test_damien2_value");
		
		GetIdentityRequestVO getIdentityRequestVO = new GetIdentityRequestVO();
		getIdentityRequestVO.setAuth("xxzcxcxz");
		getIdentityRequestVO.setIdentity(identityMap);
		
		GetIdentityResponseVO getIdentityResponseVO = identities.getIdentity(getIdentityRequestVO);
		assertNotNull(getIdentityResponseVO);
		assertNotNull(getIdentityResponseVO.getIdentityId());
		assertNotNull(getIdentityResponseVO.getPlayerName());
		assertNotNull(getIdentityResponseVO.getEthereumAddress());
		assertNotNull(getIdentityResponseVO.getUuid());
	}

	@Test
	public void testListIdentities() {	
		Map<String, Object> identityMap = new HashMap<>();
		identityMap.put("identity_id", "123456");
		identityMap.put("test_damien1", "test_damien1_value");
		identityMap.put("test_damien2", "test_damien2_value");
		
		
		String afterIdentityId = "after-1";
		String limit = "limit1";
		boolean linked = false;
		ListIdentitiesRequestVO listIdentitiesRequestVO = new ListIdentitiesRequestVO();
		listIdentitiesRequestVO.setAfterIdentityId(afterIdentityId);
		listIdentitiesRequestVO.setAuth("xxzcxcxz");
		listIdentitiesRequestVO.setLimit(limit);
		listIdentitiesRequestVO.setLinked(linked);
		listIdentitiesRequestVO.setIdentity(identityMap);
		
		ListIdentitiesResponseVO[] listIdentitiesResponseVOArray = identities.listIdentities(listIdentitiesRequestVO);

		for (ListIdentitiesResponseVO listIdentitiesResponseVO : listIdentitiesResponseVOArray) {
			assertNotNull(listIdentitiesResponseVO);
			assertNotNull(listIdentitiesResponseVO.getIdentityId());
			assertNotNull(listIdentitiesResponseVO.getPlayerName());
			assertNotNull(listIdentitiesResponseVO.getEthereumAddress());
		}
	}
	
	@Test
	public void testCreateIdentity() {
		Map<String, Object> identityMap = new HashMap<>();
		identityMap.put("identity_id", "123456");
		identityMap.put("test_damien1", "test_damien1_value");
		identityMap.put("test_damien2", "test_damien2_value");
		
		//Test the create identity request
		CreateIdentityRequestVO createIdentityRequestVO = new CreateIdentityRequestVO();
		createIdentityRequestVO.setAuth("xxzcxcxz");
		createIdentityRequestVO.setIdentity(identityMap);
		
		CreateIdentityResponseVO createIdentityResponseVO = identities.createIdentity(createIdentityRequestVO);
		assertNotNull(createIdentityResponseVO);
		assertNotNull(createIdentityResponseVO.getIdentityId());
		assertNotNull(createIdentityResponseVO.getIdentityCode());
	}

	@Test
	public void testUpdateIdentity() {	
		Map<String, Object> identityMap = new HashMap<>();
		identityMap.put("identity_id", "123456");
		identityMap.put("test_damien1", "test_damien1_value");
		identityMap.put("test_damien2", "test_damien2_value");
		
		Map<String, Object> updateMap = new HashMap<>();
		updateMap.put("player_name", null);
		updateMap.put("ethereum_address", "0x1111111111111111111111111111111111111111");
		
		UpdateIdentityRequestVO updateIdentityRequestVO = new UpdateIdentityRequestVO();
		updateIdentityRequestVO.setAuth("xxzcxcxz");
		updateIdentityRequestVO.setIdentity(identityMap);
		updateIdentityRequestVO.setUpdate(updateMap);

		UpdateIdentityResponseVO updateIdentityResponseVO = identities.updateIdentity(updateIdentityRequestVO);
		assertNotNull(updateIdentityResponseVO);
		assertNotNull(updateIdentityResponseVO.getIdentityMap());
		assertNotNull(updateIdentityResponseVO.getIdentityMap().get("identity_id"));
		assertNotNull(updateIdentityResponseVO.getIdentityMap().get("ethereum_address"));
		assertNotNull(updateIdentityResponseVO.getIdentityMap().get("uuid"));
	}
	
	@Test
	public void testDeleteIdentity() {	
		Map<String, Object> identityMap = new HashMap<>();
		identityMap.put("identity_id", "123456");
		identityMap.put("test_damien1", "test_damien1_value");
		identityMap.put("test_damien2", "test_damien2_value");
		
		// Test the delete identity request
		DeleteIdentityRequestVO deleteIdentityRequestVO = new DeleteIdentityRequestVO();
		deleteIdentityRequestVO.setAuth("xxzcxcxz");
		deleteIdentityRequestVO.setIdentity(identityMap);

		DeleteIdentityResponseVO deleteIdentityResponseVO = identities.deleteIdentity(deleteIdentityRequestVO);
		assertNotNull(deleteIdentityResponseVO);
		assertNotNull(deleteIdentityResponseVO.getResult());	

	}
}
