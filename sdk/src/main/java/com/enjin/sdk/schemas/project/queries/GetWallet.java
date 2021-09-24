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

package com.enjin.sdk.schemas.project.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.WalletFragmentArguments;

/**
 * Request for getting a player's wallet.
 *
 * @see com.enjin.sdk.models.Wallet
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class GetWallet
        extends GraphQLRequest<GetWallet>
        implements WalletFragmentArguments<GetWallet> {

    /**
     * Sole constructor.
     */
    public GetWallet() {
        super("enjin.sdk.project.GetWallet");
    }

    /**
     * Sets the user ID owning the wallet to get.
     *
     * @param userId the user ID
     * @return this request for chaining
     */
    public GetWallet userId(String userId) {
        return set("userId", userId);
    }

    /**
     * Sets the Ethereum address of the wallet to get.
     *
     * @param ethAddress the address
     * @return this request for chaining
     */
    public GetWallet ethAddress(String ethAddress) {
        return set("ethAddress", ethAddress);
    }

}
