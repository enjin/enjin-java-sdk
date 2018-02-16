package io.enjincoin.sdk.client.util.http;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProtocolPortTest {

    @Test
    public void testConstructor() {
        ProtocolPort protocolPort = new ProtocolPort();
        assertThat(protocolPort).isNotNull();
    }

}
