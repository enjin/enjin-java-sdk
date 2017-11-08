package com.enjin.coin.sdk.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ContentTypeTest {
	
	@Test
	public void testConstructor() {
		ContentType contentType = new ContentType();
		assertNotNull(contentType);
	}

}
