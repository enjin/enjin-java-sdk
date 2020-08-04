package com.enjin.sdk.graphql;

import java.util.Map;

/**
 * A interface for GraphQL requests to set variables within them.
 *
 * @param <T> the super type of the interface
 */
public interface VariableHolder<T> {

    /**
     * Sets a variable.
     *
     * @param key the key
     * @param value the value
     * @return the builder
     */
    T set(String key, Object value);

    /**
     * TODO
     * @param key
     * @return
     */
    boolean isSet(String key);

    /**
     * Gets the mapping of parameter keys and their values.
     *
     * @return the map of parameter keys and values.
     */
    Map<String, Object> getVariables();

}
