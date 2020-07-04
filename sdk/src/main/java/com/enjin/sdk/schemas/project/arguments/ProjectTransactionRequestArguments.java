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

package com.enjin.sdk.schemas.project.arguments;

import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;

/**
 * Interface used to set common arguments used in transaction requests in the project schema.
 *
 * @param <T> the type of the implementing class
 * @see com.enjin.sdk.models.Request
 */
public interface ProjectTransactionRequestArguments<T extends TransactionFragmentArguments<T>>
        extends TransactionFragmentArguments<T> {

    /**
     * Sets the Ethereum address of the sender.
     *
     * @param ethAddress the address
     * @return this request for chaining
     */
    default T ethAddress(String ethAddress) {
        return set("ethAddress", ethAddress);
    }

}
