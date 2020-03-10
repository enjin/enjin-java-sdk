package com.enjin.sdk.graphql;

import java.util.List;

import com.enjin.sdk.model.service.PaginationCursor;

import lombok.ToString;

/**
 * Models the body of a GraphQLResponse.
 *
 * @param <T> the model of the data field.
 *
 * @author Evan Lindsay
 * @see GraphQLError
 */
@ToString
public class GraphQLResponse<T> {

    private String raw;
    private T data;
    private List<GraphQLError> errors;
    private PaginationCursor cursor;

    /**
     * Represents a response of a GraphQL request.
     *
     * @param raw    the raw response body
     * @param data   the deserialized response data
     * @param errors the deserialized response errors
     * @param cursor the deserialized response pagination cursor
     */
    public GraphQLResponse(String raw, T data, List<GraphQLError> errors, PaginationCursor cursor) {
        this.raw = raw;
        this.data = data;
        this.errors = errors;
        this.cursor = cursor;
    }

    public String getRaw() {
        return raw;
    }

    /**
     * Returns the data object.
     *
     * @return the data object.
     */
    public T getData() {
        return data;
    }

    /**
     * Returns the GraphQL errors.
     *
     * @return the errors.
     */
    public List<GraphQLError> getErrors() {
        return errors;
    }

    public PaginationCursor getCursor() {
        return cursor;
    }

    /**
     * Returns whether the response is empty or not.
     *
     * @return true if data is not null, else false.
     */
    public boolean isEmpty() {
        return data == null;
    }

    /**
     * Returns whether the response contains any errors.
     *
     * @return true if there are errors, else false.
     */
    public boolean hasErrors() {
        return errors != null && !errors.isEmpty();
    }

    public boolean isPaginated() {
        return cursor != null;
    }

    /**
     * Returns whether the response was successful. A
     * response is considered successful if there are no
     * errors and there exists a data value.
     *
     * @return true if not empty and no errors, else false.
     */
    public boolean isSuccess() {
        return !(isEmpty() || hasErrors());
    }
}
