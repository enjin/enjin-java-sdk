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

import com.google.gson.JsonObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Models a asset variant.
 *
 * @see Asset
 */
@EqualsAndHashCode
@Getter
public final class AssetVariant {

    /**
     * -- Getter --
     * @return the ID of this variant
     */
    private Integer id;

    /**
     * -- Getter --
     * @return the asset ID this variant belongs to
     */
    private String assetId;

    /**
     * -- Getter --
     * @return the metadata for this variant
     */
    private JsonObject variantMetadata;

    /**
     * -- Getter --
     * @return the usage count
     */
    private Integer usageCount;

    /**
     * -- Getter --
     * <br>
     * <p>
     *     Formatted as an ISO 8601 string.
     * </p>
     *
     * @return the datetime when this was created
     */
    private String createdAt;

    /**
     * -- Getter --
     * <br>
     * <p>
     *     Formatted as an ISO 8601 string.
     * </p>
     *
     * @return the datetime when this was last updated
     */
    private String updatedAt;

}
