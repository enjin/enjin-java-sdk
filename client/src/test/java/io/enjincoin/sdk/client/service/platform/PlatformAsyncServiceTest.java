package io.enjincoin.sdk.client.service.platform;

import io.enjincoin.sdk.client.BaseTestHelper;
import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.platform.impl.PlatformAsyncServiceImpl;
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
import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PlatformAsyncServiceImpl.class)
public class PlatformAsyncServiceTest {

    PlatformAsyncService platformAsyncService;
    Config enjinConfig;

    @Before
    public void setUp() {
        enjinConfig = BaseTestHelper.getEnjinConfig();
    }

    @Test
    public void testContructor() {
        platformAsyncService = new PlatformAsyncServiceImpl(enjinConfig);
        assertThat(platformAsyncService).isNotNull().satisfies(o -> assertThat(o.toString()).isNotEmpty());
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
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class)))
                .thenReturn(returnedGetPlatformAuthResponseVO);

        platformAsyncService = new PlatformAsyncServiceImpl(enjinConfig);
        CompletableFuture<GetPlatformAuthResponseVO> getPlatformAuthResponseCompletableFutureVO = platformAsyncService.getAuthAsync(getPlatformAuthRequestVO);
        assertThat(getPlatformAuthResponseCompletableFutureVO).isNotNull();
        assertThat(getPlatformAuthResponseCompletableFutureVO.get()).isNotNull()
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
