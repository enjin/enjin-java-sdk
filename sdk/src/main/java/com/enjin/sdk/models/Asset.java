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
import lombok.Getter;

import java.util.List;

/**
 * Models a asset on the platform.
 */
@EqualsAndHashCode
@Getter
public class Asset {

    /**
     * -- Getter --
     * @return the base ID of this asset
     */
    private String id;

    /**
     * -- Getter --
     * @return the name of this asset
     */
    private String name;

    /**
     * -- Getter --
     * @return the state data of this asset
     */
    private AssetStateData stateData;

    /**
     * -- Getter --
     * @return the config data of this asset
     */
    private AssetConfigData configData;

    /**
     * -- Getter --
     * @return this asset's variant mode
     */
    private AssetVariantMode variantMode;

    /**
     * -- Getter --
     * @return this asset's variants
     */
    private List<AssetVariant> variants;

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
