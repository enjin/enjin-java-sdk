package com.enjin.coin.sdk.util;

import com.enjin.coin.sdk.util.http.Header;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(HeaderTest.class)
public class HeaderTest {

    @Test
    public void testConstructor() {
        Header header = new Header();
        assertThat(header).isNotNull();
    }

}
