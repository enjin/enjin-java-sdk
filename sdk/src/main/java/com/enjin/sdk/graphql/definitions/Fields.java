package com.enjin.sdk.graphql.definitions;

import com.enjin.sdk.graphql.GraphQLTemplateField;

public final class Fields {

    public static final GraphQLTemplateField ID = GraphQLTemplateField.of("id");
    public static final GraphQLTemplateField NAME = GraphQLTemplateField.of("name");
    public static final GraphQLTemplateField ACCESS_TOKENS = GraphQLTemplateField.of("accessTokens");
    public static final GraphQLTemplateField ACCESS_TOKEN = GraphQLTemplateField.of("accessToken");
    public static final GraphQLTemplateField REFRESH_TOKEN = GraphQLTemplateField.of("refreshToken");
    public static final GraphQLTemplateField APP_ID = GraphQLTemplateField.of("appId");
    public static final GraphQLTemplateField ETH_ADDR = GraphQLTemplateField.of("ethAddress");
    public static final GraphQLTemplateField LINKING_CODE = GraphQLTemplateField.of("linkingCode");
    public static final GraphQLTemplateField LINKING_CODE_QR = GraphQLTemplateField.of("linkingCodeQr");
    public static final GraphQLTemplateField VALUE = GraphQLTemplateField.of("value");
    public static final GraphQLTemplateField TOKEN_ID = GraphQLTemplateField.of("tokenId");
    public static final GraphQLTemplateField TOKEN_ID_OLD = GraphQLTemplateField.of("token_id");
    public static final GraphQLTemplateField TOKEN_INDEX_OLD = GraphQLTemplateField.of("token_index");
    public static final GraphQLTemplateField INDEX = GraphQLTemplateField.of("index");
    public static final GraphQLTemplateField IDENTITY_ID = GraphQLTemplateField.of("identity_id");
    public static final GraphQLTemplateField CREATOR = GraphQLTemplateField.of("creator");
    public static final GraphQLTemplateField MELT_VALUE = GraphQLTemplateField.of("meltValue");
    public static final GraphQLTemplateField MELT_FEE_RATIO = GraphQLTemplateField.of("meltFeeRatio");
    public static final GraphQLTemplateField MELT_FEE_MAX_RATIO = GraphQLTemplateField.of("meltFeeMaxRatio");
    public static final GraphQLTemplateField SUPPLY_MODEL = GraphQLTemplateField.of("supplyModel");
    public static final GraphQLTemplateField TOTAL_SUPPLY = GraphQLTemplateField.of("totalSupply");
    public static final GraphQLTemplateField CIRCULATING_SUPPLY = GraphQLTemplateField.of("circulatingSupply");
    public static final GraphQLTemplateField RESERVE = GraphQLTemplateField.of("reserve");
    public static final GraphQLTemplateField TRANSFERABLE = GraphQLTemplateField.of("transferable");
    public static final GraphQLTemplateField NON_FUNGIBLE = GraphQLTemplateField.of("nonFungible");
    public static final GraphQLTemplateField FIRST_BLOCK = GraphQLTemplateField.of("firstBlock");
    public static final GraphQLTemplateField BLOCK_HEIGHT = GraphQLTemplateField.of("blockHeight");
    public static final GraphQLTemplateField MARKED_FOR_DELETE = GraphQLTemplateField.of("markedForDelete");
    public static final GraphQLTemplateField TYPE = GraphQLTemplateField.of("type");
    public static final GraphQLTemplateField ETH_BALANCE = GraphQLTemplateField.of("ethBalance");
    public static final GraphQLTemplateField ENJ_BALANCE = GraphQLTemplateField.of("enjBalance");
    public static final GraphQLTemplateField ENJ_ALLOWANCE = GraphQLTemplateField.of("enjAllowance");
    public static final GraphQLTemplateField NETWORK = GraphQLTemplateField.of("network");
    public static final GraphQLTemplateField NOTIFICATIONS = GraphQLTemplateField.of("notifications");
    public static final GraphQLTemplateField TRANSACTION_ID = GraphQLTemplateField.of("transactionId");
    public static final GraphQLTemplateField RECIPIENT_ID = GraphQLTemplateField.of("recipientId");
    public static final GraphQLTemplateField RECIPIENT_ADDR = GraphQLTemplateField.of("recipientAddress");
    public static final GraphQLTemplateField ENCODED_DATA = GraphQLTemplateField.of("encodedData");
    public static final GraphQLTemplateField SIGNED_TRANSACTION = GraphQLTemplateField.of("signedTransaction");
    public static final GraphQLTemplateField SIGNED_BACKUP_TRANSACTION = GraphQLTemplateField.of(
            "signedBackupTransaction");
    public static final GraphQLTemplateField SIGNED_CANCEL_TRANSACTION = GraphQLTemplateField.of(
            "signedCancelTransaction");
    public static final GraphQLTemplateField NONCE = GraphQLTemplateField.of("nonce");
    public static final GraphQLTemplateField RETRY_STATE = GraphQLTemplateField.of("retryState");
    public static final GraphQLTemplateField STATE = GraphQLTemplateField.of("state");
    public static final GraphQLTemplateField ACCEPTED = GraphQLTemplateField.of("accepted");
    public static final GraphQLTemplateField EVENT = GraphQLTemplateField.of("event");
    public static final GraphQLTemplateField PARAM1 = GraphQLTemplateField.of("param1");
    public static final GraphQLTemplateField PARAM2 = GraphQLTemplateField.of("param2");
    public static final GraphQLTemplateField PARAM3 = GraphQLTemplateField.of("param3");
    public static final GraphQLTemplateField PARAM4 = GraphQLTemplateField.of("param4");
    public static final GraphQLTemplateField BLOCK_NUMBER = GraphQLTemplateField.of("blockNumber");
    public static final GraphQLTemplateField SECRET = GraphQLTemplateField.of("secret");
    public static final GraphQLTemplateField DESCRIPTION = GraphQLTemplateField.of("description");
    public static final GraphQLTemplateField IMAGE = GraphQLTemplateField.of("image");
    public static final GraphQLTemplateField TOKEN_COUNT = GraphQLTemplateField.of("token_count");
    public static final GraphQLTemplateField ITEM_URI = GraphQLTemplateField.of("itemURI");
    public static final GraphQLTemplateField WALLETS = GraphQLTemplateField.of("wallets")
                                                                           .withChild(ETH_ADDR);
    public static final GraphQLTemplateField OWNER = GraphQLTemplateField.of("owner")
                                                                         .withChild(ID)
                                                                         .withChild(NAME);
    public static final GraphQLTemplateField CURSOR = GraphQLTemplateField.of("cursor")
                                                                          .withChild("total")
                                                                          .withChild("perPage")
                                                                          .withChild("currentPage")
                                                                          .withChild("hasPages");
    public static final GraphQLTemplateField TRANSFER_FEE_SETTINGS = GraphQLTemplateField.of("transferFeeSettings")
                                                                                         .withChild(TYPE)
                                                                                         .withChild(TOKEN_ID)
                                                                                         .withChild(VALUE);
    public static final GraphQLTemplateField WALLET_ADDRESS = GraphQLTemplateField.of("wallet")
                                                                                  .withChild(ETH_ADDR);
    public static final GraphQLTemplateField BAL_IDENT_ID = GraphQLTemplateField.of("identity")
                                                                                .withChild(ID);
    public static final GraphQLTemplateField IDENT_BASE = GraphQLTemplateField.of("identities")
                                                                              .withChild(ID)
                                                                              .withChild(APP_ID)
                                                                              .withChild(WALLET_ADDRESS)
                                                                              .withChild(LINKING_CODE)
                                                                              .withChild(LINKING_CODE_QR);
    public static final GraphQLTemplateField BALANCES_SIMPLE = GraphQLTemplateField.of("balances")
                                                                                   .withChild(ID)
                                                                                   .withChild(INDEX)
                                                                                   .withChild(VALUE);
    public static final GraphQLTemplateField BALANCES = GraphQLTemplateField.of("balances")
                                                                            .copyChildren(BALANCES_SIMPLE)
                                                                            .withChild(BAL_IDENT_ID);
    public static final GraphQLTemplateField WALLET = GraphQLTemplateField.of("wallet")
                                                                          .copyChildren(WALLET_ADDRESS)
                                                                          .withChild(ENJ_ALLOWANCE)
                                                                          .withChild(ENJ_BALANCE)
                                                                          .withChild(ETH_BALANCE)
                                                                          .withChild(BALANCES_SIMPLE);
    public static final GraphQLTemplateField IDENT_W_BALS = GraphQLTemplateField.of("identities")
                                                                                .copyChildren(IDENT_BASE)
                                                                                .withChild(WALLET);
    public static final GraphQLTemplateField EVENTS = GraphQLTemplateField.of("events")
                                                                          .withChild(ID)
                                                                          .withChild(TOKEN_ID)
                                                                          .withChild(EVENT)
                                                                          .withChild(PARAM1)
                                                                          .withChild(PARAM2)
                                                                          .withChild(PARAM3)
                                                                          .withChild(PARAM4)
                                                                          .withChild(BLOCK_NUMBER);
    public static final GraphQLTemplateField USER_APPS = GraphQLTemplateField.of("apps")
                                                                             .withChild(ID)
                                                                             .withChild(NAME)
                                                                             .withChild(WALLETS);

    private Fields() {
        throw new UnsupportedOperationException("Utility Class");
    }

}
