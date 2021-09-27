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
 * Request for getting the platform details.
 *
 * @see com.enjin.sdk.models.Platform
 * @see com.enjin.sdk.schemas.shared.ISharedSchema
 */
public class GetPlatform extends GraphQLRequest<GetPlatform> {

    /**
     * Sole constructor.
     */
    public GetPlatform() {
        super("enjin.sdk.shared.GetPlatform");
    }

    /**
     * Sets the request to include the contracts with the platform.
     *
     * @return this request for chaining
     */
    public GetPlatform withContracts() {
        return set("withContracts", true);
    }

    /**
     * Sets the request to include the notification drivers with the platform.
     *
     * @return this request for chaining
     */
    public GetPlatform withNotificationDrivers() {
        return set("withNotificationDrivers", true);
    }

}
