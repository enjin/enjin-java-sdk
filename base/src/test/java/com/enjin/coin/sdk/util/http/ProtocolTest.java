package com.enjin.coin.sdk.util.http;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ProtocolTest {

    @Test
    public void testConstructor() {
        Protocol protocol = new Protocol();
        assertThat(protocol).isNotNull();
    }

}
