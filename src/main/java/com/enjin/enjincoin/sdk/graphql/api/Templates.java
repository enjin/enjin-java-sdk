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

    // Identity Templates

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
