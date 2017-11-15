package com.enjin.coin.sdk.mockServer;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.config.ImmutableConfig;
import com.enjin.coin.sdk.service.EnjinService;
import com.enjin.coin.sdk.service.TokensService;
import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.ImmutableGetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.ImmutableListTokensRequestVO;
import com.enjin.coin.sdk.vo.token.ListTokensRequestVO;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class TokensServiceTestsAgainstMockServer extends BaseMockServer {

    private TokensService tokens;

    @Before
    public void init() {
        Config enjinConfig = ImmutableConfig.builder()
                .setTrustedPlatform(getPlatform())
                .setInTestMode(true)
                .build();
        EnjinService enjinService = new EnjinService(enjinConfig);
        tokens = enjinService.getTokensService();
    }

    @Test
    public void testGetToken() {
        GetTokenRequestVO getTokenRequestVO = ImmutableGetTokenRequestVO.builder()
                .setTokenId("12345")
                .build();
        assertThat(getTokenRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                .satisfies(o -> assertThat(tokens.getToken(o)).isNotNull()
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

    @Test
    public void testListIdentities() {
        ListTokensRequestVO listTokensRequestVO = ImmutableListTokensRequestVO.builder()
                .setAppId("123456")
                .setAfterTokenId("352")
                .setLimit("limit1")
                .build();
        assertThat(listTokensRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                .satisfies(o -> assertThat(tokens.listTokens(o)).isNotNull()
                        .satisfies(o2 -> assertThat(o2.toString()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getGetTokensResponseVOArray()).isPresent()
                                .hasValueSatisfying(o3 -> assertThat(o3).allSatisfy(i -> assertThat(i).isNotNull()
                                        .satisfies(o4 -> assertThat(o4.toString()).isNotEmpty())
                                        .satisfies(o4 -> assertThat(o4.getAdapter()).isNotEmpty())
                                        .satisfies(o4 -> assertThat(o4.getCreator()).isNotEmpty())
                                        .satisfies(o4 -> assertThat(o4.getDecimals()).isNotEmpty())
                                        .satisfies(o4 -> assertThat(o4.getExchangeRate()).isNotEmpty())
                                        .satisfies(o4 -> assertThat(o4.getIcon()).isNotEmpty())
                                        .satisfies(o4 -> assertThat(o4.getMaxMeltFee()).isNotEmpty())
                                        .satisfies(o4 -> assertThat(o4.getMeltFee()).isNotEmpty())
                                        .satisfies(o4 -> assertThat(o4.getName()).isNotEmpty())
                                        .satisfies(o4 -> assertThat(o4.getTokenId()).isNotEmpty())
                                        .satisfies(o4 -> assertThat(o4.getTotalSupply()).isNotEmpty())
                                        .satisfies(o4 -> assertThat(o4.getTransferable()).isNotEmpty())))));
    }

}
