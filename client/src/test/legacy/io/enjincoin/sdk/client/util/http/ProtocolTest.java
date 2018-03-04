package io.enjincoin.sdk.client.util.http;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import io.enjincoin.sdk.client.util.http.Protocol;

public class ProtocolTest {

    @Test
    public void testConstructor() {
        Protocol protocol = new Protocol();
        assertThat(protocol).isNotNull();
    }

}
