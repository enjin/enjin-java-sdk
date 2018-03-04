package io.enjincoin.sdk.client.util.http;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import io.enjincoin.sdk.client.util.http.ContentType;

public class ContentTypeTest {

    @Test
    public void testConstructor() {
        ContentType contentType = new ContentType();
        assertThat(contentType).isNotNull();
    }

}
