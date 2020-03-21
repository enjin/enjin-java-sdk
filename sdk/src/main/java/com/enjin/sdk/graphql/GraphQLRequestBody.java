package com.enjin.sdk.graphql;

import java.util.Map;

public class GraphQLRequestBody {

    private String query;
    private Map<String, Object> variables;

    public GraphQLRequestBody(String query, Map<String, Object> variables) {
        this.query = query;
        this.variables = variables;
    }

}
