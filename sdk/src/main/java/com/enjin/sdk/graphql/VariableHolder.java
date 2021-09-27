/* Copyright 2021 Enjin Pte. Ltd.
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
