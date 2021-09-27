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

/**
 * Models a gas prices object.
 */
@EqualsAndHashCode
@Getter
public class GasPrices {

    /**
     * -- Getter --
     * The recommended safe gas price in Gwei.
     * <br>
     * <p>
     *     Expected to be mined in less than 30 minutes.
     * </p>
     *
     * @return the gas price
     */
    private float safeLow;

    /**
     * -- Getter --
     * The recommended average gas price in Gwei.
     * <br>
     * <p>
     *     Expected to be mined in less than 5 minutes.
     * </p>
     *
     * @return the gas price
     */
    private float average;

    /**
     * -- Getter --
     * The recommended fast gas price in Gwei.
     * <br>
     * <p>
     *     Expected to be mined in less than 2 minutes.
     * </p>
     *
     * @return the gas price
     */
    private float fast;

    /**
     * -- Getter --
     * The recommended fastest gas price in Gwei.
     * <br>
     * <p>
     *     Expected to be mined in less than 30 seconds.
     * </p>
     *
     * @return the gas price
     */
    private float fastest;

}
