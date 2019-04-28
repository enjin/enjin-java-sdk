package com.enjin.enjincoin.sdk.graphql;

import java.util.List;

/**
 * Models the body of a GraphQLResponse.
 *
 * @param <T> the model of the data field.
 *
 * @author Evan Lindsay
 * @see GraphQLError
 */
public class GraphQLResponse<T> {

    private T data;

    private List<GraphQLError> errors;

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
        return errors != null && errors.size() > 0;
    }

    /**
     * Returns whether the response was successful. A
     * response is considered successful if there are no
     * errors and there exists a data value.
     *
     * @return true if not empty and no errors, else false.
     */
    public boolean isSuccess() {
        return !isEmpty() && !hasErrors();
    }
}
