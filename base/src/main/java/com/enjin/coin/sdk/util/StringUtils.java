package com.enjin.coin.sdk.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;

public final class StringUtils {

    protected StringUtils() {
    }

    /**
     * Method to convert an exception to string
     *
     * @param e
     * @return
     */
    public static String exceptionToString(Exception e) {
        String stacktrace = null;
        if (e != null) {
            try (StringWriter sw = new StringWriter()) {
                try (PrintWriter pw = new PrintWriter(sw)) {
                    e.printStackTrace(pw);
                    stacktrace = sw.toString();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return stacktrace;
    }

    /**
     * Method to check if a string is empty
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return ObjectUtils.isNull(str) || str.isEmpty();
    }

    /**
     * Method to check if a string is not empty
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * Method to check if an optional string is empty.
     *
     * @param optional
     * @return
     */
    public static boolean isEmpty(Optional<String> optional) {
        return OptionalUtils.isNotPresent(optional) || isEmpty(optional.get());
    }

    /**
     * Method to check if an optional string is not empty.
     *
     * @param optional
     * @return
     */
    public static boolean isNotEmpty(Optional<String> optional) {
        return !isEmpty(optional);
    }

}
