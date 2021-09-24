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

/**
 * Request for deleting a player from the project.
 *
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class DeletePlayer extends GraphQLRequest<DeletePlayer> {

    /**
     * Sole constructor.
     */
    public DeletePlayer() {
        super("enjin.sdk.project.DeletePlayer");
    }

    /**
     * Sets the ID for the player to be deleted.
     *
     * @param id the ID
     * @return this request for chaining
     */
    public DeletePlayer id(String id) {
        return set("id", id);
    }

}
