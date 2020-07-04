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

/**
 * Request for getting a project on the platform.
 *
 * @see com.enjin.sdk.models.Project
 * @see com.enjin.sdk.schemas.shared.ISharedSchema
 */
public final class GetProject extends GraphQLRequest<GetProject> {

    /**
     * Sole constructor.
     */
    public GetProject() {
        super("enjin.sdk.shared.GetProject");
    }

    /**
     * Sets the project ID.
     *
     * @param id the ID
     * @return this request for chaining
     */
    public GetProject id(Integer id) {
        return set("id", id);
    }

    /**
     * Sets the project name.
     *
     * @param name the name
     * @return this request for chaining
     */
    public GetProject name(String name) {
        return set("name", name);
    }

}
