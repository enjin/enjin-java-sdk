package com.enjin.enjincoin.sdk.graphql.api;

import com.enjin.enjincoin.sdk.graphql.GraphQLTemplateField;

public class Fields {

    public static final GraphQLTemplateField ID                 = GraphQLTemplateField.of("id");
    public static final GraphQLTemplateField NAME               = GraphQLTemplateField.of("name");
    public static final GraphQLTemplateField EMAIL              = GraphQLTemplateField.of("email");
    public static final GraphQLTemplateField ACCESS_TOKENS      = GraphQLTemplateField.of("access_tokens");
    public static final GraphQLTemplateField APP_ID             = GraphQLTemplateField.of("app_id");
    public static final GraphQLTemplateField ETH_ADDR           = GraphQLTemplateField.of("ethereum_address");
    public static final GraphQLTemplateField LINKING_CODE       = GraphQLTemplateField.of("linking_code");
    public static final GraphQLTemplateField LINKING_CODE_QR    = GraphQLTemplateField.of("linking_code_qr");
    public static final GraphQLTemplateField KEY                = GraphQLTemplateField.of("key");
    public static final GraphQLTemplateField VALUE              = GraphQLTemplateField.of("value");
    public static final GraphQLTemplateField TOKEN_ID           = GraphQLTemplateField.of("token_id");
    public static final GraphQLTemplateField BALANCE            = GraphQLTemplateField.of("balance");
    public static final GraphQLTemplateField ETH_BALANCE        = GraphQLTemplateField.of("eth_balance");
    public static final GraphQLTemplateField ENJ_BALANCE        = GraphQLTemplateField.of("enj_balance");
    public static final GraphQLTemplateField ENJ_ALLOWANCE      = GraphQLTemplateField.of("enj_allowance");
    public static final GraphQLTemplateField ALL_TOKENS_BALANCE = GraphQLTemplateField.of("all_tokens_balance");
    public static final GraphQLTemplateField NETWORK            = GraphQLTemplateField.of("network");
    public static final GraphQLTemplateField NOTIFICATIONS      = GraphQLTemplateField.of("notifications");
    public static final GraphQLTemplateField CURSOR             = GraphQLTemplateField.of("cursor")
                                                                                      .withChild(GraphQLTemplateField.of("total"))
                                                                                      .withChild(GraphQLTemplateField.of("perPage"))
                                                                                      .withChild(GraphQLTemplateField.of("currentPage"))
                                                                                      .withChild(GraphQLTemplateField.of("hasPages"));
    public static final GraphQLTemplateField PERMISSIONS        = GraphQLTemplateField.of("permissions")
                                                                                      .withChild(ID)
                                                                                      .withChild(NAME);
    public static final GraphQLTemplateField ROLES              = GraphQLTemplateField.of("roles")
                                                                                      .withChild(ID)
                                                                                      .withChild(NAME)
                                                                                      .withChild(PERMISSIONS)
                                                                                      .withChild(APP_ID);
    public static final GraphQLTemplateField FIELDS             = GraphQLTemplateField.of("fields")
                                                                                      .withChild(KEY)
                                                                                      .withChild(VALUE);
    public static final GraphQLTemplateField TOKENS             = GraphQLTemplateField.of("tokens")
                                                                                      .withChild(TOKEN_ID)
                                                                                      .withChild(BALANCE);
    public static final GraphQLTemplateField IDENTITIES         = GraphQLTemplateField.of("identities")
                                                                                      .withChild(ID)
                                                                                      .withChild(APP_ID)
                                                                                      .withChild(ETH_ADDR)
                                                                                      .withChild(LINKING_CODE)
                                                                                      .withChild(LINKING_CODE_QR)
                                                                                      .withChild(FIELDS)
                                                                                      .withChild(TOKENS)
                                                                                      .withChild(ETH_BALANCE)
                                                                                      .withChild(ENJ_BALANCE)
                                                                                      .withChild(ENJ_ALLOWANCE)
                                                                                      .withChild(ALL_TOKENS_BALANCE);
}
