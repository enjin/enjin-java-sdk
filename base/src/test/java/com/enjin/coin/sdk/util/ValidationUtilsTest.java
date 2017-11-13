package com.enjin.coin.sdk.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidationUtilsTest {

    @Test
    public void testConstructor() {
        ObjectUtils validationUtils = new ObjectUtils();
        assertNotNull(validationUtils);
    }

    @Test
    public void testIsNull_ObjectIsNull() {
        Object o = null;
        assertTrue(ObjectUtils.isNull(o));
    }

    @Test
    public void testIsNull_ObjectIsNotNull() {
        Object o = new Object();
        assertFalse(ObjectUtils.isNull(o));
    }

    @Test
    public void testIsNotNull_ObjectIsNull() {
        Object o = null;
        assertFalse(ObjectUtils.isNotNull(o));
    }

    @Test
    public void testIsNotNull_ObjectIsNotNull() {
        Object o = new Object();
        assertTrue(ObjectUtils.isNotNull(o));
    }

}
