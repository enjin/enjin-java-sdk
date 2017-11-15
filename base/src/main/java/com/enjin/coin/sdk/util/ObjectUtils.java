package com.enjin.coin.sdk.util;

public class ObjectUtils {

    /**
     * Method to check if an object is null.
     *
     * @param object - object to check
     * @return - boolean result
     */
    public static boolean isNull(Object object) {
        return object == null;
    }

    /**
     * Method to check if an object is not null.
     *
     * @param object - object to check
     * @return - boolean result
     */
    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }

}
