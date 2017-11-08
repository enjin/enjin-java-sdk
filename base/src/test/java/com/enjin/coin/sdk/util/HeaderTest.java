package com.enjin.coin.sdk.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class HeaderTest {
	
	@Test
	public void testConstructor() {
		Header header = new Header();
		assertNotNull(header);
	}

}
