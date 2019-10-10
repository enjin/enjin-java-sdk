package com.enjin.sdk.graphql;

import static com.google.common.truth.Truth.*;

import org.junit.Test;

public class GraphQLTemplateTest {

    private static final String  TEMPLATE_NAME    = "TemplateName";
    private static final boolean MUTATION         = true;
    private static final String  METHOD           = "Get";
    private static final String  FIELD_NAME       = "Test";
    private static final String  CHILD_FIELD_NAME = "Child";

    @Test
    public void constructor() {
        GraphQLTemplate template = createQuery();
        assertThat(template).isNotNull();
    }

    @Test
    public void getName_isEqual() {
        GraphQLTemplate template = createQuery();
        assertThat(template.getName()).isEqualTo(TEMPLATE_NAME);
    }

    @Test
    public void isMutation_isFalse() {
        GraphQLTemplate template = createQuery();
        assertThat(template.isMutation()).isFalse();
    }

    @Test
    public void getMethod_isEqual() {
        GraphQLTemplate template = createQuery();
        assertThat(template.getMethod()).isEqualTo(METHOD);
    }

    @Test
    public void withField_fieldAddedToTemplate() {
        GraphQLTemplate template = createQuery();
        template.withField(FIELD_NAME);
        assertThat(template.fields).hasSize(1);
        assertThat(template.fields.get(0).name).isEqualTo(FIELD_NAME);
    }

    @Test
    public void copyFields_fieldsCopied() {
        GraphQLTemplate template = createQuery();
        template.withField(FIELD_NAME);
        GraphQLTemplate copy = createQuery();
        copy.copyFields(template);
        assertThat(copy.fields).hasSize(1);
        assertThat(copy.fields.get(0).name).isEqualTo(FIELD_NAME);
    }

    @Test
    public void copyChildren_childrenCopied() {
        GraphQLTemplate      template = createQuery();
        GraphQLTemplateField field    = GraphQLTemplateField.of(FIELD_NAME);
        field.withChild(CHILD_FIELD_NAME);
        template.copyChildren(field);
        assertThat(template.fields).hasSize(1);
        assertThat(template.fields.get(0).name).isEqualTo(CHILD_FIELD_NAME);
    }

    @Test
    public void serializeFields_isCommaSeparated() {
        GraphQLTemplate template = createQuery();
        template.withField(FIELD_NAME);
        template.withField(CHILD_FIELD_NAME);
        assertThat(template.serializeFields().split(",")).hasLength(2);
    }

    @Test
    public void serialize_withParams_matches() {
        GraphQLTemplate template = createQuery();
        template.withField(FIELD_NAME);
        template.withField(CHILD_FIELD_NAME);
        GraphQLParameters parameters = new GraphQLParameters();
        parameters.getParameters().put(FIELD_NAME, FIELD_NAME);
        assertThat(template.serialize(parameters))
                .matches(String.format("^query %s\\{result:%s\\(.*\\)\\{.*\\}\\}$",
                                       TEMPLATE_NAME, METHOD));
    }

    @Test
    public void serialize_paginated_matches() {
        GraphQLTemplate template = createQuery();
        template.withField(FIELD_NAME);
        template.withField(CHILD_FIELD_NAME);
        GraphQLParameters parameters = new GraphQLParameters();
        parameters.getParameters().put(FIELD_NAME, FIELD_NAME);
        parameters.getParameters().put(GraphQLTemplate.PAGINATION_PARAM, true);
        assertThat(template.serialize(parameters))
                .matches(String.format("^query %s\\{result:%s\\(pagination: true.*\\)\\{.*\\}\\}$",
                                       TEMPLATE_NAME, METHOD));
    }

    @Test
    public void serialize_paramsNull_matches() {
        GraphQLTemplate template = createQuery();
        template.withField(FIELD_NAME);
        template.withField(CHILD_FIELD_NAME);
        assertThat(template.serialize(null))
                .matches(String.format("^query %s\\{result:%s\\{.*\\}\\}$",
                                       TEMPLATE_NAME, METHOD));
    }

    @Test
    public void serialize_paramsEmpty_matches() {
        GraphQLTemplate template = createQuery();
        template.withField(FIELD_NAME);
        template.withField(CHILD_FIELD_NAME);
        assertThat(template.serialize(new GraphQLParameters()))
                .matches(String.format("^query %s\\{result:%s\\{.*\\}\\}$",
                                       TEMPLATE_NAME, METHOD));
    }

    @Test
    public void serialize_mutation_matches() {
        GraphQLTemplate template = createMutation();
        template.withField(FIELD_NAME);
        template.withField(CHILD_FIELD_NAME);
        assertThat(template.serialize(new GraphQLParameters()))
                .matches(String.format("^mutation %s\\{result:%s\\{.*\\}\\}$",
                                       TEMPLATE_NAME, METHOD));
    }

    private GraphQLTemplate createQuery() {
        return GraphQLTemplate.of(TEMPLATE_NAME, !MUTATION, METHOD);
    }

    private GraphQLTemplate createMutation() {
        return GraphQLTemplate.of(TEMPLATE_NAME, MUTATION, METHOD);
    }

}
