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

package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.TransactionFilter;
import com.enjin.sdk.models.TransactionSort;
import com.enjin.sdk.schemas.shared.arguments.PaginationArguments;
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;

/**
 * Request for getting transactions on the platform.
 *
 * @see com.enjin.sdk.models.Request
 * @see com.enjin.sdk.schemas.shared.ISharedSchema
 */
public class GetRequests
        extends GraphQLRequest<GetRequests>
        implements TransactionFragmentArguments<GetRequests>,
        PaginationArguments<GetRequests> {

    /**
     * Sole constructor.
     */
    public GetRequests() {
        super("enjin.sdk.shared.GetRequests");
    }

    /**
     * Sets the filter the request will use.
     *
     * @param filter the filter
     * @return this request for chaining
     */
    public GetRequests filter(TransactionFilter filter) {
        return set("filter", filter);
    }

    /**
     * Sets the request to sort the results by the specified options.
     *
     * @param sort the sort options
     * @return this request for chaining
     */
    public GetRequests sort(TransactionSort sort) {
        return set("sort", sort);
    }

}
