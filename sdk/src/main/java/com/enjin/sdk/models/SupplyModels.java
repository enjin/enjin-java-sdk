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

/**
 * Models the supply models used by the platform.
 */
@EqualsAndHashCode
@Getter
public class SupplyModels {

    /**
     * -- Getter --
     * @return the fixed model
     */
    private String fixed;

    /**
     * -- Getter --
     * @return the settable model
     */
    private String settable;

    /**
     * -- Getter --
     * @return the infinite model
     */
    private String infinite;

    /**
     * -- Getter --
     * @return the collapsing model
     */
    private String collapsing;

    /**
     * -- Getter --
     * @return the annual value model
     */
    private String annualValue;

    /**
     * -- Getter --
     * @return the annual percentage model
     */
    private String annualPercentage;

}
