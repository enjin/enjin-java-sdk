package com.enjin.coin.sdk.mockServer;

import com.enjin.coin.sdk.config.EnjinConfig;
import com.enjin.coin.sdk.service.EnjinService;
import com.enjin.coin.sdk.service.TokensService;
import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenResponseVO;
import com.enjin.coin.sdk.vo.token.ListTokensRequestVO;
import com.enjin.coin.sdk.vo.token.ListTokensResponseVO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TokensServiceTestsAgainstMockServer extends BaseMockServer {

    private TokensService tokens;


    @Before
    public void init() {
        EnjinConfig enjinConfig = new EnjinConfig();
        enjinConfig.setTrustedPlatformUrl(getURL());
        enjinConfig.setInTestMode(true);
        EnjinService enjinService = new EnjinService(enjinConfig);
        tokens = enjinService.getTokensService();
    }

    @Test
    public void testGetToken() {
        GetTokenRequestVO getTokenRequestVO = new GetTokenRequestVO();
        getTokenRequestVO.setTokenId("12345");
        assertNotNull(getTokenRequestVO.toString());

        GetTokenResponseVO getTokenResponseVO = tokens.getToken(getTokenRequestVO);
        assertNotNull(getTokenResponseVO);
        assertNotNull(getTokenResponseVO.toString());
        assertNotNull(getTokenResponseVO.getAdapter());
        assertNotNull(getTokenResponseVO.getCreator());
        assertNotNull(getTokenResponseVO.getDecimals());
        assertNotNull(getTokenResponseVO.getExchangeRate());
        assertNotNull(getTokenResponseVO.getIcon());
        assertNotNull(getTokenResponseVO.getMaxMeltFee());
        assertNotNull(getTokenResponseVO.getMeltFee());
        assertNotNull(getTokenResponseVO.getName());
        assertNotNull(getTokenResponseVO.getTokenId());
        assertNotNull(getTokenResponseVO.getTotalSupply());
        assertNotNull(getTokenResponseVO.getTransferable());
    }

    @Test
    public void testListIdentities() {
        ListTokensRequestVO listTokensRequestVO = new ListTokensRequestVO();
        listTokensRequestVO.setAfterTokenId("123456");
        listTokensRequestVO.setAppId("352");
        listTokensRequestVO.setLimit("limit1");
        assertNotNull(listTokensRequestVO.toString());

        ListTokensResponseVO listTokensResponseVOArray = tokens.listTokens(listTokensRequestVO);
        assertNotNull(listTokensResponseVOArray.toString());

        for (GetTokenResponseVO getTokenResponseVO : listTokensResponseVOArray.getGetTokensResponseVOArray()) {
            assertNotNull(getTokenResponseVO);
            assertNotNull(getTokenResponseVO.toString());
            assertNotNull(getTokenResponseVO.getAdapter());
            assertNotNull(getTokenResponseVO.getCreator());
            assertNotNull(getTokenResponseVO.getDecimals());
            assertNotNull(getTokenResponseVO.getExchangeRate());
            assertNotNull(getTokenResponseVO.getIcon());
            assertNotNull(getTokenResponseVO.getMaxMeltFee());
            assertNotNull(getTokenResponseVO.getMeltFee());
            assertNotNull(getTokenResponseVO.getName());
            assertNotNull(getTokenResponseVO.getTokenId());
            assertNotNull(getTokenResponseVO.getTotalSupply());
            assertNotNull(getTokenResponseVO.getTransferable());
        }
    }


}
