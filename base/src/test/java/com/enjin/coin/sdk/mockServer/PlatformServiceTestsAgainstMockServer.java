package com.enjin.coin.sdk.mockServer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.config.ImmutableConfig;
import com.enjin.coin.sdk.service.EnjinCoinClient;
import com.enjin.coin.sdk.service.platform.PlatformService;
import com.enjin.coin.sdk.vo.platform.GetPlatformAuthRequestVO;
import com.enjin.coin.sdk.vo.platform.GetPlatformAuthResponseVO;
import com.enjin.coin.sdk.vo.platform.ImmutableGetPlatformAuthRequestVO;

public class PlatformServiceTestsAgainstMockServer extends BaseMockServer {

    private PlatformService platformService;

    @Before
    public void init() {
        Config enjinConfig = ImmutableConfig.builder()
                .setTrustedPlatform(getPlatform())
                .setInTestMode(true)
                .setNotification(getNotification())
                .build();
        EnjinCoinClient enjinService = new EnjinCoinClient(enjinConfig);
        platformService = enjinService.getPlatformService();
    }

    @Test
    public void testGetPlatformAuth() {
        GetPlatformAuthRequestVO getPlatformAuthRequestVO = ImmutableGetPlatformAuthRequestVO.builder()
                .setAuth("xxxxx")
                .build();
        assertThat(getPlatformAuthRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());

        GetPlatformAuthResponseVO getPlatformAuthResponseVO = platformService.getAuth(getPlatformAuthRequestVO);
        assertThat(getPlatformAuthResponseVO).isNotNull()
        .satisfies(o -> assertThat(o.toString()).isNotEmpty())
        .satisfies(o -> assertThat(o.getPlatformAuthNotificationDetails()).isNotNull())
        .satisfies(o -> assertThat(o.getPlatformAuthNotificationDetails().get()).isNotNull()
                .satisfies(j -> assertThat(j.getMethod()).isNotEmpty())
                .satisfies(j -> assertThat(j.getChannelsMap()).isNotEmpty())
                .satisfies(j -> assertThat(j.getClientInfoMap()).isNotEmpty())
                .satisfies(j -> assertThat(j.getRole()).isNotEmpty()));

    }

}
