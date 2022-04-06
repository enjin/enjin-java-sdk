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

package com.enjin.sdk.schemas.project.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.WalletFragmentArguments;

/**
 * Request for getting player wallets.
 *
 * @see com.enjin.sdk.models.Wallet
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class GetWallets
        extends GraphQLRequest<GetWallets>
        implements WalletFragmentArguments<GetWallets> {

    /**
     * Sole constructor.
     */
    public GetWallets() {
        super("enjin.sdk.project.GetWallets");
    }

    /**
     * Sets the user IDs owning the wallets to get.
     *
     * @param userIds the IDs
     *
     * @return this request for chaining
     */
    public GetWallets userIds(String... userIds) {
        return set("userIds", userIds);
    }

    /**
     * Sets the Ethereum addresses of the wallets to get.
     *
     * @param ethAddresses the addresses
     *
     * @return this request for chaining
     */
    public GetWallets ethAddresses(String... ethAddresses) {
        return set("ethAddresses", ethAddresses);
    }

}
