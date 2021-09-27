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

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Models the configuration data of a {@link Asset}.
 */
@EqualsAndHashCode
@Getter
public class AssetConfigData {

    /**
     * -- Getter --
     * <br>
     * <p>
     *     The ratio is in the range of 0-10000 to allow fractional ratios, e.g. 1 = 0.01%, 10000 = 100%, etc...
     * </p>
     *
     * @return the melt fee ratio
     */
    private Integer meltFeeRatio;

    /**
     * -- Getter --
     * <br>
     * <p>
     *     The ratio is in the range of 0-10000 to allow fractional ratios, e.g. 1 = 0.01%, 10000 = 100%, etc...
     * </p>
     *
     * @return the max melt fee ratio
     */
    private Integer meltFeeMaxRatio;

    /**
     * -- Getter --
     * <br>
     * <p>
     *     Corresponds to this item's exchange rate.
     * </p>
     *
     * @return the melt value for the asset
     */
    private String meltValue;

    /**
     * -- Getter --
     * @return the metadata URI for the asset
     */
    @SerializedName("metadataURI")
    private String metadataUri;

    /**
     * -- Getter --
     * @return the transferable type
     */
    private AssetTransferable transferable;

    /**
     * -- Getter --
     * @return the fee settings for the asset
     */
    private AssetTransferFeeSettings transferFeeSettings;

}
