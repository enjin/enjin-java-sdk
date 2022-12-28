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
import com.enjin.sdk.schemas.project.arguments.TransactionRequestArguments;

/**
 * Request for setting the name of an existing asset.
 *
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class UpdateName
        extends GraphQLRequest<UpdateName>
        implements TransactionRequestArguments<UpdateName> {

    /**
     * Sole constructor.
     */
    public UpdateName() {
        super("enjin.sdk.project.UpdateName");
    }

    /**
     * Sets the ID of the asset to be updated.
     *
     * @param assetId the ID
     *
     * @return this request for chaining
     */
    public UpdateName assetId(String assetId) {
        return set("assetId", assetId);
    }

    /**
     * Sets the name the asset will be updated to.
     *
     * @param name the name
     *
     * @return this request for chaining
     */
    public UpdateName name(String name) {
        return set("name", name);
    }

}
