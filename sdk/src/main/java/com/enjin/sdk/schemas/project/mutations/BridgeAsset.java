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
import com.enjin.sdk.schemas.project.arguments.ProjectTransactionRequestArguments;

/**
 * Request for bridging an asset.
 *
 * @see BridgeAssets
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class BridgeAsset
        extends GraphQLRequest<BridgeAsset>
        implements ProjectTransactionRequestArguments<BridgeAsset> {

    /**
     * Sole constructor.
     */
    public BridgeAsset() {
        super("enjin.sdk.project.BridgeAsset");
    }

    /**
     * Sets the ID of the asset to bridge.
     *
     * @param assetId the asset ID
     *
     * @return this request for chaining
     */
    public BridgeAsset assetId(String assetId) {
        set("assetId", assetId);
        return this;
    }

    /**
     * Sets the index of the asset to bridge if the asset is an NFT.
     *
     * @param assetIndex the asset index
     *
     * @return this request for chaining
     */
    public BridgeAsset assetIndex(String assetIndex) {
        set("assetIndex", assetIndex);
        return this;
    }

    /**
     * Sets the amount to bridge.
     *
     * @param value the amount
     *
     * @return this request for chaining
     */
    public BridgeAsset value(String value) {
        set("value", value);
        return this;
    }

}
