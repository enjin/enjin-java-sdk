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

package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.TransferInput;
import com.enjin.sdk.schemas.project.arguments.ProjectTransactionRequestArguments;

/**
 * Request for sending one or more assets in a single transaction.
 *
 * @see SendAsset
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class AdvancedSendAsset
        extends GraphQLRequest<AdvancedSendAsset>
        implements ProjectTransactionRequestArguments<AdvancedSendAsset> {

    /**
     * Sole constructor.
     */
    public AdvancedSendAsset() {
        super("enjin.sdk.project.AdvancedSendAsset");
    }

    /**
     * Sets the different transfers to perform.
     *
     * @param transfers the transfers
     *
     * @return this request for chaining
     */
    public AdvancedSendAsset transfers(TransferInput... transfers) {
        return set("transfers", transfers);
    }

    /**
     * Sets the data to forward with the transaction.
     *
     * @param data the data
     *
     * @return this request for chaining
     */
    public AdvancedSendAsset data(String data) {
        return set("data", data);
    }

}
