package com.enjin.enjincoin.sdk.client.util;

import com.enjin.enjincoin.sdk.client.model.attribute.GraphError;
import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class GraphErrorUtil {

    public static List<GraphError> getGraphQLError(String errorJson) {
        Gson               gson           = new Gson();
        Type               tokenType      = new TypeToken<GraphQLResponse<?>>() {}.getType();
        GraphQLResponse<?> graphContainer = gson.fromJson(errorJson, tokenType);
        return graphContainer.getErrors();
    }
}
