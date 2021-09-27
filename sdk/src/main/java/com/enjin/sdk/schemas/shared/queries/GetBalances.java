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
import com.enjin.sdk.models.BalanceFilter;
import com.enjin.sdk.schemas.shared.arguments.BalanceFragmentArguments;
import com.enjin.sdk.schemas.shared.arguments.PaginationArguments;

/**
 * Request for getting balances on the platform.
 *
 * @see com.enjin.sdk.models.Balance
 * @see com.enjin.sdk.schemas.shared.ISharedSchema
 */
public class GetBalances
        extends GraphQLRequest<GetBalances>
        implements BalanceFragmentArguments<GetBalances>,
        PaginationArguments<GetBalances> {

    /**
     * Sole constructor.
     */
    public GetBalances() {
        super("enjin.sdk.shared.GetBalances");
    }

    /**
     * Sets the filter the request will use.
     *
     * @param filter the filter
     * @return this request for chaining
     */
    public GetBalances filter(BalanceFilter filter) {
        return set("filter", filter);
    }

}
