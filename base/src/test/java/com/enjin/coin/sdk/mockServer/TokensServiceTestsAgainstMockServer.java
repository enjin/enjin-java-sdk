package com.enjin.coin.sdk.mockServer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.config.ImmutableConfig;
import com.enjin.coin.sdk.service.EnjinCoinClient;
import com.enjin.coin.sdk.service.tokens.TokensService;
import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.ImmutableGetTokenRequestVO;

public class TokensServiceTestsAgainstMockServer extends BaseMockServer {

    private TokensService tokensService;

    @Before
    public void init() {
        Config enjinConfig = ImmutableConfig.builder()
                .setTrustedPlatform(getPlatform())
                .setInTestMode(true)
                .build();
        EnjinCoinClient enjinService = new EnjinCoinClient(enjinConfig);
        tokensService = enjinService.getTokensService();
    }

    @Test
    public void testGetToken() {
        GetTokenRequestVO getTokenRequestVO = ImmutableGetTokenRequestVO.builder()
                .setTokenId("12345")
                .build();
        assertThat(getTokenRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                .satisfies(o -> assertThat(tokensService.getToken(o)).isNotNull()
                        .satisfies(o2 -> assertThat(o2.toString()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getAdapter()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getCreator()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getDecimals()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getExchangeRate()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getIcon()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getMaxMeltFee()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getMeltFee()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getName()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getTokenId()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getTotalSupply()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getTransferable()).isNotEmpty())
                );
    }

}
