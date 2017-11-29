package com.enjin.coin.sdk.util.http;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ContentTypeTest {

    @Test
    public void testConstructor() {
        ContentType contentType = new ContentType();
        assertThat(contentType).isNotNull();
    }

}
