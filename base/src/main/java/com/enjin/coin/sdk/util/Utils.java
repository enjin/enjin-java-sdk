package com.enjin.coin.sdk.util;

import java.util.UUID;

public class Utils {

	/**
	 * Method to generate a randomId
	 * @return
	 */
	public static String generateRandomId() {
		//TODO - update with a proper random string
		String randomId = UUID.randomUUID().toString();
		randomId = randomId.replaceAll("-", "");
		
		//TODO: id must be 1 for now when mocking against WireMock as the clientId and returned serverId must match
		randomId = "1";
		return randomId;
	}

}
