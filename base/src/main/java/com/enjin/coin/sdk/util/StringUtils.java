package com.enjin.coin.sdk.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

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

}
