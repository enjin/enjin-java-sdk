package com.enjin.coin.sdk.util;

import java.util.Optional;

public class OptionalUtils {

    /**
     * Method to check if an optional's value is present.
     *
     * @param optional
     * @return
     */
    public static boolean isPresent(Optional<?> optional) {
        return optional != null && optional.isPresent();
    }

    /**
     * Method to check if an optional's value is absent.
     *
     * @param optional
     * @return
     */
    public static boolean isNotPresent(Optional<?> optional) {
        return !isPresent(optional);
    }

}
