package com.enjin.coin.sdk;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.enjin.coin.sdk.util.JsonRpcUtils;
import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenResponseVO;
import com.enjin.coin.sdk.vo.token.ListTokensRequestVO;
import com.enjin.coin.sdk.vo.token.ListTokensResponseVO;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Tokens.class)
public class TokensTest {

	Tokens tokens;

	@Test
	public void testContructor1() {
		tokens = new Tokens();
		assertNotNull(tokens);
		assertNotNull(tokens.toString());
	}
	
	@Test
	public void testContructor2() {
		tokens = new Tokens("http://localhost:8080");
		assertNotNull(tokens);
		assertNotNull(tokens.toString());
	}
	
	@Test
	public void testGetToken_GetTokenRequestVOIsNull() {
		GetTokenRequestVO getTokenRequestVO = null;
		
		tokens = new Tokens();
		GetTokenResponseVO getTokenResponseVO = tokens.getToken(getTokenRequestVO);
		assertNull(getTokenResponseVO);
	}
	@Test
	public void testGetToken_TokenIsNull() {
		GetTokenRequestVO getTokenRequestVO = new GetTokenRequestVO();
		getTokenRequestVO.setTokenId(null);
		
		tokens = new Tokens();
		GetTokenResponseVO getTokenResponseVO = tokens.getToken(getTokenRequestVO);
		assertNull(getTokenResponseVO);
	}
	@Test
	public void testGetToken_TokenIdIsEmpty() {
		GetTokenRequestVO getTokenRequestVO = new GetTokenRequestVO();
		getTokenRequestVO.setTokenId("");
		
		tokens = new Tokens();
		GetTokenResponseVO getTokenResponseVO = tokens.getToken(getTokenRequestVO);
		assertNull(getTokenResponseVO);
	}

	
	@SuppressWarnings("unchecked")
	@Test
	public void testGetToken_ResponseIsNull() throws Exception {
		GetTokenRequestVO getTokenRequestVO = new GetTokenRequestVO();
		getTokenRequestVO.setTokenId("tokenId");
		
		GetTokenResponseVO returnedGetTokenResponseVO = null;
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTokenResponseVO);
		
		tokens = new Tokens();
		GetTokenResponseVO getTokenResponseVO = tokens.getToken(getTokenRequestVO);
		assertNull(getTokenResponseVO);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testGetToken_Success() throws Exception {
		GetTokenRequestVO getTokenRequestVO = new GetTokenRequestVO();
		getTokenRequestVO.setTokenId("tokenId");

		GetTokenResponseVO returnedGetTokenResponseVO = new GetTokenResponseVO();
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTokenResponseVO);
		
