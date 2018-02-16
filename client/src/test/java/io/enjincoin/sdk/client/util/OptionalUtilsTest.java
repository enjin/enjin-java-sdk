package io.enjincoin.sdk.client.util;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionalUtilsTest {

    @Test
    public void testConstructor() {
        OptionalUtils optionalUtils = new OptionalUtils();
        assertThat(optionalUtils).isNotNull();
    }

    @Test
    public void testIsPresent_FalseNullOptional() {
        Optional<?> optional = null;
        assertThat(OptionalUtils.isPresent(optional)).isFalse();
    }
    @Test
    public void testIsPresent_FalseNotPresent() {
        Optional<?> optional = Optional.empty();
        assertThat(OptionalUtils.isPresent(optional)).isFalse();
    }
    @Test
    public void testIsPresent_FalseOptionalNullable() {
        Optional<?> optional = Optional.ofNullable(null);
        assertThat(OptionalUtils.isPresent(optional)).isFalse();
    }
    @Test
    public void testIsPresent_True() {
        Optional<?> optional = Optional.of(new Object());
        assertThat(OptionalUtils.isPresent(optional)).isTrue();
    }
    
    @Test
    public void testIsNotPresent_False() {
        Optional<?> optional = Optional.of(new Object());
        assertThat(OptionalUtils.isNotPresent(optional)).isFalse();
    }
    
    @Test
    public void testIsNotPresent_TrueNullOptional() {
        Optional<?> optional = null;
        assertThat(OptionalUtils.isNotPresent(optional)).isTrue();
    }
    @Test
    public void testIsNotPresent_TrueNotPresent() {
        Optional<?> optional = Optional.empty();
        assertThat(OptionalUtils.isNotPresent(optional)).isTrue();
    }
    @Test
    public void testIsNotPresent_TrueOptionalNullable() {
        Optional<?> optional = Optional.ofNullable(null);
        assertThat(OptionalUtils.isNotPresent(optional)).isTrue();
    }
}
