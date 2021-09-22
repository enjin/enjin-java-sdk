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

package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.Whitelisted;
import com.enjin.sdk.schemas.project.arguments.ProjectTransactionRequestArguments;

/**
 * Request for setting an asset's whitelist.
 *
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class SetWhitelisted
        extends GraphQLRequest<SetWhitelisted>
        implements ProjectTransactionRequestArguments<SetWhitelisted> {

    /**
     * Sole constructor.
     */
    public SetWhitelisted() {
        super("enjin.sdk.project.SetWhitelisted");
    }

    /**
     * Sets the asset ID.
     *
     * @param assetId the ID
     * @return this request for chaining
     */
    public SetWhitelisted assetId(String assetId) {
        return set("assetId", assetId);
    }

    /**
     * Sets the account address to be added to the whitelist.
     *
     * @param accountAddress the address
     * @return this request for chaining
     */
    public SetWhitelisted accountAddress(String accountAddress) {
        return set("accountAddress", accountAddress);
    }

    /**
     * Sets the whitelisted setting for the account.
     *
     * @param whitelisted the setting
     * @return this request for chaining
     */
    public SetWhitelisted whitelisted(Whitelisted whitelisted) {
        return set("whitelisted", whitelisted);
    }

    /**
     * Sets the specified address for sending or receiving.
     *
     * @param whitelistedAddress the address
     * @return this request for chaining
     */
    public SetWhitelisted whitelistedAddress(String whitelistedAddress) {
        return set("whitelistedAddress", whitelistedAddress);
    }

    /**
     * Sets whether the whitelist setting is on or off.
     *
     * @param on the setting
     * @return this request for chaining
     */
    public SetWhitelisted on(Boolean on) {
        return set("on", on);
    }

}
