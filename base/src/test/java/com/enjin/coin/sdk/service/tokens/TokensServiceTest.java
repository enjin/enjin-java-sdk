package com.enjin.coin.sdk.service.tokens;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.enjin.coin.sdk.BaseTestHelper;
import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.tokens.impl.TokensServiceImpl;
import com.enjin.coin.sdk.util.JsonRpcUtils;
import com.enjin.coin.sdk.vo.token.GetTokenBalanceRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenBalanceResponseVO;
import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenResponseVO;
import com.enjin.coin.sdk.vo.token.ImmutableGetTokenBalanceRequestVO;
import com.enjin.coin.sdk.vo.token.ImmutableGetTokenBalanceResponseVO;
import com.enjin.coin.sdk.vo.token.ImmutableGetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.ImmutableGetTokenResponseVO;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TokensServiceImpl.class)
public class TokensServiceTest {

    TokensServiceImpl tokenService;
    Config enjinConfig;

    @Before
    public void setUp() {
        enjinConfig = BaseTestHelper.getEnjinConfig();
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
        GetTokenResponseVO[] getTokenResponseVO = tokenService.getToken(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNull();
    }

    @Test
    public void testGetToken_AppIdIsNull() {
        GetTokenRequestVO getTokenRequestVO = ImmutableGetTokenRequestVO.builder()
        	     .setAppId((String)null)
                 .setAfterTokenId("123456")
                 .setLimit("50")
                .build();

        tokenService = new TokensServiceImpl(enjinConfig);
        GetTokenResponseVO[] getTokenResponseVO = tokenService.getToken(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNull();
    }

    @Test
    public void testGetToken_AppIdIsEmpty() {
        GetTokenRequestVO getTokenRequestVO = ImmutableGetTokenRequestVO.builder()
                .setAppId("")
                .setAfterTokenId("123456")
                .setLimit("50")
                .build();

        tokenService = new TokensServiceImpl(enjinConfig);
        GetTokenResponseVO[] getTokenResponseVO = tokenService.getToken(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNull();
    }

    @Test
    public void testGetToken_AfterTokenIdIsNull() {
        GetTokenRequestVO getTokenRequestVO = ImmutableGetTokenRequestVO.builder()
        	     .setAppId("352")
                 .setAfterTokenId((String)null)
                 .setLimit("50")
                .build();

        tokenService = new TokensServiceImpl(enjinConfig);
        GetTokenResponseVO[] getTokenResponseVO = tokenService.getToken(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNull();
    }

    @Test
    public void testGetToken_AfterTokendIsEmpty() {
        GetTokenRequestVO getTokenRequestVO = ImmutableGetTokenRequestVO.builder()
                .setAppId("35")
                .setAfterTokenId("")
                .setLimit("50")
                .build();

        tokenService = new TokensServiceImpl(enjinConfig);
        GetTokenResponseVO[] getTokenResponseVO = tokenService.getToken(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNull();
    }
    @Test
    public void testGetToken_LimitIsNull() {
        GetTokenRequestVO getTokenRequestVO = ImmutableGetTokenRequestVO.builder()
        	     .setAppId("352")
                 .setAfterTokenId("123456")
                 .setLimit((String)null)
                .build();

        tokenService = new TokensServiceImpl(enjinConfig);
        GetTokenResponseVO[] getTokenResponseVO = tokenService.getToken(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNull();
    }

    @Test
    public void testGetToken_LimitIsEmpty() {
        GetTokenRequestVO getTokenRequestVO = ImmutableGetTokenRequestVO.builder()
                .setAppId("35")
                .setAfterTokenId("123456")
                .setLimit("")
                .build();

        tokenService = new TokensServiceImpl(enjinConfig);
        GetTokenResponseVO[] getTokenResponseVO = tokenService.getToken(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNull();
    }
    @SuppressWarnings("unchecked")
    @Test
    public void testGetToken_ResponseIsNull() throws Exception {
        GetTokenRequestVO getTokenRequestVO = ImmutableGetTokenRequestVO.builder()
                .setAppId("352")
                .setAfterTokenId("123456")
                .setLimit("50")
                .build();

        GetTokenResponseVO returnedGetTokenResponseVO = null;

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTokenResponseVO);

        tokenService = new TokensServiceImpl(enjinConfig);
        GetTokenResponseVO[] getTokenResponseVO = tokenService.getToken(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGetToken_Success() throws Exception {
        GetTokenRequestVO getTokenRequestVO = ImmutableGetTokenRequestVO.builder()
                .setAppId("352")
                .setAfterTokenId("123456")
                .setLimit("50")
                .build();

        GetTokenResponseVO returnedGetTokenResponseVO = ImmutableGetTokenResponseVO.builder().build();
        GetTokenResponseVO[] returnedGetTokenResponseArray = new GetTokenResponseVO[] {returnedGetTokenResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTokenResponseArray);

        tokenService = new TokensServiceImpl(enjinConfig);
        GetTokenResponseVO[] getTokenResponseVO = tokenService.getToken(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }
    @Test
    public void testGetTokenBalance_RequestObjectIsNull() throws Exception {
        GetTokenBalanceRequestVO getTokenBalanceRequestVO = null;

        tokenService = new TokensServiceImpl(enjinConfig);
        GetTokenBalanceResponseVO[] getTokenBalanceResponseVO = tokenService.getTokenBalance(getTokenBalanceRequestVO);
        assertThat(getTokenBalanceResponseVO).isNull();
    }
    @Test
    public void testGetTokenBalance_IdentityMapIsEmpty() throws Exception {
        Map<String, Object> identityMapParam = new HashMap<>();

        Map<String, Object> tokenIdsMap = new HashMap<>();
        tokenIdsMap.put("1", "1");
        tokenIdsMap.put("2", "2");
        tokenIdsMap.put("3", "3");

        GetTokenBalanceRequestVO getTokenBalanceRequestVO = ImmutableGetTokenBalanceRequestVO.builder()
                .setIdentityMap(identityMapParam)
                .setTokenIdsMap(tokenIdsMap)
                .build();

        tokenService = new TokensServiceImpl(enjinConfig);
        GetTokenBalanceResponseVO[] getTokenBalanceResponseVO = tokenService.getTokenBalance(getTokenBalanceRequestVO);
        assertThat(getTokenBalanceResponseVO).isNull();
    }
    @Test
    public void testGetTokenBalance_IdentityMapIsNull() throws Exception {
        Map<String, Object> identityMapParam = null;

        Map<String, Object> tokenIdsMap = new HashMap<>();
        tokenIdsMap.put("1", "1");
        tokenIdsMap.put("2", "2");
        tokenIdsMap.put("3", "3");

        GetTokenBalanceRequestVO getTokenBalanceRequestVO = ImmutableGetTokenBalanceRequestVO.builder()
                .setIdentityMap(identityMapParam)
                .setTokenIdsMap(tokenIdsMap)
                .build();

        tokenService = new TokensServiceImpl(enjinConfig);
        GetTokenBalanceResponseVO[] getTokenBalanceResponseVO = tokenService.getTokenBalance(getTokenBalanceRequestVO);
        assertThat(getTokenBalanceResponseVO).isNull();
    }
    @Test
    public void testGetTokenBalance_TokenIdsMapIsEmpty() throws Exception {
        Map<String, Object> identityMapParam = new HashMap<>();
        identityMapParam.put("ethereum_address", "0x0000000000000000000000000000000000000000");
        identityMapParam.put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");
        identityMapParam.put("player_name", "notch");

        Map<String, Object> tokenIdsMap = new HashMap<>();

        GetTokenBalanceRequestVO getTokenBalanceRequestVO = ImmutableGetTokenBalanceRequestVO.builder()
                .setIdentityMap(identityMapParam)
                .setTokenIdsMap(tokenIdsMap)
                .build();

        tokenService = new TokensServiceImpl(enjinConfig);
        GetTokenBalanceResponseVO[] getTokenBalanceResponseVO = tokenService.getTokenBalance(getTokenBalanceRequestVO);
        assertThat(getTokenBalanceResponseVO).isNull();
    }
    @Test
    public void testGetTokenBalance_TokenIdsMapIsNull() throws Exception {
        Map<String, Object> identityMapParam = new HashMap<>();
        identityMapParam.put("ethereum_address", "0x0000000000000000000000000000000000000000");
        identityMapParam.put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");
        identityMapParam.put("player_name", "notch");

        Map<String, Object> tokenIdsMap = null;

        GetTokenBalanceRequestVO getTokenBalanceRequestVO = ImmutableGetTokenBalanceRequestVO.builder()
                .setIdentityMap(identityMapParam)
                .setTokenIdsMap(tokenIdsMap)
                .build();

        tokenService = new TokensServiceImpl(enjinConfig);
        GetTokenBalanceResponseVO[] getTokenBalanceResponseVO = tokenService.getTokenBalance(getTokenBalanceRequestVO);
        assertThat(getTokenBalanceResponseVO).isNull();

    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGetTokenBalance_ResponseIsNull() throws Exception {
        Map<String, Object> identityMapParam = new HashMap<>();
        identityMapParam.put("ethereum_address", "0x0000000000000000000000000000000000000000");
        identityMapParam.put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");
        identityMapParam.put("player_name", "notch");

        Map<String, Object> tokenIdsMap = new HashMap<>();
        tokenIdsMap.put("1", "1");
        tokenIdsMap.put("2", "2");
        tokenIdsMap.put("3", "3");

        GetTokenBalanceRequestVO getTokenBalanceRequestVO = ImmutableGetTokenBalanceRequestVO.builder()
                .setIdentityMap(identityMapParam)
                .setTokenIdsMap(tokenIdsMap)
                .build();

        GetTokenBalanceResponseVO[] returnedGetTokenBalanceResponseArray = null;

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTokenBalanceResponseArray);

        tokenService = new TokensServiceImpl(enjinConfig);
        GetTokenBalanceResponseVO[] getTokenBalanceResponseVO = tokenService.getTokenBalance(getTokenBalanceRequestVO);
        assertThat(getTokenBalanceResponseVO).isNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }
    @SuppressWarnings("unchecked")
    @Test
    public void testGetTokenBalance_Success() throws Exception {
        Map<String, Object> identityMapParam = new HashMap<>();
        identityMapParam.put("ethereum_address", "0x0000000000000000000000000000000000000000");
        identityMapParam.put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");
        identityMapParam.put("player_name", "notch");

        Map<String, Object> tokenIdsMap = new HashMap<>();
        tokenIdsMap.put("1", "1");
        tokenIdsMap.put("2", "2");
        tokenIdsMap.put("3", "3");

        GetTokenBalanceRequestVO getTokenBalanceRequestVO = ImmutableGetTokenBalanceRequestVO.builder()
                .setIdentityMap(identityMapParam)
                .setTokenIdsMap(tokenIdsMap)
                .build();

        GetTokenBalanceResponseVO returnedGetTokenBalanceResponseVO = ImmutableGetTokenBalanceResponseVO.builder().build();
        GetTokenBalanceResponseVO[] returnedGetTokenBalanceResponseArray = new GetTokenBalanceResponseVO[] {returnedGetTokenBalanceResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTokenBalanceResponseArray);

        tokenService = new TokensServiceImpl(enjinConfig);
        GetTokenBalanceResponseVO[] getTokenBalanceResponseVO = tokenService.getTokenBalance(getTokenBalanceRequestVO);
        assertThat(getTokenBalanceResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }
}
