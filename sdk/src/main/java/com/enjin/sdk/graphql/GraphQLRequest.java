package com.enjin.sdk.graphql;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a model of a GraphQL request and
 * facilitates the serialization of the query.
 *
 * @author Evan Lindsay
 */
public class GraphQLRequest<T extends GraphQLRequest<T>> implements GraphQLVariableHolder<T> {

    private Map<String, Object> variables;

    public GraphQLRequest() {
        this(new HashMap<>());
    }

    public GraphQLRequest(Map<String, Object> variables) {
        this.variables = variables;
    }

    /**
     * Adds a parameter to be baked into the query.
     *
     * @param key   the parameter key.
     * @param value the parameter value.
     *
     * @return the builder.
     *
     * @throws NullPointerException     if key is null
     * @throws IllegalArgumentException if key is empty
     */
    public T set(@NonNull String key, @NonNull Object value) {
        if (key.isEmpty()) {
            throw new IllegalArgumentException("Key is empty");
        }

        this.variables.put(key, value);

        return (T) this;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

}
