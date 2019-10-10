package com.enjin.sdk.graphql;

import static com.google.common.truth.Truth.*;

import org.junit.Test;

public class GraphQLTemplateRegistryTest {

    private static final String TEMPLATE_NAME = "TestTemplate";
    private static final boolean MUTATION = true;
    private static final String METHOD = "Method";

    @Test
    public void register_resultIsTrue() {
        GraphQLTemplateRegistry registry = new GraphQLTemplateRegistry();
        GraphQLTemplate template = createTemplate();
        assertThat(registry.register(template)).isTrue();
    }

    @Test
    public void register_resultIsFalse() {
        GraphQLTemplateRegistry registry = new GraphQLTemplateRegistry();
        GraphQLTemplate template = createTemplate();
        registry.register(template);
        assertThat(registry.register(template)).isFalse();
    }

    @Test
    public void has_returnTrue() {
        GraphQLTemplateRegistry registry = new GraphQLTemplateRegistry();
        GraphQLTemplate template = createTemplate();
        registry.register(template);
        assertThat(registry.has(template.name)).isTrue();
    }

    @Test
    public void get_returnExisting() {
        GraphQLTemplateRegistry registry = new GraphQLTemplateRegistry();
        GraphQLTemplate template = createTemplate();
        registry.register(template);
        assertThat(registry.get(template.name)).isNotNull();
    }

    private GraphQLTemplate createTemplate() {
        return GraphQLTemplate.of(TEMPLATE_NAME, MUTATION, METHOD);
    }

}
