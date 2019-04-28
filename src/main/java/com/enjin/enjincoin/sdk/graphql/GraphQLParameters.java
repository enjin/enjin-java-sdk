package com.enjin.enjincoin.sdk.graphql;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a dynamic mapping of GraphQL parameters and
 * facilitates the serialization of the parameters to the
 * GraphQL query format.
 *
 * @author Evan Lindsay
 */
public class GraphQLParameters {

    private final Gson                gson = new GsonBuilder()
            .disableHtmlEscaping()
            .create();
    private       Map<String, Object> parameters;

    /**
     * Creates a new instance with no parameters.
     */
    public GraphQLParameters() {
        this(new HashMap<>());
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
            if (builder.length() > 0) {
                builder.append(", ");
            }

            builder.append(parameter.getKey()).append(": ");
            builder.append(objectToGraphQLFormat(parameter.getValue()));
        }
        return builder.toString();
    }

    private String objectToGraphQLFormat(Object object) {
        if (object instanceof JsonElement) {
            return jsonElementToGraphQLFormat((JsonElement) object);
        } else if (object instanceof Enum) {
            return ((Enum) object).name();
        }

        return jsonElementToGraphQLFormat(gson.toJsonTree(object));
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
