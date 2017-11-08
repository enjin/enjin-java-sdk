package com.enjin.coin.sdk;

import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.util.JsonRpcUtils;
import com.enjin.coin.sdk.util.ValidationUtils;

public class BaseAction {

	private String trustedPlatformUrl;
	protected JsonRpcUtils jsonRpcUtils;
	public BaseAction() {
		jsonRpcUtils = new JsonRpcUtils();
	}
	
	public BaseAction(String trustedPlatformUrl) {
		super();
		this.trustedPlatformUrl = trustedPlatformUrl;
		jsonRpcUtils = new JsonRpcUtils();
	}
	
	public BaseAction(String trustedPlatformUrl, boolean inTestMode) {
		super();
		this.trustedPlatformUrl = trustedPlatformUrl;
		jsonRpcUtils = new JsonRpcUtils();
		jsonRpcUtils.setInTestMode(inTestMode);
	}
	public BaseAction(boolean inTestMode) {
		super();
		jsonRpcUtils = new JsonRpcUtils();
		jsonRpcUtils.setInTestMode(inTestMode);
	}
	/**
	 * Method to get the identities url
	 * @return
	 */
	protected String getIdentitiesUrl() {		
		return getJsonRpcURL(Constants.IDENTITIES_URL);
	}	
	/**
	 * Method to get the tokens url
	 * @return
	 */
	protected String getTokensUrl() {		
		return getJsonRpcURL(Constants.TOKENS_URL);
	}	
	/**
	 * Method to get the Transaction Requests url
	 * @return
	 */
	protected String getTransactionRequestsUrl() {		
		return getJsonRpcURL(Constants.TRANSACTION_REQUESTS_URL);
	}	
	
	/**
	 * Method to get the rpc url to use
	 * @param endpoint
	 * @return
	 */
	private String getJsonRpcURL(String endpoint) {
		String baseURL = Constants.TRUSTED_PLATFORM_BASE_URL;
		if (ValidationUtils.isNotEmpty(trustedPlatformUrl)) {
			baseURL = trustedPlatformUrl;
		}
		
		if (!baseURL.endsWith("/")) {
			baseURL += "/";
		}
		
		String jsonRpcURL = baseURL + endpoint;
		
		return jsonRpcURL;
	}

	public String getTrustedPlatformUrl() {
		return trustedPlatformUrl;
	}

	public void setTrustedPlatformUrl(String trustedPlatformUrl) {
		this.trustedPlatformUrl = trustedPlatformUrl;
	}

	@Override
	public String toString() {
		return "BaseAction [trustedPlatformUrl=" + trustedPlatformUrl + "]";
	}
	
}
