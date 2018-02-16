package io.enjincoin.sdk.client.config;

import io.enjincoin.sdk.client.util.http.Protocol;
import io.enjincoin.sdk.client.util.http.ProtocolPort;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlatformTest {

    private Platform platform;

    @Before
    public void setUp() {
        this.platform = ImmutablePlatform.builder().build();
    }


    @Test
    public void testGetHost() {
        assertThat(this.platform.getHost()).isEqualToIgnoringCase("localhost");
    }

    @Test
    public void testGetPort() {
        assertThat(this.platform.getPort()).isEqualTo(ProtocolPort.HTTPS);
    }

    @Test
    public void testGetProtocol() {
        assertThat(this.platform.getProtocol()).isEqualTo(Protocol.HTTPS);
    }

    @Test
    public void testToString() {
        assertThat(this.platform.toString())
                .isEqualToIgnoringCase(String
                        .format("%s://%s:%d/", this.platform.getProtocol(), this.platform.getHost(), this.platform.getPort()));
    }

}
