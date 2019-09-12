package com.enjin.sdk.graphql.definitions;

public final class Methods {

    // Platform
    public static final String ENJIN_PLATFORM = "EnjinPlatform";

    // Ethereum
    public static final String ENJIN_BLOCK_HEIGHT = "EnjinBlockHeight";

    // Oauth
    public static final String ENJIN_OAUTH = "EnjinOauth";

    // Apps
    public static final String ENJIN_APPS = "EnjinApps";
    public static final String CREATE_ENJIN_APP = "CreateEnjinApp";
    public static final String UPDATE_ENJIN_APP = "UpdateEnjinApp";
    public static final String DELETE_ENJIN_APP = "DeleteEnjinApp";

    // Roles
    public static final String ENJIN_ROLES = "EnjinRoles";
    public static final String CREATE_ENJIN_ROLE = "CreateEnjinRole";
    public static final String UPDATE_ENJIN_ROLE = "UpdateEnjinRole";
    public static final String DELETE_ENJIN_ROLE = "DeleteEnjinRole";

    // Users
    public static final String ENJIN_USERS = "EnjinUsers";
    public static final String CREATE_ENJIN_USER = "CreateEnjinUser";
    public static final String UPDATE_ENJIN_USER = "UpdateEnjinUser";
    public static final String DELETE_ENJIN_USER = "DeleteEnjinUser";

    // Identities
    public static final String ENJIN_IDENTITIES = "EnjinIdentities";
    public static final String CREATE_ENJIN_IDENTITY = "CreateEnjinIdentity";
    public static final String UPDATE_ENJIN_IDENTITY = "UpdateEnjinIdentity";
    public static final String DELETE_ENJIN_IDENTITY = "DeleteEnjinIdentity";

    // Tokens
    public static final String ENJIN_TOKENS = "EnjinTokens";
    public static final String CREATE_ENJIN_TOKEN = "CreateEnjinToken";
    public static final String UPDATE_ENJIN_TOKEN = "UpdateEnjinToken";
    public static final String DELETE_ENJIN_TOKEN = "DeleteEnjinToken";
    public static final String ENJIN_TOKEN_EVENTS = "EnjinTokenEvents";

    // Requests
    public static final String ENJIN_TRANSACTIONS = "EnjinTransactions";
    public static final String CREATE_ENJIN_REQUEST = "CreateEnjinRequest";
    public static final String UPDATE_ENJIN_REQUEST = "UpdateEnjinRequest";
    public static final String DELETE_ENJIN_REQUEST = "DeleteEnjinRequest";

    // Balances
    public static final String ENJIN_BALANCES = "EnjinBalances";

    private Methods() {
        throw new UnsupportedOperationException("Utility Class");
    }

}
