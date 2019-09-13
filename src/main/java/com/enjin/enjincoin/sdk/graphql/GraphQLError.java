package com.enjin.enjincoin.sdk.graphql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * A class that models the structure of a GraphQL response error.
 *
 * @author Evan Lindsay
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GraphQLError {

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
