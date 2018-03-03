package io.enjincoin.sdk.client.util;

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

    /**
     * the id to use for requests when in test mode.
     **/
    public static final String TEST_MODE_ID = "1";

    /**
     * the trusted platform base url .
     **/
    public static final String TRUSTED_PLATFORM_BASE_URL = "http://localhost:8080";
    // Port 81 used when trying out the tcp ip monitor in eclipse
    // private static final String TRUSTED_PLATFORM_BASE_URL =
    // "http://localhost:81";
    /**
     * the identities action.
     **/
    public static final String IDENTITIES_URL = "identities";

    /**
     * the link wallet action.
     **/
    public static final String LINK_WALLET_URL = "identity/link-wallet";


    /**
     * the tokens action.
     **/
    public static final String TOKENS_URL = "Tokens.php";
    /**
     * the transactionRequests action.
     **/
    public static final String TRANSACTION_REQUESTS_URL = "TransactionRequests.php";
    /**
     * the events action.
     **/
    public static final String EVENTS_URL = "Events.php";
    /**
     * the Platform action.
     **/
    public static final String PLATFORM_URL = "Platform.php";


    /**
     * Constants for the Identities Create method.
     **/
    public static final String METHOD_IDENTITIES_CREATE = "create";
    /**
     * Constants for the Identities Delete method.
     **/
    public static final String METHOD_IDENTITIES_DELETE = "delete";
    /**
     * Constants for the Identities Update method.
     **/
    public static final String METHOD_IDENTITIES_UPDATE = "update";

    /**
     * Constants for the Tokens Get method.
     **/
    public static final String METHOD_TOKENS_GET = "get";
    /**
     * Constants for the Tokens GetBalance method.
     **/
    public static final String METHOD_TOKENS_GET_BALANCE = "getBalance";

    /**
     * Constants for the TransactionRequests Get method.
     **/
    public static final String METHOD_TRANSACTION_REQUESTS_GET = "get";
    /**
     * Constants for the TransactionRequests Create method.
     **/
    public static final String METHOD_TRANSACTION_REQUESTS_CREATE = "create";
    /**
     * Constants for the TransactionRequests Cancel method.
     **/
    public static final String METHOD_TRANSACTION_REQUESTS_CANCEL = "cancel";

    /**
     * Constants for the Events Get method.
     **/
    public static final String METHOD_EVENTS_GET = "get";

    /**
     * Constants for the Platform Auth method.
     **/
    public static final String METHOD_PLATFORM_AUTH = "auth";

    /**
     * Numeric constants - 1.
     **/
    public static final int ONE = 1;
    /**
     * Numeric constants - 1000.
     **/
    public static final int ONE_THOUSAND = 1000;
    /**
     * Numeric constants - 10,000.
     **/
    public static final int TEN_THOUSAND = 10000;
    /**
     * Numeric constants - 40,000.
     **/
    public static final Long FOUR_THOUSAND = 4000L;
    /**
     * Numeric constants - 100,000.
     **/
    public static final int ONE_HUNDRED_THOUSAND = 100000;

    /**
     * Charset UTF-8.
     **/
    public static final String CHARSET_UTF_8 = "UTF-8";

    /**
     * Constants for the success http code
     */
    public static final int SUCCESS_HTTP_CODE = 200;


}
