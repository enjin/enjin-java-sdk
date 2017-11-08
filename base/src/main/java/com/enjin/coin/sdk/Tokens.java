package com.enjin.coin.sdk;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenResponseVO;
import com.enjin.coin.sdk.vo.token.ListTokensRequestVO;
import com.enjin.coin.sdk.vo.token.ListTokensResponseVO;

public class Tokens extends BaseAction{

	private static final Logger LOGGER = LoggerFactory.getLogger(Tokens.class);
	
	/**
	 * Class contructor
	 */
	public Tokens() {
		
	}

	/**
	 * Class contructor
	 * @param trustedPlatformUrl
	 */
	public Tokens(String trustedPlatformUrl) {
		super(trustedPlatformUrl);
	}
	
	/**
	 * Method to get an identity
	 * @param getTokenRequestVO
	 * @return
	 */
	public GetTokenResponseVO getToken(GetTokenRequestVO getTokenRequestVO) {
		GetTokenResponseVO getTokenResponseVO = null;

		if (getTokenRequestVO == null || StringUtils.isEmpty(getTokenRequestVO.getTokenId())) {
			LOGGER.error("getTokenRequestVO is null or tokenId passed in are null or empty");
			return getTokenResponseVO;
		}		

		Map<String,Object> params = new HashMap<String,Object>();
		params.put("token_id",  getTokenRequestVO.getTokenId());

		// Construct new request
		String method = Constants.METHOD_TOKENS_GET;

		getTokenResponseVO = (GetTokenResponseVO) jsonRpcUtils.sendJsonRpcRequest(getTokensUrl(), GetTokenResponseVO.class, method, params);

		return getTokenResponseVO;
	}
	
	/**
	 * Method to list the identities
	 * @param listTokensRequestVO
	 * @return
	 */
	public ListTokensResponseVO listTokens(ListTokensRequestVO listTokensRequestVO) {
		ListTokensResponseVO listTokensResponseVO = null;

		if (listTokensRequestVO == null || StringUtils.isEmpty(listTokensRequestVO.getAppId()) || StringUtils.isEmpty(listTokensRequestVO.getAfterTokenId()) || StringUtils.isEmpty(listTokensRequestVO.getLimit())) {
			LOGGER.error("listTokensRequestVO is null, appId, afterTokenId or limit passed in are null or empty");
			return listTokensResponseVO;
		}
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("app_id",  listTokensRequestVO.getAppId());
		params.put("after_token_id", listTokensRequestVO.getAfterTokenId());
		params.put("limit", listTokensRequestVO.getLimit());

		// Construct new request
		String method = Constants.METHOD_TOKENS_LIST;

		GetTokenResponseVO[] getTokenResponseVOArray = (GetTokenResponseVO[]) jsonRpcUtils.sendJsonRpcRequest(getTokensUrl(), GetTokenResponseVO[].class, method, params);
		if (ArrayUtils.isEmpty(getTokenResponseVOArray)) {
			LOGGER.error("No tokens returned");
			return listTokensResponseVO;
		}
		listTokensResponseVO = new ListTokensResponseVO();
		listTokensResponseVO.setGetTokenResponseVOArray(getTokenResponseVOArray);
		
		return listTokensResponseVO;
	}
}
