package com.enjin.coin.sdk.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

public final class JsonUtils {

    private static final Logger LOGGER = Logger.getLogger(JsonUtils.class.getName());

    /**
     * Method to convert a json string to an object
     * @param gson
     * @param jsonString
     * @param responseClass
     * @return
     */
    public static Object convertJsonToObject(Gson gson, String jsonString, Class<?> responseClass) {
        Object responseObject = null;

        if (gson == null || StringUtils.isEmpty(jsonString) || ObjectUtils.isNull(responseClass)) {
            LOGGER.warning("gson passed in is null or jsonString passed in is null or empty or the responseClass is null");
            return responseObject;
        }

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
     * Method to convert a json string from a file to an object
     * @param gson
     * @param filePath
     * @param responseClass
     * @return
     */
    public static Object convertJsonFromFileToObject(Gson gson, String filePath, Class<?> responseClass) {
        Object responseObject = null;

        if (gson == null || StringUtils.isEmpty(filePath) || ObjectUtils.isNull(responseClass)) {
            LOGGER.warning("gson passed in is null or filePath passed in is null or empty or the responseClass is null");
            return responseObject;
        }

        //JSON from file to Object
        try {
            LOGGER.fine(String.format("filePath:%s", filePath));
            FileReader fileReader = new FileReader("jsonFile.json");
            JsonReader jsonReader = new JsonReader(fileReader);
			responseObject = gson.fromJson(jsonReader, responseClass);
        } catch (JsonSyntaxException e) {
            LOGGER.warning(String.format("A JsonSyntaxException has occured. Exception: %s", StringUtils.exceptionToString(e)));
        } catch (FileNotFoundException e) {
        	LOGGER.warning(String.format("A FileNotFoundException has occured. Exception: %s", StringUtils.exceptionToString(e)));
		}

        return responseObject;
    }

    /**
     * Method to convert json from a fileReader to an object
     * @param file
     * @param clazz
     */
	public static Object convertJsonFromFileReaderToObject(Gson gson, FileReader fileReader, Class<?> responseClass) {
        Object responseObject = null;

        if (gson == null ||fileReader == null ||  ObjectUtils.isNull(responseClass)) {
            LOGGER.warning("gson passed in is null or fileReader passed in is null or empty or the responseClass is null");
            return responseObject;
        }

        //JSON from file to Object
        try {
            JsonReader jsonReader = new JsonReader(fileReader);
			responseObject = gson.fromJson(jsonReader, responseClass);
        } catch (JsonSyntaxException e) {
            LOGGER.warning(String.format("A JsonSyntaxException has occured. Exception: %s", StringUtils.exceptionToString(e)));
        } 
        
        return responseObject;		
	}

    /**
     *  Method to convert an object to a json string
     * @param gson
     * @param jsonObject
     * @return
     */
    public static String convertObjectToJson(Gson gson, Object jsonObject) {
        String jsonString = null;

        if (gson == null || ObjectUtils.isNull(jsonObject)) {
            LOGGER.warning("gson or jsonObject passed in is null");
            return jsonString;
        }

        jsonString = gson.toJson(jsonObject);
        LOGGER.fine(String.format("jsonString:%s", jsonString));
        return jsonString;
    }

	/**
	 * Method to convert an object to a json tree
	 * 
	 * @param gson
	 * @param data
	 * @return
	 */
	public static JsonElement convertObjectToJsonTree(Gson gson, Object jsonObject) {
		JsonElement jsonElement = null;

		if (gson == null || ObjectUtils.isNull(jsonObject)) {
			LOGGER.warning("gson or jsonObject passed in is null");
			return jsonElement;
		}

		jsonElement = gson.toJsonTree(jsonObject);

		return jsonElement;
	}

}
