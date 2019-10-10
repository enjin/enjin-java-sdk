package com.enjin.sdk.graphql;

import static com.google.common.truth.Truth.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.enjin.sdk.model.service.tokens.TokenTransferFeeType;
import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonObject;

import org.junit.Test;

public class GraphQLParametersTest {

    private static final Map<String, Object> PARAMETERS = new HashMap<>();
    private static final String              PARAM1     = "1";
    private static final String              PARAM2     = "2";
    private static final String              PARAM3     = "3";

    static {
        PARAMETERS.put(PARAM1, "one");
        PARAMETERS.put(PARAM2, 2);
        PARAMETERS.put(PARAM3, true);
    }

    @Test
    public void createInstanceWithNoParameters_getParametersReturnsEmpty() {
        GraphQLParameters parameters = new GraphQLParameters();
        assertThat(parameters.getParameters()).isEmpty();
    }

    @Test
    public void createInstanceWithParameters_hasSizeThree() {
        GraphQLParameters parameters = new GraphQLParameters(PARAMETERS);
        assertThat(parameters.getParameters()).hasSize(3);
    }

    @Test
    public void hasParameter_returnsTrue() {
        GraphQLParameters parameters = new GraphQLParameters(PARAMETERS);
        assertThat(parameters.has(PARAM1)).isTrue();
    }

    @Test
    public void objectToGraphQLFormat_forEnum_returnsEnumName() {
        GraphQLParameters parameters = new GraphQLParameters(ImmutableMap.<String, Object>of(PARAM1, TokenTransferFeeType.NONE));
        assertThat(parameters.getFormattedParameters()).contains(TokenTransferFeeType.NONE.name());
    }

    @Test
    public void getFormattedParameters_containingMany_fieldsAreCommaSeparated() {
        GraphQLParameters parameters = new GraphQLParameters(PARAMETERS);
        assertThat(parameters.getFormattedParameters().split(",")).hasLength(3);
    }

    @Test
    public void jsonElementToGraphQLFormat_forList_isInArrayFormat() {
        GraphQLParameters parameters = new GraphQLParameters(Collections.<String, Object>singletonMap(PARAM1, Arrays.asList("1", 2, "3", 4)));
        assertThat(parameters.getFormattedParameters()).matches(String.format("^%s: \\[.*\\]$", PARAM1));
    }

    @Test
    public void jsonElementToGraphQLFormat_forObject_isInObjectFormat() {
        JsonObject object = new JsonObject();
        object.addProperty(PARAM1, PARAM1);
        GraphQLParameters parameters = new GraphQLParameters(Collections.<String, Object>singletonMap(PARAM1, object));
        assertThat(parameters.getFormattedParameters()).matches(String.format("^%s: \\{.*\\}$", PARAM1));
    }

    @Test
    public void jsonElementToGraphQLFormat_forObject_fieldsAreCommaSeparated() {
        JsonObject object = new JsonObject();
        object.addProperty(PARAM1, PARAM1);
        object.addProperty(PARAM2, PARAM2);
        object.addProperty(PARAM3, PARAM3);
        GraphQLParameters parameters = new GraphQLParameters(Collections.<String, Object>singletonMap(PARAM1, object));
        assertThat(parameters.getFormattedParameters().split(",")).hasLength(3);
    }

    @Test
    public void jsonElementToGraphQLFormat_forString_containsStringWithQuotes() {
        GraphQLParameters parameters = new GraphQLParameters(ImmutableMap.<String, Object>of(PARAM1, PARAM1));
        assertThat(parameters.getFormattedParameters()).contains(new StringBuilder("\"").append(PARAM1)
                                                                                        .append("\""));
    }

    @Test
    public void jsonElementToGraphQLFormat_forNull_containsNull() {
        GraphQLParameters parameters = new GraphQLParameters(Collections.singletonMap(PARAM1, null));
        assertThat(parameters.getFormattedParameters()).contains("null");
    }

}
