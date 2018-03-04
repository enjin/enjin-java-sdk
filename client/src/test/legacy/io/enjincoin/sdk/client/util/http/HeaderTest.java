package io.enjincoin.sdk.client.util.http;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class HeaderTest {

    @Test
    public void testConstructor() {
        Header header = new Header();
        assertThat(header).isNotNull();
    }

}
