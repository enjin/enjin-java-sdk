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
 * Request for setting an asset's max melt fee to a lower value.
 *
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class DecreaseMaxMeltFee
        extends GraphQLRequest<DecreaseMaxMeltFee>
        implements TransactionRequestArguments<DecreaseMaxMeltFee> {

    /**
     * Sole constructor.
     */
    public DecreaseMaxMeltFee() {
        super("enjin.sdk.project.DecreaseMaxMeltFee");
    }

    /**
     * Sets the asset ID.
     *
     * @param assetId the ID
     * @return this request for chaining
     */
    public DecreaseMaxMeltFee assetId(String assetId) {
        return set("assetId", assetId);
    }

    /**
     * Sets the new max melt fee for the asset.
     * <br>
     * <p>
     *     The ratio is in the range 0-5000 to allow fractional ratios, e.g. 1 = 0.01%, 5000 = 50%, ect...
     * </p>
     *
     * @param maxMeltFee the new ratio
     * @return this request for chaining
     */
    public DecreaseMaxMeltFee maxMeltFee(int maxMeltFee) {
        return set("maxMeltFee", maxMeltFee);
    }

}
