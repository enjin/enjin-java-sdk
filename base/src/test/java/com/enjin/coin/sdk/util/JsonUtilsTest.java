package com.enjin.coin.sdk.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.enjin.coin.sdk.vo.event.GetEventResponseVO;
import com.enjin.coin.sdk.vo.event.ImmutableGetEventResponseVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

@RunWith(PowerMockRunner.class)
@PrepareForTest({JsonUtils.class, Gson.class, GsonBuilder.class})
public class JsonUtilsTest {

    @Test
    public void testConstructor() {
        JsonUtils jsonUtils = new JsonUtils();
        assertThat(jsonUtils).isNotNull();
    }

    @Test
    public void testConvertJsonToObject_JsonStringIsEmpty() {
        String jsonString = "";
        Class<?> responseClass = GetEventResponseVO.class;
        Object responseObject = JsonUtils.convertJsonToObject(jsonString, responseClass);
        assertThat(responseObject).isNull();
    }

    @Test
    public void testConvertJsonToObject_JsonStringIsNull() {
        String jsonString = null;
        Class<?> responseClass = GetEventResponseVO.class;
        Object responseObject = JsonUtils.convertJsonToObject(jsonString, responseClass);
        assertThat(responseObject).isNull();
    }

    @Test
    public void testConvertJsonToObject_ResponseObjectIsNull() {
        String jsonString = "{}";
        Class<?> responseClass = null;
        Object responseObject = JsonUtils.convertJsonToObject(jsonString, responseClass);
        assertThat(responseObject).isNull();
    }

