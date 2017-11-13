package com.enjin.coin.sdk.util;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.logging.Logger;

public final class JsonUtils {

    private static final Logger LOGGER = Logger.getLogger(JsonUtils.class.getName());

    /**
     * Method to convert a json string to an object
     *
     * @param jsonString
     * @param responseClass
     * @return
     */
    public static Object convertJsonToObject(String jsonString, Class<?> responseClass) {
        return convertJsonToObject(GsonUtils.GSON, jsonString, responseClass);
    }

    public static Object convertJsonToObject(Gson gson, String jsonString, Class<?> responseClass) {
        Object responseObject = null;

        if (StringUtils.isEmpty(jsonString) || ObjectUtils.isNull(responseClass)) {
            LOGGER.warning("jsonString passed in is null or empty or the responseClass is null");
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
     * Method to convert an object to a json string
     *
     * @param jsonObject
     * @return
     */
    public static String convertObjectToJson(Object jsonObject) {
        return convertObjectToJson(GsonUtils.GSON, jsonObject);
    }

    public static String convertObjectToJson(Gson gson, Object jsonObject) {
        String jsonString = null;

        if (ObjectUtils.isNull(jsonObject)) {
            LOGGER.warning("jsonObject passed in is null");
            return jsonString;
        }

        jsonString = gson.toJson(jsonObject);
        LOGGER.fine(String.format("jsonString:%s", jsonString));
        return jsonString;
    }
}
