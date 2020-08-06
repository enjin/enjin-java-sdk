package com.enjin.sdk.models;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
 * @param <T>
 */
public abstract class Filter<T extends Filter<T>> {

    private List<T> and;
    private List<T> or;

    /**
     * TODO
     * @param others
     * @return
     */
    @SafeVarargs
    public final T and(T... others) {
        and = Arrays.asList(others);
        return (T) this;
    }

    /**
     * TODO
     * @param others
     * @return
     */
    @SafeVarargs
    public final T or(T... others) {
        or = Arrays.asList(others);
        return (T) this;
    }

}
