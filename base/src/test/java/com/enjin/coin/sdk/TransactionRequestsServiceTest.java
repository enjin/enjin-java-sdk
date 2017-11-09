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
import com.enjin.coin.sdk.vo.transactionrequest.CancelTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.CancelTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.CreateTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.CreateTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.GetTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.GetTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.ListTransactionRequestsRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.ListTransactionRequestsResponseVO;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TransactionRequestsService.class)
public class TransactionRequestsServiceTest {

	TransactionRequestsService transactionRequestsService;

	@Test
	public void testContructor1() {
		transactionRequestsService = new TransactionRequestsService();
		assertNotNull(transactionRequestsService);
		assertNotNull(transactionRequestsService.toString());
	}
	
	@Test
	public void testContructor2() {
		transactionRequestsService = new TransactionRequestsService("http://localhost:8080");
		assertNotNull(transactionRequestsService);
		assertNotNull(transactionRequestsService.toString());
	}
	@Test
	public void testContructor3() {
		transactionRequestsService = new TransactionRequestsService("http://localhost:8080", true);
		assertNotNull(transactionRequestsService);
		assertNotNull(transactionRequestsService.toString());
	}
	@Test
	public void testContructor4() {
		transactionRequestsService = new TransactionRequestsService(true);
		assertNotNull(transactionRequestsService);
		assertNotNull(transactionRequestsService.toString());
	}
	@Test
	public void testGetTransactionRequest_AuthIsNull() throws Exception {
		GetTransactionRequestRequestVO getTransactionRequestRequestVO = new GetTransactionRequestRequestVO();
		getTransactionRequestRequestVO.setAuth(null);
		getTransactionRequestRequestVO.setTxrId("txrId");
		
		transactionRequestsService = new TransactionRequestsService();
		GetTransactionRequestResponseVO getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
		assertNull(getTransactionRequestResponseVO);
	}
	@Test
	public void testGetTransactionRequest_AuthIsEmpty() throws Exception {
		GetTransactionRequestRequestVO getTransactionRequestRequestVO = new GetTransactionRequestRequestVO();
		getTransactionRequestRequestVO.setAuth("");
		getTransactionRequestRequestVO.setTxrId("txrId");
		
		transactionRequestsService = new TransactionRequestsService();
		GetTransactionRequestResponseVO getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
		assertNull(getTransactionRequestResponseVO);
	}
	@Test
	public void testGetTransactionRequest_TxrIdIsNull() throws Exception {
		GetTransactionRequestRequestVO getTransactionRequestRequestVO = new GetTransactionRequestRequestVO();
		getTransactionRequestRequestVO.setAuth("xxxxxxxx");
		getTransactionRequestRequestVO.setTxrId(null);
		
		transactionRequestsService = new TransactionRequestsService();
		GetTransactionRequestResponseVO getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
		assertNull(getTransactionRequestResponseVO);
	}
	@Test
	public void testGetTransactionRequest_TxrIdIsEmpty() throws Exception {
		GetTransactionRequestRequestVO getTransactionRequestRequestVO = new GetTransactionRequestRequestVO();
		getTransactionRequestRequestVO.setAuth("xxxxxxxx");
		getTransactionRequestRequestVO.setTxrId("");
		
		transactionRequestsService = new TransactionRequestsService();
		GetTransactionRequestResponseVO getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
		assertNull(getTransactionRequestResponseVO);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testGetTransactionRequest_ResponseIsNull() throws Exception {
		GetTransactionRequestRequestVO getTransactionRequestRequestVO = new GetTransactionRequestRequestVO();
		getTransactionRequestRequestVO.setAuth("xxxxxxxx");
		getTransactionRequestRequestVO.setTxrId("123456");
		
		GetTransactionRequestResponseVO returnedGetTransactionRequestResponseVO = null;
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTransactionRequestResponseVO);
		
		transactionRequestsService = new TransactionRequestsService();
		GetTransactionRequestResponseVO getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
		assertNull(getTransactionRequestResponseVO);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testGetTransactionRequest_Success() throws Exception {
		GetTransactionRequestRequestVO getTransactionRequestRequestVO = new GetTransactionRequestRequestVO();
		getTransactionRequestRequestVO.setAuth("xxxxxxxx");
		getTransactionRequestRequestVO.setTxrId("123456");
		
		GetTransactionRequestResponseVO returnedGetTransactionRequestResponseVO = new GetTransactionRequestResponseVO();
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTransactionRequestResponseVO);
		
		transactionRequestsService = new TransactionRequestsService();
		GetTransactionRequestResponseVO getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
		assertNotNull(getTransactionRequestResponseVO);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	
	@Test
	public void testListTransactionRequests_ListTransactionRequestsRequestVOIsNull() throws Exception {
		ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = null;
		
		transactionRequestsService = new TransactionRequestsService();
		ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
		assertNull(listTransactionRequestsResponseVOArray);
	}
	
	@Test
	public void testListTransactionRequests_AuthIsEmpty() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("identity_id", "12345");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("identity_id", "54321");
		
		ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = new ListTransactionRequestsRequestVO();
		listTransactionRequestsRequestVO.setAuth("");
		listTransactionRequestsRequestVO.setIdentityMap(listIdentityMap);
		listTransactionRequestsRequestVO.setAppId("appId");
		listTransactionRequestsRequestVO.setRecipientMap(listRecipientMap);
		listTransactionRequestsRequestVO.setType("buy");
		listTransactionRequestsRequestVO.setAfterTxrId("after");
		listTransactionRequestsRequestVO.setLimit("50");
		listTransactionRequestsRequestVO.setCurrency("currency");
		
		transactionRequestsService = new TransactionRequestsService();
		ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
		assertNull(listTransactionRequestsResponseVOArray);
	}
	
