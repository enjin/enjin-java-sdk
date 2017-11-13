package com.enjin.coin.sdk.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ArrayUtils.class)
public class ArrayUtilsTest {

    @Test
    public void testConstructor() {
        ArrayUtils arrayUtils = new ArrayUtils();
        assertNotNull(arrayUtils);
    }

    @Test
    public void testIsEmpty_Array_False() {
        Object[] arr = new Object[]{new Object()};
        boolean isEmpty = ArrayUtils.isEmpty(arr);
        assertFalse(isEmpty);
    }

    @Test
    public void testIsEmpty_Array_TrueNull() {
        Object[] arr = null;
        boolean isEmpty = ArrayUtils.isEmpty(arr);
        assertTrue(isEmpty);
    }

    @Test
    public void testIsEmpty_Array_TrueEmpty() {
        Object[] arr = new Object[]{};
        boolean isEmpty = ArrayUtils.isEmpty(arr);
        assertTrue(isEmpty);
    }

    @Test
    public void testIsNotEmpty_Array_FalseEmpty() {
        Object[] arr = new Object[]{};
        boolean isEmpty = ArrayUtils.isNotEmpty(arr);
        assertFalse(isEmpty);
    }

    @Test
    public void testIsNotEmpty_Array_FalseNull() {
        Object[] arr = null;
        boolean isEmpty = ArrayUtils.isNotEmpty(arr);
        assertFalse(isEmpty);
    }

    @Test
    public void testIsNotEmpty_Array_True() {
        Object[] arr = new Object[]{new Object()};
        boolean isEmpty = ArrayUtils.isNotEmpty(arr);
        assertTrue(isEmpty);
    }

}
