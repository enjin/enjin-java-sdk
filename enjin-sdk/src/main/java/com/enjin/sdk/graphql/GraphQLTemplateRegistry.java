package com.enjin.sdk.graphql;

import java.util.HashMap;
import java.util.Map;

public class GraphQLTemplateRegistry {

    private Map<String, GraphQLTemplate> registered = new HashMap<>();

    /**
     * Registers a template with a registry.
     *
     * @param template the template to register
     *
     * @return true if registered, false if already exists
     */
    public boolean register(GraphQLTemplate template) {
        boolean result = false;

        if (!registered.containsKey(template.getName())) {
            registered.put(template.getName(), template);
            result = true;
        }

        return result;
    }

    public boolean has(String key) {
        return registered.containsKey(key);
    }

    public GraphQLTemplate get(String key) {
        return registered.get(key);
    }

}
