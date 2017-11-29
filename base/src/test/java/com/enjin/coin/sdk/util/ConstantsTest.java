package com.enjin.coin.sdk.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ConstantsTest {

    @Test
    public void testConstructor() {
        Constants constants = new Constants();
        assertThat(constants).isNotNull();
    }

}
