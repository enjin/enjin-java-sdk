package com.enjin.coin.sdk;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

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

@RunWith(PowerMockRunner.class)
@PrepareForTest(Identities.class)
public class IdentitiesTest {

	Identities identities;

	@Test
	public void testContructor1() {
		identities = new Identities();
		assertNotNull(identities);
		assertNotNull(identities.toString());
	}
	
	@Test
	public void testContructor2() {
		identities = new Identities("http://localhost:8080");
		assertNotNull(identities);
		assertNotNull(identities.toString());
	}
	
	@Test
	public void testGetIdentity_GetIdentityRequestVOIsNull() {
		GetIdentityRequestVO getIdentityRequestVO = null;
		
		identities = new Identities();
		GetIdentityResponseVO getIdentityResponseVO = identities.getIdentity(getIdentityRequestVO);
		assertNull(getIdentityResponseVO);
	}
	@Test
	public void testGetIdentity_AuthIsNull() {
		GetIdentityRequestVO getIdentityRequestVO = new GetIdentityRequestVO();
		getIdentityRequestVO.setAuth(null);
		
		identities = new Identities();
		GetIdentityResponseVO getIdentityResponseVO = identities.getIdentity(getIdentityRequestVO);
		assertNull(getIdentityResponseVO);
	}
	@Test
	public void testGetIdentity_AuthIsEmpty() {
		GetIdentityRequestVO getIdentityRequestVO = new GetIdentityRequestVO();
		getIdentityRequestVO.setAuth("");
		
		identities = new Identities();
		GetIdentityResponseVO getIdentityResponseVO = identities.getIdentity(getIdentityRequestVO);
		assertNull(getIdentityResponseVO);
	}
	@Test
	public void testGetIdentity_IdentityMapIsNull() {
		GetIdentityRequestVO getIdentityRequestVO = new GetIdentityRequestVO();
		getIdentityRequestVO.setAuth("auth");
		Map<String, Object> identityMap = null;
		getIdentityRequestVO.setIdentity(identityMap);
		
		identities = new Identities();
		GetIdentityResponseVO getIdentityResponseVO = identities.getIdentity(getIdentityRequestVO);
		assertNull(getIdentityResponseVO);
	}
	@Test
	public void testGetIdentity_IdentityMapIsEmpty() {
		GetIdentityRequestVO getIdentityRequestVO = new GetIdentityRequestVO();
		getIdentityRequestVO.setAuth("auth");
		Map<String, Object> identityMap = new HashMap<>();
		getIdentityRequestVO.setIdentity(identityMap);
		
		identities = new Identities();
		GetIdentityResponseVO getIdentityResponseVO = identities.getIdentity(getIdentityRequestVO);
		assertNull(getIdentityResponseVO);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testGetIdentity_ResponseIsNull() throws Exception {
		GetIdentityRequestVO getIdentityRequestVO = new GetIdentityRequestVO();
		getIdentityRequestVO.setAuth("auth");
		Map<String, Object> identityMap = new HashMap<>();
		identityMap.put("key", "value");		
		getIdentityRequestVO.setIdentity(identityMap);
		
		GetIdentityResponseVO returnedGetIdentityResponseVO = null;
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetIdentityResponseVO);
		
		identities = new Identities();
		GetIdentityResponseVO getIdentityResponseVO = identities.getIdentity(getIdentityRequestVO);
		assertNull(getIdentityResponseVO);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testGetIdentity_Success() throws Exception {
		GetIdentityRequestVO getIdentityRequestVO = new GetIdentityRequestVO();
		getIdentityRequestVO.setAuth("auth");
		Map<String, Object> identityMap = new HashMap<>();
		identityMap.put("key", "value");		
		getIdentityRequestVO.setIdentity(identityMap);
		
		GetIdentityResponseVO returnedGetIdentityResponseVO = new GetIdentityResponseVO();
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetIdentityResponseVO);
		
		identities = new Identities();
		GetIdentityResponseVO getIdentityResponseVO = identities.getIdentity(getIdentityRequestVO);
		assertNotNull(getIdentityResponseVO);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	
	@Test
	public void testListIdentities_ListIdentitiesRequestVOIsNull() {
		ListIdentitiesRequestVO listIdentitiesRequestVO = null;
		
		identities = new Identities();
		ListIdentitiesResponseVO[] listIdentitiesResponseVO = identities.listIdentities(listIdentitiesRequestVO);
		assertNull(listIdentitiesResponseVO);
	}
	@Test
	public void testListIdentities_AuthIsNull() {
		ListIdentitiesRequestVO listIdentitiesRequestVO = new ListIdentitiesRequestVO();
		listIdentitiesRequestVO.setAuth(null);
		
		identities = new Identities();
		ListIdentitiesResponseVO[] listIdentitiesResponseVO = identities.listIdentities(listIdentitiesRequestVO);
		assertNull(listIdentitiesResponseVO);
	}
	@Test
	public void testListIdentities_AuthIsEmpty() {
		ListIdentitiesRequestVO listIdentitiesRequestVO = new ListIdentitiesRequestVO();
		listIdentitiesRequestVO.setAuth("");
		
		identities = new Identities();
		ListIdentitiesResponseVO[] listIdentitiesResponseVO = identities.listIdentities(listIdentitiesRequestVO);
		assertNull(listIdentitiesResponseVO);
	}
	@Test
	public void testListIdentities_IdentityMapIsNull() {
		ListIdentitiesRequestVO listIdentitiesRequestVO = new ListIdentitiesRequestVO();
		listIdentitiesRequestVO.setAuth("auth");
		Map<String, Object> identityMap = null;
		listIdentitiesRequestVO.setIdentity(identityMap);
		
		identities = new Identities();
		ListIdentitiesResponseVO[] listIdentitiesResponseVO = identities.listIdentities(listIdentitiesRequestVO);
		assertNull(listIdentitiesResponseVO);
	}
	@Test
	public void testListIdentities_IdentityMapIsEmpty() {
		ListIdentitiesRequestVO listIdentitiesRequestVO = new ListIdentitiesRequestVO();
		listIdentitiesRequestVO.setAuth("auth");
		Map<String, Object> identityMap = new HashMap<>();
		listIdentitiesRequestVO.setIdentity(identityMap);
		
		identities = new Identities();
		ListIdentitiesResponseVO[] listIdentitiesResponseVO = identities.listIdentities(listIdentitiesRequestVO);
		assertNull(listIdentitiesResponseVO);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testListIdentities_ResponseIsNull() throws Exception {
		ListIdentitiesRequestVO listIdentitiesRequestVO = new ListIdentitiesRequestVO();
		listIdentitiesRequestVO.setAuth("auth");
		Map<String, Object> identityMap = new HashMap<>();
		identityMap.put("key", "value");		
		listIdentitiesRequestVO.setIdentity(identityMap);
		
		ListIdentitiesResponseVO[] returnedListIdentitiesResponseVO = null;
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListIdentitiesResponseVO);
		
		identities = new Identities();
		ListIdentitiesResponseVO[] listIdentitiesResponseVO = identities.listIdentities(listIdentitiesRequestVO);
		assertNull(listIdentitiesResponseVO);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testListIdentities_ResponseIsEmpty() throws Exception {
		ListIdentitiesRequestVO listIdentitiesRequestVO = new ListIdentitiesRequestVO();
		listIdentitiesRequestVO.setAuth("auth");
		Map<String, Object> identityMap = new HashMap<>();
		identityMap.put("key", "value");		
		listIdentitiesRequestVO.setIdentity(identityMap);
		
		ListIdentitiesResponseVO[] returnedListIdentitiesResponseVO = new ListIdentitiesResponseVO[] {};
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListIdentitiesResponseVO);
		
		identities = new Identities();
		ListIdentitiesResponseVO[] listIdentitiesResponseVO = identities.listIdentities(listIdentitiesRequestVO);
		assertNotNull(listIdentitiesResponseVO);
		assertNotNull(listIdentitiesResponseVO.length == 0);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testListIdentities_Success1() throws Exception {
		ListIdentitiesRequestVO listIdentitiesRequestVO = new ListIdentitiesRequestVO();
		listIdentitiesRequestVO.setAuth("auth");
		Map<String, Object> identityMap = new HashMap<>();
		identityMap.put("key", "value");		
		listIdentitiesRequestVO.setIdentity(identityMap);
		
		ListIdentitiesResponseVO[] returnedListIdentitiesResponseVO = new ListIdentitiesResponseVO[] {new ListIdentitiesResponseVO()};
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListIdentitiesResponseVO);
		
		identities = new Identities();
		ListIdentitiesResponseVO[] listIdentitiesResponseVO = identities.listIdentities(listIdentitiesRequestVO);
		assertNotNull(listIdentitiesResponseVO);
		assertNotNull(listIdentitiesResponseVO.length == 1);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testListIdentities_Success2() throws Exception {
		ListIdentitiesRequestVO listIdentitiesRequestVO = new ListIdentitiesRequestVO();
		listIdentitiesRequestVO.setAuth("auth");
		Map<String, Object> identityMap = new HashMap<>();
		identityMap.put("key", "value");		
		listIdentitiesRequestVO.setIdentity(identityMap);
		
		ListIdentitiesResponseVO[] returnedListIdentitiesResponseVO = new ListIdentitiesResponseVO[] {new ListIdentitiesResponseVO(), new ListIdentitiesResponseVO()};
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListIdentitiesResponseVO);
		
		identities = new Identities();
		ListIdentitiesResponseVO[] listIdentitiesResponseVO = identities.listIdentities(listIdentitiesRequestVO);
		assertNotNull(listIdentitiesResponseVO);
		assertNotNull(listIdentitiesResponseVO.length == 2);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	
	@Test
	public void testCreateIdentity_CreateIdentityRequestVOIsNull() {
		CreateIdentityRequestVO createIdentityRequestVO = null;
		
		identities = new Identities();
		CreateIdentityResponseVO createIdentityResponseVO = identities.createIdentity(createIdentityRequestVO);
		assertNull(createIdentityResponseVO);
	}
	@Test
	public void testCreateIdentity_AuthIsNull() {
		CreateIdentityRequestVO createIdentityRequestVO = new CreateIdentityRequestVO();
		createIdentityRequestVO.setAuth(null);
		
		identities = new Identities();
		CreateIdentityResponseVO createIdentityResponseVO = identities.createIdentity(createIdentityRequestVO);
		assertNull(createIdentityResponseVO);
	}
	@Test
	public void testCreateIdentity_AuthIsEmpty() {
		CreateIdentityRequestVO createIdentityRequestVO = new CreateIdentityRequestVO();
		createIdentityRequestVO.setAuth("");
		
		identities = new Identities();
		CreateIdentityResponseVO createIdentityResponseVO = identities.createIdentity(createIdentityRequestVO);
		assertNull(createIdentityResponseVO);
	}
	@Test
	public void testCreateIdentity_IdentityMapIsNull() {
		CreateIdentityRequestVO createIdentityRequestVO = new CreateIdentityRequestVO();
		createIdentityRequestVO.setAuth("auth");
		Map<String, Object> identityMap = null;
		createIdentityRequestVO.setIdentity(identityMap);
		
		identities = new Identities();
		CreateIdentityResponseVO createIdentityResponseVO = identities.createIdentity(createIdentityRequestVO);
		assertNull(createIdentityResponseVO);
	}
	@Test
	public void testCreateIdentity_IdentityMapIsEmpty() {
		CreateIdentityRequestVO createIdentityRequestVO = new CreateIdentityRequestVO();
		createIdentityRequestVO.setAuth("auth");
		Map<String, Object> identityMap = new HashMap<>();
		createIdentityRequestVO.setIdentity(identityMap);
		
		identities = new Identities();
		CreateIdentityResponseVO createIdentityResponseVO = identities.createIdentity(createIdentityRequestVO);
		assertNull(createIdentityResponseVO);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testCreateIdentity_ResponseIsNull() throws Exception {
		CreateIdentityRequestVO createIdentityRequestVO = new CreateIdentityRequestVO();
		createIdentityRequestVO.setAuth("auth");
		Map<String, Object> identityMap = new HashMap<>();
		identityMap.put("key", "value");		
		createIdentityRequestVO.setIdentity(identityMap);
		
		CreateIdentityResponseVO returnedCreateIdentityResponseVO = null;
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedCreateIdentityResponseVO);
		
		identities = new Identities();
		CreateIdentityResponseVO createIdentityResponseVO = identities.createIdentity(createIdentityRequestVO);
		assertNull(createIdentityResponseVO);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testCreateIdentity_Success() throws Exception {
		CreateIdentityRequestVO createIdentityRequestVO = new CreateIdentityRequestVO();
		createIdentityRequestVO.setAuth("auth");
		Map<String, Object> identityMap = new HashMap<>();
		identityMap.put("key", "value");		
		createIdentityRequestVO.setIdentity(identityMap);
		
		CreateIdentityResponseVO returnedCreateIdentityResponseVO = new CreateIdentityResponseVO();
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedCreateIdentityResponseVO);
		
		identities = new Identities();
		CreateIdentityResponseVO createIdentityResponseVO = identities.createIdentity(createIdentityRequestVO);
		assertNotNull(createIdentityResponseVO);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	
	@Test
	public void testUpdateIdentity_UpdateIdentityRequestVOIsNull() {
		UpdateIdentityRequestVO updateIdentityRequestVO = null;
		
		identities = new Identities();
		UpdateIdentityResponseVO updateIdentityResponseVO = identities.updateIdentity(updateIdentityRequestVO);
		assertNull(updateIdentityResponseVO);
	}
	@Test
	public void testUpdateIdentity_AuthIsNull() {
		UpdateIdentityRequestVO updateIdentityRequestVO = new UpdateIdentityRequestVO();
		updateIdentityRequestVO.setAuth(null);
		
		identities = new Identities();
		UpdateIdentityResponseVO updateIdentityResponseVO = identities.updateIdentity(updateIdentityRequestVO);
		assertNull(updateIdentityResponseVO);
	}
	@Test
	public void testUpdateIdentity_AuthIsEmpty() {
		UpdateIdentityRequestVO updateIdentityRequestVO = new UpdateIdentityRequestVO();
		updateIdentityRequestVO.setAuth("");
		
		identities = new Identities();
		UpdateIdentityResponseVO updateIdentityResponseVO = identities.updateIdentity(updateIdentityRequestVO);
		assertNull(updateIdentityResponseVO);
	}
	@Test
	public void testUpdateIdentity_IdentityMapIsNull() {
		UpdateIdentityRequestVO updateIdentityRequestVO = new UpdateIdentityRequestVO();
		updateIdentityRequestVO.setAuth("auth");
		Map<String, Object> identityMap = null;
		updateIdentityRequestVO.setIdentity(identityMap);
		
		identities = new Identities();
		UpdateIdentityResponseVO updateIdentityResponseVO = identities.updateIdentity(updateIdentityRequestVO);
		assertNull(updateIdentityResponseVO);
	}
	@Test
	public void testUpdateIdentity_IdentityMapIsEmpty() {
		UpdateIdentityRequestVO updateIdentityRequestVO = new UpdateIdentityRequestVO();
		updateIdentityRequestVO.setAuth("auth");
		Map<String, Object> identityMap = new HashMap<>();
		updateIdentityRequestVO.setIdentity(identityMap);
		
		identities = new Identities();
		UpdateIdentityResponseVO updateIdentityResponseVO = identities.updateIdentity(updateIdentityRequestVO);
		assertNull(updateIdentityResponseVO);
	}
	@Test
	public void testUpdateIdentity_UpdateMapIsNull() {
		UpdateIdentityRequestVO updateIdentityRequestVO = new UpdateIdentityRequestVO();
		updateIdentityRequestVO.setAuth("auth");
		Map<String, Object> identityMap = new HashMap<>();
		identityMap.put("key", "value");		
		updateIdentityRequestVO.setIdentity(identityMap);
		
		Map<String, Object> updateMap = null;
		updateIdentityRequestVO.setUpdate(updateMap);
		
		identities = new Identities();
		UpdateIdentityResponseVO updateIdentityResponseVO = identities.updateIdentity(updateIdentityRequestVO);
		assertNull(updateIdentityResponseVO);
	}
	@Test
	public void testUpdateIdentity_UpdateMapIsEmpty() {
		UpdateIdentityRequestVO updateIdentityRequestVO = new UpdateIdentityRequestVO();
		updateIdentityRequestVO.setAuth("auth");
		Map<String, Object> identityMap = new HashMap<>();
		identityMap.put("key", "value");		
		updateIdentityRequestVO.setIdentity(identityMap);
		
		Map<String, Object> updateMap = new HashMap<>();
		updateIdentityRequestVO.setUpdate(updateMap);
		
		identities = new Identities();
		UpdateIdentityResponseVO updateIdentityResponseVO = identities.updateIdentity(updateIdentityRequestVO);
		assertNull(updateIdentityResponseVO);
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testUpdateIdentity_ResponseIsNull() throws Exception {
		UpdateIdentityRequestVO updateIdentityRequestVO = new UpdateIdentityRequestVO();
		updateIdentityRequestVO.setAuth("auth");
		Map<String, Object> identityMap = new HashMap<>();
		identityMap.put("key", "value");		
		updateIdentityRequestVO.setIdentity(identityMap);
		
		Map<String, Object> updateMap = new HashMap<>();
		updateMap.put("key", "value");		
		updateIdentityRequestVO.setUpdate(updateMap);
		
		UpdateIdentityResponseVO returnedUpdateIdentityResponseVO = null;
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedUpdateIdentityResponseVO);
		
		identities = new Identities();
		UpdateIdentityResponseVO updateIdentityResponseVO = identities.updateIdentity(updateIdentityRequestVO);
		assertNull(updateIdentityResponseVO);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testUpdateIdentity_Success() throws Exception {
		UpdateIdentityRequestVO updateIdentityRequestVO = new UpdateIdentityRequestVO();
		updateIdentityRequestVO.setAuth("auth");
		Map<String, Object> identityMap = new HashMap<>();
		identityMap.put("key", "value");		
		updateIdentityRequestVO.setIdentity(identityMap);
		
		Map<String, Object> updateMap = new HashMap<>();
		updateMap.put("key", "value");		
		updateIdentityRequestVO.setUpdate(updateMap);
		
		UpdateIdentityResponseVO returnedUpdateIdentityResponseVO = new UpdateIdentityResponseVO();
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedUpdateIdentityResponseVO);
		
		identities = new Identities();
		UpdateIdentityResponseVO updateIdentityResponseVO = identities.updateIdentity(updateIdentityRequestVO);
		assertNotNull(updateIdentityResponseVO);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	
	@Test
	public void testDeleteIdentity_DeleteIdentityRequestVOIsNull() {
		DeleteIdentityRequestVO deleteIdentityRequestVO = null;
		
		identities = new Identities();
		DeleteIdentityResponseVO deleteIdentityResponseVO = identities.deleteIdentity(deleteIdentityRequestVO);
		assertNull(deleteIdentityResponseVO);
	}
	@Test
	public void testDeleteIdentity_AuthIsNull() {
		DeleteIdentityRequestVO deleteIdentityRequestVO = new DeleteIdentityRequestVO();
		deleteIdentityRequestVO.setAuth(null);
		
		identities = new Identities();
		DeleteIdentityResponseVO deleteIdentityResponseVO = identities.deleteIdentity(deleteIdentityRequestVO);
		assertNull(deleteIdentityResponseVO);
	}
	@Test
	public void testDeleteIdentity_AuthIsEmpty() {
		DeleteIdentityRequestVO deleteIdentityRequestVO = new DeleteIdentityRequestVO();
		deleteIdentityRequestVO.setAuth("");
		
		identities = new Identities();
		DeleteIdentityResponseVO deleteIdentityResponseVO = identities.deleteIdentity(deleteIdentityRequestVO);
		assertNull(deleteIdentityResponseVO);
	}
	@Test
	public void testDeleteIdentity_IdentityMapIsNull() {
		DeleteIdentityRequestVO deleteIdentityRequestVO = new DeleteIdentityRequestVO();
		deleteIdentityRequestVO.setAuth("auth");
		Map<String, Object> identityMap = null;
		deleteIdentityRequestVO.setIdentity(identityMap);
		
		identities = new Identities();
		DeleteIdentityResponseVO deleteIdentityResponseVO = identities.deleteIdentity(deleteIdentityRequestVO);
		assertNull(deleteIdentityResponseVO);
	}
	@Test
	public void testDeleteIdentity_IdentityMapIsEmpty() {
		DeleteIdentityRequestVO deleteIdentityRequestVO = new DeleteIdentityRequestVO();
		deleteIdentityRequestVO.setAuth("auth");
		Map<String, Object> identityMap = new HashMap<>();
		deleteIdentityRequestVO.setIdentity(identityMap);
		
		identities = new Identities();
		DeleteIdentityResponseVO deleteIdentityResponseVO = identities.deleteIdentity(deleteIdentityRequestVO);
		assertNull(deleteIdentityResponseVO);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testDeleteIdentity_ResultIsNull() throws Exception {
		DeleteIdentityRequestVO deleteIdentityRequestVO = new DeleteIdentityRequestVO();
		deleteIdentityRequestVO.setAuth("auth");
		Map<String, Object> identityMap = new HashMap<>();
		identityMap.put("key", "value");		
		deleteIdentityRequestVO.setIdentity(identityMap);
		
		Boolean result = null;
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(result);
		
		identities = new Identities();
		DeleteIdentityResponseVO deleteIdentityResponseVO = identities.deleteIdentity(deleteIdentityRequestVO);
		assertNotNull(deleteIdentityResponseVO);
		assertNull(deleteIdentityResponseVO.getResult());
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testDeleteIdentity_ResultIsFalse() throws Exception {
		DeleteIdentityRequestVO deleteIdentityRequestVO = new DeleteIdentityRequestVO();
		deleteIdentityRequestVO.setAuth("auth");
		Map<String, Object> identityMap = new HashMap<>();
		identityMap.put("key", "value");		
		deleteIdentityRequestVO.setIdentity(identityMap);
		
		Boolean result = false;
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(result);
		
		identities = new Identities();
		DeleteIdentityResponseVO deleteIdentityResponseVO = identities.deleteIdentity(deleteIdentityRequestVO);
		assertNotNull(deleteIdentityResponseVO);
		assertFalse(deleteIdentityResponseVO.getResult());
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testDeleteIdentity_Success() throws Exception {
		DeleteIdentityRequestVO deleteIdentityRequestVO = new DeleteIdentityRequestVO();
		deleteIdentityRequestVO.setAuth("auth");
		Map<String, Object> identityMap = new HashMap<>();
		identityMap.put("key", "value");		
		deleteIdentityRequestVO.setIdentity(identityMap);
		
		Boolean result = true;
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(result);
		
		identities = new Identities();
		DeleteIdentityResponseVO deleteIdentityResponseVO = identities.deleteIdentity(deleteIdentityRequestVO);
		assertNotNull(deleteIdentityResponseVO);
		assertTrue(deleteIdentityResponseVO.getResult());
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
}
