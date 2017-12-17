package com.enjin.coin.sdk.service.tokens;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.enjin.coin.sdk.BaseTestHelper;
import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.tokens.impl.TokensAsyncServiceImpl;
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
@PrepareForTest(TokensAsyncServiceImpl.class)
public class TokensAsyncServiceTest {

    TokensAsyncService tokensAsyncService;
    Config enjinConfig;

    @Before
    public void setUp() {
        enjinConfig = BaseTestHelper.getEnjinConfig();
    }

    @Test
    public void testContructor() {
        tokensAsyncService = new TokensAsyncServiceImpl(enjinConfig);
        assertThat(tokensAsyncService).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());
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

        tokensAsyncService = new TokensAsyncServiceImpl(enjinConfig);
        CompletableFuture<GetTokenResponseVO[]> getTokenResponseCompletableFutureVO = tokensAsyncService.getTokenAsync(getTokenRequestVO);
        assertThat(getTokenResponseCompletableFutureVO).isNotNull();
        assertThat(getTokenResponseCompletableFutureVO.get()).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }


    @SuppressWarnings("unchecked")
    @Test
    public void testGetBalanceToken_Success() throws Exception {
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

        tokensAsyncService = new TokensAsyncServiceImpl(enjinConfig);
        CompletableFuture<GetTokenBalanceResponseVO[]> getTokenBalanceResponseCompletableFutureVO = tokensAsyncService.getTokenBalanceAsync(getTokenBalanceRequestVO);
        assertThat(getTokenBalanceResponseCompletableFutureVO).isNotNull();
        assertThat(getTokenBalanceResponseCompletableFutureVO.get()).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }
}
