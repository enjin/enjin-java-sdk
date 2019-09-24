package com.enjin.testing.utils;

import java.lang.reflect.Method;

public class RuntimeUtils {

    public static Method getCurrentMethod() throws RuntimeException {
        StackTraceElement element = new Throwable().getStackTrace()[1];

        try {
            return Class.forName(element.getClassName()).getMethod(element.getMethodName());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
