package com.enjin.coin.sdk;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenResponseVO;
import com.enjin.coin.sdk.vo.token.ListTokensRequestVO;
import com.enjin.coin.sdk.vo.token.ListTokensResponseVO;

public class TokensTestsAgainstMockServer {

	private Tokens tokens;
	
	private String tokenId;	
	private String appId;
	private String afterTokenId;
	private String limit;
	@Before
	public void setUp() {
		tokens = new Tokens();
		tokenId = "12345";
		appId = "352";
		afterTokenId = "123456";
		limit = "limit1";
	}
	
	@Test
	public void testGetToken() {		
		GetTokenRequestVO getTokenRequestVO = new GetTokenRequestVO();
		getTokenRequestVO.setTokenId(tokenId);
		GetTokenResponseVO getTokenResponseVO = tokens.getToken(getTokenRequestVO);
		assertNotNull(getTokenResponseVO);
		assertNotNull(getTokenResponseVO.getAdapter());
		assertNotNull(getTokenResponseVO.getCreator());	
		assertNotNull(getTokenResponseVO.getDecimals());	
		assertNotNull(getTokenResponseVO.getExchangeRate());	
		assertNotNull(getTokenResponseVO.getIcon());	
		assertNotNull(getTokenResponseVO.getMaxMeltFee());	
		assertNotNull(getTokenResponseVO.getMeltFee());	
		assertNotNull(getTokenResponseVO.getName());	
		assertNotNull(getTokenResponseVO.getOtherFields());	
		assertNotNull(getTokenResponseVO.getTokenId());	
		assertNotNull(getTokenResponseVO.getTotalSupply());
		assertNotNull(getTokenResponseVO.getTransferable());
	}
	
	@Test
	public void testListIdentities() {		
		ListTokensRequestVO listTokensRequestVO = new ListTokensRequestVO();
		listTokensRequestVO.setAfterTokenId(afterTokenId);
		listTokensRequestVO.setAppId(appId);
		listTokensRequestVO.setLimit(limit);
		
		ListTokensResponseVO listTokensResponseVOArray = tokens.listTokens(listTokensRequestVO);

		for (GetTokenResponseVO getTokenResponseVO : listTokensResponseVOArray.getGetTokenResponseVOArray()) {
			assertNotNull(getTokenResponseVO);
			assertNotNull(getTokenResponseVO.getAdapter());
			assertNotNull(getTokenResponseVO.getCreator());	
			assertNotNull(getTokenResponseVO.getDecimals());	
			assertNotNull(getTokenResponseVO.getExchangeRate());	
			assertNotNull(getTokenResponseVO.getIcon());	
			assertNotNull(getTokenResponseVO.getMaxMeltFee());	
			assertNotNull(getTokenResponseVO.getMeltFee());	
			assertNotNull(getTokenResponseVO.getName());	
			assertNotNull(getTokenResponseVO.getOtherFields());	
			assertNotNull(getTokenResponseVO.getTokenId());	
			assertNotNull(getTokenResponseVO.getTotalSupply());
			assertNotNull(getTokenResponseVO.getTransferable());
		}
	}
	
	
}
