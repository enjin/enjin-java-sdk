package com.enjin.coin.sdk.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ArrayUtils.class)
public class ArrayUtilsTest {

    @Test
    public void testConstructor() {
        ArrayUtils arrayUtils = new ArrayUtils();
        assertThat(arrayUtils).isNotNull();
    }

    @Test
    public void testIsEmpty_Array_False() {
        Object[] arr = new Object[]{new Object()};
        assertThat(ArrayUtils.isEmpty(arr)).isFalse();
    }

    @Test
    public void testIsEmpty_Array_TrueNull() {
        Object[] arr = null;
        assertThat(ArrayUtils.isEmpty(arr)).isTrue();
    }

    @Test
    public void testIsEmpty_Array_TrueEmpty() {
        Object[] arr = new Object[]{};
        assertThat(ArrayUtils.isEmpty(arr)).isTrue();
    }

    @Test
    public void testIsNotEmpty_Array_FalseEmpty() {
        Object[] arr = new Object[]{};
        assertThat(ArrayUtils.isNotEmpty(arr)).isFalse();
    }

    @Test
    public void testIsNotEmpty_Array_FalseNull() {
        Object[] arr = null;
        assertThat(ArrayUtils.isNotEmpty(arr)).isFalse();
    }

    @Test
    public void testIsNotEmpty_Array_True() {
        Object[] arr = new Object[]{new Object()};
        assertThat(ArrayUtils.isNotEmpty(arr)).isTrue();
    }

    @Test
    public void testGetLength_Array_NullEqualsZero() {
        Object[] arr = null;
        assertThat(ArrayUtils.getLength(arr)).isEqualTo(0);
    }

    @Test
    public void testGetLength_Array_EmptyEqualsZero() {
        Object[] arr = new Object[]{};
        assertThat(ArrayUtils.getLength(arr)).isEqualTo(0);
    }

    @Test
    public void testGetLength_Array_GreaterThanZero() {
        Object[] arr = new Object[]{new Object()};
        assertThat(ArrayUtils.getLength(arr)).isGreaterThan(0);
    }

}
