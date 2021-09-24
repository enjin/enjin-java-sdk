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

import lombok.EqualsAndHashCode;

/**
 * Models sorting input for assets.
 */
@EqualsAndHashCode
public class AssetSort {

    private AssetField field;
    private SortDirection direction;

    /**
     * Sets the field to sort by.
     *
     * @param field the field
     * @return this input for chaining
     */
    public AssetSort field(AssetField field) {
        this.field = field;
        return this;
    }

    /**
     * Sets the direction to sort by.
     *
     * @param direction the direction
     * @return this input for chaining
     */
    public AssetSort direction(SortDirection direction) {
        this.direction = direction;
        return this;
    }

}
