package com.enjin.coin.sdk.util;

import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

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
				
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();

		//JSON from file to Object
		try {
			LOGGER.fine(String.format("jsonString:%s", jsonString));
			responseObject = gson.fromJson(jsonString, responseClass);
		} catch (JsonSyntaxException e) {
			LOGGER.warning(String.format("A JsonSyntaxException has occured. Exception: %s", StringUtils.exceptionToString(e)));
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
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		jsonString = gson.toJson(jsonObject);
		LOGGER.fine(String.format("jsonString:%s", jsonString));	
		return jsonString;
	}
}
