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

package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * Request for canceling a transaction on the platform.
 *
 * @see com.enjin.sdk.schemas.shared.ISharedSchema
 */
public class CancelTransaction extends GraphQLRequest<CancelTransaction> {

    /**
     * Sole constructor.
     */
    public CancelTransaction() {
        super("enjin.sdk.shared.CancelTransaction");
    }

    /**
     * Sets the ID of the transaction to cancel.
     *
     * @param id the ID
     * @return this request for chaining
     */
    public CancelTransaction id(Integer id) {
        return set("id", id);
    }

}
