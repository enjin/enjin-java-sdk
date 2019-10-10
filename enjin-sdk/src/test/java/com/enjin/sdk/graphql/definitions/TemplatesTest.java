package com.enjin.sdk.graphql.definitions;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLTemplate;
import com.google.common.truth.Truth;

import org.junit.Test;
import org.powermock.reflect.Whitebox;

public class TemplatesTest {

    // Tests will fail if new templates are added and this isn't updated
    private static final int TEMPLATE_COUNT = 29;

    @Test(expected = UnsupportedOperationException.class)
    public void constructor_unsupported() throws Exception {
        Whitebox.invokeConstructor(Templates.class);
    }

    @Test
    public void getTemplates_returnsCorrectNumberOfTemplates() {
        List<GraphQLTemplate> templates = Templates.getTemplates();
        Truth.assertThat(templates).hasSize(TEMPLATE_COUNT);
    }

}
