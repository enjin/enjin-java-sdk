package com.enjin.coin.sdk.service;

import com.enjin.coin.sdk.config.EnjinConfig;
import com.enjin.coin.sdk.util.JsonRpcUtils;
import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenResponseVO;
import com.enjin.coin.sdk.vo.token.ListTokensRequestVO;
import com.enjin.coin.sdk.vo.token.ListTokensResponseVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TokensService.class)
public class TokensServiceTest {

    TokensService tokenService;
    EnjinConfig enjinConfig;

    @Before
    public void setUp() {
        enjinConfig = new EnjinConfig();
    }

    @Test
    public void testContructor() {
        tokenService = new TokensService(enjinConfig);
        assertNotNull(tokenService);
        assertNotNull(tokenService.toString());
    }

    @Test
    public void testGetToken_GetTokenRequestVOIsNull() {
        GetTokenRequestVO getTokenRequestVO = null;

        tokenService = new TokensService(enjinConfig);
        GetTokenResponseVO getTokenResponseVO = tokenService.getToken(getTokenRequestVO);
        assertNull(getTokenResponseVO);
    }

    @Test
    public void testGetToken_TokenIsNull() {
        GetTokenRequestVO getTokenRequestVO = new GetTokenRequestVO();
        getTokenRequestVO.setTokenId(null);

        tokenService = new TokensService(enjinConfig);
        GetTokenResponseVO getTokenResponseVO = tokenService.getToken(getTokenRequestVO);
        assertNull(getTokenResponseVO);
    }

    @Test
    public void testGetToken_TokenIdIsEmpty() {
        GetTokenRequestVO getTokenRequestVO = new GetTokenRequestVO();
        getTokenRequestVO.setTokenId("");

        tokenService = new TokensService(enjinConfig);
        GetTokenResponseVO getTokenResponseVO = tokenService.getToken(getTokenRequestVO);
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
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTokenResponseVO);

        tokenService = new TokensService(enjinConfig);
        GetTokenResponseVO getTokenResponseVO = tokenService.getToken(getTokenRequestVO);
        assertNull(getTokenResponseVO);

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGetToken_Success() throws Exception {
        GetTokenRequestVO getTokenRequestVO = new GetTokenRequestVO();
        getTokenRequestVO.setTokenId("tokenId");

        GetTokenResponseVO returnedGetTokenResponseVO = new GetTokenResponseVO();

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTokenResponseVO);

        tokenService = new TokensService(enjinConfig);
        GetTokenResponseVO getTokenResponseVO = tokenService.getToken(getTokenRequestVO);
        assertNotNull(getTokenResponseVO);

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @Test
    public void testListTokens_ListTokensRequestVOIsNull() {
        ListTokensRequestVO listTokensRequestVO = null;

        tokenService = new TokensService(enjinConfig);
        ListTokensResponseVO listTokensResponseVO = tokenService.listTokens(listTokensRequestVO);
        assertNull(listTokensResponseVO);
    }

    @Test
    public void testListTokens_AfterTokenIdIsNull() {
        ListTokensRequestVO listTokensRequestVO = new ListTokensRequestVO();
        listTokensRequestVO.setAfterTokenId(null);
        listTokensRequestVO.setAppId("appId");
        listTokensRequestVO.setLimit("limit");
        tokenService = new TokensService(enjinConfig);
        ListTokensResponseVO listTokensResponseVO = tokenService.listTokens(listTokensRequestVO);
        assertNull(listTokensResponseVO);
    }

    @Test
    public void testListTokens_AfterTokenIdIsEmpty() {
        ListTokensRequestVO listTokensRequestVO = new ListTokensRequestVO();
        listTokensRequestVO.setAfterTokenId("");
        listTokensRequestVO.setAppId("appId");
        listTokensRequestVO.setLimit("limit");

        tokenService = new TokensService(enjinConfig);
        ListTokensResponseVO listTokensResponseVO = tokenService.listTokens(listTokensRequestVO);
        assertNull(listTokensResponseVO);
    }

