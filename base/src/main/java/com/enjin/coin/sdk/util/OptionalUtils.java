package com.enjin.coin.sdk.util;

import java.util.Optional;

/**
 * <p>Functionality for working with optionals</p>
 */
public class OptionalUtils {

    /**
     * Method to check if an optional's value is present.
     *
     * @param optional - optional to check
     * @return - boolean result
     */
    public static boolean isPresent(Optional<?> optional) {
        return optional != null && optional.isPresent();
    }

    /**
     * Method to check if an optional's value is absent.
     *
     * @param optional - optional to check
     * @return - boolean result
     */
    public static boolean isNotPresent(Optional<?> optional) {
        return !isPresent(optional);
    }

}
