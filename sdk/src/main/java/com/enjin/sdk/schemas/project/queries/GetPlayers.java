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

package com.enjin.sdk.schemas.project.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.PlayerFilter;
import com.enjin.sdk.schemas.shared.arguments.PaginationArguments;
import com.enjin.sdk.schemas.shared.arguments.PlayerFragmentArguments;

/**
 * Request for getting players on the project.
 *
 * @see com.enjin.sdk.models.Player
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class GetPlayers
        extends GraphQLRequest<GetPlayers>
        implements PlayerFragmentArguments<GetPlayers>,
        PaginationArguments<GetPlayers> {

    /**
     * Sole constructor.
     */
    public GetPlayers() {
        super("enjin.sdk.project.GetPlayers");
    }

    /**
     * Sets the filter the request will use.
     *
     * @param filter the filter
     * @return this request for chaining
     */
    public GetPlayers filter(PlayerFilter filter) {
        return set("filter", filter);
    }

}
