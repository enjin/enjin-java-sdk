package io.enjincoin.sdk.client.mockServer;

import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.config.ImmutableConfig;
import io.enjincoin.sdk.client.service.EnjinCoinClient;
import io.enjincoin.sdk.client.service.platform.PlatformService;
import io.enjincoin.sdk.client.vo.platform.GetPlatformAuthRequestVO;
import io.enjincoin.sdk.client.vo.platform.GetPlatformAuthResponseVO;
import io.enjincoin.sdk.client.vo.platform.ImmutableGetPlatformAuthRequestVO;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlatformServiceTestsAgainstMockServer extends BaseMockServer {

    private PlatformService platformService;

    @Before
    public void init() {
        Config enjinConfig = ImmutableConfig.builder()
                .setTrustedPlatform(getPlatform())
                .setInTestMode(true)
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
