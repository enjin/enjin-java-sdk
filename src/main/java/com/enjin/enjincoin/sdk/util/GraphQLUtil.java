package com.enjin.enjincoin.sdk.util;

import com.enjin.enjincoin.sdk.graphql.GraphError;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class GraphQLUtil {

    private static final Gson GSON = new GsonBuilder().create();

    public static List<GraphError> getGraphQLError(String errorJson) {
        Type               tokenType      = new TypeToken<GraphQLResponse<?>>() {}.getType();
        GraphQLResponse<?> graphContainer = GSON.fromJson(errorJson, tokenType);
        return graphContainer.getErrors();
    }
}