    @Test
    public void testConvertJsonToObject_GsonIsNull() throws Exception {
        String jsonString = "{}";
        Class<?> responseClass = GetEventResponseVO.class;

        Gson mockGson = null;

        Object responseObject = JsonUtils.convertJsonToObject(mockGson, jsonString, responseClass);
        assertThat(responseObject).isNull();
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void testConvertJsonToObject_JsonSyntaxException() throws Exception {
        String jsonString = "{}";
        Class<?> responseClass = GetEventResponseVO.class;

        Gson mockGson = PowerMockito.mock(Gson.class);

        Mockito.when(mockGson.fromJson(Mockito.anyString(), Mockito.isA(Class.class))).thenThrow(new JsonSyntaxException("exception"));
        Object responseObject = JsonUtils.convertJsonToObject(mockGson, jsonString, responseClass);
        assertThat(responseObject).isNull();

        Mockito.verify(mockGson, Mockito.times(1)).fromJson(Mockito.anyString(), Mockito.isA(Class.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testConvertJsonToObject_Success() throws Exception {
        String jsonString = "{}";
        Class<?> responseClass = GetEventResponseVO.class;

        Gson mockGson = PowerMockito.mock(Gson.class);

        Mockito.when(mockGson.fromJson(Mockito.anyString(), Mockito.isA(Class.class))).thenReturn(ImmutableGetEventResponseVO.builder().build());
        Object responseObject = JsonUtils.convertJsonToObject(mockGson, jsonString, responseClass);
        assertThat(responseObject).isNotNull();

        Mockito.verify(mockGson, Mockito.times(1)).fromJson(Mockito.anyString(), Mockito.isA(Class.class));
    }

    
    @Test
    public void testConvertJsonFromFileToObject_FilePathIsEmpty() {
        String filePath = "";
        Class<?> responseClass = GetEventResponseVO.class;
        Object responseObject = JsonUtils.convertJsonFromFileToObject(filePath, responseClass);
        assertThat(responseObject).isNull();
    }

    @Test
    public void testConvertJsonFromFileToObject_FilePathIsNull() {
        String filePath = null;
        Class<?> responseClass = GetEventResponseVO.class;
        Object responseObject = JsonUtils.convertJsonFromFileToObject(filePath, responseClass);
        assertThat(responseObject).isNull();
    }

    @Test
    public void testConvertJsonFromFileToObject_ResponseObjectIsNull() {
        String filePath = "{}";
        Class<?> responseClass = null;
        Object responseObject = JsonUtils.convertJsonFromFileToObject(filePath, responseClass);
        assertThat(responseObject).isNull();
    }

    @Test
    public void testConvertJsonFromFileToObject_GsonIsNull() throws Exception {
        String filePath = "{}";
        Class<?> responseClass = GetEventResponseVO.class;

        Gson mockGson = null;

        Object responseObject = JsonUtils.convertJsonFromFileToObject(mockGson, filePath, responseClass);
        assertThat(responseObject).isNull();
    }
    
    @Test
    public void testConvertJsonFromFileToObject_FileNotFoundException() throws Exception {
        String filePath = "{}";
        Class<?> responseClass = GetEventResponseVO.class;

        Gson mockGson = PowerMockito.mock(Gson.class);

        PowerMockito.whenNew(FileReader.class).withArguments(Mockito.anyString()).thenThrow(new FileNotFoundException());
        Object responseObject = JsonUtils.convertJsonFromFileToObject(mockGson, filePath, responseClass);
        assertThat(responseObject).isNull();

        PowerMockito.verifyNew(FileReader.class, Mockito.times(1)).withArguments(Mockito.anyString());
    }

    
    @Test
    public void testConvertJsonFromFileToObject_JsonSyntaxException() throws Exception {
        String filePath = "{}";
        Class<?> responseClass = GetEventResponseVO.class;

        Gson mockGson = PowerMockito.mock(Gson.class);
        FileReader mockFileReader = Mockito.mock(FileReader.class);
        JsonReader mockJsonReader = Mockito.mock(JsonReader.class);
        
        PowerMockito.whenNew(FileReader.class).withArguments(Mockito.anyString()).thenReturn(mockFileReader);
        PowerMockito.whenNew(JsonReader.class).withArguments(Mockito.isA(FileReader.class)).thenReturn(mockJsonReader);
        Mockito.when(mockGson.fromJson(Mockito.isA(JsonReader.class), Mockito.isA(Class.class))).thenThrow(new JsonSyntaxException("exception"));
        Object responseObject = JsonUtils.convertJsonFromFileToObject(mockGson, filePath, responseClass);
        assertThat(responseObject).isNull();

        PowerMockito.verifyNew(FileReader.class, Mockito.times(1)).withArguments(Mockito.anyString());
        PowerMockito.verifyNew(JsonReader.class, Mockito.times(1)).withArguments(Mockito.isA(FileReader.class));
        Mockito.verify(mockGson, Mockito.times(1)).fromJson(Mockito.isA(JsonReader.class), Mockito.isA(Class.class));
    }

    @Test
    public void testConvertJsonFromFileToObject_Success() throws Exception {
        String filePath = "{}";
        Class<?> responseClass = GetEventResponseVO.class;

        Gson mockGson = PowerMockito.mock(Gson.class);
        FileReader mockFileReader = Mockito.mock(FileReader.class);
        JsonReader mockJsonReader = Mockito.mock(JsonReader.class);
        
        PowerMockito.whenNew(FileReader.class).withArguments(Mockito.anyString()).thenReturn(mockFileReader);
        PowerMockito.whenNew(JsonReader.class).withArguments(Mockito.isA(FileReader.class)).thenReturn(mockJsonReader);
        Mockito.when(mockGson.fromJson(Mockito.isA(JsonReader.class), Mockito.isA(Class.class))).thenReturn(ImmutableGetEventResponseVO.builder().build());
        Object responseObject = JsonUtils.convertJsonFromFileToObject(mockGson, filePath, responseClass);
        assertThat(responseObject).isNotNull();

        PowerMockito.verifyNew(FileReader.class, Mockito.times(1)).withArguments(Mockito.anyString());
        PowerMockito.verifyNew(JsonReader.class, Mockito.times(1)).withArguments(Mockito.isA(FileReader.class));
        Mockito.verify(mockGson, Mockito.times(1)).fromJson(Mockito.isA(JsonReader.class), Mockito.isA(Class.class));
    }
    
    @Test
    public void testConvertObjectToJson_JsonObjectIsNull() {
        Object jsonObject = null;
        String jsonResponse = JsonUtils.convertObjectToJson(jsonObject);
        assertThat(jsonResponse).isNull();
    }
    @Test
    public void testConvertObjectToJson_GonObjectIsNull() {
        GetEventResponseVO jsonObject = ImmutableGetEventResponseVO.builder().build();
        Gson mockGson = null;
		String jsonResponse = JsonUtils.convertObjectToJson(mockGson, jsonObject);
        assertThat(jsonResponse).isNull();
    }
    @Test
    public void testConvertObjectToJson_SuccessButJsonIsEmpty() throws Exception {
        String jsonStrResponse = "";
        GetEventResponseVO jsonObject = ImmutableGetEventResponseVO.builder().build();

        Gson mockGson = PowerMockito.mock(Gson.class);

        PowerMockito.when(mockGson.toJson(Mockito.isA(GetEventResponseVO.class))).thenReturn(jsonStrResponse);

        String jsonResponse = JsonUtils.convertObjectToJson(mockGson, jsonObject);
        assertThat(jsonResponse).isNotNull()
                .satisfies(o -> assertThat(o.length()).isEqualTo(0));

        Mockito.verify(mockGson, Mockito.times(1)).toJson(Mockito.isA(GetEventResponseVO.class));
    }

    @Test
    public void testConvertObjectToJson_Success() throws Exception {
        String jsonStrResponse = "{\"event_id\":\"1\"}";
        GetEventResponseVO jsonObject = ImmutableGetEventResponseVO.builder().build();

        Gson mockGson = PowerMockito.mock(Gson.class);

        PowerMockito.when(mockGson.toJson(Mockito.isA(GetEventResponseVO.class))).thenReturn(jsonStrResponse);

        String jsonResponse = JsonUtils.convertObjectToJson(mockGson, jsonObject);
        assertThat(jsonResponse).isNotNull()
                .satisfies(o -> assertThat(o.length()).isGreaterThan(0));

        Mockito.verify(mockGson, Mockito.times(1)).toJson(Mockito.isA(GetEventResponseVO.class));
    }

}
