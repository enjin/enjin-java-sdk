package com.enjin.coin.sdk.util;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	/**
	 * Method to convert a json string to an object
	 * @param responseString
	 * @param responseClass
	 * @return
	 */
	public static Object convertJsonToObject(String responseString, Class<?> responseClass) {
		Object responseObject = null;
		
		if (StringUtils.isEmpty(responseString) || responseClass == null) {
			//TODO: replace System.out with logging framework
			System.out.println("responseString passed in is null or empty or the responseClass is null");
			return responseObject;
		}		
		
		ObjectMapper mapper = new ObjectMapper();

		//JSON from file to Object
		try {
			responseObject = mapper.readValue(responseString, responseClass);
		} catch (IOException e) {
			System.out.println("An IOException has occured. Exception:" + e);
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
			//TODO: replace System.out with logging framework
			System.out.println("jsonObject passed in is null");
			return responseJson;
		}		
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			responseJson = mapper.writeValueAsString(jsonObject);
		} catch (JsonProcessingException e) {
			System.out.println("A JsonProcessingException has occured. Exception:" + e);
		}

		return responseJson;
	}
}
