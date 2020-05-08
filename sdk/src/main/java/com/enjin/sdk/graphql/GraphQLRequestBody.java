package com.enjin.sdk.graphql;

import java.util.Map;

/**
 * Represents a model of a GraphQL request's body.
 */
public class GraphQLRequestBody {

    private String query;
    private Map<String, Object> variables;

    /**
     * Constructs the request body using the query and its variables.
     *
     * @param query     the query
     * @param variables the request parameter variables
     */
    public GraphQLRequestBody(String query, Map<String, Object> variables) {
        this.query = query;
        this.variables = variables;
    }

}
