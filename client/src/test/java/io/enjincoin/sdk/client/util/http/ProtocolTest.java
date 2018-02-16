package io.enjincoin.sdk.client.util.http;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProtocolTest {

    @Test
    public void testConstructor() {
        Protocol protocol = new Protocol();
        assertThat(protocol).isNotNull();
    }

}
