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

package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.project.arguments.ProjectTransactionRequestArguments;

/**
 * Request for allowing an operator complete control of all assets owned by the caller.
 *
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class SetApprovalForAll
        extends GraphQLRequest<SetApprovalForAll>
        implements ProjectTransactionRequestArguments<SetApprovalForAll> {

    /**
     * Sole constructor.
     */
    public SetApprovalForAll() {
        super("enjin.sdk.project.SetApprovalForAll");
    }

    /**
     * Sets the wallet address of the operator.
     *
     * @param operatorAddress the address
     * @return this request for chaining
     */
    public SetApprovalForAll operatorAddress(String operatorAddress) {
        return set("operatorAddress", operatorAddress);
    }

    /**
     * Sets the approval state.
     *
     * @param approved the approval
     * @return this request for chaining
     */
    public SetApprovalForAll approved(Boolean approved) {
        return set("approved", approved);
    }

}
