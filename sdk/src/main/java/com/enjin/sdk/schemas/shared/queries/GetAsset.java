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

package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.AssetFragmentArguments;

/**
 * Request for getting a asset on the platform.
 *
 * @see com.enjin.sdk.models.Asset
 * @see com.enjin.sdk.schemas.shared.ISharedSchema
 */
public class GetAsset
        extends GraphQLRequest<GetAsset>
        implements AssetFragmentArguments<GetAsset> {

    /**
     * Sole constructor.
     */
    public GetAsset() {
        super("enjin.sdk.shared.GetAsset");
    }

    /**
     * Sets the asset ID.
     *
     * @param id the ID
     * @return this request for chaining
     */
    public GetAsset id(String id) {
        return set("id", id);
    }

}
