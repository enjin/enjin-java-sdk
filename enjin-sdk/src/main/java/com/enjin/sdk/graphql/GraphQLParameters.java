package com.enjin.sdk.graphql;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * Represents a dynamic mapping of GraphQL parameters and
 * facilitates the serialization of the parameters to the
 * GraphQL query format.
 *
 * @author Evan Lindsay
 */
public class GraphQLParameters {

    private final Gson gson = new GsonBuilder().disableHtmlEscaping()
                                               .create();
    private Map<String, Object> parameters;

    /**
     * Creates a new instance with no parameters.
     */
    public GraphQLParameters() {
        this(new HashMap<String, Object>());
    }

    /**
     * Creates a new instance with existing parameters.
     *
     * @param parameters the parameters.
     */
    public GraphQLParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    /**
     * Returns a map of parameter keys and values.
     *
     * @return the parameters
     */
    public Map<String, Object> getParameters() {
        return this.parameters;
    }

    /**
     * Returns a String of parameters in GraphQL query format.
     *
     * @return the formatted parameters.
     */
    public String getFormattedParameters() {
        StringBuilder builder = new StringBuilder();

        for (final Map.Entry<String, Object> parameter : this.parameters.entrySet()) {
            if (builder.length() > 0)
                builder.append(", ");

            builder.append(parameter.getKey())
                   .append(": ")
                   .append(toGraphQLFormat(parameter.getValue()));
        }

        return builder.toString();
    }

    public boolean has(String key) {
        return parameters.containsKey(key);
    }

    private String toGraphQLFormat(Object object) {
        if (object instanceof JsonElement)
            return toGraphQLFormat((JsonElement) object);
        else if (object instanceof Enum)
            return ((Enum) object).name();

        return toGraphQLFormat(gson.toJsonTree(object));
    }

    private String toGraphQLFormat(JsonObject object) {
        StringBuilder builder = new StringBuilder("{");

        for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
            if (builder.length() > 1)
                builder.append(',');

            builder.append(entry.getKey())
                   .append(':')
                   .append(toGraphQLFormat(entry.getValue()));
        }

        return builder.append('}')
                      .toString();
    }

    private String toGraphQLFormat(JsonArray array) {
        StringBuilder builder = new StringBuilder("[");

        for (JsonElement elem : array) {
            if (builder.length() > 1)
                builder.append(',');

            builder.append(toGraphQLFormat(elem));
        }

        return builder.append(']')
                      .toString();
    }

    private String toGraphQLFormat(JsonElement element) {
        StringBuilder builder = new StringBuilder();

        if (element instanceof JsonObject) {
            builder.append(toGraphQLFormat(element.getAsJsonObject()));
        } else if (element instanceof JsonArray) {
            builder.append(toGraphQLFormat(element.getAsJsonArray()));
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
