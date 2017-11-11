package com.enjin.coin.sdk.util;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class StringUtilsTest {


    @Test
    public void testConstructor() {
        StringUtils stringUtils = new StringUtils();
        assertNotNull(stringUtils);
    }

    @Test
    public void testExceptionToString_ExceptionIsNull() {
        Exception e = null;
        String stacktrace = StringUtils.exceptionToString(e);
        assertNull(stacktrace);
    }

    @Test
    public void testExceptionToString_Success() {
        Exception e = new NullPointerException();
        String stacktrace = StringUtils.exceptionToString(e);
        assertNotNull(stacktrace);
    }


}
