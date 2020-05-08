package com.enjin.sdk.graphql;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.ToString;

/**
 * A class that models the structure of a GraphQL response error.
 *
 * @author Evan Lindsay
 */
@Getter
@ToString
public final class GraphQLError {

    /**
     * -- GETTER --
     * Returns the response error message.
     *
     * @return the error message.
     */
    private String message;

    /**
     * -- GETTER --
     * Returns the response error code.
     *
     * @return the error code.
     */
    private int code;

    /**
     * -- GETTER --
     * Returns the response error locations.
     *
     * @return the error locations.
     */
    private List<Map<String, Integer>> locations;

    /**
     * -- GETTER --
     * Returns the response error details.
     *
     * @return the error details.
     */
    private String details;

}
