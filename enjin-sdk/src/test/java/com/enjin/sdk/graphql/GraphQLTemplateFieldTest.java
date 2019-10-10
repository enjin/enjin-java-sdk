package com.enjin.sdk.graphql;

import static com.google.common.truth.Truth.*;

import org.junit.Test;

public class GraphQLTemplateFieldTest {

    private static final String NAME             = "Test";
    private static final String CHILD_NAME       = "Child";
    private static final String OTHER_CHILD_NAME = "OtherChild";

    @Test
    public void constructor_isNotNull() {
        assertThat(create(NAME)).isNotNull();
    }

    @Test
    public void constructor_withChildren_isNotEmpty() {
        GraphQLTemplateField field = create(NAME, create(CHILD_NAME));
        assertThat(field.getChildren()).isNotEmpty();
    }

    @Test
    public void withChild_equalToChildName() {
        GraphQLTemplateField field = create(NAME);
        field.withChild(CHILD_NAME);
        assertThat(field.getChildren()).isNotEmpty();
        assertThat(field.getChildren().get(0).name).isEqualTo(CHILD_NAME);
    }

    @Test
    public void copyChildren_hasChildEqualToChildName() {
        GraphQLTemplateField field = create(NAME, create(CHILD_NAME));
        GraphQLTemplateField copy  = create(NAME);
        copy.copyChildren(field);
        assertThat(copy.getChildren()).isNotEmpty();
        assertThat(copy.getChildren().get(0).name).isEqualTo(CHILD_NAME);
    }

    @Test
    public void getName_isEqual() {
        GraphQLTemplateField field = create(NAME);
        assertThat(field.getName()).isEqualTo(NAME);
    }

    @Test
    public void serialize_withChildren_matches() {
        GraphQLTemplateField field = create(NAME, create(CHILD_NAME), create(OTHER_CHILD_NAME));
        assertThat(field.serialize())
                .matches(String.format("^%s\\{%s,%s\\}$",
                                       NAME, CHILD_NAME, OTHER_CHILD_NAME));
    }

    @Test
    public void serialize_withoutChildren_equalToName() {
        GraphQLTemplateField field = create(NAME);
        assertThat(field.serialize()).isEqualTo(NAME);
    }

    private GraphQLTemplateField create(String name) {
        return GraphQLTemplateField.of(name);
    }

    private GraphQLTemplateField create(String name, GraphQLTemplateField... children) {
        return GraphQLTemplateField.of(name, children);
    }

}
