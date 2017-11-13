package com.enjin.coin.sdk.util;

import com.enjin.coin.sdk.util.http.Header;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class HeaderTest {

    @Test
    public void testConstructor() {
        Header header = new Header();
        assertNotNull(header);
    }

}
