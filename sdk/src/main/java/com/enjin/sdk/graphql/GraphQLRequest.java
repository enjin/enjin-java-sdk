package com.enjin.sdk.graphql;

import lombok.Getter;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a model of a GraphQL request and
 * facilitates the serialization of the query.
 *
 * @author Evan Lindsay
 */
public class GraphQLRequest<T extends GraphQLRequest<T>> implements VariableHolder<T> {

    private final Map<String, Object> variables;

    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    @Getter
    private final String namespace;

    /**
     * TODO
     * @param namespace
     */
    public GraphQLRequest(String namespace) {
        this(new HashMap<>(), namespace);
    }

    /**
     * Constructs a request with the passed parameter mapping.
     *
     * @param variables mapping of parameter keys and values.
     * @param namespace
     */
    public GraphQLRequest(Map<String, Object> variables, String namespace) {
        this.variables = variables;
        this.namespace = namespace;
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
    public T set(@NonNull String key, Object value) {
        if (key.isEmpty())
            throw new IllegalArgumentException("Key is empty");

        if (value == null)
            variables.remove(key);
        else
            variables.put(key, value);

        return (T) this;
    }

    @Override
    public boolean isSet(String key) {
        return variables.containsKey(key);
    }

    @Override
    public Map<String, Object> getVariables() {
        return variables;
    }

}
