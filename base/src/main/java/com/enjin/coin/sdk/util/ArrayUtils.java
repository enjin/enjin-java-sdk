package com.enjin.coin.sdk.util;

import java.lang.reflect.Array;

public class ArrayUtils {

    /**
     * Method to check if an array is empty.
     *
     * @param array
     * @return
     */
    public static boolean isEmpty(Object[] array) {
        return ObjectUtils.isNull(array) || getLength(array) == 0;
    }

    /**
     * Method to check if an array is not empty.
     *
     * @param array
     * @return
     */
    public static boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }

    /**
     * Returns the length of an array or 0 if the array is null.
     *
     * @param array
     * @return
     */
    public static int getLength(Object array) {
        return ObjectUtils.isNull(array) ? 0 : Array.getLength(array);
    }

}
