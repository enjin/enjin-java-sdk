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

import java.util.HashMap;
import java.util.Map;

/**
 * Class for registering and storing GraphQL templates.
 */
public class GraphQLQueryRegistry {

    private final Map<String, String> registered = new HashMap<>();

    /**
     * Sole constructor.
     */
    public GraphQLQueryRegistry() {
        registerTemplateConstants();
    }

    /**
     * Registers a new template.
     *
     * @param name the template name
     * @param query the template to register
     * @return true if registered, false if already exists
     */
    public boolean register(String name, String query) {
        if (!registered.containsKey(name)) {
            registered.put(name, query);
            return true;
        }

        return false;
    }

    /**
     * Returns true if this registry contains the template.
     *
     * @param key the template name
     * @return true if the template is registered, false otherwise
     */
    public boolean has(String key) {
        return registered.containsKey(key);
    }

    /**
     * Returns the query string if the registry contains the template or null if not.
     *
     * @param key the template name
     * @return the query
     */
    public String get(String key) {
        return registered.get(key);
    }

    private void registerTemplateConstants() {
        TemplateConstants.TEMPLATES.forEach(this::register);
    }

}
