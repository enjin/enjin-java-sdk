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

import java.util.Arrays;
import java.util.List;

/**
 * Provides implementation of common filter input functionality.
 *
 * @param <T> the type of the implementing class
 */
@EqualsAndHashCode
public abstract class Filter<T extends Filter<T>> {

    private List<T> and;
    private List<T> or;

    /**
     * Sets the filter to include other filters to intersect with.
     *
     * @param others the other filters
     * @return this filter for chaining
     */
    @SafeVarargs
    public final T and(T... others) {
        and = others == null
                ? null
                : Arrays.asList(others);
        return (T) this;
    }

    /**
     * Sets the filter to include other filters to union with.
     *
     * @param others the other filters
     * @return this filter for chaining
     */
    @SafeVarargs
    public final T or(T... others) {
        or = others == null
                ? null
                : Arrays.asList(others);
        return (T) this;
    }

}
