package com.enjin.sdk.graphql;

/**
 * A interface for GraphQL builders to set variables within them.
 *
 * @param <T> the super type of the interface
 */
public interface GraphQLVariableHolder<T> {

    /**
     * Sets a variable.
     *
     * @param key   the key
     * @param value the value
     * @return      the builder
     */
    T set(String key, Object value);

}
