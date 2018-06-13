package com.enjin.enjincoin.sdk.client.model.request;

import java.util.HashMap;
import java.util.Map;

public class GraphQLParameters {

    private Map<String, Object> parameters;

    public GraphQLParameters() {
        this(new HashMap<>());
    }

    public GraphQLParameters(final Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public Map<String, Object> getParameters() {
        return this.parameters;
    }

    public String getFormattedParameters() {
        final StringBuilder builder = new StringBuilder();
        for (final Map.Entry<String, Object> parameter : this.parameters.entrySet()) {
            if (builder.length() > 0) {
                builder.append(", ");
            }

            builder.append(parameter.getKey()).append(": ");

            if (parameter.getValue() instanceof String) {
                builder.append("\"");
            }

            builder.append(String.valueOf(parameter.getValue()));

            if (parameter.getValue() instanceof String) {
                builder.append("\"");
            }
        }
        return builder.toString();
    }

}
