package com.enjin.sdk.graphql;

import java.util.List;

import com.enjin.sdk.models.PaginationCursor;

import lombok.Getter;
import lombok.ToString;

/**
 * Models the body of a GraphQLResponse.
 *
 * @param <T> the model of the data field
 * @author Evan Lindsay
 * @see GraphQLError
 */
@ToString
public class GraphQLResponse<T> {

    /**
     * -- GETTER --
     * @return the raw data
     */
    @Getter
    private String raw;

    /**
     * -- GETTER --
     * @return the data object
     */
    @Getter
    private T data;

    /**
     * -- GETTER --
     * @return the errors
     */
    @Getter
    private List<GraphQLError> errors;

    /**
     * -- GETTER --
     * @return the cursor
     */
    @Getter
    private PaginationCursor cursor;

    /**
     * Constructs a representation of a response from a GraphQL request.
     *
     * @param raw the raw response body
     * @param data the deserialized response data
     * @param errors the deserialized response errors
     * @param cursor the deserialized response pagination cursor
     */
    public GraphQLResponse(String raw, T data, List<GraphQLError> errors, PaginationCursor cursor) {
        this.raw = raw;
        this.data = data;
        this.errors = errors;
        this.cursor = cursor;
    }

    /**
     * Returns whether the response is empty or not.
     *
     * @return true if data is not null, else false
     */
    public boolean isEmpty() {
        return data == null;
    }

    /**
     * Returns whether the response contains any errors.
     *
     * @return true if there are errors, else false
     */
    public boolean hasErrors() {
        return errors != null && !errors.isEmpty();
    }

    /**
     * Returns whether the response is paginated.
     *
     * @return true if the response is paginated, else false
     */
    public boolean isPaginated() {
        return cursor != null;
    }

    /**
     * Returns whether the response was successful.
     * <br>
     * <p>
     *     A response is considered successful if there are no errors and there exists a data value.
     * </p>
     *
     * @return true if successful, else false
     */
    public boolean isSuccess() {
        return !(isEmpty() || hasErrors());
    }

}
