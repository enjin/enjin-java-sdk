package com.enjin.sdk.graphql;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Class for registering and storing GraphQL templates.
 */
public class GraphQLQueryRegistry {

    private Map<String, String> registered = new HashMap<>();

    /**
     * Sole constructor.
     */
    public GraphQLQueryRegistry() {
        registerTemplateConstants();
    }

    /**
     * Registers a template with a registry.
     *
     * @param name  the template name
     * @param query the template to register
     *
     * @return true if registered, false if already exists
     */
    public boolean register(String name, String query) {
        boolean result = false;

        if (!registered.containsKey(query)) {
            registered.put(name, query);
            result = true;
        }

        return result;
    }

    /**
     * Returns true if the registry contains the template.
     *
     * @param key the template name
     * @return    true if the template is registered, false otherwise
     */
    public boolean has(String key) {
        return registered.containsKey(key);
    }

    /**
     * Returns the query string if the registry contains the template or null if not.
     *
     * @param key the template name
     * @return    the query
     */
    public String get(String key) {
        return registered.get(key);
    }

    @SneakyThrows
    private void registerTemplateConstants() {
        Field[] fields = TemplateConstants.class.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            String query = (String) field.get(null);
            register(name, query);
        }
    }

}
