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

package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;

/**
 * Models transfer input when making requests.
 *
 * @see com.enjin.sdk.schemas.player.mutations.AdvancedSendAsset
 * @see com.enjin.sdk.schemas.project.mutations.AdvancedSendAsset
 */
@EqualsAndHashCode
public class Transfers {

    private String from;
    private String to;
    private String assetId;
    private String assetIndex;
    private String value;

    /**
     * Sets the source of the funds.
     *
     * @param address the source
     *
     * @return this input for chaining
     */
    public Transfers from(String address) {
        from = address;
        return this;
    }

    /**
     * Sets the destination of the funds.
     *
     * @param address the destination
     *
     * @return this input for chaining
     */
    public Transfers to(String address) {
        to = address;
        return this;
    }

    /**
     * Sets the asset ID to transfer.
     * <br>
     * <p>
     * If null or omitted then ENJ will be traded instead.
     * </p>
     *
     * @param id the ID
     *
     * @return this input for chaining
     */
    public Transfers assetId(String id) {
        assetId = id;
        return this;
    }

    /**
     * Sets the index for non-fungible assets.
     *
     * @param index the index
     *
     * @return this input for chaining
     */
    public Transfers assetIndex(String index) {
        assetIndex = index;
        return this;
    }

    /**
     * Sets the number of assets to transfer.
     * <br>
     * <p>
     * If transferring ENJ, the value is the amount to send in Wei (10^18 e.g. 1 ENJ = 1000000000000000000).
     * </p>
     *
     * @param value the amount
     *
     * @return this input for chaining
     */
    public Transfers value(String value) {
        this.value = value;
        return this;
    }

}
