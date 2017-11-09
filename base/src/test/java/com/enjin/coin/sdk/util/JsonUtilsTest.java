package com.enjin.coin.sdk.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.enjin.coin.sdk.vo.event.GetEventResponseVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

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
		
		GsonBuilder mockGsonBuilder = PowerMockito.mock(GsonBuilder.class);
		Gson mockGson= PowerMockito.mock(Gson.class);
		PowerMockito.whenNew(GsonBuilder.class).withNoArguments().thenReturn(mockGsonBuilder);
		Mockito.when(mockGsonBuilder.create()).thenReturn(mockGson);
		
		Mockito.when(mockGson.fromJson(Mockito.anyString(), Mockito.isA(Class.class))).thenThrow(new JsonSyntaxException("exception"));
		Object responseObject = JsonUtils.convertJsonToObject(jsonString, responseClass);
		assertNull(responseObject);
		
		PowerMockito.verifyNew(GsonBuilder.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockGsonBuilder, Mockito.times(1)).create();
		Mockito.verify(mockGson, Mockito.times(1)).fromJson(Mockito.anyString(), Mockito.isA(Class.class));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testConvertJsonToObject_Success() throws Exception {
		String jsonString = "{}";
		Class<?> responseClass = GetEventResponseVO.class;
		
		GsonBuilder mockGsonBuilder = PowerMockito.mock(GsonBuilder.class);
		Gson mockGson= PowerMockito.mock(Gson.class);
		PowerMockito.whenNew(GsonBuilder.class).withNoArguments().thenReturn(mockGsonBuilder);
		Mockito.when(mockGsonBuilder.create()).thenReturn(mockGson);
		
		Mockito.when(mockGson.fromJson(Mockito.anyString(), Mockito.isA(Class.class))).thenReturn(new GetEventResponseVO());
		Object responseObject = JsonUtils.convertJsonToObject(jsonString, responseClass);
		assertNotNull(responseObject);
		
		PowerMockito.verifyNew(GsonBuilder.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockGsonBuilder, Mockito.times(1)).create();
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
		
		GsonBuilder mockGsonBuilder = PowerMockito.mock(GsonBuilder.class);
		Gson mockGson= PowerMockito.mock(Gson.class);
		PowerMockito.whenNew(GsonBuilder.class).withNoArguments().thenReturn(mockGsonBuilder);
		Mockito.when(mockGsonBuilder.create()).thenReturn(mockGson);
		
		PowerMockito.when(mockGson.toJson(Mockito.isA(GetEventResponseVO.class))).thenReturn(jsonStrResponse);
		
		String jsonResponse = JsonUtils.convertObjectToJson(jsonObject);
		assertNotNull(jsonResponse);
		assertTrue(jsonResponse.length() == 0);
		
		PowerMockito.verifyNew(GsonBuilder.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockGsonBuilder, Mockito.times(1)).create();
		Mockito.verify(mockGson, Mockito.times(1)).toJson(Mockito.isA(GetEventResponseVO.class));
	}
	@Test
	public void testConvertObjectToJson_Success() throws Exception {
		String jsonStrResponse = "{\"event_id\":\"1\"}";
		GetEventResponseVO jsonObject = new GetEventResponseVO();
		
		GsonBuilder mockGsonBuilder = PowerMockito.mock(GsonBuilder.class);
		Gson mockGson= PowerMockito.mock(Gson.class);
		PowerMockito.whenNew(GsonBuilder.class).withNoArguments().thenReturn(mockGsonBuilder);
		Mockito.when(mockGsonBuilder.create()).thenReturn(mockGson);
		
		PowerMockito.when(mockGson.toJson(Mockito.isA(GetEventResponseVO.class))).thenReturn(jsonStrResponse);
		
		String jsonResponse = JsonUtils.convertObjectToJson(jsonObject);
		assertNotNull(jsonResponse);
		assertTrue(jsonResponse.length() > 0);

		PowerMockito.verifyNew(GsonBuilder.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockGsonBuilder, Mockito.times(1)).create();
		Mockito.verify(mockGson, Mockito.times(1)).toJson(Mockito.isA(GetEventResponseVO.class));
	}
}
