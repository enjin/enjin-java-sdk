package io.enjincoin.sdk.client.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BooleanUtilsTest {

    @Test
    public void testConstructor() {
        BooleanUtils booleanUtils = new BooleanUtils();
        assertThat(booleanUtils).isNotNull();
    }

    @Test
    public void testIsTrue_NullCondition() {
        Boolean condition = null;
        assertThat(BooleanUtils.isTrue(condition)).isFalse();
    }
    @Test
    public void testIsTrue_FalseCondition() {
        Boolean condition = false;
        assertThat(BooleanUtils.isTrue(condition)).isFalse();
    }
    @Test
    public void testIsTrue_TrueCondition() {
        Boolean condition = true;
        assertThat(BooleanUtils.isTrue(condition)).isTrue();
    }

    @Test
    public void testIsNotTrue_NullCondition() {
        Boolean condition = null;
        assertThat(BooleanUtils.isNotTrue(condition)).isTrue();
    }
    @Test
    public void testIsNotTrue_FalseCondition() {
        Boolean condition = false;
        assertThat(BooleanUtils.isNotTrue(condition)).isTrue();
    }
    @Test
    public void testIsNotTrue_TrueCondition() {
        Boolean condition = true;
        assertThat(BooleanUtils.isNotTrue(condition)).isFalse();
    }

    @Test
    public void testIsFalse_NullCondition() {
        Boolean condition = null;
        assertThat(BooleanUtils.isFalse(condition)).isTrue();
    }
    @Test
    public void testIsFalse_FalseCondition() {
        Boolean condition = false;
        assertThat(BooleanUtils.isFalse(condition)).isTrue();
    }
    @Test
    public void testIsFalse_TrueCondition() {
        Boolean condition = true;
        assertThat(BooleanUtils.isFalse(condition)).isFalse();
    }

    @Test
    public void testIsNotFalse_NullCondition() {
        Boolean condition = null;
        assertThat(BooleanUtils.isNotFalse(condition)).isFalse();
    }
    @Test
    public void testIsNotFalse_FalseCondition() {
        Boolean condition = false;
        assertThat(BooleanUtils.isNotFalse(condition)).isFalse();
    }
    @Test
    public void testIsNotFalse_TrueCondition() {
        Boolean condition = true;
        assertThat(BooleanUtils.isNotFalse(condition)).isTrue();
    }
}
