package com.enjin.enjincoin.sdk.graphql.api;

import com.enjin.enjincoin.sdk.graphql.GraphQLTemplate;
import static com.enjin.enjincoin.sdk.graphql.api.Fields.*;
import static com.enjin.enjincoin.sdk.graphql.api.Methods.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class Templates {

    // Platform
    public static final GraphQLTemplate GET_PLATFORM = GraphQLTemplate.of("GetPlatform", false, ENJIN_PLATFORM)
                                                                      .withField(ID)
                                                                      .withField(NAME)
                                                                      .withField(NETWORK)
                                                                      .withField(NOTIFICATIONS);

    // Users
    public static final GraphQLTemplate GET_USERS   = GraphQLTemplate.of("GetUsers", false, ENJIN_USERS)
                                                                     .withField(ID)
                                                                     .withField(NAME)
                                                                     .withField(EMAIL)
                                                                     .withField(ACCESS_TOKENS)
                                                                     .withField(ROLES)
                                                                     .withField(IDENTITIES);
    public static final GraphQLTemplate LOGIN_USER  = GraphQLTemplate.of("LoginUser", false, ENJIN_OAUTH)
                                                                     .copyFields(GET_USERS);
    public static final GraphQLTemplate CREATE_USER = GraphQLTemplate.of("CreateUser", true, CREATE_ENJIN_USER)
                                                                     .copyFields(GET_USERS);
    public static final GraphQLTemplate UPDATE_USER = GraphQLTemplate.of("UpdateUser", true, UPDATE_ENJIN_USER)
                                                                     .copyFields(GET_USERS);
    public static final GraphQLTemplate DELETE_USER = GraphQLTemplate.of("DeleteUser", true, DELETE_ENJIN_USER);

    // Identities
    public static final GraphQLTemplate GET_IDENTITIES  = GraphQLTemplate.of("GetIdentities", false, ENJIN_IDENTITIES)
                                                                         .copyChildren(IDENTITIES);
    public static final GraphQLTemplate CREATE_IDENTITY = GraphQLTemplate.of("CreateIdentity", true, CREATE_ENJIN_IDENTITY)
                                                                         .copyChildren(IDENTITIES);
    public static final GraphQLTemplate UPDATE_IDENTITY = GraphQLTemplate.of("UpdateIdentity", true, UPDATE_ENJIN_IDENTITY)
                                                                         .copyChildren(IDENTITIES);
    public static final GraphQLTemplate DELETE_IDENTITY = GraphQLTemplate.of("DeleteIdentity", true, DELETE_ENJIN_IDENTITY)
                                                                         .copyChildren(IDENTITIES);
    // Tokens
    public static final GraphQLTemplate GET_TOKENS      = GraphQLTemplate.of("GetTokens", false, ENJIN_TOKENS)
                                                                         .withField(TOKEN_ID)
                                                                         .withField(INDEX)
                                                                         .withField(APP_ID)
                                                                         .withField(NAME)
                                                                         .withField(CREATOR)
                                                                         .withField(MELT_VALUE)
                                                                         .withField(MELT_FEE_RATIO)
                                                                         .withField(MELT_FEE_MAX_RATIO)
                                                                         .withField(SUPPLY_MODEL)
                                                                         .withField(TOTAL_SUPPLY)
                                                                         .withField(CIRCULATING_SUPPLY)
                                                                         .withField(RESERVE)
                                                                         .withField(TRANSFERABLE)
                                                                         .withField(TRANSFER_FEE_SETTINGS)
                                                                         .withField(NON_FUNGIBLE)
                                                                         .withField(FIRST_BLOCK)
                                                                         .withField(BLOCK_HEIGHT)
                                                                         .withField(MARKED_FOR_DELETE);
    public static final GraphQLTemplate CREATE_TOKEN    = GraphQLTemplate.of("CreateToken", true, CREATE_ENJIN_TOKEN)
                                                                         .copyFields(GET_TOKENS);
    public static final GraphQLTemplate UPDATE_TOKEN    = GraphQLTemplate.of("UpdateToken", true, UPDATE_ENJIN_TOKEN)
                                                                         .copyFields(GET_TOKENS);
    public static final GraphQLTemplate DELETE_TOKEN    = GraphQLTemplate.of("DeleteToken", true, DELETE_ENJIN_TOKEN)
                                                                         .copyFields(GET_TOKENS);

    // Requests
    public static final GraphQLTemplate GET_REQUESTS   = GraphQLTemplate.of("GetRequests", false, ENJIN_TRANSACTIONS)
                                                                        .withField(ID)
                                                                        .withField(TRANSACTION_ID)
                                                                        .withField(APP_ID)
                                                                        .withField(IDENTITY_ID)
                                                                        .withField(TYPE)
                                                                        .withField(RECIPIENT_ID)
                                                                        .withField(RECIPIENT_ADDR)
                                                                        .withField(TOKEN_ID)
                                                                        .withField(ENCODED_DATA)
                                                                        .withField(SIGNED_TRANSACTION)
                                                                        .withField(SIGNED_BACKUP_TRANSACTION)
                                                                        .withField(SIGNED_CANCEL_TRANSACTION)
                                                                        .withField(NONCE)
                                                                        .withField(RETRY_STATE)
                                                                        .withField(STATE)
                                                                        .withField(ACCEPTED);
    public static final GraphQLTemplate CREATE_REQUEST = GraphQLTemplate.of("CreateRequest", true, CREATE_ENJIN_REQUEST)
                                                                        .copyFields(GET_REQUESTS);
    public static final GraphQLTemplate UPDATE_REQUEST = GraphQLTemplate.of("UpdateRequest", true, UPDATE_ENJIN_REQUEST)
                                                                        .copyFields(GET_REQUESTS);
    public static final GraphQLTemplate DELETE_REQUEST = GraphQLTemplate.of("DeleteRequest", true, DELETE_ENJIN_REQUEST)
                                                                        .copyFields(GET_REQUESTS);

    // Balances
    public static final GraphQLTemplate GET_BALANCES = GraphQLTemplate.of("GetBalances", false, ENJIN_BALANCES)
                                                                      .withField(ETH_ADDR)
                                                                      .withField(TOKEN_ID)
                                                                      .withField(TOKEN_INDEX)
                                                                      .withField(IDENTITY_ID)
                                                                      .withField(BALANCE);

    public static List<GraphQLTemplate> getTemplates() {
        List<GraphQLTemplate> templates = new ArrayList<>();
        for (Field field : Templates.class.getDeclaredFields()) {
            if (field.getType() == GraphQLTemplate.class && Modifier.isPublic(field.getModifiers())
                    && Modifier.isStatic(field.getModifiers())
                    && Modifier.isFinal(field.getModifiers())) {
                try {
                    templates.add((GraphQLTemplate) field.get(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return templates;
    }

}
