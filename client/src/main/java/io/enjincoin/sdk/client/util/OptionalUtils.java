package io.enjincoin.sdk.client.util;

import java.util.Optional;

/**
 * <p>
 * Functionality for working with optionals.
 * </p>
 */
public class OptionalUtils {

    /**
     * Class constructor.
     */
    protected OptionalUtils() {

    }

    /**
     * Method to check if an optional's value is present.
     *
     * @param optional - optional to check
     *
     * @return - boolean result
     */
    public static boolean isPresent(final Optional<?> optional) {
        return optional != null && optional.isPresent();
    }

    /**
     * Method to check if an optional's value is absent.
     *
     * @param optional - optional to check
     *
     * @return - boolean result
     */
    public static boolean isNotPresent(final Optional<?> optional) {
        return !isPresent(optional);
    }

}
