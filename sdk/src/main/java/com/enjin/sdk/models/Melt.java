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
 * Models a melt input for melt requests.
 *
 * @see com.enjin.sdk.schemas.player.mutations.MeltAsset
 * @see com.enjin.sdk.schemas.project.mutations.MeltAsset
 */
@EqualsAndHashCode
public class Melt {

    private String assetId;
    private String assetIndex;
    private String value;

    /**
     * Sets the asset ID to melt.
     *
     * @param assetId the ID
     *
     * @return this input for chaining
     */
    public Melt assetId(String assetId) {
        this.assetId = assetId;
        return this;
    }

    /**
     * Sets the index of a non-fungible asset to melt.
     *
     * @param assetIndex the index
     *
     * @return this input for chaining
     */
    public Melt assetIndex(String assetIndex) {
        this.assetIndex = assetIndex;
        return this;
    }

    /**
     * Sets the number of assets to melt.
     *
     * @param value the amount
     *
     * @return this input for chaining
     */
    public Melt value(String value) {
        this.value = value;
        return this;
    }

}
