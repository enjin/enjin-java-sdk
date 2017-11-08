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
	 * @param jsonString
	 * @param responseClass
	 * @return
	 */
	public static Object convertJsonToObject(String jsonString, Class<?> responseClass) {
		Object responseObject = null;
		
		if (StringUtils.isEmpty(jsonString) || responseClass == null) {
			LOGGER.error("jsonString passed in is null or empty or the responseClass is null");
			return responseObject;
		}		
		
		ObjectMapper mapper = new ObjectMapper();

		//JSON from file to Object
		try {
			LOGGER.debug("jsonString:{}", jsonString);
			responseObject = mapper.readValue(jsonString, responseClass);
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
	public static String convertObjectToJson(Object jsonObject) {
		String jsonString = null;
		
		if (jsonObject == null) {
			LOGGER.error("jsonObject passed in is null");
			return jsonString;
		}		
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonString = mapper.writeValueAsString(jsonObject);
			LOGGER.debug("jsonString:{}", jsonString);
		} catch (JsonProcessingException e) {
			LOGGER.error("A JsonProcessingException has occured. Exception: {}", e);
		}

		return jsonString;
	}
}
