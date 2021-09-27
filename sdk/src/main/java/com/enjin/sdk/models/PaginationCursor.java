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

package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Models a pagination cursor for queries.
 */
@EqualsAndHashCode
@Getter
@ToString
public class PaginationCursor {

    /**
     * -- GETTER --
     * @retrun the total number of items selected
     */
    private Integer total;

    /**
     * -- GETTER --
     * @return the number of items per page
     */
    private Integer perPage;

    /**
     * -- GETTER --
     * @return the current page
     */
    private Integer currentPage;

    /**
     * -- GETTER --
     * @return true if the cursor has pages, false otherwise
     */
    private Boolean hasPages;

    /**
     * -- GETTER --
     * @return the number of the first item returned
     */
    private Integer from;

    /**
     * -- GETTER --
     * @return the number of the last item returned
     */
    private Integer to;

    /**
     * -- GETTER --
     * @return the last page (number of pages)
     */
    private Integer lastPage;

    /**
     * -- GETTER --
     * @return true if the cursor has more pages, false otherwise
     */
    private Boolean hasMorePages;

}
