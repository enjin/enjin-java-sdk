package com.enjin.sdk.graphql;

import static com.google.common.truth.Truth.*;

import org.junit.Test;

public class GraphQLRequestTest {

    private static final String KEY = "key";
    private static final String VAL = "val";

    @Test
    public void constructor() {
        GraphQLRequest request = new GraphQLRequest();
        assertThat(request).isNotNull();
    }

    @Test(expected = NullPointerException.class)
    public void withParameter_keyNull_npeThrown() {
        GraphQLRequest request = new GraphQLRequest();
        request.withParameter(null, VAL);
    }

    @Test(expected = NullPointerException.class)
    public void withParameter_valueNull_npeThrown() {
        GraphQLRequest request = new GraphQLRequest();
        request.withParameter(KEY, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withParameter_keyEmpty_illegalArgumentExceptionThrown() {
        GraphQLRequest request = new GraphQLRequest();
        request.withParameter("", VAL);
    }

    @Test
    public void withParameter_parameterSet() {
        GraphQLRequest request = new GraphQLRequest();
        request.withParameter(KEY, VAL);
        assertThat(request.parameters().has(KEY)).isTrue();
    }

}
