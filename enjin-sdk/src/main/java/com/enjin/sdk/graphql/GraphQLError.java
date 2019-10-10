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
     * The response error message.
     *
     * @return the error message.
     */
    private String message;

    /**
     * The response error code.
     *
     * @return the error code.
     */
    private int code;

    /**
     * The response error locations.
     *
     * @return the error locations.
     */
    private List<Map<String, Integer>> locations;

    /**
     * The response error details.
     *
     * @return the error details.
     */
    private String details;

}
