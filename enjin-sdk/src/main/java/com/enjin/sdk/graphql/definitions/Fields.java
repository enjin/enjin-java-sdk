package com.enjin.sdk.graphql.definitions;

import com.enjin.sdk.graphql.GraphQLTemplateField;

public final class Fields {

    public static final GraphQLTemplateField ID = GraphQLTemplateField.of("id");
    public static final GraphQLTemplateField NAME = GraphQLTemplateField.of("name");
    public static final GraphQLTemplateField EMAIL = GraphQLTemplateField.of("email");
    public static final GraphQLTemplateField ACCESS_TOKENS = GraphQLTemplateField.of("access_tokens");
    public static final GraphQLTemplateField APP_ID = GraphQLTemplateField.of("app_id");
    public static final GraphQLTemplateField ETH_ADDR = GraphQLTemplateField.of("ethereum_address");
    public static final GraphQLTemplateField LINKING_CODE = GraphQLTemplateField.of("linking_code");
    public static final GraphQLTemplateField LINKING_CODE_QR = GraphQLTemplateField.of("linking_code_qr");
    public static final GraphQLTemplateField VALUE = GraphQLTemplateField.of("value");
    public static final GraphQLTemplateField TOKEN_ID = GraphQLTemplateField.of("token_id");
    public static final GraphQLTemplateField TOKEN_INDEX = GraphQLTemplateField.of("token_index");
    public static final GraphQLTemplateField INDEX = GraphQLTemplateField.of("index");
    public static final GraphQLTemplateField IDENTITY_ID = GraphQLTemplateField.of("identity_id");
    public static final GraphQLTemplateField BALANCE = GraphQLTemplateField.of("balance");
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
    public static final GraphQLTemplateField ETH_BALANCE = GraphQLTemplateField.of("eth_balance");
    public static final GraphQLTemplateField ENJ_BALANCE = GraphQLTemplateField.of("enj_balance");
    public static final GraphQLTemplateField ENJ_ALLOWANCE = GraphQLTemplateField.of("enj_allowance");
    public static final GraphQLTemplateField ALL_TOKENS_BALANCE = GraphQLTemplateField.of("all_tokens_balance");
    public static final GraphQLTemplateField NETWORK = GraphQLTemplateField.of("network");
    public static final GraphQLTemplateField NOTIFICATIONS = GraphQLTemplateField.of("notifications");
    public static final GraphQLTemplateField TRANSACTION_ID = GraphQLTemplateField.of("transaction_id");
    public static final GraphQLTemplateField RECIPIENT_ID = GraphQLTemplateField.of("recipient_id");
    public static final GraphQLTemplateField RECIPIENT_ADDR = GraphQLTemplateField.of("recipient_address");
    public static final GraphQLTemplateField ENCODED_DATA = GraphQLTemplateField.of("encoded_data");
    public static final GraphQLTemplateField SIGNED_TRANSACTION = GraphQLTemplateField.of("signed_transaction");
    public static final GraphQLTemplateField SIGNED_BACKUP_TRANSACTION = GraphQLTemplateField.of(
            "signed_backup_transaction");
    public static final GraphQLTemplateField SIGNED_CANCEL_TRANSACTION = GraphQLTemplateField.of(
            "signed_cancel_transaction");
    public static final GraphQLTemplateField NONCE = GraphQLTemplateField.of("nonce");
    public static final GraphQLTemplateField RETRY_STATE = GraphQLTemplateField.of("retry_state");
    public static final GraphQLTemplateField STATE = GraphQLTemplateField.of("state");
    public static final GraphQLTemplateField ACCEPTED = GraphQLTemplateField.of("accepted");
    public static final GraphQLTemplateField EVENT = GraphQLTemplateField.of("event");
    public static final GraphQLTemplateField PARAM1 = GraphQLTemplateField.of("param1");
    public static final GraphQLTemplateField PARAM2 = GraphQLTemplateField.of("param2");
    public static final GraphQLTemplateField PARAM3 = GraphQLTemplateField.of("param3");
    public static final GraphQLTemplateField PARAM4 = GraphQLTemplateField.of("param4");
    public static final GraphQLTemplateField BLOCK_NUMBER = GraphQLTemplateField.of("blockNumber");
    public static final GraphQLTemplateField BLOCK = GraphQLTemplateField.of("block");
    public static final GraphQLTemplateField SECRET = GraphQLTemplateField.of("secret");
    public static final GraphQLTemplateField DESCRIPTION = GraphQLTemplateField.of("description");
    public static final GraphQLTemplateField IMAGE = GraphQLTemplateField.of("image");
    public static final GraphQLTemplateField TOKEN_COUNT = GraphQLTemplateField.of("token_count");
    public static final GraphQLTemplateField ITEM_URI = GraphQLTemplateField.of("itemURI");
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
    public static final GraphQLTemplateField PERMISSIONS = GraphQLTemplateField.of("permissions")
                                                                               .withChild(ID)
                                                                               .withChild(NAME);
    public static final GraphQLTemplateField ROLES = GraphQLTemplateField.of("roles")
                                                                         .withChild(ID)
                                                                         .withChild(NAME)
                                                                         .withChild(PERMISSIONS)
                                                                         .withChild(APP_ID);
    public static final GraphQLTemplateField IDENT_TOK_BAL = GraphQLTemplateField.of("tokens")
                                                                                 .withChild(TOKEN_ID)
                                                                                 .withChild(INDEX)
                                                                                 .withChild(BALANCE);
    public static final GraphQLTemplateField BALANCE_TOKEN = GraphQLTemplateField.of("token")
                                                                                 .withChild(NAME)
                                                                                 .withChild(ITEM_URI);
    public static final GraphQLTemplateField IDENT_BASE = GraphQLTemplateField.of("identities")
                                                                              .withChild(ID)
                                                                              .withChild(APP_ID)
                                                                              .withChild(ETH_ADDR)
                                                                              .withChild(LINKING_CODE)
                                                                              .withChild(LINKING_CODE_QR);
    public static final GraphQLTemplateField IDENT_W_BALS = GraphQLTemplateField.of("identities")
                                                                                .copyChildren(IDENT_BASE)
                                                                                .withChild(IDENT_TOK_BAL)
                                                                                .withChild(ETH_BALANCE)
                                                                                .withChild(ENJ_BALANCE)
                                                                                .withChild(ENJ_ALLOWANCE)
                                                                                .withChild(ALL_TOKENS_BALANCE);
    public static final GraphQLTemplateField EVENTS = GraphQLTemplateField.of("events")
                                                                          .withChild(ID)
                                                                          .withChild(TOKEN_ID)
                                                                          .withChild(EVENT)
                                                                          .withChild(PARAM1)
                                                                          .withChild(PARAM2)
                                                                          .withChild(PARAM3)
                                                                          .withChild(PARAM4)
                                                                          .withChild(BLOCK_NUMBER);

    private Fields() {
        throw new UnsupportedOperationException("Utility Class");
    }

}
