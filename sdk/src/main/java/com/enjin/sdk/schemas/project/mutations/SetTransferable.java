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
import com.enjin.sdk.models.AssetTransferable;
import com.enjin.sdk.schemas.project.arguments.ProjectTransactionRequestArguments;

/**
 * Request for setting if a asset may be transferred.
 *
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class SetTransferable
        extends GraphQLRequest<SetTransferable>
        implements ProjectTransactionRequestArguments<SetTransferable> {

    /**
     * Sole constructor.
     */
    public SetTransferable() {
        super("enjin.sdk.project.SetTransferable");
    }

    /**
     * Sets the asset ID.
     *
     * @param assetId the ID
     * @return this request for chaining
     */
    public SetTransferable assetId(String assetId) {
        return set("assetId", assetId);
    }

    /**
     * Sets the index for non-fungible assets.
     *
     * @param assetIndex the index
     * @return this request for chaining
     */
    public SetTransferable assetIndex(String assetIndex) {
        return set("assetIndex", assetIndex);
    }

    /**
     * Sets the new transfer mode.
     *
     * @param transferable the new mode
     * @return this request for chaining
     */
    public SetTransferable transferable(AssetTransferable transferable) {
        return set("transferable", transferable);
    }

}
