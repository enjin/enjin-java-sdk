package com.enjin.enjincoin.sdk.graphql;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

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

            builder.append(objectToGraphQLFormat(parameter.getValue()));

            if (parameter.getValue() instanceof String) {
                builder.append("\"");
            }
        }
        return builder.toString();
    }

    private String objectToGraphQLFormat(Object object) {
        if (object instanceof JsonElement) {
            return jsonElementToGraphQLFormat((JsonElement) object);
        } else if (object instanceof Enum) {
            return ((Enum) object).name();
        }

        return String.valueOf(object);
    }

    private String jsonElementToGraphQLFormat(JsonElement element) {
        StringBuilder builder = new StringBuilder();

        if (element instanceof JsonObject) {
            JsonObject object = element.getAsJsonObject();

            builder.append('{');
            StringBuilder objBuilder = new StringBuilder();
            for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
                if (objBuilder.length() > 0) {
                    objBuilder.append(',');
                }

                objBuilder.append(entry.getKey())
                          .append(':')
                          .append(jsonElementToGraphQLFormat(entry.getValue()));
            }
            builder.append(objBuilder.toString());
            builder.append('}');
        } else if (element instanceof JsonArray) {
            JsonArray array = element.getAsJsonArray();

            builder.append('[');
            StringBuilder arrBuilder = new StringBuilder();
            for (JsonElement elem : array) {
                if (arrBuilder.length() > 0) {
                    arrBuilder.append(',');
                }

                arrBuilder.append(jsonElementToGraphQLFormat(elem));
            }
            builder.append(arrBuilder.toString());
            builder.append(']');
        } else if (element instanceof JsonPrimitive) {
            JsonPrimitive primitive = element.getAsJsonPrimitive();
            if (primitive.isBoolean()) {
                builder.append(primitive.getAsBoolean());
            } else if (primitive.isNumber()) {
                builder.append(primitive.getAsNumber());
            } else {
                builder.append('\"')
                       .append(primitive.getAsString())
                       .append('\"');
            }
        } else {
            builder.append("null");
        }

        return builder.toString();
    }

}
