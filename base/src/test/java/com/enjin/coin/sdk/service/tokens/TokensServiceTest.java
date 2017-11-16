package com.enjin.coin.sdk.service.tokens;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.tokens.impl.TokensServiceImpl;
import com.enjin.coin.sdk.util.JsonRpcUtils;
import com.enjin.coin.sdk.vo.token.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TokensServiceImpl.class)
public class TokensServiceTest {

    TokensServiceImpl tokenService;
    Config enjinConfig;

    @Before
    public void setUp() {
        enjinConfig = new Config();
    }

    @Test
    public void testContructor() {
        tokenService = new TokensServiceImpl(enjinConfig);
        assertThat(tokenService).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }

    @Test
    public void testGetToken_GetTokenRequestVOIsNull() {
        GetTokenRequestVO getTokenRequestVO = null;

        tokenService = new TokensServiceImpl(enjinConfig);
        GetTokenResponseVO getTokenResponseVO = tokenService.getToken(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNull();
    }

    @Test
    public void testGetToken_TokenIsNull() {
        GetTokenRequestVO getTokenRequestVO = ImmutableGetTokenRequestVO.builder()
                .setTokenId((String) null)
                .build();

        tokenService = new TokensServiceImpl(enjinConfig);
        GetTokenResponseVO getTokenResponseVO = tokenService.getToken(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNull();
    }

    @Test
    public void testGetToken_TokenIdIsEmpty() {
        GetTokenRequestVO getTokenRequestVO = ImmutableGetTokenRequestVO.builder()
                .setTokenId("")
                .build();

        tokenService = new TokensServiceImpl(enjinConfig);
        GetTokenResponseVO getTokenResponseVO = tokenService.getToken(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNull();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGetToken_ResponseIsNull() throws Exception {
        GetTokenRequestVO getTokenRequestVO = ImmutableGetTokenRequestVO.builder()
                .setTokenId("tokenId")
                .build();

        GetTokenResponseVO returnedGetTokenResponseVO = null;

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTokenResponseVO);

        tokenService = new TokensServiceImpl(enjinConfig);
        GetTokenResponseVO getTokenResponseVO = tokenService.getToken(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGetToken_Success() throws Exception {
        GetTokenRequestVO getTokenRequestVO = ImmutableGetTokenRequestVO.builder()
                .setTokenId("tokenId")
                .build();

        GetTokenResponseVO returnedGetTokenResponseVO = ImmutableGetTokenResponseVO.builder().build();

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTokenResponseVO);

        tokenService = new TokensServiceImpl(enjinConfig);
        GetTokenResponseVO getTokenResponseVO = tokenService.getToken(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @Test
    public void testListTokens_ListTokensRequestVOIsNull() {
        ListTokensRequestVO listTokensRequestVO = null;

        tokenService = new TokensServiceImpl(enjinConfig);
        ListTokensResponseVO listTokensResponseVO = tokenService.listTokens(listTokensRequestVO);
        assertThat(listTokensResponseVO).isNull();
    }

    @Test
    public void testListTokens_AfterTokenIdIsNull() {
        ListTokensRequestVO listTokensRequestVO = ImmutableListTokensRequestVO.builder()
                .setAfterTokenId((String) null)
                .setAppId("appId")
                .setLimit("limit")
                .build();
        tokenService = new TokensServiceImpl(enjinConfig);
        ListTokensResponseVO listTokensResponseVO = tokenService.listTokens(listTokensRequestVO);
        assertThat(listTokensResponseVO).isNull();
    }

    @Test
    public void testListTokens_AfterTokenIdIsEmpty() {
        ListTokensRequestVO listTokensRequestVO = ImmutableListTokensRequestVO.builder()
                .setAfterTokenId("")
                .setAppId("appId")
                .setLimit("limit")
                .build();

        tokenService = new TokensServiceImpl(enjinConfig);
        ListTokensResponseVO listTokensResponseVO = tokenService.listTokens(listTokensRequestVO);
        assertThat(listTokensResponseVO).isNull();
    }

    @Test
    public void testListTokens_AppIdIsNull() {
        ListTokensRequestVO listTokensRequestVO = ImmutableListTokensRequestVO.builder()
                .setAfterTokenId("afterTokenId")
                .setAppId((String) null)
                .setLimit("limit")
                .build();
        tokenService = new TokensServiceImpl(enjinConfig);
        ListTokensResponseVO listTokensResponseVO = tokenService.listTokens(listTokensRequestVO);
        assertThat(listTokensResponseVO).isNull();
    }

    @Test
    public void testListTokens_LimitIsEmpty() {
        ListTokensRequestVO listTokensRequestVO = ImmutableListTokensRequestVO.builder()
                .setAfterTokenId("afterTokenId")
                .setAppId("appId")
                .setLimit("")
                .build();
        tokenService = new TokensServiceImpl(enjinConfig);
        ListTokensResponseVO listTokensResponseVO = tokenService.listTokens(listTokensRequestVO);
        assertThat(listTokensResponseVO).isNull();
    }

    @Test
    public void testListTokens_LimitIsNull() {
        ListTokensRequestVO listTokensRequestVO = ImmutableListTokensRequestVO.builder()
                .setAfterTokenId("afterTokenId")
                .setAppId("appId")
                .setLimit((String) null)
                .build();
        tokenService = new TokensServiceImpl(enjinConfig);
        ListTokensResponseVO listTokensResponseVO = tokenService.listTokens(listTokensRequestVO);
        assertThat(listTokensResponseVO).isNull();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testListTokens_ResponseIsNull() throws Exception {
        ListTokensRequestVO listTokensRequestVO = ImmutableListTokensRequestVO.builder()
                .setAfterTokenId("afterTokenId")
                .setAppId("appId")
                .setLimit("limit")
                .build();

        ListTokensResponseVO[] returnedListTokensResponseVO = null;

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListTokensResponseVO);

        tokenService = new TokensServiceImpl(enjinConfig);
        ListTokensResponseVO listTokensResponseVO = tokenService.listTokens(listTokensRequestVO);
        assertThat(listTokensResponseVO).isNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testListTokens_ResponseIsEmpty() throws Exception {
        ListTokensRequestVO listTokensRequestVO = ImmutableListTokensRequestVO.builder()
                .setAfterTokenId("afterTokenId")
                .setAppId("appId")
                .setLimit("limit")
                .build();

        GetTokenResponseVO[] returnedListTokensResponseVO = new GetTokenResponseVO[]{};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListTokensResponseVO);

        tokenService = new TokensServiceImpl(enjinConfig);
        ListTokensResponseVO listTokensResponseVO = tokenService.listTokens(listTokensRequestVO);
        assertThat(listTokensResponseVO).isNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testListTokens_Success1() throws Exception {
        ListTokensRequestVO listTokensRequestVO = ImmutableListTokensRequestVO.builder()
                .setAfterTokenId("afterTokenId")
                .setAppId("appId")
                .setLimit("limit")
                .build();

        GetTokenResponseVO[] returnedListTokensResponseVO = new GetTokenResponseVO[]{
                ImmutableGetTokenResponseVO.builder().build()
        };

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListTokensResponseVO);

        tokenService = new TokensServiceImpl(enjinConfig);
        ListTokensResponseVO listTokensResponseVO = tokenService.listTokens(listTokensRequestVO);
        assertThat(listTokensResponseVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                .satisfies(o -> assertThat(o.getGetTokensResponseVOArray()).isPresent()
                        .hasValueSatisfying(v -> assertThat(v).hasSize(1)));

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testListTokens_Success2() throws Exception {
        ListTokensRequestVO listTokensRequestVO = ImmutableListTokensRequestVO.builder()
                .setAfterTokenId("afterTokenId")
                .setAppId("appId")
                .setLimit("limit")
                .build();

        GetTokenResponseVO[] returnedListTokensResponseVO = new GetTokenResponseVO[]{
                ImmutableGetTokenResponseVO.builder().build(),
                ImmutableGetTokenResponseVO.builder().build()
        };

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListTokensResponseVO);

        tokenService = new TokensServiceImpl(enjinConfig);
        ListTokensResponseVO listTokensResponseVO = tokenService.listTokens(listTokensRequestVO);
        assertThat(listTokensResponseVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                .satisfies(o -> assertThat(o.getGetTokensResponseVOArray()).isPresent()
                        .hasValueSatisfying(v -> assertThat(v).hasSize(2)));

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

}
