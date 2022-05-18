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
import com.enjin.sdk.models.TradeInput;
import com.enjin.sdk.schemas.project.arguments.ProjectTransactionRequestArguments;

/**
 * Request for creating a trade between two wallets.
 *
 * @see CompleteTrade
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class CreateTrade
        extends GraphQLRequest<CreateTrade>
        implements ProjectTransactionRequestArguments<CreateTrade> {

    /**
     * Sole constructor.
     */
    public CreateTrade() {
        super("enjin.sdk.project.CreateTrade");
    }

    /**
     * Sets the assets the sender is asking for.
     *
     * @param assets the assets
     * @return this request for chaining
     */
    public CreateTrade askingAssets(TradeInput... assets) {
        return set("askingAssets", assets);
    }

    /**
     * Sets the assets to be offered by the sender.
     *
     * @param assets the assets
     * @return this request for chaining
     */
    public CreateTrade offeringAssets(TradeInput... assets) {
        return set("offeringAssets", assets);
    }

    /**
     * Sets the wallet address of the recipient.
     *
     * @param recipientAddress the address
     * @return this request for chaining
     */
    public CreateTrade recipientAddress(String recipientAddress) {
        return set("recipientAddress", recipientAddress);
    }

}
