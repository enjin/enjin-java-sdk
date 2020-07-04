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

package com.enjin.sdk.models;

import com.enjin.sdk.schemas.project.mutations.MintAsset;
import lombok.EqualsAndHashCode;

/**
 * Models a mint input for mint requests.
 *
 * @see MintAsset
 */
@EqualsAndHashCode
public class MintInput {

    private String to;
    private String value;

    /**
     * Sets the Ethereum address to mint to.
     *
     * @param ethAddress the address
     * @return this input for chaining
     */
    public MintInput to(String ethAddress) {
        to = ethAddress;
        return this;
    }

    /**
     * Sets the number of assets to mint.
     *
     * @param value the amount to mint
     * @return this input for chaining
     */
    public MintInput value(String value) {
        this.value = value;
        return this;
    }

}
