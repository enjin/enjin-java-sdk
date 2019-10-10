package com.enjin.sdk.graphql;

import static com.google.common.truth.Truth.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.enjin.sdk.model.service.PaginationCursor;
import com.enjin.testing.JsonFileResource;
import com.enjin.testing.rules.JsonParsingRule;
import com.google.gson.Gson;

import org.junit.Rule;
import org.junit.Test;

public class GraphQLResponseTest {

    private static final Gson GSON = new Gson();

    @Rule
    public final JsonParsingRule jsonParsingRule = new JsonParsingRule(GSON);

    private static final String       RAW_RESULT = "{\"data\":{\"result\":[]}}";
    private static final List<String> DATA       = new ArrayList<>();

    @Test
    public void constructor() {
        GraphQLResponse<List<String>> response = create(RAW_RESULT, DATA, null, null);
        assertThat(response).isNotNull();
    }

    @Test
    public void getRaw_equalToRAW() {
        GraphQLResponse<List<String>> response = create(RAW_RESULT, DATA, null, null);
        assertThat(response.getRaw()).isEqualTo(RAW_RESULT);
    }

    @Test
    public void getData_equalToRAW() {
        GraphQLResponse<String> response = create(RAW_RESULT, RAW_RESULT, null, null);
        assertThat(response.getData()).isEqualTo(RAW_RESULT);
    }

    @Test
    @JsonFileResource(fileName = "error-500.json", targetClass = GraphQLError.class)
    public void getErrors_notEmpty() {
        GraphQLError error = jsonParsingRule.getModel(0).getValue();
        GraphQLResponse<List<String>> response = create(RAW_RESULT, null, Arrays.asList(error), null);
        assertThat(response.getErrors()).isNotEmpty();
    }

    @Test
    @JsonFileResource(fileName = "pagination-cursor.json", targetClass = PaginationCursor.class)
    public void getCursor_notNull() {
        PaginationCursor cursor = jsonParsingRule.getModel(0).getValue();
        GraphQLResponse<List<String>> response = create(RAW_RESULT, DATA, null, cursor);
        assertThat(response.getCursor()).isNotNull();
    }

    @Test
    public void isEmpty_isFalse() {
        GraphQLResponse<String> response = create(RAW_RESULT, RAW_RESULT, null, null);
        assertThat(response.isEmpty()).isFalse();
    }

    @Test
    public void isEmpty_isTrue() {
        GraphQLResponse<String> response = create(RAW_RESULT, null, null, null);
        assertThat(response.isEmpty()).isTrue();
    }

    @Test
    @JsonFileResource(fileName = "error-500.json", targetClass = GraphQLError.class)
    public void hasErrors_isTrue() {
        GraphQLError error = jsonParsingRule.getModel(0).getValue();
        GraphQLResponse<List<String>> response = create(RAW_RESULT, null, Arrays.asList(error), null);
        assertThat(response.hasErrors()).isTrue();
    }

    @Test
    @JsonFileResource(fileName = "error-500.json", targetClass = GraphQLError.class)
    public void hasErrors_errorsNotNull_isFalse() {
        GraphQLResponse<List<String>> response = create(RAW_RESULT, null, new ArrayList<GraphQLError>(0), null);
        assertThat(response.hasErrors()).isFalse();
    }

    @Test
    @JsonFileResource(fileName = "error-500.json", targetClass = GraphQLError.class)
    public void hasErrors_errorsNull_isFalse() {
        GraphQLResponse<List<String>> response = create(RAW_RESULT, null, null, null);
        assertThat(response.hasErrors()).isFalse();
    }

    @Test
    @JsonFileResource(fileName = "pagination-cursor.json", targetClass = PaginationCursor.class)
    public void isPaginated_isTrue() {
        PaginationCursor cursor = jsonParsingRule.getModel(0).getValue();
        GraphQLResponse<List<String>> response = create(RAW_RESULT, DATA, null, cursor);
        assertThat(response.isPaginated()).isTrue();
    }

    @Test
    public void isPaginated_isFalse() {
        GraphQLResponse<List<String>> response = create(RAW_RESULT, DATA, null, null);
        assertThat(response.isPaginated()).isFalse();
    }

    @Test
    public void isSuccess_isTrue() {
        GraphQLResponse<String> response = create(RAW_RESULT, RAW_RESULT, null, null);
        assertThat(response.isSuccess()).isTrue();
    }

    @Test
    public void isSuccess_isEmpty_isFalse() {
        GraphQLResponse<String> response = create(RAW_RESULT, null, null, null);
        assertThat(response.isSuccess()).isFalse();
    }

    @Test
    @JsonFileResource(fileName = "error-500.json", targetClass = GraphQLError.class)
    public void isSuccess_hasErrors_isFalse() {
        GraphQLError error = jsonParsingRule.getModel(0).getValue();
        GraphQLResponse<String> response = create(RAW_RESULT, RAW_RESULT, Arrays.asList(error), null);
        assertThat(response.isSuccess()).isFalse();
    }

    @Test
    public void toString_matches() {
        GraphQLResponse<List<String>> response = create(RAW_RESULT,DATA,null, null);
        assertThat(response.toString()).matches("^GraphQLResponse\\(raw=.*, data=.*, errors=.*, cursor=.*\\)$");
    }

    private <T> GraphQLResponse<T> create(String raw, T data, List<GraphQLError> errors, PaginationCursor cursor) {
        return new GraphQLResponse<>(raw, data, errors, cursor);
    }

}
