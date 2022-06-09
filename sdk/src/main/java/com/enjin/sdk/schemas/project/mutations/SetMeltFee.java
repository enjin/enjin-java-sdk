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
 * Request for setting the melt fee of an asset.
 *
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class SetMeltFee
        extends GraphQLRequest<SetMeltFee>
        implements TransactionRequestArguments<SetMeltFee> {

    /**
     * Sole constructor.
     */
    public SetMeltFee() {
        super("enjin.sdk.project.SetMeltFee");
    }

    /**
     * Sets the asset ID.
     *
     * @param assetId the ID
     * @return this request for chaining
     */
    public SetMeltFee assetId(String assetId) {
        return set("assetId", assetId);
    }

    /**
     * Sets the new melt fee for the asset.
     * <br>
     * <p>
     *     The ratio is in the range 0-5000 to allow fractional ratios, e.g. 1 = 0.01%, 5000 = 50%, ect...
     * </p>
     *
     * @param meltFee the new ratio
     * @return this request for chaining
     */
    public SetMeltFee meltFee(Integer meltFee) {
        return set("meltFee", meltFee);
    }

}
