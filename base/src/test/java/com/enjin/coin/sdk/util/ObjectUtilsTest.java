package com.enjin.coin.sdk.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ObjectUtils.class)
public class ObjectUtilsTest {

    @Test
    public void testConstructor() {
        ObjectUtils validationUtils = new ObjectUtils();
        assertThat(validationUtils).isNotNull();
    }

    @Test
    public void testIsNull_ObjectIsNull() {
        Object o = null;
        assertThat(ObjectUtils.isNull(o)).isTrue();
    }

    @Test
    public void testIsNull_ObjectIsNotNull() {
        Object o = new Object();
        assertThat(ObjectUtils.isNull(o)).isFalse();
    }

    @Test
    public void testIsNotNull_ObjectIsNull() {
        Object o = null;
        assertThat(ObjectUtils.isNotNull(o)).isFalse();
    }

    @Test
    public void testIsNotNull_ObjectIsNotNull() {
        Object o = new Object();
        assertThat(ObjectUtils.isNotNull(o)).isTrue();
    }

}
