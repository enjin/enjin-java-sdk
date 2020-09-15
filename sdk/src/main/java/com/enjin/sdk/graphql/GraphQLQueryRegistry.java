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
        if (!registered.containsKey(query)) {
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
