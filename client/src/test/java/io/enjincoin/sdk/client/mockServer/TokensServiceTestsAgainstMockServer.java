package io.enjincoin.sdk.client.mockServer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import io.enjincoin.sdk.client.ClientImpl;
import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.config.ImmutableConfig;
import io.enjincoin.sdk.client.service.tokens.SynchronousTokensService;
import io.enjincoin.sdk.client.vo.token.GetTokenBalanceRequestVO;
import io.enjincoin.sdk.client.vo.token.GetTokenBalanceResponseVO;
import io.enjincoin.sdk.client.vo.token.GetTokenRequestVO;
import io.enjincoin.sdk.client.vo.token.GetTokenResponseVO;
import io.enjincoin.sdk.client.vo.token.ImmutableGetTokenBalanceRequestVO;
import io.enjincoin.sdk.client.vo.token.ImmutableGetTokenRequestVO;

public class TokensServiceTestsAgainstMockServer extends BaseMockServer {

    private SynchronousTokensService tokensService;

    @Before
    public void init() {
        Config enjinConfig = ImmutableConfig.builder()
                .setTrustedPlatform(this.getPlatform())
                .build();
        ClientImpl enjinService = new ClientImpl(enjinConfig);
        this.tokensService = enjinService.getTokensService();
    }

    @Test
    public void testGetToken() {
        GetTokenRequestVO getTokenRequestVO = ImmutableGetTokenRequestVO.builder()
                .setAppId("352")
                .setAfterTokenId("123456")
                .setLimit("50")
                .build();
        assertThat(getTokenRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());

        GetTokenResponseVO[] getTokenResponseVO = this.tokensService.getTokensSync(getTokenRequestVO);
        assertThat(getTokenResponseVO).isNotNull();
        for (GetTokenResponseVO tokenResponseVO : getTokenResponseVO) {
            assertThat(tokenResponseVO).isNotNull()
                    .satisfies(o -> assertThat(tokenResponseVO).isNotNull()
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

    @Test
    public void testGetBalanceToken() {
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

        assertThat(getTokenBalanceRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                .satisfies(o -> assertThat(o.getIdentityMap()).isNotEmpty())
                .satisfies(o -> assertThat(o.getTokenIdsMap()).isNotEmpty());

        GetTokenBalanceResponseVO[] getTokenBalanceResponseVO = this.tokensService.getTokenBalancesSync(getTokenBalanceRequestVO);
        assertThat(getTokenBalanceResponseVO).isNotNull();
        for (GetTokenBalanceResponseVO tokenBalanceResponseVO : getTokenBalanceResponseVO) {
            assertThat(tokenBalanceResponseVO).isNotNull()
                    .satisfies(o -> assertThat(tokenBalanceResponseVO).isNotNull()
                            .satisfies(o2 -> assertThat(o2.toString()).isNotEmpty())
                            .satisfies(o2 -> assertThat(o2.getTokenBalanceMap()).isNotNull()));
        }
    }

}
