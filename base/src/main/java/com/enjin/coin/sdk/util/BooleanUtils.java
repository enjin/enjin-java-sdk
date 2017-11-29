package com.enjin.coin.sdk.util;

/**
 * <p>
 * Functionality for working with optionals.
 * </p>
 */
public class BooleanUtils {

    /**
     * Class constructor.
     */
    protected BooleanUtils() {

    }

    /**
     * Method to check if condition is true
     *
     * @param condition - condition to check
     * @return - boolean result
     */
    public static boolean isTrue(final Boolean condition) {
        return condition != null && condition == true;
    }

    /**
     * Method to check if condition is not true
     *
     * @param condition - condition to check
     * @return - boolean result
     */
    public static boolean isNotTrue(final Boolean condition) {
        return !isTrue(condition);
    }

    /**
     * Method to check if condition is false
     *
     * @param condition - condition to check
     * @return - boolean result
     */
    public static boolean isFalse(final Boolean condition) {
        return !isTrue(condition);
    }

    /**
     * Method to check if condition is not false
     *
     * @param condition - condition to check
     * @return - boolean result
     */
    public static boolean isNotFalse(final Boolean condition) {
        return isTrue(condition);
    }

}
