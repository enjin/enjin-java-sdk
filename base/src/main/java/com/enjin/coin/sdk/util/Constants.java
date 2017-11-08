package com.enjin.coin.sdk.util;

public class Constants {

	protected Constants () {
		
	}
	
	private static final String TRUSTED_PLATFORM_BASE_URL = "http://localhost:8080";
	//Port 81 used when trying out the tcp ip monitor in eclipse
	//private static final String TRUSTED_PLATFORM_BASE_URL = "http://localhost:81";
	public static final String IDENTITIES_URL             = TRUSTED_PLATFORM_BASE_URL + "/Identities.php";
	public static final String TOKENS_URL                 = TRUSTED_PLATFORM_BASE_URL + "/Tokens.php";
	public static final String TRANSACTION_REQUESTS_URL   = TRUSTED_PLATFORM_BASE_URL + "/TransactionRequests.php";
	
	/** Constant for the accept header **/
	public static final String ACCEPT_HEADER = "Accept";	
	/** Constant for the content type header **/
	public static final String CONTENT_TYPE_HEADER = "Content-Type";	
	/** Constant for the json rpc type **/
	public static final String TYPE_JSON_RPC = "application/json-rpc";
	
	
	/** Constants for the identity methods **/
	public static final String METHOD_IDENTITIES_GET    = "Identities.get";
	public static final String METHOD_IDENTITIES_LIST   = "Identities.list";
	public static final String METHOD_IDENTITIES_DELETE = "Identities.delete";
	public static final String METHOD_IDENTITIES_CREATE = "Identities.create";
	public static final String METHOD_IDENTITIES_UPDATE = "Identities.update";
	
	/** Constants for the token methods **/
	public static final String METHOD_TOKENS_GET = "Token.get";
	
	/** Constants for the TransactionRequests methods **/
	public static final String METHOD_TRANSACTION_REQUESTS_GET    = "TransactionRequests.get";
	public static final String METHOD_TRANSACTION_REQUESTS_LIST   = "TransactionRequests.list";
	public static final String METHOD_TRANSACTION_REQUESTS_CREATE = "TransactionRequests.create";
	public static final String METHOD_TRANSACTION_REQUESTS_CANCEL = "TransactionRequests.cancel";
}
