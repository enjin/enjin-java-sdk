package com.enjin.coin.sdk.util;

import com.enjin.coin.sdk.vo.event.GetEventResponseVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({JsonUtils.class, Gson.class, GsonBuilder.class})
public class JsonUtilsTest {

    @Test
    public void testConstructor() {
        JsonUtils jsonUtils = new JsonUtils();
        assertNotNull(jsonUtils);
    }

    @Test
    public void testConvertJsonToObject_JsonStringIsEmpty() {
        String jsonString = "";
        Class<?> responseClass = GetEventResponseVO.class;
        Object responseObject = JsonUtils.convertJsonToObject(jsonString, responseClass);
        assertNull(responseObject);
    }

    @Test
    public void testConvertJsonToObject_JsonStringIsNull() {
        String jsonString = null;
        Class<?> responseClass = GetEventResponseVO.class;
        Object responseObject = JsonUtils.convertJsonToObject(jsonString, responseClass);
        assertNull(responseObject);
    }

    @Test
    public void testConvertJsonToObject_ResponseObjectIsNull() {
        String jsonString = "{}";
        Class<?> responseClass = null;
        Object responseObject = JsonUtils.convertJsonToObject(jsonString, responseClass);
        assertNull(responseObject);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testConvertJsonToObject_JsonSyntaxException() throws Exception {
        String jsonString = "{}";
        Class<?> responseClass = GetEventResponseVO.class;

        Gson mockGson = PowerMockito.mock(Gson.class);

        Mockito.when(mockGson.fromJson(Mockito.anyString(), Mockito.isA(Class.class))).thenThrow(new JsonSyntaxException("exception"));
        Object responseObject = JsonUtils.convertJsonToObject(mockGson, jsonString, responseClass);
        assertNull(responseObject);

        Mockito.verify(mockGson, Mockito.times(1)).fromJson(Mockito.anyString(), Mockito.isA(Class.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testConvertJsonToObject_Success() throws Exception {
        String jsonString = "{}";
        Class<?> responseClass = GetEventResponseVO.class;

        Gson mockGson = PowerMockito.mock(Gson.class);

        Mockito.when(mockGson.fromJson(Mockito.anyString(), Mockito.isA(Class.class))).thenReturn(new GetEventResponseVO());
        Object responseObject = JsonUtils.convertJsonToObject(mockGson, jsonString, responseClass);
        assertNotNull(responseObject);

        Mockito.verify(mockGson, Mockito.times(1)).fromJson(Mockito.anyString(), Mockito.isA(Class.class));
    }

    @Test
    public void testConvertObjectToJson_JsonObjectIsNull() {
        Object jsonObject = null;
        String jsonResponse = JsonUtils.convertObjectToJson(jsonObject);
        assertNull(jsonResponse);
    }


    @Test
    public void testConvertObjectToJson_SuccessButJsonIsEmpty() throws Exception {
        String jsonStrResponse = "";
        GetEventResponseVO jsonObject = new GetEventResponseVO();

        Gson mockGson = PowerMockito.mock(Gson.class);

        PowerMockito.when(mockGson.toJson(Mockito.isA(GetEventResponseVO.class))).thenReturn(jsonStrResponse);

        String jsonResponse = JsonUtils.convertObjectToJson(mockGson, jsonObject);
        assertNotNull(jsonResponse);
        assertTrue(jsonResponse.length() == 0);

        Mockito.verify(mockGson, Mockito.times(1)).toJson(Mockito.isA(GetEventResponseVO.class));
    }

    @Test
    public void testConvertObjectToJson_Success() throws Exception {
        String jsonStrResponse = "{\"event_id\":\"1\"}";
        GetEventResponseVO jsonObject = new GetEventResponseVO();

        Gson mockGson = PowerMockito.mock(Gson.class);

        PowerMockito.when(mockGson.toJson(Mockito.isA(GetEventResponseVO.class))).thenReturn(jsonStrResponse);

        String jsonResponse = JsonUtils.convertObjectToJson(mockGson, jsonObject);
        assertNotNull(jsonResponse);
        assertTrue(jsonResponse.length() > 0);

        Mockito.verify(mockGson, Mockito.times(1)).toJson(Mockito.isA(GetEventResponseVO.class));
    }
}
