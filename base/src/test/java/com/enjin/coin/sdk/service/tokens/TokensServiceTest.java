package com.enjin.coin.sdk.service.tokens;

import static org.assertj.core.api.Assertions.assertThat;

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
import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenResponseVO;
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
}
