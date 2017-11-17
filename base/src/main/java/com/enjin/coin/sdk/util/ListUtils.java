package com.enjin.coin.sdk.util;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * Functionality for working with lists.
 * </p>
 */
public final class ListUtils {

    /**
     * Class constructor.
     */
    protected ListUtils() {

    }

    /**
     * Method to check if a list is empty.
     *
     * @param list - list to check
     * @return - boolean result
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(final List list) {
        return ObjectUtils.isNull(list) || list.size() == 0;
    }

    /**
     * Method to check if a list is not empty.
     *
     * @param list - list to check
     * @return - boolean result
     */
    @SuppressWarnings("rawtypes")
    public static boolean isNotEmpty(final List list) {
        return !isEmpty(list);
    }

    /**
     * Method to check if an optional list is empty.
     *
     * @param optional - optional list to check
     * @return - boolean result
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(final Optional<? extends List> optional) {
        return ObjectUtils.isNull(optional) || OptionalUtils.isNotPresent(optional) || isEmpty(optional.get());
    }

    /**
     * Method to check if an optional list is not empty.
     *
     * @param optional - optional list to check
     * @return - boolean result
     */
    @SuppressWarnings("rawtypes")
    public static boolean isNotEmpty(final Optional<? extends List> optional) {
        return !isEmpty(optional);
    }

}
