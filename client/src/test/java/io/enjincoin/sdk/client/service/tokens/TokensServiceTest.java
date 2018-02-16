package io.enjincoin.sdk.client.service.tokens;

import io.enjincoin.sdk.client.BaseTestHelper;
import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.tokens.impl.TokensServiceImpl;
import io.enjincoin.sdk.client.util.JsonRpcUtils;
import io.enjincoin.sdk.client.vo.token.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TokensServiceImpl.class)
public class TokensServiceTest {

    TokensServiceImpl service;
    Config config;

    @Before
    public void setUp() {
        this.config = BaseTestHelper.getEnjinConfig();
    }

    @Test
    public void testContructor() {
        this.service = new TokensServiceImpl(this.config);
        assertThat(this.service).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }

    @Test
    public void testGetToken_GetTokenRequestVOIsNull() {
        GetTokenRequestVO getTokenRequestVO = null;

        this.service = new TokensServiceImpl(this.config);
        GetTokenResponseVO[] getTokenResponseVO = this.service.getTokensSync(getTokenRequestVO);
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

        this.service = new TokensServiceImpl(this.config);
        GetTokenResponseVO[] getTokenResponseVO = this.service.getTokensSync(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGetToken_AppIdIsNull() throws Exception {
        GetTokenRequestVO getTokenRequestVO = ImmutableGetTokenRequestVO.builder()
                .setAppId((String) null)
                .setAfterTokenId("123456")
                .setLimit("50")
                .build();

        GetTokenResponseVO returnedGetTokenResponseVO = ImmutableGetTokenResponseVO.builder().build();
        GetTokenResponseVO[] returnedGetTokenResponseArray = new GetTokenResponseVO[]{returnedGetTokenResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTokenResponseArray);

        this.service = new TokensServiceImpl(this.config);
        GetTokenResponseVO[] getTokenResponseVO = this.service.getTokensSync(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGetToken_AppIdIsEmpty() throws Exception {
        GetTokenRequestVO getTokenRequestVO = ImmutableGetTokenRequestVO.builder()
                .setAppId("")
                .setAfterTokenId("123456")
                .setLimit("50")
                .build();

        GetTokenResponseVO returnedGetTokenResponseVO = ImmutableGetTokenResponseVO.builder().build();
        GetTokenResponseVO[] returnedGetTokenResponseArray = new GetTokenResponseVO[]{returnedGetTokenResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTokenResponseArray);

        this.service = new TokensServiceImpl(this.config);
        GetTokenResponseVO[] getTokenResponseVO = this.service.getTokensSync(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGetToken_AfterTokenIdIsNull() throws Exception {
        GetTokenRequestVO getTokenRequestVO = ImmutableGetTokenRequestVO.builder()
                .setAppId("352")
                .setAfterTokenId((String) null)
                .setLimit("50")
                .build();

        GetTokenResponseVO returnedGetTokenResponseVO = ImmutableGetTokenResponseVO.builder().build();
        GetTokenResponseVO[] returnedGetTokenResponseArray = new GetTokenResponseVO[]{returnedGetTokenResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTokenResponseArray);

        this.service = new TokensServiceImpl(this.config);
        GetTokenResponseVO[] getTokenResponseVO = this.service.getTokensSync(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGetToken_AfterTokenIdIsEmpty() throws Exception {
        GetTokenRequestVO getTokenRequestVO = ImmutableGetTokenRequestVO.builder()
                .setAppId("35")
                .setAfterTokenId("")
                .setLimit("50")
                .build();

        GetTokenResponseVO returnedGetTokenResponseVO = ImmutableGetTokenResponseVO.builder().build();
        GetTokenResponseVO[] returnedGetTokenResponseArray = new GetTokenResponseVO[]{returnedGetTokenResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTokenResponseArray);

        this.service = new TokensServiceImpl(this.config);
        GetTokenResponseVO[] getTokenResponseVO = this.service.getTokensSync(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGetToken_LimitIsNull() throws Exception {
        GetTokenRequestVO getTokenRequestVO = ImmutableGetTokenRequestVO.builder()
                .setAppId("352")
                .setAfterTokenId("123456")
                .setLimit((String) null)
                .build();

        GetTokenResponseVO returnedGetTokenResponseVO = ImmutableGetTokenResponseVO.builder().build();
        GetTokenResponseVO[] returnedGetTokenResponseArray = new GetTokenResponseVO[]{returnedGetTokenResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTokenResponseArray);

        this.service = new TokensServiceImpl(this.config);
        GetTokenResponseVO[] getTokenResponseVO = this.service.getTokensSync(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGetToken_LimitIsEmpty() throws Exception {
        GetTokenRequestVO getTokenRequestVO = ImmutableGetTokenRequestVO.builder()
                .setAppId("35")
                .setAfterTokenId("123456")
                .setLimit("")
                .build();

        GetTokenResponseVO returnedGetTokenResponseVO = ImmutableGetTokenResponseVO.builder().build();
        GetTokenResponseVO[] returnedGetTokenResponseArray = new GetTokenResponseVO[]{returnedGetTokenResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTokenResponseArray);

        this.service = new TokensServiceImpl(this.config);
        GetTokenResponseVO[] getTokenResponseVO = this.service.getTokensSync(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNotNull();

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
        GetTokenResponseVO[] returnedGetTokenResponseArray = new GetTokenResponseVO[]{returnedGetTokenResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTokenResponseArray);

        this.service = new TokensServiceImpl(this.config);
        GetTokenResponseVO[] getTokenResponseVO = this.service.getTokensSync(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @Test
    public void testGetTokenBalance_RequestObjectIsNull() throws Exception {
        GetTokenBalanceRequestVO getTokenBalanceRequestVO = null;

        this.service = new TokensServiceImpl(this.config);
        GetTokenBalanceResponseVO[] getTokenBalanceResponseVO = this.service.getTokenBalancesSync(getTokenBalanceRequestVO);
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

        this.service = new TokensServiceImpl(this.config);
        GetTokenBalanceResponseVO[] getTokenBalanceResponseVO = this.service.getTokenBalancesSync(getTokenBalanceRequestVO);
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

        this.service = new TokensServiceImpl(this.config);
        GetTokenBalanceResponseVO[] getTokenBalanceResponseVO = this.service.getTokenBalancesSync(getTokenBalanceRequestVO);
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

        this.service = new TokensServiceImpl(this.config);
        GetTokenBalanceResponseVO[] getTokenBalanceResponseVO = this.service.getTokenBalancesSync(getTokenBalanceRequestVO);
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

        this.service = new TokensServiceImpl(this.config);
        GetTokenBalanceResponseVO[] getTokenBalanceResponseVO = this.service.getTokenBalancesSync(getTokenBalanceRequestVO);
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

        this.service = new TokensServiceImpl(this.config);
        GetTokenBalanceResponseVO[] getTokenBalanceResponseVO = this.service.getTokenBalancesSync(getTokenBalanceRequestVO);
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
        GetTokenBalanceResponseVO[] returnedGetTokenBalanceResponseArray = new GetTokenBalanceResponseVO[]{returnedGetTokenBalanceResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTokenBalanceResponseArray);

        this.service = new TokensServiceImpl(this.config);
        GetTokenBalanceResponseVO[] getTokenBalanceResponseVO = this.service.getTokenBalancesSync(getTokenBalanceRequestVO);
        assertThat(getTokenBalanceResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGetTokenAsync_Success() throws Exception {
        GetTokenRequestVO getTokenRequestVO = ImmutableGetTokenRequestVO.builder()
                .setAppId("352")
                .setAfterTokenId("123456")
                .setLimit("50")
                .build();

        GetTokenResponseVO returnedGetTokenResponseVO = ImmutableGetTokenResponseVO.builder().build();
        GetTokenResponseVO[] returnedGetTokenResponseArray = new GetTokenResponseVO[]{returnedGetTokenResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTokenResponseArray);

        this.service = new TokensServiceImpl(this.config);
        CompletableFuture<GetTokenResponseVO[]> getTokenResponseCompletableFutureVO = this.service.getTokensAsync(getTokenRequestVO);
        assertThat(getTokenResponseCompletableFutureVO).isNotNull();
        assertThat(getTokenResponseCompletableFutureVO.get()).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }


    @SuppressWarnings("unchecked")
    @Test
    public void testGetBalanceTokenAsync_Success() throws Exception {
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
        GetTokenBalanceResponseVO[] returnedGetTokenBalanceResponseArray = new GetTokenBalanceResponseVO[]{returnedGetTokenBalanceResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTokenBalanceResponseArray);

        this.service = new TokensServiceImpl(this.config);
        CompletableFuture<GetTokenBalanceResponseVO[]> getTokenBalanceResponseCompletableFutureVO = this.service.getTokenBalancesAsync(getTokenBalanceRequestVO);
        assertThat(getTokenBalanceResponseCompletableFutureVO).isNotNull();
        assertThat(getTokenBalanceResponseCompletableFutureVO.get()).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }
}
