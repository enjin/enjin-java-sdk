package com.enjin.enjincoin.sdk.util;

import com.enjin.enjincoin.sdk.model.attribute.GraphError;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class GraphErrorUtil {

    private static final Gson GSON = new GsonBuilder().create();

    public static List<GraphError> getGraphQLError(String errorJson) {
        Type               tokenType      = new TypeToken<GraphQLResponse<?>>() {}.getType();
        GraphQLResponse<?> graphContainer = GSON.fromJson(errorJson, tokenType);
        return graphContainer.getErrors();
    }
}
