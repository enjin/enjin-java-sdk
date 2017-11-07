package com.enjin.coin.sdk.util;

public class Constants {

	protected Constants () {
		
	}
	
	private static final String TRUSTED_PLATFORM_BASE_URL = "http://localhost:8080";
	public static final String IDENTITIES_URL             = TRUSTED_PLATFORM_BASE_URL + "/Identities.php";
	public static final String TOKENS_URL                 = TRUSTED_PLATFORM_BASE_URL + "/Tokens.php";
	public static final String TRANSACTION_REQUESTS_URL   = TRUSTED_PLATFORM_BASE_URL + "/TransactionRequests.php";
	
	/** Constant for the accept header **/
	public static final String ACCEPT_HEADER = "Accept";	
	/** Constant for the content type header **/
	public static final String CONTENT_TYPE_HEADER = "Content-Type";	
	/** Constant for the json rpc type **/
	public static final String TYPE_JSON_RPC = "application/json-rpc";
	
	
}
