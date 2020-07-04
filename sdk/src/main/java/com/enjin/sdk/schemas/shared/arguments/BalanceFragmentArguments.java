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

package com.enjin.sdk.schemas.shared.arguments;

import com.enjin.sdk.graphql.VariableHolder;
import com.enjin.sdk.models.AssetIdFormat;
import com.enjin.sdk.models.AssetIndexFormat;

/**
 * Fragment interface used to request certain information from balances returned by the platform.
 *
 * @param <T> the type of the implementing class
 * @see com.enjin.sdk.models.Balance
 */
public interface BalanceFragmentArguments<T extends VariableHolder<T>> extends VariableHolder<T> {

    /**
     * Sets the desired asset ID format.
     *
     * @param balIdFormat the format
     * @return this request for chaining
     */
    default T balIdFormat(AssetIdFormat balIdFormat) {
        return set("balIdFormat", balIdFormat);
    }

    /**
     * Sets the desired index format for non-fungible assets.
     *
     * @param balIndexFormat the format
     * @return this request for chaining
     */
    default T balIndexFormat(AssetIndexFormat balIndexFormat) {
        return set("balIndexFormat", balIndexFormat);
    }

    /**
     * Sets the request to include the project UUID with the balance.
     *
     * @return this request for chaining
     */
    default T withBalProjectUuid() {
        return set("withBalProjectUuid", true);
    }

    /**
     * Sets the request to include the wallet address with the balance.
     *
     * @return this request for chaining
     */
    default T withBalWalletAddress() {
        return set("withBalWalletAddress", true);
    }

}

