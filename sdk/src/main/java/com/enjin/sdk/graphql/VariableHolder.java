package com.enjin.sdk.graphql;

import java.util.Map;

/**
 * A interface for GraphQL requests to set variables within them.
 *
 * @param <T> the implementing type of the interface
 */
public interface VariableHolder<T> {

    /**
     * Sets a variable.
     *
     * @param key the key
     * @param value the value
     * @return this object for chaining
     */
    T set(String key, Object value);

    /**
     * Determines if a variable exists for the specified key.
     *
     * @param key the key
     * @return whether the variable exists
     */
    boolean isSet(String key);

    /**
     * Gets the mapping of parameter keys and their values.
     *
     * @return the mapping of parameter keys and values
     */
    Map<String, Object> getVariables();

}
