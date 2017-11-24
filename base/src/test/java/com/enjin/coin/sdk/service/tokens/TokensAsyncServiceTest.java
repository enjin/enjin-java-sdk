package com.enjin.coin.sdk.service.tokens;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.concurrent.Future;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.tokens.impl.TokensAsyncServiceImpl;
import com.enjin.coin.sdk.util.JsonRpcUtils;
import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenResponseVO;
import com.enjin.coin.sdk.vo.token.ImmutableGetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.ImmutableGetTokenResponseVO;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TokensAsyncServiceImpl.class)
public class TokensAsyncServiceTest {

    TokensAsyncService tokensAsyncService;
    Config enjinConfig;

    @Before
    public void setUp() {
        enjinConfig = new Config();
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
                .setTokenId("tokenId")
                .build();

        GetTokenResponseVO returnedGetTokenResponseVO = ImmutableGetTokenResponseVO.builder().build();

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTokenResponseVO);

        tokensAsyncService = new TokensAsyncServiceImpl(enjinConfig);
        Future<GetTokenResponseVO> getTokenResponseFutureVO = tokensAsyncService.getTokenAsync(getTokenRequestVO);
        assertThat(getTokenResponseFutureVO).isNotNull();
        GetTokenResponseVO getTokenResponseVO = getTokenResponseFutureVO.get();
        assertThat(getTokenResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

}
