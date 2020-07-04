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

package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.AssetSupplyModel;
import com.enjin.sdk.models.AssetTransferFeeSettingsInput;
import com.enjin.sdk.models.AssetTransferable;
import com.enjin.sdk.schemas.project.arguments.ProjectTransactionRequestArguments;

/**
 * Request for creating a asset on the platform.
 *
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class CreateAsset
        extends GraphQLRequest<CreateAsset>
        implements ProjectTransactionRequestArguments<CreateAsset> {

    /**
     * Sole constructor.
     */
    public CreateAsset() {
        super("enjin.sdk.project.CreateAsset");
    }

    /**
     * Sets the name of the asset.
     *
     * @param name the name
     * @return this request for chaining
     */
    public CreateAsset name(String name) {
        return set("name", name);
    }

    /**
     * Sets the total supply of the asset.
     *
     * @param totalSupply the total supply
     * @return this request for chaining
     */
    public CreateAsset totalSupply(String totalSupply) {
        return set("totalSupply", totalSupply);
    }

    /**
     * Sets the initial reserve of the asset.
     *
     * @param initialReserve the reserve
     * @return this request for chaining
     */
    public CreateAsset initialReserve(String initialReserve) {
        return set("initialReserve", initialReserve);
    }

    /**
     * Sets the supply model of the asset.
     *
     * @param supplyModel the model
     * @return this request for chaining
     */
    public CreateAsset supplyModel(AssetSupplyModel supplyModel) {
        return set("supplyModel", supplyModel);
    }

    /**
     * Sets the melt value of the asset.
     * <br>
     * <p>
     *     Corresponds to the exchange rate.
     * </p>
     *
     * @param meltValue the value
     * @return this request for chaining
     */
    public CreateAsset meltValue(String meltValue) {
        return set("meltValue", meltValue);
    }

    /**
     * Sets the ratio of the melt value to be returned to the creator.
     * <br>
     * <p>
     *     The ratio is in the range 0-5000 to allow fractional ratios, e.g. 1 = 0.01%, 5000 = 50%, ect...
     * </p>
     *
     * @param meltFeeRatio the ratio
     * @return this request for chaining
     */
    public CreateAsset meltFeeRatio(int meltFeeRatio) {
        return set("meltFeeRatio", meltFeeRatio);
    }

    /**
     * Sets the transferable type of the asset.
     *
     * @param transferable the transferable type
     * @return this request for chaining
     */
    public CreateAsset transferable(AssetTransferable transferable) {
        return set("transferable", transferable);
    }

    /**
     * Sets the transfer fee settings of the asset.
     *
     * @param transferFeeSettings the settings
     * @return this request for chaining
     */
    public CreateAsset transferFeeSettings(AssetTransferFeeSettingsInput transferFeeSettings) {
        return set("transferFeeSettings", transferFeeSettings);
    }

    /**
     * Sets the fungible state of the asset.
     *
     * @param nonFungible the state
     * @return this request for chaining
     */
    public CreateAsset nonFungible(boolean nonFungible) {
        return set("nonFungible", nonFungible);
    }

}