		tokens = new Tokens();
		GetTokenResponseVO getTokenResponseVO = tokens.getToken(getTokenRequestVO);
		assertNotNull(getTokenResponseVO);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	
	@Test
	public void testListTokens_ListTokensRequestVOIsNull() {
		ListTokensRequestVO listTokensRequestVO = null;
		
		tokens = new Tokens();
		ListTokensResponseVO listTokensResponseVO = tokens.listTokens(listTokensRequestVO);
		assertNull(listTokensResponseVO);
	}
	@Test
	public void testListTokens_AfterTokenIdIsNull() {
		ListTokensRequestVO listTokensRequestVO = new ListTokensRequestVO();
		listTokensRequestVO.setAfterTokenId(null);
		listTokensRequestVO.setAppId("appId");
		listTokensRequestVO.setLimit("limit");
		tokens = new Tokens();
		ListTokensResponseVO listTokensResponseVO = tokens.listTokens(listTokensRequestVO);
		assertNull(listTokensResponseVO);
	}
	@Test
	public void testListTokens_AfterTokenIdIsEmpty() {
		ListTokensRequestVO listTokensRequestVO = new ListTokensRequestVO();
		listTokensRequestVO.setAfterTokenId("");
		listTokensRequestVO.setAppId("appId");
		listTokensRequestVO.setLimit("limit");
		
		tokens = new Tokens();
		ListTokensResponseVO listTokensResponseVO = tokens.listTokens(listTokensRequestVO);
		assertNull(listTokensResponseVO);
	}
	@Test
	public void testListTokens_AppIdIsNull() {
		ListTokensRequestVO listTokensRequestVO = new ListTokensRequestVO();
		listTokensRequestVO.setAfterTokenId("afterTokenId");
		listTokensRequestVO.setAppId(null);
		listTokensRequestVO.setLimit("limit");
		tokens = new Tokens();
		ListTokensResponseVO listTokensResponseVO = tokens.listTokens(listTokensRequestVO);
		assertNull(listTokensResponseVO);
	}
	@Test
	public void testListTokens_LimitIsEmpty() {
		ListTokensRequestVO listTokensRequestVO = new ListTokensRequestVO();
		listTokensRequestVO.setAfterTokenId("afterTokenId");
		listTokensRequestVO.setAppId("appId");
		listTokensRequestVO.setLimit("");
		tokens = new Tokens();
		ListTokensResponseVO listTokensResponseVO = tokens.listTokens(listTokensRequestVO);
		assertNull(listTokensResponseVO);
	}
	@Test
	public void testListTokens_LimitIsNull() {
		ListTokensRequestVO listTokensRequestVO = new ListTokensRequestVO();
		listTokensRequestVO.setAfterTokenId("afterTokenId");
		listTokensRequestVO.setAppId("appId");
		listTokensRequestVO.setLimit(null);
		tokens = new Tokens();
		ListTokensResponseVO listTokensResponseVO = tokens.listTokens(listTokensRequestVO);
		assertNull(listTokensResponseVO);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testListTokens_ResponseIsNull() throws Exception {
		ListTokensRequestVO listTokensRequestVO = new ListTokensRequestVO();
		listTokensRequestVO.setAfterTokenId("afterTokenId");
		listTokensRequestVO.setAppId("appId");
		listTokensRequestVO.setLimit("limit");
		
		ListTokensResponseVO[] returnedListTokensResponseVO = null;
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListTokensResponseVO);
		
		tokens = new Tokens();
		ListTokensResponseVO listTokensResponseVO = tokens.listTokens(listTokensRequestVO);
		assertNull(listTokensResponseVO);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testListTokens_ResponseIsEmpty() throws Exception {
		ListTokensRequestVO listTokensRequestVO = new ListTokensRequestVO();
		listTokensRequestVO.setAfterTokenId("afterTokenId");
		listTokensRequestVO.setAppId("appId");
		listTokensRequestVO.setLimit("limit");
		
		GetTokenResponseVO[] returnedListTokensResponseVO = new GetTokenResponseVO[] {};
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListTokensResponseVO);
		
		tokens = new Tokens();
		ListTokensResponseVO listTokensResponseVO = tokens.listTokens(listTokensRequestVO);
		assertNull(listTokensResponseVO);

		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testListTokens_Success1() throws Exception {
		ListTokensRequestVO listTokensRequestVO = new ListTokensRequestVO();
		listTokensRequestVO.setAfterTokenId("afterTokenId");
		listTokensRequestVO.setAppId("appId");
		listTokensRequestVO.setLimit("limit");
		
		GetTokenResponseVO[] returnedListTokensResponseVO = new GetTokenResponseVO[] {new GetTokenResponseVO()};
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListTokensResponseVO);
		
		tokens = new Tokens();
		ListTokensResponseVO listTokensResponseVO = tokens.listTokens(listTokensRequestVO);
		assertNotNull(listTokensResponseVO);
		assertNotNull(listTokensResponseVO.getGetTokenResponseVOArray());
		assertNotNull(listTokensResponseVO.getGetTokenResponseVOArray().length == 1);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testListTokens_Success2() throws Exception {
		ListTokensRequestVO listTokensRequestVO = new ListTokensRequestVO();
		listTokensRequestVO.setAfterTokenId("afterTokenId");
		listTokensRequestVO.setAppId("appId");
		listTokensRequestVO.setLimit("limit");
		
		GetTokenResponseVO[] returnedListTokensResponseVO = new GetTokenResponseVO[] {new GetTokenResponseVO(), new GetTokenResponseVO()};
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListTokensResponseVO);
		
		tokens = new Tokens();
		ListTokensResponseVO listTokensResponseVO = tokens.listTokens(listTokensRequestVO);
		assertNotNull(listTokensResponseVO);
		assertNotNull(listTokensResponseVO.getGetTokenResponseVOArray());
		assertNotNull(listTokensResponseVO.getGetTokenResponseVOArray().length == 2);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	
}
