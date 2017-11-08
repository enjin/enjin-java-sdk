package com.enjin.coin.sdk.util;

public class Constants {

	protected Constants () {
		
	}
	
	//the id to use for requests when in test mode
	public static String testModeId = "1";
	
	public static final String TRUSTED_PLATFORM_BASE_URL = "http://localhost:8080";
	//Port 81 used when trying out the tcp ip monitor in eclipse
	//private static final String TRUSTED_PLATFORM_BASE_URL = "http://localhost:81";
	public static final String IDENTITIES_URL             = "Identities.php";
	public static final String TOKENS_URL                 = "Tokens.php";
	public static final String TRANSACTION_REQUESTS_URL   = "TransactionRequests.php";
	
	/** Constants for the Identities methods **/
	public static final String METHOD_IDENTITIES_GET    = "Identities.get";
	public static final String METHOD_IDENTITIES_LIST   = "Identities.list";
	public static final String METHOD_IDENTITIES_CREATE = "Identities.create";
	public static final String METHOD_IDENTITIES_DELETE = "Identities.delete";
	public static final String METHOD_IDENTITIES_UPDATE = "Identities.update";
	
	/** Constants for the Tokens methods **/
	public static final String METHOD_TOKENS_GET = "Tokens.get";
	public static final String METHOD_TOKENS_LIST = "Tokens.list";
	
	/** Constants for the TransactionRequests methods **/
	public static final String METHOD_TRANSACTION_REQUESTS_GET    = "TransactionRequests.get";
	public static final String METHOD_TRANSACTION_REQUESTS_LIST   = "TransactionRequests.list";
	public static final String METHOD_TRANSACTION_REQUESTS_CREATE = "TransactionRequests.create";
	public static final String METHOD_TRANSACTION_REQUESTS_CANCEL = "TransactionRequests.cancel";
	
	/** Constants for the Events methods **/
	public static final String METHOD_EVENTS_GET  = "Events.get";
	public static final String METHOD_EVENTS_LIST = "Events.list";
	
	/** Numeric constants **/
	public static final int ONE_THOUSAND = 1000;
	public static final int TEN_THOUSAND = 10000;
	public static final int ONE_HUNDRED_THOUSAND = 100000;

}
