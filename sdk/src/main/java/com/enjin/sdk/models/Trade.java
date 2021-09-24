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
 * Models a trade input for requests.
 *
 * @see com.enjin.sdk.schemas.project.mutations.CreateTrade
 */
@EqualsAndHashCode
public class Trade {

    private String assetId;
    private String assetIndex;
    private String value;

    /**
     * Sets the asset ID to trade.
     * <br>
     * <p>
     * If null or omitted then ENJ will be traded instead.
     * </p>
     *
     * @param assetId the asset ID
     *
     * @return this input for chaining
     */
    public Trade assetId(String assetId) {
        this.assetId = assetId;
        return this;
    }

    /**
     * Sets the index for non-fungible assets.
     *
     * @param assetIndex the index
     *
     * @return this input for chaining
     */
    public Trade assetIndex(String assetIndex) {
        this.assetIndex = assetIndex;
        return this;
    }

    /**
     * Sets the number of assets to trade.
     * <br>
     * <p>
     * If trading ENJ, the value is the amount to send in Wei (10^18 e.g. 1 ENJ = 1000000000000000000).
     * </p>
     *
     * @param value the amount
     *
     * @return this input for chaining
     */
    public Trade value(String value) {
        this.value = value;
        return this;
    }

}