    @Test
    public void testListTokens_AppIdIsNull() {
        ListTokensRequestVO listTokensRequestVO = new ListTokensRequestVO();
        listTokensRequestVO.setAfterTokenId("afterTokenId");
        listTokensRequestVO.setAppId(null);
        listTokensRequestVO.setLimit("limit");
        tokenService = new TokensService(enjinConfig);
        ListTokensResponseVO listTokensResponseVO = tokenService.listTokens(listTokensRequestVO);
        assertNull(listTokensResponseVO);
    }

    @Test
    public void testListTokens_LimitIsEmpty() {
        ListTokensRequestVO listTokensRequestVO = new ListTokensRequestVO();
        listTokensRequestVO.setAfterTokenId("afterTokenId");
        listTokensRequestVO.setAppId("appId");
        listTokensRequestVO.setLimit("");
        tokenService = new TokensService(enjinConfig);
        ListTokensResponseVO listTokensResponseVO = tokenService.listTokens(listTokensRequestVO);
        assertNull(listTokensResponseVO);
    }

    @Test
    public void testListTokens_LimitIsNull() {
        ListTokensRequestVO listTokensRequestVO = new ListTokensRequestVO();
        listTokensRequestVO.setAfterTokenId("afterTokenId");
        listTokensRequestVO.setAppId("appId");
        listTokensRequestVO.setLimit(null);
        tokenService = new TokensService(enjinConfig);
        ListTokensResponseVO listTokensResponseVO = tokenService.listTokens(listTokensRequestVO);
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
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListTokensResponseVO);

        tokenService = new TokensService(enjinConfig);
        ListTokensResponseVO listTokensResponseVO = tokenService.listTokens(listTokensRequestVO);
        assertNull(listTokensResponseVO);

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testListTokens_ResponseIsEmpty() throws Exception {
        ListTokensRequestVO listTokensRequestVO = new ListTokensRequestVO();
        listTokensRequestVO.setAfterTokenId("afterTokenId");
        listTokensRequestVO.setAppId("appId");
        listTokensRequestVO.setLimit("limit");

        GetTokenResponseVO[] returnedListTokensResponseVO = new GetTokenResponseVO[]{};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListTokensResponseVO);

        tokenService = new TokensService(enjinConfig);
        ListTokensResponseVO listTokensResponseVO = tokenService.listTokens(listTokensRequestVO);
        assertNull(listTokensResponseVO);

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testListTokens_Success1() throws Exception {
        ListTokensRequestVO listTokensRequestVO = new ListTokensRequestVO();
        listTokensRequestVO.setAfterTokenId("afterTokenId");
        listTokensRequestVO.setAppId("appId");
        listTokensRequestVO.setLimit("limit");

        GetTokenResponseVO[] returnedListTokensResponseVO = new GetTokenResponseVO[]{new GetTokenResponseVO()};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListTokensResponseVO);

        tokenService = new TokensService(enjinConfig);
        ListTokensResponseVO listTokensResponseVO = tokenService.listTokens(listTokensRequestVO);
        assertNotNull(listTokensResponseVO);
        assertNotNull(listTokensResponseVO.getGetTokensResponseVOArray());
        assertNotNull(listTokensResponseVO.getGetTokensResponseVOArray().length == 1);

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testListTokens_Success2() throws Exception {
        ListTokensRequestVO listTokensRequestVO = new ListTokensRequestVO();
        listTokensRequestVO.setAfterTokenId("afterTokenId");
        listTokensRequestVO.setAppId("appId");
        listTokensRequestVO.setLimit("limit");

        GetTokenResponseVO[] returnedListTokensResponseVO = new GetTokenResponseVO[]{new GetTokenResponseVO(), new GetTokenResponseVO()};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListTokensResponseVO);

        tokenService = new TokensService(enjinConfig);
        ListTokensResponseVO listTokensResponseVO = tokenService.listTokens(listTokensRequestVO);
        assertNotNull(listTokensResponseVO);
        assertNotNull(listTokensResponseVO.getGetTokensResponseVOArray());
        assertNotNull(listTokensResponseVO.getGetTokensResponseVOArray().length == 2);

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

}
