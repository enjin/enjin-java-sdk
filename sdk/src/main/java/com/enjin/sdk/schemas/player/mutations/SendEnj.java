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

package com.enjin.sdk.schemas.player.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;

/**
 * Request for sending send ENJ.
 *
 * @see com.enjin.sdk.schemas.player.IPlayerSchema
 */
public class SendEnj
        extends GraphQLRequest<SendEnj>
        implements TransactionFragmentArguments<SendEnj> {

    /**
     * Sole constructor.
     */
    public SendEnj() {
        super("enjin.sdk.player.SendEnj");
    }

    /**
     * Sets the wallet address of the recipient.
     *
     * @param recipientAddress the address
     * @return this request for chaining
     */
    public SendEnj recipientAddress(String recipientAddress) {
        return set("recipientAddress", recipientAddress);
    }

    /**
     * Sets the amount of ENJ to send.
     * <br>
     * <p>
     *     The value is in Wei as 10^18 (e.g. 1 ENJ = 1000000000000000000).
     * </p>
     *
     * @param value the value
     * @return this request for chaining
     */
    public SendEnj value(String value) {
        return set("value", value);
    }

}
