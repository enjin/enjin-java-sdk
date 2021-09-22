/* Copyright 2021 Enjin Pte Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.enjin.sdk.graphql;

import lombok.Getter;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Facilitates setting variables to be used in a GraphQL request.
 *
 * @param <T> the type of the implementing class
 */
public class GraphQLRequest<T extends GraphQLRequest<T>> implements VariableHolder<T> {

    private final Map<String, Object> variables;

    /**
     * -- Getter --
     * @return the namespace
     */
    @Getter
    private final String namespace;

    /**
     * Constructs a request with the specified namespace and no predefined variables.
     *
     * @param namespace the request namespace
     */
    public GraphQLRequest(String namespace) {
        this(new HashMap<>(), namespace);
    }

    /**
     * Constructs a request with the passed variable mapping and namespace.
     *
     * @param variables the mapping of variable keys and values
     * @param namespace the request namespace
     */
    public GraphQLRequest(Map<String, Object> variables, String namespace) {
        this.variables = variables;
        this.namespace = namespace;
    }

    /**
     * Sets a variable.
     *
     * @param key the key
     * @param value the value
     * @return this request for chaining
     * @throws NullPointerException if key is null
     * @throws IllegalArgumentException if key is empty
     */
    @Override
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
