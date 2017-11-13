package com.enjin.coin.sdk.util;

import com.enjin.coin.sdk.util.http.ContentType;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ContentTypeTest {

    @Test
    public void testConstructor() {
        ContentType contentType = new ContentType();
        assertNotNull(contentType);
    }

}
