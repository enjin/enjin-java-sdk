package com.enjin.sdk.graphql;

import static com.google.common.truth.Truth.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.enjin.testing.JsonFileResource;
import com.enjin.testing.JsonFileResources;
import com.enjin.testing.rules.JsonParsingRule;
import com.google.gson.Gson;

import org.junit.Rule;
import org.junit.Test;


public class GraphQLErrorTest {

    private static final Gson GSON = new Gson();

    @Rule
    public final JsonParsingRule jsonParsingRule = new JsonParsingRule(GSON);

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

    @Test
    @JsonFileResource(fileName = "error-500.json", targetClass = GraphQLError.class)
    public void deserializeFromJson_fieldsMatchConstants() {
        GraphQLError error = jsonParsingRule.getModel(0).getValue();
        assertThat(error.getMessage()).isEqualTo(MESSAGE);
        assertThat(error.getCode()).isEqualTo(CODE);
        assertThat(error.getLocations()).isEqualTo(LOCATIONS);
        assertThat(error.getDetails()).isEqualTo(MESSAGE);
    }

    @Test
    @JsonFileResources(resources = {
            @JsonFileResource(fileName = "error-500.json", targetClass = GraphQLError.class),
            @JsonFileResource(fileName = "error-502.json", targetClass = GraphQLError.class)
    })
    public void equalTo_notEqual() {
        GraphQLError error500 = jsonParsingRule.getModel(0).getValue();
        GraphQLError error502 = jsonParsingRule.getModel(1).getValue();
        assertThat(error500).isNotEqualTo(error502);
    }

    @Test
    @JsonFileResource(fileName = "error-500.json", targetClass = GraphQLError.class)
    public void toString_matches() {
        GraphQLError error = jsonParsingRule.getModel(0).getValue();
        assertThat(error.toString()).matches("^GraphQLError\\(message=.*, code=.*, locations=.*, details=.*\\)$");
    }

}
