package com.enjin.coin.sdk.util;

import java.util.Map;
import java.util.Optional;

/**
 * <p>Functionality for working with maps.</p>
 */
public final class MapUtils {

	/**
	 * Class constructor.
	 */
    protected MapUtils() {

    }

    /**
     * Method to check if a map is empty.
     *
     * @param map - map to check
     * @return - boolean result
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Map map) {
        return ObjectUtils.isNull(map) || map.size() == 0;
    }

    /**
     * Method to check if a map is not empty.
     *
     * @param map - map to check
     * @return - boolean result
     */
    @SuppressWarnings("rawtypes")
    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }

    /**
     * Method to check if an optional map is empty.
     *
     * @param optional - optional map to check
     * @return - boolean result
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Optional<? extends Map> optional) {
        return ObjectUtils.isNull(optional) || OptionalUtils.isNotPresent(optional) || isEmpty(optional.get());
    }

    /**
     * Method to check if an optional map is not empty.
     *
     * @param optional - optional map to check
     * @return - boolean result
     */
    @SuppressWarnings("rawtypes")
    public static boolean isNotEmpty(Optional<? extends Map> optional) {
        return !isEmpty(optional);
    }

}
