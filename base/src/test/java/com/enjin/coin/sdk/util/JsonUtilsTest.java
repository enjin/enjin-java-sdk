package com.enjin.coin.sdk.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.enjin.coin.sdk.vo.BaseResponseVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(PowerMockRunner.class)
@PrepareForTest(JsonUtils.class)
public class JsonUtilsTest {

	@Test
	public void testConstructor() {
		JsonUtils jsonUtils = new JsonUtils();
		assertNotNull(jsonUtils);
	}
	
	@Test
	public void testConvertJsonToObject_JsonStringIsEmpty() {
		String jsonString = "";
		Class<?> responseClass = BaseResponseVO.class;
		Object responseObject = JsonUtils.convertJsonToObject(jsonString, responseClass);
		assertNull(responseObject);
	}
	@Test
	public void testConvertJsonToObject_JsonStringIsNull() {
		String jsonString = null;
		Class<?> responseClass = BaseResponseVO.class;
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
	public void testConvertJsonToObject_IOException() throws Exception {
		String jsonString = "{}";
		Class<?> responseClass = BaseResponseVO.class;
		
		ObjectMapper mockObjectMapper = PowerMockito.mock(ObjectMapper.class);
		PowerMockito.whenNew(ObjectMapper.class).withNoArguments().thenReturn(mockObjectMapper);
		
		Mockito.when(mockObjectMapper.readValue(Mockito.anyString(), Mockito.isA(Class.class))).thenThrow(new IOException());
		Object responseObject = JsonUtils.convertJsonToObject(jsonString, responseClass);
		assertNull(responseObject);
		
		PowerMockito.verifyNew(ObjectMapper.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockObjectMapper, Mockito.times(1)).readValue(Mockito.anyString(), Mockito.isA(Class.class));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testConvertJsonToObject_Success() throws Exception {
		String jsonString = "{}";
		Class<?> responseClass = BaseResponseVO.class;
		
		ObjectMapper mockObjectMapper = PowerMockito.mock(ObjectMapper.class);
		PowerMockito.whenNew(ObjectMapper.class).withNoArguments().thenReturn(mockObjectMapper);
		
		Mockito.when(mockObjectMapper.readValue(Mockito.anyString(), Mockito.isA(Class.class))).thenReturn(new BaseResponseVO());
		Object responseObject = JsonUtils.convertJsonToObject(jsonString, responseClass);
		assertNotNull(responseObject);
		
		PowerMockito.verifyNew(ObjectMapper.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockObjectMapper, Mockito.times(1)).readValue(Mockito.anyString(), Mockito.isA(Class.class));
	}
	
	@Test
	public void testConvertObjectToJson_JsonObjectIsNull() {
		Object jsonObject = null;
		String jsonResponse = JsonUtils.convertObjectToJson(jsonObject);
		assertNull(jsonResponse);
	}
	
	@Test
	public void testConvertObjectToJson_JsonProcessingException() throws Exception {
		Object jsonObject = new BaseResponseVO();
		
		JsonProcessingException mockJsonProcessingException = PowerMockito.mock(JsonProcessingException.class);
		ObjectMapper mockObjectMapper = PowerMockito.mock(ObjectMapper.class);
		PowerMockito.whenNew(ObjectMapper.class).withNoArguments().thenReturn(mockObjectMapper);
		
		Mockito.when(mockObjectMapper.writeValueAsString(Mockito.any())).thenThrow(mockJsonProcessingException);
		
		String jsonResponse = JsonUtils.convertObjectToJson(jsonObject);
		assertNull(jsonResponse);
		
		PowerMockito.verifyNew(ObjectMapper.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockObjectMapper, Mockito.times(1)).writeValueAsString(Mockito.any());
	}
	@Test
	public void testConvertObjectToJson_SuccessButJsonIsEmpty() throws Exception {
		String jsonStrResponse = "";
		Object jsonObject = new BaseResponseVO();
		
		ObjectMapper mockObjectMapper = PowerMockito.mock(ObjectMapper.class);
		PowerMockito.whenNew(ObjectMapper.class).withNoArguments().thenReturn(mockObjectMapper);
		
		Mockito.when(mockObjectMapper.writeValueAsString(Mockito.any())).thenReturn(jsonStrResponse);
		
		String jsonResponse = JsonUtils.convertObjectToJson(jsonObject);
		assertNotNull(jsonResponse);
		assertTrue(jsonResponse.length() == 0);
		
		PowerMockito.verifyNew(ObjectMapper.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockObjectMapper, Mockito.times(1)).writeValueAsString(Mockito.any());
	}
	@Test
	public void testConvertObjectToJson_Success() throws Exception {
		String jsonStrResponse = "{}";
		Object jsonObject = new BaseResponseVO();
		
		ObjectMapper mockObjectMapper = PowerMockito.mock(ObjectMapper.class);
		PowerMockito.whenNew(ObjectMapper.class).withNoArguments().thenReturn(mockObjectMapper);
		
		Mockito.when(mockObjectMapper.writeValueAsString(Mockito.any())).thenReturn(jsonStrResponse);
		
		String jsonResponse = JsonUtils.convertObjectToJson(jsonObject);
		assertNotNull(jsonResponse);
		assertTrue(jsonResponse.length() > 0);
		
		PowerMockito.verifyNew(ObjectMapper.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockObjectMapper, Mockito.times(1)).writeValueAsString(Mockito.any());
	}
}
