package com.enjin.enjincoin.sdk.graphql;

import com.enjin.testing.JsonFileResource;
import com.enjin.testing.JsonFileResources;
import com.enjin.testing.rules.JsonParsingRule;
import com.google.gson.Gson;
import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.truth.Truth.*;

public class GraphQLErrorTest {

    // General
    private static final Gson GSON = new Gson();

    // Test Data
    private static final String                     MESSAGE   = "Internal Server Error";
    private static final int                        CODE      = 500;
    private static final List<Map<String, Integer>> LOCATIONS = new ArrayList<>();

    static {
        Map<String, Integer> location = new HashMap<>();
        location.put("1", 1);
        location.put("2", 2);
        location.put("3", 3);
        LOCATIONS.add(location);
    }

    @Rule
    public final JsonParsingRule jsonParsingRule = new JsonParsingRule(GSON);

    @Test
    @JsonFileResource(fileName = "graphql-error-500.json", targetClass = GraphQLError.class)
    public void deserializeFromJson_fieldsMatchConstants() {
        GraphQLError error = jsonParsingRule.getModel(0).getValue();
        assertThat(error.getMessage()).isEqualTo(MESSAGE);
        assertThat(error.getCode()).isEqualTo(CODE);
        assertThat(error.getLocations()).isEqualTo(LOCATIONS);
        assertThat(error.getDetails()).isEqualTo(MESSAGE);
    }

    @Test
    @JsonFileResources(resources = {
            @JsonFileResource(fileName = "graphql-error-500.json", targetClass = GraphQLError.class),
            @JsonFileResource(fileName = "graphql-error-502.json", targetClass = GraphQLError.class)
    })
    public void equalTo_notEqual() {
        GraphQLError error500 = jsonParsingRule.getModel(0).getValue();
        GraphQLError error502 = jsonParsingRule.getModel(1).getValue();
        assertThat(error500).isNotEqualTo(error502);
    }

    @Test
    public void toString_verified() {
        ToStringVerifier.forClass(GraphQLError.class)
                        .withClassName(NameStyle.SIMPLE_NAME)
                        .verify();
    }

    @Test
    public void equals_verified() {
        EqualsVerifier.forClass(GraphQLError.class)
                      .suppress(Warning.NONFINAL_FIELDS)
                      .verify();
    }


}
