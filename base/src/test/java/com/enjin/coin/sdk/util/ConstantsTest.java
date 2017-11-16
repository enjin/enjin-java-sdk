package com.enjin.coin.sdk.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConstantsTest {

    @Test
    public void testConstructor() {
        Constants constants = new Constants();
        assertThat(constants).isNotNull();
    }

}
