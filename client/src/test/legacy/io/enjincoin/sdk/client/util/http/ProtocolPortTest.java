package io.enjincoin.sdk.client.util.http;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import io.enjincoin.sdk.client.util.http.ProtocolPort;

public class ProtocolPortTest {

    @Test
    public void testConstructor() {
        ProtocolPort protocolPort = new ProtocolPort();
        assertThat(protocolPort).isNotNull();
    }

}
