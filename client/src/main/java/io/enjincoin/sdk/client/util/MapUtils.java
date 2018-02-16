package io.enjincoin.sdk.client.util;

import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * Functionality for working with maps.
 * </p>
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
     *
     * @return - boolean result
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(final Map map) {
        return ObjectUtils.isNull(map) || map.size() == 0;
    }

    /**
     * Method to check if a map is not empty.
     *
     * @param map - map to check
     *
     * @return - boolean result
     */
    @SuppressWarnings("rawtypes")
    public static boolean isNotEmpty(final Map map) {
        return !isEmpty(map);
    }

    /**
     * Method to check if an optional map is empty.
     *
     * @param optional - optional map to check
     *
     * @return - boolean result
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(final Optional<? extends Map> optional) {
        return ObjectUtils.isNull(optional) || OptionalUtils.isNotPresent(optional) || isEmpty(optional.get());
    }

    /**
     * Method to check if an optional map is not empty.
     *
     * @param optional - optional map to check
     *
     * @return - boolean result
     */
    @SuppressWarnings("rawtypes")
    public static boolean isNotEmpty(final Optional<? extends Map> optional) {
        return !isEmpty(optional);
    }

    /**
     * Method to convert a key object to a string.
     *
     * @param map to check
     * @param key to check for
     *
     * @return String
     */
    public static String convertKeyObjectToString(final Map<String, Object> map, final String key) {
        String value = null;
        if (isEmpty(map) || StringUtils.isEmpty(key)) {
            return value;
        }

        if (!map.containsKey(key)) {
            return value;
        }
        Object objectValue = map.get(key);
        if (objectValue != null) {
            value = objectValue.toString();
        }
        return value;
    }

}
