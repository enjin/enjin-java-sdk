package com.enjin.sdk.graphql;

import lombok.NonNull;

/**
 * Represents a model of a GraphQL request and
 * facilitates the serialization of the query.
 *
 * @author Evan Lindsay
 * @see GraphQLParameters
 */
public class GraphQLRequest<T extends GraphQLRequest<T>> {

    private GraphQLParameters parameters;

    public GraphQLRequest() {
        this.parameters = new GraphQLParameters();
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
    public T withParameter(@NonNull String key, @NonNull Object value) {
        if (key.isEmpty()) {
            throw new IllegalArgumentException("Key is empty");
        }

        this.parameters.getParameters().put(key, value);

        return (T) this;
    }

    public GraphQLParameters parameters() {
        return this.parameters;
    }

}
