package com.enjin.coin.sdk.util;

/**
 * <p>
 * Constants used throughout the SDK.
 * </p>
 */
public class Constants {

    /**
     * Class constructor.
     */
    protected Constants() {

    }

    /** the id to use for requests when in test mode. **/
    public static final String TEST_MODE_ID = "1";

    /** the trusted platform base url . **/
    public static final String TRUSTED_PLATFORM_BASE_URL = "http://localhost:8080";
    // Port 81 used when trying out the tcp ip monitor in eclipse
    // private static final String TRUSTED_PLATFORM_BASE_URL =
    // "http://localhost:81";
    /** the identities action. **/
    public static final String IDENTITIES_URL = "Identities.php";
    /** the tokens action. **/
    public static final String TOKENS_URL = "Tokens.php";
    /** the transactionRequests action. **/
    public static final String TRANSACTION_REQUESTS_URL = "TransactionRequests.php";
    /** the events action. **/
    public static final String EVENTS_URL = "Events.php";

    /** Constants for the Identities Get method. **/
    public static final String METHOD_IDENTITIES_GET = "Identities.get";
    /** Constants for the Identities List method. **/
    public static final String METHOD_IDENTITIES_LIST = "Identities.list";
    /** Constants for the Identities Create method. **/
    public static final String METHOD_IDENTITIES_CREATE = "Identities.create";
    /** Constants for the Identities Delete method. **/
    public static final String METHOD_IDENTITIES_DELETE = "Identities.delete";
    /** Constants for the Identities Update method. **/
    public static final String METHOD_IDENTITIES_UPDATE = "Identities.update";

    /** Constants for the Tokens Get method. **/
    public static final String METHOD_TOKENS_GET = "Tokens.get";
    /** Constants for the Tokens List method. **/
    public static final String METHOD_TOKENS_LIST = "Tokens.list";

    /** Constants for the TransactionRequests Get method. **/
    public static final String METHOD_TRANSACTION_REQUESTS_GET = "TransactionRequests.get";
    /** Constants for the TransactionRequests List method. **/
    public static final String METHOD_TRANSACTION_REQUESTS_LIST = "TransactionRequests.list";
    /** Constants for the TransactionRequests Create method. **/
    public static final String METHOD_TRANSACTION_REQUESTS_CREATE = "TransactionRequests.create";
    /** Constants for the TransactionRequests Cancel method. **/
    public static final String METHOD_TRANSACTION_REQUESTS_CANCEL = "TransactionRequests.cancel";

    /** Constants for the Events Get method. **/
    public static final String METHOD_EVENTS_GET = "Events.get";
    /** Constants for the Events List method. **/
    public static final String METHOD_EVENTS_LIST = "Events.list";

    /** Numeric constants - 1. **/
    public static final int ONE = 1;
    /** Numeric constants - 1000. **/
    public static final int ONE_THOUSAND = 1000;
    /** Numeric constants - 10,000. **/
    public static final int TEN_THOUSAND = 10000;
    /** Numeric constants - 100,000. **/
    public static final int ONE_HUNDRED_THOUSAND = 100000;

    /** Charset UTF-8. **/
    public static final String CHARSET_UTF_8 = "UTF-8";

}
