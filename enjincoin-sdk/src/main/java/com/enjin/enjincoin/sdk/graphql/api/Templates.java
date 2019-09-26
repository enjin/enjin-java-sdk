package com.enjin.enjincoin.sdk.graphql.api;

import com.enjin.enjincoin.sdk.graphql.GraphQLTemplate;
import static com.enjin.enjincoin.sdk.graphql.api.Fields.*;
import static com.enjin.enjincoin.sdk.graphql.api.Methods.*;
import com.enjin.enjincoin.sdk.reflection.SafeField;
import com.enjin.enjincoin.sdk.reflection.SafeReflection;
import com.github.dmstocking.optional.java.util.Optional;
import com.github.dmstocking.optional.java.util.function.Consumer;
import lombok.extern.java.Log;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

@Log
public final class Templates {

    private Templates() {
        throw new IllegalStateException("Utility Class");
    }

    // Platform
    public static final GraphQLTemplate GET_PLATFORM = GraphQLTemplate.of("GetPlatform", false, ENJIN_PLATFORM)
                                                                      .withField(ID)
                                                                      .withField(NAME)
                                                                      .withField(NETWORK)
                                                                      .withField(NOTIFICATIONS);

    // Ethereum
    public static final GraphQLTemplate GET_BLOCK_HEIGHT = GraphQLTemplate.of("GetBlockHeight", false, ENJIN_BLOCK_HEIGHT)
                                                                          .withField(BLOCK);

    // Apps
    public static final GraphQLTemplate GET_APPS   = GraphQLTemplate.of("GetApps", false, ENJIN_APPS)
                                                                    .withField(ID)
                                                                    .withField(SECRET)
                                                                    .withField(NAME)
                                                                    .withField(DESCRIPTION)
                                                                    .withField(IMAGE)
                                                                    .withField(OWNER)
                                                                    .withField(TOKEN_COUNT);
    public static final GraphQLTemplate CREATE_APP = GraphQLTemplate.of("CreateApp", true, CREATE_ENJIN_APP)
                                                                    .copyFields(GET_APPS);
    public static final GraphQLTemplate UPDATE_APP = GraphQLTemplate.of("UpdateApp", true, UPDATE_ENJIN_APP)
                                                                    .copyFields(GET_APPS);
    public static final GraphQLTemplate DELETE_APP = GraphQLTemplate.of("DeleteApp", true, DELETE_ENJIN_APP)
                                                                    .copyFields(GET_APPS);

    // Roles
    public static final GraphQLTemplate GET_ROLES   = GraphQLTemplate.of("GetRoles", false, ENJIN_ROLES)
                                                                     .copyChildren(ROLES);
    public static final GraphQLTemplate CREATE_ROLE = GraphQLTemplate.of("CreateRole", true, CREATE_ENJIN_ROLE)
                                                                     .copyFields(GET_ROLES);
    public static final GraphQLTemplate UPDATE_ROLE = GraphQLTemplate.of("UpdateRole", true, UPDATE_ENJIN_ROLE)
                                                                     .copyFields(GET_ROLES);
    public static final GraphQLTemplate DELETE_ROLE = GraphQLTemplate.of("DeleteRole", true, DELETE_ENJIN_ROLE)
                                                                     .copyFields(GET_ROLES);

    // Users
    public static final GraphQLTemplate GET_USERS   = GraphQLTemplate.of("GetUsers", false, ENJIN_USERS)
                                                                     .withField(ID)
                                                                     .withField(NAME)
                                                                     .withField(EMAIL)
                                                                     .withField(ACCESS_TOKENS)
                                                                     .withField(ROLES)
                                                                     .withField(IDENTITIES_BASE);
    public static final GraphQLTemplate AUTH_USER   = GraphQLTemplate.of("AuthUser", false, ENJIN_OAUTH)
                                                                     .copyFields(GET_USERS);
    public static final GraphQLTemplate CREATE_USER = GraphQLTemplate.of("CreateUser", true, CREATE_ENJIN_USER)
                                                                     .copyFields(GET_USERS);
    public static final GraphQLTemplate UPDATE_USER = GraphQLTemplate.of("UpdateUser", true, UPDATE_ENJIN_USER)
                                                                     .copyFields(GET_USERS);
    public static final GraphQLTemplate DELETE_USER = GraphQLTemplate.of("DeleteUser", true, DELETE_ENJIN_USER);

    // Identities
    public static final GraphQLTemplate GET_IDENTITIES  = GraphQLTemplate.of("GetIdentities", false, ENJIN_IDENTITIES)
                                                                         .copyChildren(IDENTITIES_WITH_BALANCES);
    public static final GraphQLTemplate CREATE_IDENTITY = GraphQLTemplate.of("CreateIdentity", true, CREATE_ENJIN_IDENTITY)
                                                                         .copyChildren(IDENTITIES_WITH_BALANCES);
    public static final GraphQLTemplate UPDATE_IDENTITY = GraphQLTemplate.of("UpdateIdentity", true, UPDATE_ENJIN_IDENTITY)
                                                                         .copyChildren(IDENTITIES_WITH_BALANCES);
    public static final GraphQLTemplate DELETE_IDENTITY = GraphQLTemplate.of("DeleteIdentity", true, DELETE_ENJIN_IDENTITY)
                                                                         .copyChildren(IDENTITIES_WITH_BALANCES);

    // Tokens
    public static final GraphQLTemplate GET_TOKENS       = GraphQLTemplate.of("GetTokens", false, ENJIN_TOKENS)
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
                                                                          .withField(MARKED_FOR_DELETE)
                                                                          .withField(ITEM_URI);
    public static final GraphQLTemplate CREATE_TOKEN     = GraphQLTemplate.of("CreateToken", true, CREATE_ENJIN_TOKEN)
                                                                          .copyFields(GET_TOKENS);
    public static final GraphQLTemplate UPDATE_TOKEN     = GraphQLTemplate.of("UpdateToken", true, UPDATE_ENJIN_TOKEN)
                                                                          .copyFields(GET_TOKENS);
    public static final GraphQLTemplate DELETE_TOKEN     = GraphQLTemplate.of("DeleteToken", true, DELETE_ENJIN_TOKEN)
                                                                          .copyFields(GET_TOKENS);
    public static final GraphQLTemplate GET_TOKEN_EVENTS = GraphQLTemplate.of("GetTokenEvents", false, ENJIN_TOKEN_EVENTS)
                                                                          .copyChildren(EVENTS);

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
                                                                        .withField(ACCEPTED)
                                                                        .withField(EVENTS);
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
                                                                      .withField(BALANCE)
                                                                      .withField(BALANCE_TOKEN);

    public static List<GraphQLTemplate> getTemplates() {
        final List<GraphQLTemplate> templates = new ArrayList<>();
        final List<SafeField> fields = SafeReflection.getFieldsOfTypeWithModifiers(Templates.class, GraphQLTemplate.class,
                                                                             Modifier.PUBLIC, Modifier.STATIC);

        for (SafeField field : fields) {
            final Optional<GraphQLTemplate> template = field.getStatic(GraphQLTemplate.class);
            template.ifPresent(new Consumer<GraphQLTemplate>() {
                @Override
                public void accept(GraphQLTemplate graphQLTemplate) {
                    templates.add(template.get());
                }
            });
        }

        return templates;
    }

}
