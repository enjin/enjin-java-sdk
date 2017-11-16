package com.enjin.coin.sdk.util;

import java.lang.reflect.Array;

/**
 * <p>Functionality for working with arrays</p>
 *
 * @author damien
 */
public class ArrayUtils {

    /**
     * Method to check if an array is empty.
     *
     * @param array - array to check
     * @return - boolean stating if the array is empty or not
     */
    public static boolean isEmpty(Object[] array) {
        return ObjectUtils.isNull(array) || getLength(array) == 0;
    }

    /**
     * Method to check if an array is not empty.
     *
     * @param array - array to check
     * @return - boolean stating if the array is not empty or is
     */
    public static boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }

    /**
     * Returns the length of an array or 0 if the array is null.
     *
     * @param array - array to check
     * @return - int with the length of the array
     */
    public static int getLength(Object array) {
        return ObjectUtils.isNull(array) ? 0 : Array.getLength(array);
    }

}