	@Test
	public void testListTransactionRequests_AuthIsNull() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("identity_id", "12345");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("identity_id", "54321");
		
		ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = new ListTransactionRequestsRequestVO();
		listTransactionRequestsRequestVO.setAuth(null);
		listTransactionRequestsRequestVO.setIdentityMap(listIdentityMap);
		listTransactionRequestsRequestVO.setAppId("appId");
		listTransactionRequestsRequestVO.setRecipientMap(listRecipientMap);
		listTransactionRequestsRequestVO.setType("buy");
		listTransactionRequestsRequestVO.setAfterTxrId("after");
		listTransactionRequestsRequestVO.setLimit("50");
		listTransactionRequestsRequestVO.setCurrency("currency");
		
		transactionRequestsService = new TransactionRequestsService();
		ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
		assertNull(listTransactionRequestsResponseVOArray);
	}
	
	@Test
	public void testListTransactionRequests_IdentityMaoIsEmpty() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("identity_id", "54321");
		
		ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = new ListTransactionRequestsRequestVO();
		listTransactionRequestsRequestVO.setAuth("xxxxxxxx");
		listTransactionRequestsRequestVO.setIdentityMap(listIdentityMap);
		listTransactionRequestsRequestVO.setAppId("1233");
		listTransactionRequestsRequestVO.setRecipientMap(listRecipientMap);
		listTransactionRequestsRequestVO.setType("buy");
		listTransactionRequestsRequestVO.setAfterTxrId("after");
		listTransactionRequestsRequestVO.setLimit("50");
		listTransactionRequestsRequestVO.setCurrency("currency");
		
		transactionRequestsService = new TransactionRequestsService();
		ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
		assertNull(listTransactionRequestsResponseVOArray);
	}
	@Test
	public void testListTransactionRequests_IdentityMaoIsNull() throws Exception {
		Map<String, Object> listIdentityMap = null;
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("identity_id", "54321");
		
		ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = new ListTransactionRequestsRequestVO();
		listTransactionRequestsRequestVO.setAuth("xxxxxxxx");
		listTransactionRequestsRequestVO.setIdentityMap(listIdentityMap);
		listTransactionRequestsRequestVO.setAppId("1233");
		listTransactionRequestsRequestVO.setRecipientMap(listRecipientMap);
		listTransactionRequestsRequestVO.setType("buy");
		listTransactionRequestsRequestVO.setAfterTxrId("after");
		listTransactionRequestsRequestVO.setLimit("50");
		listTransactionRequestsRequestVO.setCurrency("currency");
		
		transactionRequestsService = new TransactionRequestsService();
		ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
		assertNull(listTransactionRequestsResponseVOArray);
	}
	
	@Test
	public void testListTransactionRequests_AppIdIsEmpty() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("identity_id", "12345");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("identity_id", "54321");
		
		ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = new ListTransactionRequestsRequestVO();
		listTransactionRequestsRequestVO.setAuth("xxxxxxxx");
		listTransactionRequestsRequestVO.setIdentityMap(listIdentityMap);
		listTransactionRequestsRequestVO.setAppId("");
		listTransactionRequestsRequestVO.setRecipientMap(listRecipientMap);
		listTransactionRequestsRequestVO.setType("buy");
		listTransactionRequestsRequestVO.setAfterTxrId("after");
		listTransactionRequestsRequestVO.setLimit("50");
		listTransactionRequestsRequestVO.setCurrency("currency");
		
		transactionRequestsService = new TransactionRequestsService();
		ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
		assertNull(listTransactionRequestsResponseVOArray);
	}
	@Test
	public void testListTransactionRequests_AppIdIsNull() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("identity_id", "12345");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("identity_id", "54321");
		
		ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = new ListTransactionRequestsRequestVO();
		listTransactionRequestsRequestVO.setAuth("xxxxxxxx");
		listTransactionRequestsRequestVO.setIdentityMap(listIdentityMap);
		listTransactionRequestsRequestVO.setAppId(null);
		listTransactionRequestsRequestVO.setRecipientMap(listRecipientMap);
		listTransactionRequestsRequestVO.setType("buy");
		listTransactionRequestsRequestVO.setAfterTxrId("after");
		listTransactionRequestsRequestVO.setLimit("50");
		listTransactionRequestsRequestVO.setCurrency("currency");
		
		transactionRequestsService = new TransactionRequestsService();
		ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
		assertNull(listTransactionRequestsResponseVOArray);
	}
	@Test
	public void testListTransactionRequests_RecipientMapIsEmpty() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("identity_id", "12345");
		Map<String, Object> listRecipientMap = new HashMap<>();
		
		ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = new ListTransactionRequestsRequestVO();
		listTransactionRequestsRequestVO.setAuth("xxxxxxxx");
		listTransactionRequestsRequestVO.setIdentityMap(listIdentityMap);
		listTransactionRequestsRequestVO.setAppId("123");
		listTransactionRequestsRequestVO.setRecipientMap(listRecipientMap);
		listTransactionRequestsRequestVO.setType("buy");
		listTransactionRequestsRequestVO.setAfterTxrId("after");
		listTransactionRequestsRequestVO.setLimit("50");
		listTransactionRequestsRequestVO.setCurrency("currency");
		
		transactionRequestsService = new TransactionRequestsService();
		ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
		assertNull(listTransactionRequestsResponseVOArray);
	}
	@Test
	public void testListTransactionRequests_RecipientMapIsNull() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("identity_id", "12345");
		Map<String, Object> listRecipientMap = null;
		
		ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = new ListTransactionRequestsRequestVO();
		listTransactionRequestsRequestVO.setAuth("xxxxxxxx");
		listTransactionRequestsRequestVO.setIdentityMap(listIdentityMap);
		listTransactionRequestsRequestVO.setAppId("123");
		listTransactionRequestsRequestVO.setRecipientMap(listRecipientMap);
		listTransactionRequestsRequestVO.setType("buy");
		listTransactionRequestsRequestVO.setAfterTxrId("after");
		listTransactionRequestsRequestVO.setLimit("50");
		listTransactionRequestsRequestVO.setCurrency("currency");
		
		transactionRequestsService = new TransactionRequestsService();
		ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
		assertNull(listTransactionRequestsResponseVOArray);
	}
	@Test
	public void testListTransactionRequests_TypeIsEmpty() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("identity_id", "12345");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("identity_id", "54321");
		
		ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = new ListTransactionRequestsRequestVO();
		listTransactionRequestsRequestVO.setAuth("xxxxxxxx");
		listTransactionRequestsRequestVO.setIdentityMap(listIdentityMap);
		listTransactionRequestsRequestVO.setAppId("123");
		listTransactionRequestsRequestVO.setRecipientMap(listRecipientMap);
		listTransactionRequestsRequestVO.setType("");
		listTransactionRequestsRequestVO.setAfterTxrId("after");
		listTransactionRequestsRequestVO.setLimit("50");
		listTransactionRequestsRequestVO.setCurrency("currency");
		
		transactionRequestsService = new TransactionRequestsService();
		ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
		assertNull(listTransactionRequestsResponseVOArray);
	}
	@Test
	public void testListTransactionRequests_TypeIsNull() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("identity_id", "12345");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("identity_id", "54321");
		
		ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = new ListTransactionRequestsRequestVO();
		listTransactionRequestsRequestVO.setAuth("xxxxxxxx");
		listTransactionRequestsRequestVO.setIdentityMap(listIdentityMap);
		listTransactionRequestsRequestVO.setAppId("123");
		listTransactionRequestsRequestVO.setRecipientMap(listRecipientMap);
		listTransactionRequestsRequestVO.setType(null);
		listTransactionRequestsRequestVO.setAfterTxrId("after");
		listTransactionRequestsRequestVO.setLimit("50");
		listTransactionRequestsRequestVO.setCurrency("currency");
		
		transactionRequestsService = new TransactionRequestsService();
		ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
		assertNull(listTransactionRequestsResponseVOArray);
	}
	@Test
	public void testListTransactionRequests_AfterTxrIsEmpty() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("identity_id", "12345");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("identity_id", "54321");
		
		ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = new ListTransactionRequestsRequestVO();
		listTransactionRequestsRequestVO.setAuth("xxxxxxxx");
		listTransactionRequestsRequestVO.setIdentityMap(listIdentityMap);
		listTransactionRequestsRequestVO.setAppId("123");
		listTransactionRequestsRequestVO.setRecipientMap(listRecipientMap);
		listTransactionRequestsRequestVO.setType("buy");
		listTransactionRequestsRequestVO.setAfterTxrId("");
		listTransactionRequestsRequestVO.setLimit("50");
		listTransactionRequestsRequestVO.setCurrency("currency");
		
		transactionRequestsService = new TransactionRequestsService();
		ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
		assertNull(listTransactionRequestsResponseVOArray);
	}
	@Test
	public void testListTransactionRequests_AfterTxrIsNull() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("identity_id", "12345");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("identity_id", "54321");
		
		ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = new ListTransactionRequestsRequestVO();
		listTransactionRequestsRequestVO.setAuth("xxxxxxxx");
		listTransactionRequestsRequestVO.setIdentityMap(listIdentityMap);
		listTransactionRequestsRequestVO.setAppId("123");
		listTransactionRequestsRequestVO.setRecipientMap(listRecipientMap);
		listTransactionRequestsRequestVO.setType("buy");
		listTransactionRequestsRequestVO.setAfterTxrId(null);
		listTransactionRequestsRequestVO.setLimit("50");
		listTransactionRequestsRequestVO.setCurrency("currency");
		
		transactionRequestsService = new TransactionRequestsService();
		ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
		assertNull(listTransactionRequestsResponseVOArray);
	}
	@Test
	public void testListTransactionRequests_LimitIsEmpty() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("identity_id", "12345");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("identity_id", "54321");
		
		ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = new ListTransactionRequestsRequestVO();
		listTransactionRequestsRequestVO.setAuth("xxxxxxxx");
		listTransactionRequestsRequestVO.setIdentityMap(listIdentityMap);
		listTransactionRequestsRequestVO.setAppId("123");
		listTransactionRequestsRequestVO.setRecipientMap(listRecipientMap);
		listTransactionRequestsRequestVO.setType("buy");
		listTransactionRequestsRequestVO.setAfterTxrId("1234567");
		listTransactionRequestsRequestVO.setLimit("");
		listTransactionRequestsRequestVO.setCurrency("currency");
		
		transactionRequestsService = new TransactionRequestsService();
		ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
		assertNull(listTransactionRequestsResponseVOArray);
	}
	@Test
	public void testListTransactionRequests_LimitIsNull() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("identity_id", "12345");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("identity_id", "54321");
		
		ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = new ListTransactionRequestsRequestVO();
		listTransactionRequestsRequestVO.setAuth("xxxxxxxx");
		listTransactionRequestsRequestVO.setIdentityMap(listIdentityMap);
		listTransactionRequestsRequestVO.setAppId("123");
		listTransactionRequestsRequestVO.setRecipientMap(listRecipientMap);
		listTransactionRequestsRequestVO.setType("buy");
		listTransactionRequestsRequestVO.setAfterTxrId("1234567");
		listTransactionRequestsRequestVO.setLimit(null);
		listTransactionRequestsRequestVO.setCurrency("currency");
		
		transactionRequestsService = new TransactionRequestsService();
		ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
		assertNull(listTransactionRequestsResponseVOArray);
	}
	@Test
	public void testListTransactionRequests_CurrencyIsEmpty() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("identity_id", "12345");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("identity_id", "54321");
		
		ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = new ListTransactionRequestsRequestVO();
		listTransactionRequestsRequestVO.setAuth("xxxxxxxx");
		listTransactionRequestsRequestVO.setIdentityMap(listIdentityMap);
		listTransactionRequestsRequestVO.setAppId("123");
		listTransactionRequestsRequestVO.setRecipientMap(listRecipientMap);
		listTransactionRequestsRequestVO.setType("buy");
		listTransactionRequestsRequestVO.setAfterTxrId("1234567");
		listTransactionRequestsRequestVO.setLimit("50");
		listTransactionRequestsRequestVO.setCurrency("");
		
		transactionRequestsService = new TransactionRequestsService();
		ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
		assertNull(listTransactionRequestsResponseVOArray);
	}
	@Test
	public void testListTransactionRequests_CurrencyIsNully() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("identity_id", "12345");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("identity_id", "54321");
		
		ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = new ListTransactionRequestsRequestVO();
		listTransactionRequestsRequestVO.setAuth("xxxxxxxx");
		listTransactionRequestsRequestVO.setIdentityMap(listIdentityMap);
		listTransactionRequestsRequestVO.setAppId("123");
		listTransactionRequestsRequestVO.setRecipientMap(listRecipientMap);
		listTransactionRequestsRequestVO.setType("buy");
		listTransactionRequestsRequestVO.setAfterTxrId("1234567");
		listTransactionRequestsRequestVO.setLimit("50");
		listTransactionRequestsRequestVO.setCurrency(null);
		
		transactionRequestsService = new TransactionRequestsService();
		ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
		assertNull(listTransactionRequestsResponseVOArray);
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testListTransactionRequests_NullResponseReturned() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("identity_id", "12345");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("identity_id", "54321");
		
		ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = new ListTransactionRequestsRequestVO();
		listTransactionRequestsRequestVO.setAuth("xxxxxxxx");
		listTransactionRequestsRequestVO.setIdentityMap(listIdentityMap);
		listTransactionRequestsRequestVO.setAppId("123");
		listTransactionRequestsRequestVO.setRecipientMap(listRecipientMap);
		listTransactionRequestsRequestVO.setType("buy");
		listTransactionRequestsRequestVO.setAfterTxrId("1234567");
		listTransactionRequestsRequestVO.setLimit("50");
		listTransactionRequestsRequestVO.setCurrency("23456");
		
		ListTransactionRequestsResponseVO[] returnedListTransactionRequestsResponseVOArray = null;
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListTransactionRequestsResponseVOArray);
		
		transactionRequestsService = new TransactionRequestsService();
		ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
		assertNull(listTransactionRequestsResponseVOArray);

		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testListTransactionRequests_NoResponseReturned() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("identity_id", "12345");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("identity_id", "54321");
		
		ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = new ListTransactionRequestsRequestVO();
		listTransactionRequestsRequestVO.setAuth("xxxxxxxx");
		listTransactionRequestsRequestVO.setIdentityMap(listIdentityMap);
		listTransactionRequestsRequestVO.setAppId("123");
		listTransactionRequestsRequestVO.setRecipientMap(listRecipientMap);
		listTransactionRequestsRequestVO.setType("buy");
		listTransactionRequestsRequestVO.setAfterTxrId("1234567");
		listTransactionRequestsRequestVO.setLimit("50");
		listTransactionRequestsRequestVO.setCurrency("23456");
		
		ListTransactionRequestsResponseVO[] returnedListTransactionRequestsResponseVOArray = new ListTransactionRequestsResponseVO[] {};
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListTransactionRequestsResponseVOArray);
		
		transactionRequestsService = new TransactionRequestsService();
		ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
		assertNotNull(listTransactionRequestsResponseVOArray);
		assertTrue(listTransactionRequestsResponseVOArray.length == 0);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testListTransactionRequests_Success() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("identity_id", "12345");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("identity_id", "54321");
		
		ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = new ListTransactionRequestsRequestVO();
		listTransactionRequestsRequestVO.setAuth("xxxxxxxx");
		listTransactionRequestsRequestVO.setIdentityMap(listIdentityMap);
		listTransactionRequestsRequestVO.setAppId("123");
		listTransactionRequestsRequestVO.setRecipientMap(listRecipientMap);
		listTransactionRequestsRequestVO.setType("buy");
		listTransactionRequestsRequestVO.setAfterTxrId("1234567");
		listTransactionRequestsRequestVO.setLimit("50");
		listTransactionRequestsRequestVO.setCurrency("23456");
		
		ListTransactionRequestsResponseVO[] returnedListTransactionRequestsResponseVOArray = new ListTransactionRequestsResponseVO[] {new ListTransactionRequestsResponseVO()};
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListTransactionRequestsResponseVOArray);
		
		transactionRequestsService = new TransactionRequestsService();
		ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
		assertNotNull(listTransactionRequestsResponseVOArray);
		assertTrue(listTransactionRequestsResponseVOArray.length == 1);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	
	@Test
	public void testCreateTransactionRequest_CreateTransactionRequestRequestVOIsNull() throws Exception {
		CreateTransactionRequestRequestVO createTransactionRequestRequestVO = null;

		transactionRequestsService = new TransactionRequestsService();
		CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
		assertNull(createTransactionRequestResponseVO);
	}
	
	@Test
	public void testCreateTransactionRequest_AuthIsNull() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("player_name", "Joe");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("player_name", "Alice");
		Map<String, Object> createValueMap = new HashMap<>();
		createValueMap.put("ENJ", "3000000000000000000");
		
		CreateTransactionRequestRequestVO createTransactionRequestRequestVO = new CreateTransactionRequestRequestVO();
		createTransactionRequestRequestVO.setAuth(null);
		createTransactionRequestRequestVO.setIdentityMap(listIdentityMap);
		createTransactionRequestRequestVO.setRecipientMap(listRecipientMap);
		createTransactionRequestRequestVO.setType("type");
		createTransactionRequestRequestVO.setIcon("icon");
		createTransactionRequestRequestVO.setTitle("title");
		createTransactionRequestRequestVO.setValueMap(createValueMap);
		
		transactionRequestsService = new TransactionRequestsService();
		CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
		assertNull(createTransactionRequestResponseVO);
	}
	@Test
	public void testCreateTransactionRequest_AuthIsEmpty() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("player_name", "Joe");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("player_name", "Alice");
		Map<String, Object> createValueMap = new HashMap<>();
		createValueMap.put("ENJ", "3000000000000000000");
		
		CreateTransactionRequestRequestVO createTransactionRequestRequestVO = new CreateTransactionRequestRequestVO();
		createTransactionRequestRequestVO.setAuth("");
		createTransactionRequestRequestVO.setIdentityMap(listIdentityMap);
		createTransactionRequestRequestVO.setRecipientMap(listRecipientMap);
		createTransactionRequestRequestVO.setType("type");
		createTransactionRequestRequestVO.setIcon("icon");
		createTransactionRequestRequestVO.setTitle("title");
		createTransactionRequestRequestVO.setValueMap(createValueMap);
		
		transactionRequestsService = new TransactionRequestsService();
		CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
		assertNull(createTransactionRequestResponseVO);
	}
	
	@Test
	public void testCreateTransactionRequest_IdentityMapIsNull() {
		Map<String, Object> listIdentityMap = null;
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("player_name", "Alice");
		Map<String, Object> createValueMap = new HashMap<>();
		createValueMap.put("ENJ", "3000000000000000000");
		
		CreateTransactionRequestRequestVO createTransactionRequestRequestVO = new CreateTransactionRequestRequestVO();
		createTransactionRequestRequestVO.setAuth("xxxxxxxx");
		createTransactionRequestRequestVO.setIdentityMap(listIdentityMap);
		createTransactionRequestRequestVO.setRecipientMap(listRecipientMap);
		createTransactionRequestRequestVO.setType("type");
		createTransactionRequestRequestVO.setIcon("icon");
		createTransactionRequestRequestVO.setTitle("title");
		createTransactionRequestRequestVO.setValueMap(createValueMap);
		
		transactionRequestsService = new TransactionRequestsService();
		CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
		assertNull(createTransactionRequestResponseVO);
	}
	
	@Test
	public void testCreateTransactionRequest_IdentityMapIsEmpty() {
		Map<String, Object> listIdentityMap = new HashMap<>();
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("player_name", "Alice");
		Map<String, Object> createValueMap = new HashMap<>();
		createValueMap.put("ENJ", "3000000000000000000");
		
		CreateTransactionRequestRequestVO createTransactionRequestRequestVO = new CreateTransactionRequestRequestVO();
		createTransactionRequestRequestVO.setAuth("xxxxxxxx");
		createTransactionRequestRequestVO.setIdentityMap(listIdentityMap);
		createTransactionRequestRequestVO.setRecipientMap(listRecipientMap);
		createTransactionRequestRequestVO.setType("type");
		createTransactionRequestRequestVO.setIcon("icon");
		createTransactionRequestRequestVO.setTitle("title");
		createTransactionRequestRequestVO.setValueMap(createValueMap);
		
		transactionRequestsService = new TransactionRequestsService();
		CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
		assertNull(createTransactionRequestResponseVO);
	}
	
	@Test
	public void testCreateTransactionRequest_RecipientMapIsNull() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("player_name", "Joe");
		Map<String, Object> listRecipientMap = null;
		Map<String, Object> createValueMap = new HashMap<>();
		createValueMap.put("ENJ", "3000000000000000000");
		
		CreateTransactionRequestRequestVO createTransactionRequestRequestVO = new CreateTransactionRequestRequestVO();
		createTransactionRequestRequestVO.setAuth("xxxxxxxx");
		createTransactionRequestRequestVO.setIdentityMap(listIdentityMap);
		createTransactionRequestRequestVO.setRecipientMap(listRecipientMap);
		createTransactionRequestRequestVO.setType("type");
		createTransactionRequestRequestVO.setIcon("icon");
		createTransactionRequestRequestVO.setTitle("title");
		createTransactionRequestRequestVO.setValueMap(createValueMap);
		
		transactionRequestsService = new TransactionRequestsService();
		CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
		assertNull(createTransactionRequestResponseVO);
	}
	
	
	@Test
	public void testCreateTransactionRequest_RecipientMapIsEmpty() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("player_name", "Joe");
		Map<String, Object> listRecipientMap = new HashMap<>();
		Map<String, Object> createValueMap = new HashMap<>();
		createValueMap.put("ENJ", "3000000000000000000");
		
		CreateTransactionRequestRequestVO createTransactionRequestRequestVO = new CreateTransactionRequestRequestVO();
		createTransactionRequestRequestVO.setAuth("xxxxxxxx");
		createTransactionRequestRequestVO.setIdentityMap(listIdentityMap);
		createTransactionRequestRequestVO.setRecipientMap(listRecipientMap);
		createTransactionRequestRequestVO.setType("type");
		createTransactionRequestRequestVO.setIcon("icon");
		createTransactionRequestRequestVO.setTitle("title");
		createTransactionRequestRequestVO.setValueMap(createValueMap);
		
		transactionRequestsService = new TransactionRequestsService();
		CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
		assertNull(createTransactionRequestResponseVO);
	}
	
	
	@Test
	public void testCreateTransactionRequest_TypeIsNull() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("player_name", "Joe");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("player_name", "Alice");
		Map<String, Object> createValueMap = new HashMap<>();
		createValueMap.put("ENJ", "3000000000000000000");
		
		CreateTransactionRequestRequestVO createTransactionRequestRequestVO = new CreateTransactionRequestRequestVO();
		createTransactionRequestRequestVO.setAuth("xxxxxxxx");
		createTransactionRequestRequestVO.setIdentityMap(listIdentityMap);
		createTransactionRequestRequestVO.setRecipientMap(listRecipientMap);
		createTransactionRequestRequestVO.setType(null);
		createTransactionRequestRequestVO.setIcon("icon");
		createTransactionRequestRequestVO.setTitle("title");
		createTransactionRequestRequestVO.setValueMap(createValueMap);
		
		transactionRequestsService = new TransactionRequestsService();
		CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
		assertNull(createTransactionRequestResponseVO);
	}
	@Test
	public void testCreateTransactionRequest_TypeIsEmpty() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("player_name", "Joe");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("player_name", "Alice");
		Map<String, Object> createValueMap = new HashMap<>();
		createValueMap.put("ENJ", "3000000000000000000");
		
		CreateTransactionRequestRequestVO createTransactionRequestRequestVO = new CreateTransactionRequestRequestVO();
		createTransactionRequestRequestVO.setAuth("xxxxxxxx");
		createTransactionRequestRequestVO.setIdentityMap(listIdentityMap);
		createTransactionRequestRequestVO.setRecipientMap(listRecipientMap);
		createTransactionRequestRequestVO.setType("");
		createTransactionRequestRequestVO.setIcon("icon");
		createTransactionRequestRequestVO.setTitle("title");
		createTransactionRequestRequestVO.setValueMap(createValueMap);
		
		transactionRequestsService = new TransactionRequestsService();
		CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
		assertNull(createTransactionRequestResponseVO);
	}
	
	@Test
	public void testCreateTransactionRequest_IconIsNull() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("player_name", "Joe");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("player_name", "Alice");
		Map<String, Object> createValueMap = new HashMap<>();
		createValueMap.put("ENJ", "3000000000000000000");
		
		CreateTransactionRequestRequestVO createTransactionRequestRequestVO = new CreateTransactionRequestRequestVO();
		createTransactionRequestRequestVO.setAuth("xxxxxxxx");
		createTransactionRequestRequestVO.setIdentityMap(listIdentityMap);
		createTransactionRequestRequestVO.setRecipientMap(listRecipientMap);
		createTransactionRequestRequestVO.setType("send");
		createTransactionRequestRequestVO.setIcon(null);
		createTransactionRequestRequestVO.setTitle("title");
		createTransactionRequestRequestVO.setValueMap(createValueMap);
		
		transactionRequestsService = new TransactionRequestsService();
		CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
		assertNull(createTransactionRequestResponseVO);
	}
	@Test
	public void testCreateTransactionRequest_IconIEmpty() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("player_name", "Joe");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("player_name", "Alice");
		Map<String, Object> createValueMap = new HashMap<>();
		createValueMap.put("ENJ", "3000000000000000000");
		
		CreateTransactionRequestRequestVO createTransactionRequestRequestVO = new CreateTransactionRequestRequestVO();
		createTransactionRequestRequestVO.setAuth("xxxxxxxx");
		createTransactionRequestRequestVO.setIdentityMap(listIdentityMap);
		createTransactionRequestRequestVO.setRecipientMap(listRecipientMap);
		createTransactionRequestRequestVO.setType("send");
		createTransactionRequestRequestVO.setIcon("");
		createTransactionRequestRequestVO.setTitle("title");
		createTransactionRequestRequestVO.setValueMap(createValueMap);
		
		transactionRequestsService = new TransactionRequestsService();
		CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
		assertNull(createTransactionRequestResponseVO);
	}
	@Test
	public void testCreateTransactionRequest_TitleIsNull() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("player_name", "Joe");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("player_name", "Alice");
		Map<String, Object> createValueMap = new HashMap<>();
		createValueMap.put("ENJ", "3000000000000000000");
		
		CreateTransactionRequestRequestVO createTransactionRequestRequestVO = new CreateTransactionRequestRequestVO();
		createTransactionRequestRequestVO.setAuth("xxxxxxxx");
		createTransactionRequestRequestVO.setIdentityMap(listIdentityMap);
		createTransactionRequestRequestVO.setRecipientMap(listRecipientMap);
		createTransactionRequestRequestVO.setType("send");
		createTransactionRequestRequestVO.setIcon("https://enjincoin.io/images/bubble.png");
		createTransactionRequestRequestVO.setTitle(null);
		createTransactionRequestRequestVO.setValueMap(createValueMap);
		
		transactionRequestsService = new TransactionRequestsService();
		CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
		assertNull(createTransactionRequestResponseVO);
	}
	@Test
	public void testCreateTransactionRequest_TitleIsEmpty() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("player_name", "Joe");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("player_name", "Alice");
		Map<String, Object> createValueMap = new HashMap<>();
		createValueMap.put("ENJ", "3000000000000000000");
		
		CreateTransactionRequestRequestVO createTransactionRequestRequestVO = new CreateTransactionRequestRequestVO();
		createTransactionRequestRequestVO.setAuth("xxxxxxxx");
		createTransactionRequestRequestVO.setIdentityMap(listIdentityMap);
		createTransactionRequestRequestVO.setRecipientMap(listRecipientMap);
		createTransactionRequestRequestVO.setType("send");
		createTransactionRequestRequestVO.setIcon("https://enjincoin.io/images/bubble.png");
		createTransactionRequestRequestVO.setTitle(null);
		createTransactionRequestRequestVO.setValueMap(createValueMap);
		
		transactionRequestsService = new TransactionRequestsService();
		CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
		assertNull(createTransactionRequestResponseVO);
	}
	@Test
	public void testCreateTransactionRequest_ValueMapIsNull() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("player_name", "Joe");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("player_name", "Alice");
		Map<String, Object> createValueMap = null;
		
		CreateTransactionRequestRequestVO createTransactionRequestRequestVO = new CreateTransactionRequestRequestVO();
		createTransactionRequestRequestVO.setAuth("xxxxxxxx");
		createTransactionRequestRequestVO.setIdentityMap(listIdentityMap);
		createTransactionRequestRequestVO.setRecipientMap(listRecipientMap);
		createTransactionRequestRequestVO.setType("send");
		createTransactionRequestRequestVO.setIcon("https://enjincoin.io/images/bubble.png");
		createTransactionRequestRequestVO.setTitle("Mineplex: /transfer alice 3 ENJ");
		createTransactionRequestRequestVO.setValueMap(createValueMap);
		
		transactionRequestsService = new TransactionRequestsService();
		CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
		assertNull(createTransactionRequestResponseVO);
	}
	@Test
	public void testCreateTransactionRequest_ValueMapIsEmpty() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("player_name", "Joe");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("player_name", "Alice");
		Map<String, Object> createValueMap = new HashMap<>();
		
		CreateTransactionRequestRequestVO createTransactionRequestRequestVO = new CreateTransactionRequestRequestVO();
		createTransactionRequestRequestVO.setAuth("xxxxxxxx");
		createTransactionRequestRequestVO.setIdentityMap(listIdentityMap);
		createTransactionRequestRequestVO.setRecipientMap(listRecipientMap);
		createTransactionRequestRequestVO.setType("send");
		createTransactionRequestRequestVO.setIcon("https://enjincoin.io/images/bubble.png");
		createTransactionRequestRequestVO.setTitle("Mineplex: /transfer alice 3 ENJ");
		createTransactionRequestRequestVO.setValueMap(createValueMap);
		
		transactionRequestsService = new TransactionRequestsService();
		CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
		assertNull(createTransactionRequestResponseVO);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testCreateTransactionRequest_NullResponse() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("player_name", "Joe");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("player_name", "Alice");
		Map<String, Object> createValueMap = new HashMap<>();
		createValueMap.put("ENJ", "3000000000000000000");
		
		CreateTransactionRequestRequestVO createTransactionRequestRequestVO = new CreateTransactionRequestRequestVO();
		createTransactionRequestRequestVO.setAuth("xxxxxxxx");
		createTransactionRequestRequestVO.setIdentityMap(listIdentityMap);
		createTransactionRequestRequestVO.setRecipientMap(listRecipientMap);
		createTransactionRequestRequestVO.setType("send");
		createTransactionRequestRequestVO.setIcon("https://enjincoin.io/images/bubble.png");
		createTransactionRequestRequestVO.setTitle("Mineplex: /transfer alice 3 ENJ");
		createTransactionRequestRequestVO.setValueMap(createValueMap);
		
		CreateTransactionRequestResponseVO returnedCreateTransactionRequestResponseVO = null;
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedCreateTransactionRequestResponseVO);
		
		transactionRequestsService = new TransactionRequestsService();
		CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
		assertNull(createTransactionRequestResponseVO);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testCreateTransactionRequest_Success() throws Exception {
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("player_name", "Joe");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("player_name", "Alice");
		Map<String, Object> createValueMap = new HashMap<>();
		createValueMap.put("ENJ", "3000000000000000000");
		
		CreateTransactionRequestRequestVO createTransactionRequestRequestVO = new CreateTransactionRequestRequestVO();
		createTransactionRequestRequestVO.setAuth("xxxxxxxx");
		createTransactionRequestRequestVO.setIdentityMap(listIdentityMap);
		createTransactionRequestRequestVO.setRecipientMap(listRecipientMap);
		createTransactionRequestRequestVO.setType("send");
		createTransactionRequestRequestVO.setIcon("https://enjincoin.io/images/bubble.png");
		createTransactionRequestRequestVO.setTitle("Mineplex: /transfer alice 3 ENJ");
		createTransactionRequestRequestVO.setValueMap(createValueMap);
		
		CreateTransactionRequestResponseVO returnedCreateTransactionRequestResponseVO = new CreateTransactionRequestResponseVO();
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedCreateTransactionRequestResponseVO);
		
		transactionRequestsService = new TransactionRequestsService();
		CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
		assertNotNull(createTransactionRequestResponseVO);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	@Test
	public void testCancelTransactionRequest_CancelTransactionRequestRequestVOIsNull() throws Exception {
		CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = null;

		transactionRequestsService = new TransactionRequestsService();
		CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequestsService.cancelTransactionRequest(cancelTransactionRequestRequestVO);
		assertNull(cancelTransactionRequestResponseVO);
	}
	@Test
	public void testCancelTransactionRequest_AuthIsNull() throws Exception {
		CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = new CancelTransactionRequestRequestVO();
		cancelTransactionRequestRequestVO.setAuth(null);
		cancelTransactionRequestRequestVO.setTxrId("1234");

		transactionRequestsService = new TransactionRequestsService();
		CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequestsService.cancelTransactionRequest(cancelTransactionRequestRequestVO);
		assertNull(cancelTransactionRequestResponseVO);
	}
	@Test
	public void testCancelTransactionRequest_AuthIsEmpty() throws Exception {
		CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = new CancelTransactionRequestRequestVO();
		cancelTransactionRequestRequestVO.setAuth("");
		cancelTransactionRequestRequestVO.setTxrId("1234");

		transactionRequestsService = new TransactionRequestsService();
		CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequestsService.cancelTransactionRequest(cancelTransactionRequestRequestVO);
		assertNull(cancelTransactionRequestResponseVO);
	}
	@Test
	public void testCancelTransactionRequest_TxrIdIsNull() throws Exception {
		CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = new CancelTransactionRequestRequestVO();
		cancelTransactionRequestRequestVO.setAuth("xxxxxxxx");
		cancelTransactionRequestRequestVO.setTxrId(null);

		transactionRequestsService = new TransactionRequestsService();
		CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequestsService.cancelTransactionRequest(cancelTransactionRequestRequestVO);
		assertNull(cancelTransactionRequestResponseVO);
	}
	
	@Test
	public void testCancelTransactionRequest_TxrIdIsEmpty() throws Exception {
		CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = new CancelTransactionRequestRequestVO();
		cancelTransactionRequestRequestVO.setAuth("xxxxxxxx");
		cancelTransactionRequestRequestVO.setTxrId("");

		transactionRequestsService = new TransactionRequestsService();
		CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequestsService.cancelTransactionRequest(cancelTransactionRequestRequestVO);
		assertNull(cancelTransactionRequestResponseVO);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testCancelTransactionRequest_NullResponse() throws Exception {
		CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = new CancelTransactionRequestRequestVO();
		cancelTransactionRequestRequestVO.setAuth("xxxxxxxx");
		cancelTransactionRequestRequestVO.setTxrId("123456");
		
		Boolean response = null;
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(response);
		
		transactionRequestsService = new TransactionRequestsService();
		CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequestsService.cancelTransactionRequest(cancelTransactionRequestRequestVO);
		assertNotNull(cancelTransactionRequestResponseVO);
		assertNull(cancelTransactionRequestResponseVO.getResult());
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testCancelTransactionRequest_FalseResponse() throws Exception {
		CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = new CancelTransactionRequestRequestVO();
		cancelTransactionRequestRequestVO.setAuth("xxxxxxxx");
		cancelTransactionRequestRequestVO.setTxrId("123456");
		
		Boolean response = false;
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(response);
		
		transactionRequestsService = new TransactionRequestsService();
		CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequestsService.cancelTransactionRequest(cancelTransactionRequestRequestVO);
		assertNotNull(cancelTransactionRequestResponseVO);
		assertFalse(cancelTransactionRequestResponseVO.getResult());
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testCancelTransactionRequest_Success() throws Exception {
		CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = new CancelTransactionRequestRequestVO();
		cancelTransactionRequestRequestVO.setAuth("xxxxxxxx");
		cancelTransactionRequestRequestVO.setTxrId("123456");
		
		Boolean response = true;
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(response);
		
		transactionRequestsService = new TransactionRequestsService();
		CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequestsService.cancelTransactionRequest(cancelTransactionRequestRequestVO);
		assertNotNull(cancelTransactionRequestResponseVO);
		assertTrue(cancelTransactionRequestResponseVO.getResult());
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
}
