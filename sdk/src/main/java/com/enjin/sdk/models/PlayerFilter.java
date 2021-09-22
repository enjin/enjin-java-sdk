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

package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.List;

/**
 * Models a filter input for player queries.
 *
 * @see com.enjin.sdk.schemas.project.queries.GetPlayers
 */
@EqualsAndHashCode(callSuper = true)
public class PlayerFilter extends Filter<PlayerFilter> {

    private String id;
    @SerializedName("id_in")
    private List<String> idIn;

    /**
     * Sets the player ID to filter for.
     *
     * @param id the ID
     * @return this filter for chaining
     */
    public PlayerFilter id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Sets the player IDs to filter for.
     *
     * @param ids the IDs
     * @return this filter for chaining
     */
    public PlayerFilter idIn(String... ids) {
        idIn = ids == null
                ? null
                : Arrays.asList(ids);
        return this;
    }

}
