/* Copyright 2021 Enjin Pte. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.enjin.sdk.graphql;

import java.util.List;
import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Models the structure of a GraphQL response error.
 */
@EqualsAndHashCode
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
