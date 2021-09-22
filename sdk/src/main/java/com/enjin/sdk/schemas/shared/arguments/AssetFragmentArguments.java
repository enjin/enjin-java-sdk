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

package com.enjin.sdk.schemas.shared.arguments;

import com.enjin.sdk.graphql.VariableHolder;
import com.enjin.sdk.models.AssetIdFormat;

/**
 * Fragment interface used to request certain information from assets returned by the platform.
 *
 * @param <T> the type of the implementing class
 * @see com.enjin.sdk.models.Asset
 */
public interface AssetFragmentArguments<T extends VariableHolder<T>> extends VariableHolder<T> {

    /**
     * Sets the desired asset ID format.
     *
     * @param assetIdFormat the format
     * @return this request for chaining
     */
    default T assetIdFormat(AssetIdFormat assetIdFormat) {
        return set("assetIdFormat", assetIdFormat);
    }

    /**
     * Sets the request to include state data about the asset.
     *
     * @return this request for chaining
     * @see AssetFragmentArguments#withCreator()
     * @see AssetFragmentArguments#withAssetBlocks()
     * @see AssetFragmentArguments#withSupplyDetails()
     */
    default T withStateData() {
        return set("withStateData", true);
    }

    /**
     * Sets the request to include configuration data about the asset.
     *
     * @return this request for chaining
     * @see AssetFragmentArguments#withMeltDetails()
     * @see AssetFragmentArguments#withMetadataUri()
     * @see AssetFragmentArguments#withTransferSettings()
     */
    default T withConfigData() {
        return set("withConfigData", true);
    }

    /**
     * Sets the request to include the block data with the asset when used with
     * {@link AssetFragmentArguments#withStateData()}.
     *
     * @return this request for chaining
     */
    default T withAssetBlocks() {
        return set("withAssetBlocks", true);
    }

    /**
     * Sets the request to include the creator with the asset when used with
     * {@link AssetFragmentArguments#withStateData()}.
     *
     * @return this request for chaining
     */
    default T withCreator() {
        return set("withCreator", true);
    }

    /**
     * Sets the request to include the melt details with the asset when used with
     * {@link AssetFragmentArguments#withConfigData()}.
     *
     * @return this request for chaining
     */
    default T withMeltDetails() {
        return set("withMeltDetails", true);
    }

    /**
     * Sets the request to include the metadata URI with the asset when used with
     * {@link AssetFragmentArguments#withConfigData()}.
     *
     * @return this request for chaining
     */
    default T withMetadataUri() {
        return set("withMetadataURI", true);
    }

    /**
     * Sets the request to include the supply details with the asset when used with
     * {@link AssetFragmentArguments#withStateData()}.
     *
     * @return this request for chaining
     */
    default T withSupplyDetails() {
        return set("withSupplyDetails", true);
    }

    /**
     * Sets the request to include the transfer settings with the asset when used with
     * {@link AssetFragmentArguments#withConfigData()}.
     *
     * @return this request for chaining
     */
    default T withTransferSettings() {
        return set("withTransferSettings", true);
    }

    /**
     * Sets the request to include the variant mode with the asset.
     *
     * @return this request for chaining
     */
    default T withAssetVariantMode() {
        return set("withAssetVariantMode", true);
    }

    /**
     * Sets the request to include the variants with the asset.
     *
     * @return this request for chaining
     */
    default T withAssetVariants() {
        return set("withAssetVariants", true);
    }

    /**
     * Sets the request to include the metadata for the variant(s) with the asset when used with
     * {@link AssetFragmentArguments#withAssetVariants()}.
     *
     * @return this request for chaining
     */
    default T withVariantMetadata() {
        return set("withVariantMetadata", true);
    }

}
