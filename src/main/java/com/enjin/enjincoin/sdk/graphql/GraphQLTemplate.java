package com.enjin.enjincoin.sdk.graphql;

import com.enjin.enjincoin.sdk.graphql.api.Fields;

import java.util.ArrayList;
import java.util.List;

public class GraphQLTemplate {

    public static final String PAGINATION_PARAM = "pagination";

    private String                     name;
    private boolean                    mutation;
    private String                     method;
    private List<GraphQLTemplateField> fields;
    private GraphQLTemplateField       paginationItemField;

    private GraphQLTemplate(String name, boolean mutation, String method) {
        this.name = name;
        this.mutation = mutation;
        this.method = method;
        this.fields = new ArrayList<>();
        this.paginationItemField = new GraphQLTemplateField("items", fields);
    }

    public String getName() {
        return name;
    }

    public boolean isMutation() {
        return mutation;
    }

    public String getMethod() {
        return method;
    }

    public GraphQLTemplate withField(GraphQLTemplateField field) {
        fields.add(field);
        return this;
    }

    public GraphQLTemplate withField(String field) {
        fields.add(GraphQLTemplateField.of(field));
        return this;
    }

    public GraphQLTemplate copyFields(GraphQLTemplate other) {
        fields.addAll(other.fields);
        return this;
    }

    public GraphQLTemplate copyChildren(GraphQLTemplateField field) {
        fields.addAll(field.children);
        return this;
    }

    public String serializeFields() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < fields.size(); i++) {
            if (i > 0) builder.append(',');
            builder.append(fields.get(i).serialize());
        }

        return builder.toString();
    }

    public String serialize(GraphQLParameters parameters) {
        StringBuilder builder = new StringBuilder(mutation ? "mutation" : "query");

        builder.append(' ')
               .append(name)
               .append('{')
               .append("result:")
               .append(method);

        if (!(parameters == null || parameters.getParameters().isEmpty())) {
            builder.append('(')
                   .append(parameters.getFormattedParameters())
                   .append(')');
        }

        builder.append('{');

        if (parameters.has(PAGINATION_PARAM)) {
            builder.append(paginationItemField.serialize())
                   .append(',')
                   .append(Fields.CURSOR.serialize());
        } else {
            builder.append(serializeFields());
        }

        return builder.append('}')
                      .append('}')
                      .toString();
    }

    public static GraphQLTemplate of(String name, boolean mutation, String method) {
        return new GraphQLTemplate(name, mutation, method);
    }

}
