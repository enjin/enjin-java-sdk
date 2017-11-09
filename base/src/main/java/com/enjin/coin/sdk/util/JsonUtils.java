package com.enjin.coin.sdk.util;

import java.io.IOException;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	private static final Logger LOGGER = Logger.getLogger(JsonUtils.class.getName());
	
	/**
	 * Method to convert a json string to an object
	 * @param jsonString
	 * @param responseClass
	 * @return
	 */
	public static Object convertJsonToObject(String jsonString, Class<?> responseClass) {
		Object responseObject = null;
		
		if (ValidationUtils.isEmpty(jsonString) || responseClass == null) {
			LOGGER.warning("jsonString passed in is null or empty or the responseClass is null");
			return responseObject;
		}		
		
		ObjectMapper mapper = new ObjectMapper();

		//JSON from file to Object
		try {
			LOGGER.fine(String.format("jsonString:%s", jsonString));
			responseObject = mapper.readValue(jsonString, responseClass);
		} catch (IOException e) {
			LOGGER.warning(String.format("An IOException has occured. Exception: %s", StringUtils.exceptionToString(e)));
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
			LOGGER.warning("jsonObject passed in is null");
			return jsonString;
		}		
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonString = mapper.writeValueAsString(jsonObject);
			LOGGER.fine(String.format("jsonString:%s", jsonString));
		} catch (JsonProcessingException e) {
			LOGGER.warning(String.format("A JsonProcessingException has occured. Exception: %e", StringUtils.exceptionToString(e)));
		}

		return jsonString;
	}
}
