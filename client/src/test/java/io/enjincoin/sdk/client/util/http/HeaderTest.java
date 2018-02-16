package io.enjincoin.sdk.client.util.http;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeaderTest {

    @Test
    public void testConstructor() {
        Header header = new Header();
        assertThat(header).isNotNull();
    }

}
