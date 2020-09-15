package com.enjin.sdk.graphql;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.ToString;

/**
 * Models the structure of a GraphQL response error.
 */
@Getter
@ToString
public final class GraphQLError {

    /**
     * -- GETTER --
     * @return the error message
     */
    private String message;

    /**
     * -- GETTER --
     * @return the error code
     */
    private int code;

    /**
     * -- GETTER --
     * @return the error locations
     */
    private List<Map<String, Integer>> locations;

    /**
     * -- GETTER --
     * @return the error details
     */
    private String details;

}
