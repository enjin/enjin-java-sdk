package com.enjin.sdk.models;

import java.util.Arrays;
import java.util.List;

/**
 * Provides implementation of common filter input functionality.
 *
 * @param <T> the type of the implementing class
 */
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
