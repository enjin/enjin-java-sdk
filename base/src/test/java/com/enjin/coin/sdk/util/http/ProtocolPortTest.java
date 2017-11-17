package com.enjin.coin.sdk.util.http;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ProtocolPortTest {

    @Test
    public void testConstructor() {
        ProtocolPort protocolPort = new ProtocolPort();
        assertThat(protocolPort).isNotNull();
    }

}
