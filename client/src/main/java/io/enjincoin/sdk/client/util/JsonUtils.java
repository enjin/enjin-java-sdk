package io.enjincoin.sdk.client.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import com.enjin.java_commons.ExceptionUtils;
import com.enjin.java_commons.ObjectUtils;
import com.enjin.java_commons.StringUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

/**
 * <p>
 * All utility methods for working with json.
 * </p>
 */
public final class JsonUtils {

    /**
     * Logger used by this class.
     */
    private static final Logger LOGGER = Logger.getLogger(JsonUtils.class.getName());

    /**
     * Class constructor.
     */
    protected JsonUtils() {

    }

    /**
     * Method to convert a json string to an object.
     *
     * @param gson          gson object
     * @param jsonString    json to convert to an object
     * @param responseClass class type to convert to
     *
     * @return An object representing the json in the fileReader
     */
    public static Object convertJsonToObject(final Gson gson, final String jsonString, final Class<?> responseClass) {

        Object responseObject = null;

        if (gson == null || StringUtils.isEmpty(jsonString) || ObjectUtils.isNull(responseClass)) {
            LOGGER.warning("gson passed in is null or jsonString passed in is null or empty or the responseClass is null");
            return responseObject;
        }
        // JSON from file to Object
        try {
            LOGGER.fine(String.format("jsonString:%s", jsonString));
            responseObject = gson.fromJson(jsonString, responseClass);
        } catch (JsonSyntaxException e) {
            LOGGER.warning(String.format("A JsonSyntaxException has occured. Exception: %s", ExceptionUtils.exceptionToString(e)));
        }

        return responseObject;
    }

    /**
     * Method to convert a json string from a file to an object.
     *
     * @param gson          gson object
     * @param filePath      filePath to read json from
     * @param responseClass class type to convert to
     *
     * @return An object representing the json at the filePath
     */
    public static Object convertJsonFromFileToObject(final Gson gson, final String filePath, final Class<?> responseClass) {
        Object responseObject = null;

        if (gson == null || StringUtils.isEmpty(filePath) || ObjectUtils.isNull(responseClass)) {
            LOGGER.warning("gson passed in is null or filePath passed in is null or empty or the responseClass is null");
            return responseObject;
        }

        // JSON from file to Object
        try {
            LOGGER.fine(String.format("filePath:%s", filePath));
            InputStream inputStream = new FileInputStream(filePath);
            Reader fileReader = new InputStreamReader(inputStream, Constants.CHARSET_UTF_8);
            JsonReader jsonReader = new JsonReader(fileReader);
            responseObject = gson.fromJson(jsonReader, responseClass);
        } catch (FileNotFoundException e) {
            LOGGER.warning(String.format("A FileNotFoundException has occured. Exception: %s", ExceptionUtils.exceptionToString(e)));
        } catch (UnsupportedEncodingException e) {
            LOGGER.warning(String.format("An UnsupportedEncodingException has occured. Exception: %s", ExceptionUtils.exceptionToString(e)));
        }

        return responseObject;
    }

    /**
     * Method to convert json from a fileReader to an object.
     *
     * @param gson          gson object
     * @param fileReader    fileReader with the required content
     * @param responseClass class type to convert to
     *
     * @return An object representing the json in the fileReader
     */
    public static Object convertJsonFromFileReaderToObject(final Gson gson, final FileReader fileReader, final Class<?> responseClass) {
        Object responseObject = null;

        if (gson == null || fileReader == null || ObjectUtils.isNull(responseClass)) {
            LOGGER.warning("gson passed in is null or fileReader passed in is null or empty or the responseClass is null");
            return responseObject;
        }

        // JSON from file to Object
        try {
            JsonReader jsonReader = new JsonReader(fileReader);
            responseObject = gson.fromJson(jsonReader, responseClass);
        } catch (JsonSyntaxException e) {
            LOGGER.warning(String.format("A JsonSyntaxException has occured. Exception: %s", ExceptionUtils.exceptionToString(e)));
        }

        return responseObject;
    }

    /**
     * Method to convert an object to a json string.
     *
     * @param gson       gson object
     * @param jsonObject jsonObject tp cpmvert
     *
     * @return - A string with the object in json format
     */
    public static String convertObjectToJson(final Gson gson, final Object jsonObject) {
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
     * Method to convert an object to a json tree.
     *
     * @param gson       gson object
     * @param jsonObject jsonObject to convert
     *
     * @return a JsonElement
     */
    public static JsonElement convertObjectToJsonTree(final Gson gson, final Object jsonObject) {
        JsonElement jsonElement = null;

        if (gson == null || ObjectUtils.isNull(jsonObject)) {
            LOGGER.warning("gson or jsonObject passed in is null");
            return jsonElement;
        }

        jsonElement = gson.toJsonTree(jsonObject);

        return jsonElement;
    }

    /**
     * Method to check if a json string is valid or not
     * @param gson
     * @return
     */
    public static boolean isJsonValid(final Gson gson, String jsonStr) {
        boolean isJsonValid = false;
        if (gson == null || StringUtils.isEmpty(jsonStr)) {
            LOGGER.warning("gson or jsonObject passed in is null");
            return isJsonValid;
        }

        try {
            gson.fromJson(jsonStr, Object.class);
            isJsonValid = true;
        } catch(JsonSyntaxException ex) {
            isJsonValid = false;
        }

        return isJsonValid;
    }

}
