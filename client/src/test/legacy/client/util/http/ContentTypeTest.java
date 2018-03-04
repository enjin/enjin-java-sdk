package io.enjincoin.sdk.client.util.http;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContentTypeTest {

    @Test
    public void testConstructor() {
        ContentType contentType = new ContentType();
        assertThat(contentType).isNotNull();
    }

}
