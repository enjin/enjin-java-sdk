/* Copyright 2021 Enjin Pte Ltd.
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
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;

/**
 * Request for getting a transaction on the platform.
 *
 * @see com.enjin.sdk.models.Request
 * @see com.enjin.sdk.schemas.shared.ISharedSchema
 */
public class GetRequest
        extends GraphQLRequest<GetRequest>
        implements TransactionFragmentArguments<GetRequest> {

    /**
     * Sole constructor.
     */
    public GetRequest() {
        super("enjin.sdk.shared.GetRequest");
    }

    /**
     * Sets the transaction ID.
     *
     * @param id the ID
     * @return this request for chaining
     */
    public GetRequest id(Integer id) {
        return set("id", id);
    }

    /**
     * Sets the transaction hash ID.
     *
     * @param id the hash ID
     * @return this request for chaining
     */
    public GetRequest transactionId(String id) {
        return set("transactionId", id);
    }

}
