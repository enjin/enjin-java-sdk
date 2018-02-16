package io.enjincoin.sdk.client.service.platform;

import io.enjincoin.sdk.client.BaseTestHelper;
import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.platform.impl.PlatformServiceImpl;
import io.enjincoin.sdk.client.util.JsonRpcUtils;
import io.enjincoin.sdk.client.vo.platform.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PlatformServiceImpl.class)
public class PlatformServiceTest {

    PlatformServiceImpl platformService;
    Config enjinConfig;

    @Before
    public void setUp() {
        enjinConfig = BaseTestHelper.getEnjinConfig();
    }

    @Test
    public void testContructor() {
        platformService = new PlatformServiceImpl(enjinConfig);
        assertThat(platformService).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }

    @Test
    public void testGetPlatform_GetPlatformAuthRequestVOIsNull() {
        GetPlatformAuthRequestVO getAuthAuthRequestVO = null;

        platformService = new PlatformServiceImpl(enjinConfig);
        GetPlatformAuthResponseVO getAuthAuthResponseVO = platformService.getAuth(getAuthAuthRequestVO);
        assertThat(getAuthAuthResponseVO).isNull();
    }

    @Test
    public void testGetPlatform_AuthIsNull() {
        GetPlatformAuthRequestVO getAuthAuthRequestVO = ImmutableGetPlatformAuthRequestVO.builder()
        	     .setAuth((String)null)
                .build();

        platformService = new PlatformServiceImpl(enjinConfig);
        GetPlatformAuthResponseVO getAuthAuthResponseVO = platformService.getAuth(getAuthAuthRequestVO);
        assertThat(getAuthAuthResponseVO).isNull();
    }

    @Test
    public void testGetPlatform_AuthIsEmpty() {
        GetPlatformAuthRequestVO getAuthAuthRequestVO = ImmutableGetPlatformAuthRequestVO.builder()
                .setAuth("")
                .build();

        platformService = new PlatformServiceImpl(enjinConfig);
        GetPlatformAuthResponseVO getAuthAuthResponseVO = platformService.getAuth(getAuthAuthRequestVO);
        assertThat(getAuthAuthResponseVO).isNull();
    }



    @SuppressWarnings("unchecked")
    @Test
    public void testGetPlatform_ResponseIsNull() throws Exception {
        GetPlatformAuthRequestVO getAuthAuthRequestVO = ImmutableGetPlatformAuthRequestVO.builder()
                .setAuth("xxxx")
                .build();

        GetPlatformAuthResponseVO returnedGetPlatformAuthResponseVO = null;

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetPlatformAuthResponseVO);

        platformService = new PlatformServiceImpl(enjinConfig);
        GetPlatformAuthResponseVO getAuthAuthResponseVO = platformService.getAuth(getAuthAuthRequestVO);
        assertThat(getAuthAuthResponseVO).isNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({ "unchecked", "serial" })
    @Test
    public void testGetPlatform_Success() throws Exception {
        GetPlatformAuthRequestVO getPlatformAuthRequestVO = ImmutableGetPlatformAuthRequestVO.builder()
                .setAuth("xxxxxxxx")
                .build();

        GetPlatformAuthDetailsResponseVO platformAuthNotificationDetails = ImmutableGetPlatformAuthDetailsResponseVO
                .builder()
                .setMethod("pusher")
                .setClientInfoMap(new HashMap<String, Object>() {
                    {
                        put("app_key", "XXXX");
                        put("cluster", "us2");
                    }
                }).setChannelsMap(new HashMap<String, Object>() {
                    {
                        put("server", "channel_name");
                    }
                }).setRole("game_server").build();

        GetPlatformAuthResponseVO returnedGetPlatformAuthResponseVO = ImmutableGetPlatformAuthResponseVO
                .builder()
                .setPlatformAuthNotificationDetails(platformAuthNotificationDetails)
                .build();

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetPlatformAuthResponseVO);

        platformService = new PlatformServiceImpl(enjinConfig);
        GetPlatformAuthResponseVO getPlatformAuthResponseVO = platformService.getAuth(getPlatformAuthRequestVO);
        assertThat(getPlatformAuthResponseVO).isNotNull()
        .satisfies(o -> assertThat(o.toString()).isNotEmpty())
        .satisfies(o -> assertThat(o.getPlatformAuthNotificationDetails()).isNotNull())
        .satisfies(o -> assertThat(o.getPlatformAuthNotificationDetails().get()).isNotNull()
                .satisfies(j -> assertThat(j.getMethod()).isNotEmpty())
                .satisfies(j -> assertThat(j.getChannelsMap()).isNotEmpty())
                .satisfies(j -> assertThat(j.getClientInfoMap()).isNotEmpty())
                .satisfies(j -> assertThat(j.getRole()).isNotEmpty()));

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }
}
