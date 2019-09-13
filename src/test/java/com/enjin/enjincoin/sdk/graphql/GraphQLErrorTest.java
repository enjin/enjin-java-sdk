package com.enjin.enjincoin.sdk.graphql;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.truth.Truth.*;

public class GraphQLErrorTest {

    private static final String                     MESSAGE   = "Internal Server Error";
    private static final int                        CODE      = 500;
    private static final String                     DETAILS   = "An error occurred.";
    private static final List<Map<String, Integer>> LOCATIONS = new ArrayList<>();
    private static final Gson                       GSON      = new Gson();
    private static final String                     JSON;

    static {
        Map<String, Integer> location = new HashMap<>();
        location.put("1", 1);
        location.put("2", 2);
        location.put("3", 3);
        LOCATIONS.add(location);

        JsonObject obj = new JsonObject();
        obj.addProperty("message", MESSAGE);
        obj.addProperty("code", CODE);
        obj.add("locations", GSON.toJsonTree(LOCATIONS));
        obj.addProperty("details", DETAILS);
        JSON = GSON.toJson(obj);
    }

    @Test
    public void allArgsConstructor_allFieldsSet() {
        GraphQLError error = new GraphQLError(MESSAGE, CODE, LOCATIONS, DETAILS);
        assertThat(error.getMessage()).isEqualTo(MESSAGE);
        assertThat(error.getCode()).isEqualTo(CODE);
        assertThat(error.getLocations()).isEqualTo(LOCATIONS);
        assertThat(error.getDetails()).isEqualTo(DETAILS);
    }

    @Test
    public void noArgsConstructor_isDeserialized_allFieldsSet() {
        GraphQLError error = GSON.fromJson(JSON, GraphQLError.class);
        assertThat(error.getMessage()).isEqualTo(MESSAGE);
        assertThat(error.getCode()).isEqualTo(CODE);
        assertThat(error.getLocations()).isEqualTo(LOCATIONS);
        assertThat(error.getDetails()).isEqualTo(DETAILS);
    }

    @Test
    public void toString_allArgsEqualToDeserialized() {
        GraphQLError allArgError       = new GraphQLError(MESSAGE, CODE, LOCATIONS, DETAILS);
        GraphQLError deserializedError = GSON.fromJson(JSON, GraphQLError.class);
        assertThat(allArgError.toString()).isEqualTo(deserializedError.toString());
    }

    @Test
    public void hashCode_allArgsEqualToDeserialized() {
        GraphQLError allArgError       = new GraphQLError(MESSAGE, CODE, LOCATIONS, DETAILS);
        GraphQLError deserializedError = GSON.fromJson(JSON, GraphQLError.class);
        assertThat(allArgError.hashCode()).isEqualTo(deserializedError.hashCode());
    }


}
