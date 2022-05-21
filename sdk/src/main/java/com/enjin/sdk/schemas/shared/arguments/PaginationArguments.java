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

package com.enjin.sdk.schemas.shared.arguments;

import com.enjin.sdk.graphql.VariableHolder;
import com.enjin.sdk.models.PaginationInput;

/**
 * Fragment interface used to set pagination options for a pagination returned by the platform.
 *
 * @param <T> the type of the implementing class
 *
 * @see com.enjin.sdk.models.PaginationCursor
 */
public interface PaginationArguments<T extends VariableHolder<T>> extends VariableHolder<T> {

    /**
     * Sets the pagination options.
     *
     * @param pagination the input
     *
     * @return this request for chaining
     */
    default T paginate(PaginationInput pagination) {
        return set("pagination", pagination);
    }

    /**
     * Creates pagination options that are then set.
     *
     * @param page  the page to start on
     * @param limit the number of items per page
     *
     * @return this request for chaining
     */
    default T paginate(Integer page, Integer limit) {
        return paginate(new PaginationInput()
                                .page(page)
                                .limit(limit));
    }

}
