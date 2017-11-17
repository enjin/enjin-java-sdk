package com.enjin.coin.sdk.util;

/**
 * <p>
 * Functionality for working with objects.
 * </p>
 */
public class ObjectUtils {

    /**
     * Class constructor.
     */
    protected ObjectUtils() {

    }

    /**
     * Method to check if an object is null.
     *
     * @param object - object to check
     * @return - boolean result
     */
    public static boolean isNull(final Object object) {
        return object == null;
    }

    /**
     * Method to check if an object is not null.
     *
     * @param object - object to check
     * @return - boolean result
     */
    public static boolean isNotNull(final Object object) {
        return !isNull(object);
    }

}
