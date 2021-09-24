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
 * Request to sign a message to prove wallet ownership.
 *
 * @see com.enjin.sdk.schemas.player.IPlayerSchema
 */
public class Message
        extends GraphQLRequest<Message>
        implements TransactionFragmentArguments<Message> {

    /**
     * Sole constructor.
     */
    public Message() {
        super("enjin.sdk.player.Message");
    }

    /**
     * Sets the message to sign.
     *
     * @param message the message
     * @return this request for chaining
     */
    public Message message(String message) {
        return set("message", message);
    }

}
