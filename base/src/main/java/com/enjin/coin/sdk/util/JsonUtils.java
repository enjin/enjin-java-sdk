package com.enjin.coin.sdk.util;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);
	
	/**
	 * Method to convert a json string to an object
	 * @param responseString
	 * @param responseClass
	 * @return
	 */
	public static Object convertJsonToObject(String responseString, Class<?> responseClass) {
		Object responseObject = null;
		
		if (StringUtils.isEmpty(responseString) || responseClass == null) {
			LOGGER.error("responseString passed in is null or empty or the responseClass is null");
			return responseObject;
		}		
		
		ObjectMapper mapper = new ObjectMapper();

		//JSON from file to Object
		try {
			responseObject = mapper.readValue(responseString, responseClass);
		} catch (IOException e) {
			LOGGER.error("An IOException has occured. Exception: {}", e);
		}

		return responseObject;
	}

	
	/**
	 * Method to convert an object to a json string
	 * @param jsonObject
	 * @return
	 */
	public static String convertJsonToObject(Object jsonObject) {
		String responseJson = null;
		
		if (jsonObject == null) {
			LOGGER.error("jsonObject passed in is null");
			return responseJson;
		}		
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			responseJson = mapper.writeValueAsString(jsonObject);
		} catch (JsonProcessingException e) {
			LOGGER.error("A JsonProcessingException has occured. Exception: {}", e);
		}

		return responseJson;
	}
}
