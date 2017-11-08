package com.enjin.coin.sdk;

import org.apache.commons.lang3.StringUtils;

import com.enjin.coin.sdk.util.Constants;

public class BaseAction {
	


	public BaseAction() {
		
	}
	
	public BaseAction(String trustedPlatformUrl) {
		super();
		this.trustedPlatformUrl = trustedPlatformUrl;
	}
	private String trustedPlatformUrl;
	
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
		return getJsonRpcURL(Constants.IDENTITIES_URL);
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
		if (StringUtils.isNotEmpty(trustedPlatformUrl)) {
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
