package com.enjin.sdk.graphql.definitions;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import com.enjin.sdk.graphql.GraphQLTemplate;
import com.enjin.sdk.reflection.SafeField;
import com.enjin.sdk.reflection.SafeReflection;
import com.github.dmstocking.optional.java.util.Optional;
import com.github.dmstocking.optional.java.util.function.Consumer;

import lombok.extern.java.Log;

@Log
public final class Templates {

    // Platform
    public static final GraphQLTemplate GET_PLATFORM = GraphQLTemplate.of("GetPlatform", false, Methods.ENJIN_PLATFORM)
                                                                      .withField(Fields.ID)
                                                                      .withField(Fields.NAME)
                                                                      .withField(Fields.NETWORK)
                                                                      .withField(Fields.NOTIFICATIONS);

    // Ethereum
    public static final GraphQLTemplate GET_BLOCK_HEIGHT = GraphQLTemplate.of("GetBlockHeight",
                                                                              false,
                                                                              Methods.ENJIN_BLOCK_HEIGHT)
                                                                          .withField(Fields.BLOCK);

    // Apps
    public static final GraphQLTemplate GET_APPS = GraphQLTemplate.of("GetApps", false, Methods.ENJIN_APPS)
                                                                  .withField(Fields.ID)
                                                                  .withField(Fields.SECRET)
                                                                  .withField(Fields.NAME)
                                                                  .withField(Fields.DESCRIPTION)
                                                                  .withField(Fields.IMAGE)
                                                                  .withField(Fields.OWNER)
                                                                  .withField(Fields.TOKEN_COUNT);
    public static final GraphQLTemplate CREATE_APP = GraphQLTemplate.of("CreateApp", true, Methods.CREATE_ENJIN_APP)
                                                                    .copyFields(GET_APPS);
    public static final GraphQLTemplate UPDATE_APP = GraphQLTemplate.of("UpdateApp", true, Methods.UPDATE_ENJIN_APP)
                                                                    .copyFields(GET_APPS);
    public static final GraphQLTemplate DELETE_APP = GraphQLTemplate.of("DeleteApp", true, Methods.DELETE_ENJIN_APP)
                                                                    .copyFields(GET_APPS);

    // Roles
    public static final GraphQLTemplate GET_ROLES = GraphQLTemplate.of("GetRoles", false, Methods.ENJIN_ROLES)
                                                                   .copyChildren(Fields.ROLES);
    public static final GraphQLTemplate CREATE_ROLE = GraphQLTemplate.of("CreateRole", true, Methods.CREATE_ENJIN_ROLE)
                                                                     .copyFields(GET_ROLES);
    public static final GraphQLTemplate UPDATE_ROLE = GraphQLTemplate.of("UpdateRole", true, Methods.UPDATE_ENJIN_ROLE)
                                                                     .copyFields(GET_ROLES);
    public static final GraphQLTemplate DELETE_ROLE = GraphQLTemplate.of("DeleteRole", true, Methods.DELETE_ENJIN_ROLE)
                                                                     .copyFields(GET_ROLES);

    // Users
    public static final GraphQLTemplate GET_USERS = GraphQLTemplate.of("GetUsers", false, Methods.ENJIN_USERS)
                                                                   .withField(Fields.ID)
                                                                   .withField(Fields.NAME)
                                                                   .withField(Fields.EMAIL)
                                                                   .withField(Fields.ACCESS_TOKENS)
                                                                   .withField(Fields.ROLES)
                                                                   .withField(Fields.IDENT_BASE);
    public static final GraphQLTemplate AUTH_USER = GraphQLTemplate.of("AuthUser", false, Methods.ENJIN_OAUTH)
                                                                   .copyFields(GET_USERS);
    public static final GraphQLTemplate CREATE_USER = GraphQLTemplate.of("CreateUser", true, Methods.CREATE_ENJIN_USER)
                                                                     .copyFields(GET_USERS);
    public static final GraphQLTemplate UPDATE_USER = GraphQLTemplate.of("UpdateUser", true, Methods.UPDATE_ENJIN_USER)
                                                                     .copyFields(GET_USERS);
    public static final GraphQLTemplate DELETE_USER = GraphQLTemplate.of("DeleteUser", true, Methods.DELETE_ENJIN_USER);

    // Identities
    public static final GraphQLTemplate GET_IDENTITIES = GraphQLTemplate.of("GetIdentities", false, Methods.ENJIN_IDENTITIES)
                                                                        .copyChildren(Fields.IDENT_W_BALS);
    public static final GraphQLTemplate CREATE_IDENTITY = GraphQLTemplate.of("CreateIdentity",
                                                                             true,
                                                                             Methods.CREATE_ENJIN_IDENTITY)
                                                                         .copyChildren(Fields.IDENT_W_BALS);
    public static final GraphQLTemplate UPDATE_IDENTITY = GraphQLTemplate.of("UpdateIdentity",
                                                                             true,
                                                                             Methods.UPDATE_ENJIN_IDENTITY)
                                                                         .copyChildren(Fields.IDENT_W_BALS);
    public static final GraphQLTemplate DELETE_IDENTITY = GraphQLTemplate.of("DeleteIdentity",
                                                                             true,
                                                                             Methods.DELETE_ENJIN_IDENTITY)
                                                                         .copyChildren(Fields.IDENT_W_BALS);

