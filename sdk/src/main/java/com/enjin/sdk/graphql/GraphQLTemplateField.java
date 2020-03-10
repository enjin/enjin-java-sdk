package com.enjin.sdk.graphql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphQLTemplateField {

    protected String name;
    protected List<GraphQLTemplateField> children;

    protected GraphQLTemplateField(String name) {
        this(name, new ArrayList<GraphQLTemplateField>());
    }

    protected GraphQLTemplateField(String name, List<GraphQLTemplateField> children) {
        this.name = name;
        this.children = new ArrayList<>(children);
    }

    public GraphQLTemplateField withChild(GraphQLTemplateField child) {
        children.add(child);
        return this;
    }

    public GraphQLTemplateField withChild(String child) {
        withChild(GraphQLTemplateField.of(child));
        return this;
    }

    public GraphQLTemplateField copyChildren(GraphQLTemplateField other) {
        children.addAll(other.children);
        return this;
    }

    public String getName() {
        return name;
    }

    public List<GraphQLTemplateField> getChildren() {
        return new ArrayList<>(children);
    }

    /**
     * Serializes the template field to GraphQL format.
     *
     * @return the serialized field
     */
    public String serialize() {
        StringBuilder builder = new StringBuilder();

        builder.append(name);

        if (!children.isEmpty()) {
            builder.append('{');

            for (int i = 0; i < children.size(); i++) {
                if (i > 0)
                    builder.append(',');
                builder.append(children.get(i).serialize());
            }

            builder.append('}');
        }

        return builder.toString();
    }

    public static GraphQLTemplateField of(String name) {
        return new GraphQLTemplateField(name);
    }

    public static GraphQLTemplateField of(String name, GraphQLTemplateField... children) {
        return new GraphQLTemplateField(name, Arrays.asList(children));
    }
}
