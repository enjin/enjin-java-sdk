package io.enjincoin.sdk.client.mockServer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import io.enjincoin.sdk.client.ClientImpl;
import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.config.ImmutableConfig;
import io.enjincoin.sdk.client.service.platform.SynchronousPlatformService;
import io.enjincoin.sdk.client.vo.platform.GetPlatformAuthRequestVO;
import io.enjincoin.sdk.client.vo.platform.GetPlatformAuthResponseVO;
import io.enjincoin.sdk.client.vo.platform.ImmutableGetPlatformAuthRequestVO;

public class PlatformServiceTestsAgainstMockServer extends BaseMockServer {

    private SynchronousPlatformService platformService;

    @Before
    public void init() {
        Config enjinConfig = ImmutableConfig.builder()
                .setTrustedPlatform(this.getPlatform())
                .build();
        ClientImpl enjinService = new ClientImpl(enjinConfig);
        this.platformService = enjinService.getPlatformService();
    }

    @Test
    public void testGetPlatformAuth() {
        GetPlatformAuthRequestVO getPlatformAuthRequestVO = ImmutableGetPlatformAuthRequestVO.builder()
                .setAuth("xxxxx")
                .build();
        assertThat(getPlatformAuthRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());

        GetPlatformAuthResponseVO getPlatformAuthResponseVO = this.platformService.getAuthSync(getPlatformAuthRequestVO);
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