    // Tokens
    public static final GraphQLTemplate GET_TOKENS = GraphQLTemplate.of("GetTokens", false, Methods.ENJIN_TOKENS)
                                                                    .withField(Fields.TOKEN_ID)
                                                                    .withField(Fields.INDEX)
                                                                    .withField(Fields.APP_ID)
                                                                    .withField(Fields.NAME)
                                                                    .withField(Fields.CREATOR)
                                                                    .withField(Fields.MELT_VALUE)
                                                                    .withField(Fields.MELT_FEE_RATIO)
                                                                    .withField(Fields.MELT_FEE_MAX_RATIO)
                                                                    .withField(Fields.SUPPLY_MODEL)
                                                                    .withField(Fields.TOTAL_SUPPLY)
                                                                    .withField(Fields.CIRCULATING_SUPPLY)
                                                                    .withField(Fields.RESERVE)
                                                                    .withField(Fields.TRANSFERABLE)
                                                                    .withField(Fields.TRANSFER_FEE_SETTINGS)
                                                                    .withField(Fields.NON_FUNGIBLE)
                                                                    .withField(Fields.FIRST_BLOCK)
                                                                    .withField(Fields.BLOCK_HEIGHT)
                                                                    .withField(Fields.MARKED_FOR_DELETE)
                                                                    .withField(Fields.ITEM_URI);
    public static final GraphQLTemplate CREATE_TOKEN = GraphQLTemplate.of("CreateToken", true, Methods.CREATE_ENJIN_TOKEN)
                                                                      .copyFields(GET_TOKENS);
    public static final GraphQLTemplate UPDATE_TOKEN = GraphQLTemplate.of("UpdateToken", true, Methods.UPDATE_ENJIN_TOKEN)
                                                                      .copyFields(GET_TOKENS);
    public static final GraphQLTemplate DELETE_TOKEN = GraphQLTemplate.of("DeleteToken", true, Methods.DELETE_ENJIN_TOKEN)
                                                                      .copyFields(GET_TOKENS);
    public static final GraphQLTemplate GET_TOKEN_EVENTS = GraphQLTemplate.of("GetTokenEvents",
                                                                              false,
                                                                              Methods.ENJIN_TOKEN_EVENTS)
                                                                          .copyChildren(Fields.EVENTS);

    // Requests
    public static final GraphQLTemplate GET_REQUESTS = GraphQLTemplate.of("GetRequests", false, Methods.ENJIN_TRANSACTIONS)
                                                                      .withField(Fields.ID)
                                                                      .withField(Fields.TRANSACTION_ID)
                                                                      .withField(Fields.APP_ID)
                                                                      .withField(Fields.IDENTITY_ID)
                                                                      .withField(Fields.TYPE)
                                                                      .withField(Fields.RECIPIENT_ID)
                                                                      .withField(Fields.RECIPIENT_ADDR)
                                                                      .withField(Fields.TOKEN_ID)
                                                                      .withField(Fields.ENCODED_DATA)
                                                                      .withField(Fields.SIGNED_TRANSACTION)
                                                                      .withField(Fields.SIGNED_BACKUP_TRANSACTION)
                                                                      .withField(Fields.SIGNED_CANCEL_TRANSACTION)
                                                                      .withField(Fields.NONCE)
                                                                      .withField(Fields.RETRY_STATE)
                                                                      .withField(Fields.STATE)
                                                                      .withField(Fields.ACCEPTED)
                                                                      .withField(Fields.EVENTS);
    public static final GraphQLTemplate CREATE_REQUEST = GraphQLTemplate.of("CreateRequest", true, Methods.CREATE_ENJIN_REQUEST)
                                                                        .copyFields(GET_REQUESTS);
    public static final GraphQLTemplate UPDATE_REQUEST = GraphQLTemplate.of("UpdateRequest", true, Methods.UPDATE_ENJIN_REQUEST)
                                                                        .copyFields(GET_REQUESTS);
    public static final GraphQLTemplate DELETE_REQUEST = GraphQLTemplate.of("DeleteRequest", true, Methods.DELETE_ENJIN_REQUEST)
                                                                        .copyFields(GET_REQUESTS);

    // Balances
    public static final GraphQLTemplate GET_BALANCES = GraphQLTemplate.of("GetBalances", false, Methods.ENJIN_BALANCES)
                                                                      .withField(Fields.ETH_ADDR)
                                                                      .withField(Fields.TOKEN_ID)
                                                                      .withField(Fields.TOKEN_INDEX)
                                                                      .withField(Fields.IDENTITY_ID)
                                                                      .withField(Fields.BALANCE)
                                                                      .withField(Fields.BALANCE_TOKEN);

    private Templates() {
        throw new UnsupportedOperationException("Utility Class");
    }

    /**
     * Gets a list of GraphQLTemplate instances.
     *
     * @return the list of templates
     */
    public static List<GraphQLTemplate> getTemplates() {
        final List<GraphQLTemplate> templates = new ArrayList<>();
        final List<SafeField> fields = SafeReflection.getFieldsOfTypeWithModifiers(Templates.class,
                                                                                   GraphQLTemplate.class,
                                                                                   Modifier.PUBLIC,
                                                                                   Modifier.STATIC);

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
