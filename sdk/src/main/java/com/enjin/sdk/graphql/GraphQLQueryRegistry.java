package com.enjin.sdk.graphql;

import com.github.nocatch.NoCatch;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class GraphQLQueryRegistry {

    private Map<String, String> registered = new HashMap<>();

    public GraphQLQueryRegistry() {
        registerTemplateConstants();
    }

    /**
     * Registers a template with a registry.
     *
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

    public boolean has(String key) {
        return registered.containsKey(key);
    }

    public String get(String key) {
        return registered.get(key);
    }

    private void registerTemplateConstants() {
        Field[] fields = TemplateConstants.class.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            String query = (String) NoCatch.noCatch(() -> field.get(null));
            register(name, query);
        }
    }

}
