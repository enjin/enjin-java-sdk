package com.enjin.coin.sdk.config;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.enjin.coin.sdk.util.JsonUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@RunWith(PowerMockRunner.class)
@PrepareForTest({JsonConfig.class, Class.class, File.class, FileWriter.class , Gson.class, JsonUtils.class, JsonElement.class, JsonObject.class})
public class JsonConfigTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testLoad_FileDoesntExistSuccess() throws Exception {
        Class configClass = JsonConfig.class;

		File mockFile = PowerMockito.mock(File.class);
		FileWriter mockFileWriter = PowerMockito.mock(FileWriter.class);
		FileWriter spyFileWriter = Mockito.spy(mockFileWriter);
		
		Mockito.when(mockFile.exists()).thenReturn(false);
		PowerMockito.whenNew(FileWriter.class).withParameterTypes(File.class).withArguments(mockFile).thenReturn(mockFileWriter);
		Mockito.when(mockFile.getParentFile()).thenReturn(null);
		Mockito.when(mockFile.exists()).thenReturn(false);
		Mockito.when(mockFile.createNewFile()).thenReturn(true);
		Mockito.doNothing().when(spyFileWriter).write(Mockito.anyString());
		Mockito.doNothing().when(spyFileWriter).close();

		JsonConfig response = JsonConfig.load(mockFile, configClass);
		assertThat(response).isNotNull();
	
		Mockito.verify(mockFile, Mockito.times(2)).exists();
	    PowerMockito.verifyNew(FileWriter.class, Mockito.times(1)).withArguments(Mockito.isA(File.class));
		Mockito.verify(mockFile, Mockito.times(1)).getParentFile();
		Mockito.verify(mockFile, Mockito.times(1)).createNewFile();
	    Mockito.verify(mockFileWriter, Mockito.times(1)).write(Mockito.anyString());
	    Mockito.verify(mockFileWriter, Mockito.times(2)).close();
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testLoad_FilesExistsSecondTimeAroundSuccess() throws Exception {
        Class configClass = JsonConfig.class;

		File mockFile = PowerMockito.mock(File.class);
		FileWriter mockFileWriter = PowerMockito.mock(FileWriter.class);
		FileWriter spyFileWriter = Mockito.spy(mockFileWriter);
		
		Mockito.when(mockFile.exists()).thenReturn(false);
		PowerMockito.whenNew(FileWriter.class).withParameterTypes(File.class).withArguments(mockFile).thenReturn(mockFileWriter);
		Mockito.when(mockFile.getParentFile()).thenReturn(null);
		Mockito.when(mockFile.exists()).thenReturn(true);
		Mockito.doNothing().when(spyFileWriter).write(Mockito.anyString());
		Mockito.doNothing().when(spyFileWriter).close();

		JsonConfig response = JsonConfig.load(mockFile, configClass);
		assertThat(response).isNotNull();
	
		Mockito.verify(mockFile, Mockito.times(2)).exists();
	    PowerMockito.verifyNew(FileWriter.class, Mockito.times(1)).withArguments(Mockito.isA(File.class));
		Mockito.verify(mockFile, Mockito.times(1)).getParentFile();
	    Mockito.verify(mockFileWriter, Mockito.times(1)).write(Mockito.anyString());
	    Mockito.verify(mockFileWriter, Mockito.times(2)).close();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testLoad_IOExceptionPerformingWrite() throws Exception {
        Class configClass = JsonConfig.class;

		File mockFile = PowerMockito.mock(File.class);
		FileWriter mockFileWriter = PowerMockito.mock(FileWriter.class);

		Mockito.when(mockFile.exists()).thenReturn(false);
		PowerMockito.whenNew(FileWriter.class).withParameterTypes(File.class).withArguments(mockFile).thenReturn(mockFileWriter);
		Mockito.when(mockFile.getParentFile()).thenReturn(null);
		Mockito.when(mockFile.exists()).thenReturn(true);
		Mockito.doThrow(new IOException("exception")).when(mockFileWriter).write(Mockito.anyString());

		JsonConfig response = JsonConfig.load(mockFile, configClass);
		assertThat(response).isNotNull();
	
		Mockito.verify(mockFile, Mockito.times(2)).exists();
	    PowerMockito.verifyNew(FileWriter.class, Mockito.times(1)).withArguments(Mockito.isA(File.class));
		Mockito.verify(mockFile, Mockito.times(1)).getParentFile();
	    Mockito.verify(mockFileWriter, Mockito.times(1)).write(Mockito.anyString());
	    Mockito.verify(mockFileWriter, Mockito.times(1)).close();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testLoad_FileExistsLengthIs0Success() throws Exception {
        Class configClass = JsonConfig.class;

		File mockFile = PowerMockito.mock(File.class);
		FileWriter mockFileWriter = PowerMockito.mock(FileWriter.class);
		FileWriter spyFileWriter = Mockito.spy(mockFileWriter);
		
		Mockito.when(mockFile.exists()).thenReturn(true);
		Mockito.when(mockFile.length()).thenReturn(0l);
		PowerMockito.whenNew(FileWriter.class).withParameterTypes(File.class).withArguments(mockFile).thenReturn(mockFileWriter);
		Mockito.when(mockFile.getParentFile()).thenReturn(null);
		Mockito.when(mockFile.exists()).thenReturn(true);
		Mockito.when(mockFile.exists()).thenReturn(true);
		Mockito.when(mockFile.exists()).thenReturn(true);
		Mockito.doNothing().when(spyFileWriter).write(Mockito.anyString());
		Mockito.doNothing().when(spyFileWriter).close();

		JsonConfig response = JsonConfig.load(mockFile, configClass);
		assertThat(response).isNotNull();
	
		Mockito.verify(mockFile, Mockito.times(2)).exists();
		Mockito.verify(mockFile, Mockito.times(1)).length();
	    PowerMockito.verifyNew(FileWriter.class, Mockito.times(1)).withArguments(Mockito.isA(File.class));
		Mockito.verify(mockFile, Mockito.times(1)).getParentFile();
	    Mockito.verify(mockFileWriter, Mockito.times(1)).write(Mockito.anyString());
	    Mockito.verify(mockFileWriter, Mockito.times(2)).close();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testLoad_ParentFileExists() throws Exception {
        Class configClass = JsonConfig.class;

		File mockFile = PowerMockito.mock(File.class);
		FileWriter mockFileWriter = PowerMockito.mock(FileWriter.class);
		FileWriter spyFileWriter = Mockito.spy(mockFileWriter);
		
		Mockito.when(mockFile.exists()).thenReturn(true);
		Mockito.when(mockFile.length()).thenReturn(0l);
		PowerMockito.whenNew(FileWriter.class).withParameterTypes(File.class).withArguments(mockFile).thenReturn(mockFileWriter);
		Mockito.when(mockFile.getParentFile()).thenReturn(mockFile);
		Mockito.when(mockFile.mkdir()).thenReturn(true);
		Mockito.when(mockFile.exists()).thenReturn(true);
		Mockito.when(mockFile.exists()).thenReturn(true);
		Mockito.when(mockFile.exists()).thenReturn(true);
		Mockito.doNothing().when(spyFileWriter).write(Mockito.anyString());
		Mockito.doNothing().when(spyFileWriter).close();

		JsonConfig response = JsonConfig.load(mockFile, configClass);
		assertThat(response).isNotNull();
	
		Mockito.verify(mockFile, Mockito.times(2)).exists();
		Mockito.verify(mockFile, Mockito.times(1)).length();
	    PowerMockito.verifyNew(FileWriter.class, Mockito.times(1)).withArguments(Mockito.isA(File.class));
		Mockito.verify(mockFile, Mockito.times(2)).getParentFile();
	    Mockito.verify(mockFileWriter, Mockito.times(1)).write(Mockito.anyString());
	    Mockito.verify(mockFileWriter, Mockito.times(2)).close();
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testLoad_FileLengthis0FilesExistsSecondTimeAroundSuccess() throws Exception {
        Class configClass = JsonConfig.class;

		File mockFile = PowerMockito.mock(File.class);
		FileWriter mockFileWriter = PowerMockito.mock(FileWriter.class);
		FileWriter spyFileWriter = Mockito.spy(mockFileWriter);

		Mockito.when(mockFile.exists()).thenReturn(true);
		Mockito.when(mockFile.length()).thenReturn(0l);
		PowerMockito.whenNew(FileWriter.class).withParameterTypes(File.class).withArguments(mockFile).thenReturn(mockFileWriter);
		Mockito.when(mockFile.getParentFile()).thenReturn(null);
		Mockito.when(mockFile.exists()).thenReturn(true);
		Mockito.doNothing().when(spyFileWriter).write(Mockito.anyString());
		Mockito.doNothing().when(spyFileWriter).close();

		JsonConfig response = JsonConfig.load(mockFile, configClass);
		assertThat(response).isNotNull();
	
		Mockito.verify(mockFile, Mockito.times(2)).exists();
		Mockito.verify(mockFile, Mockito.times(1)).length();
	    PowerMockito.verifyNew(FileWriter.class, Mockito.times(1)).withArguments(Mockito.isA(File.class));
		Mockito.verify(mockFile, Mockito.times(1)).getParentFile();
	    Mockito.verify(mockFileWriter, Mockito.times(1)).write(Mockito.anyString());
	    Mockito.verify(mockFileWriter, Mockito.times(2)).close();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testLoad_FileLengthis0IOExceptionPerformingWrite() throws Exception {
        Class configClass = JsonConfig.class;

		File mockFile = PowerMockito.mock(File.class);
		FileWriter mockFileWriter = PowerMockito.mock(FileWriter.class);
		FileWriter spyFileWriter = Mockito.spy(mockFileWriter);
		
		Mockito.when(mockFile.exists()).thenReturn(true);
		Mockito.when(mockFile.length()).thenReturn(0l);
		PowerMockito.whenNew(FileWriter.class).withParameterTypes(File.class).withArguments(mockFile).thenReturn(mockFileWriter);
		Mockito.when(mockFile.getParentFile()).thenReturn(null);
		Mockito.when(mockFile.exists()).thenReturn(true);
		Mockito.doThrow(new IOException("exception")).when(spyFileWriter).write(Mockito.anyString());
		Mockito.doNothing().when(spyFileWriter).close();

		JsonConfig response = JsonConfig.load(mockFile, configClass);
		assertThat(response).isNotNull();
	
		Mockito.verify(mockFile, Mockito.times(2)).exists();
		Mockito.verify(mockFile, Mockito.times(1)).length();
	    PowerMockito.verifyNew(FileWriter.class, Mockito.times(1)).withArguments(Mockito.isA(File.class));
		Mockito.verify(mockFile, Mockito.times(1)).getParentFile();
	    Mockito.verify(mockFileWriter, Mockito.times(1)).write(Mockito.anyString());
	    Mockito.verify(mockFileWriter, Mockito.times(2)).close();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testLoad_LoadExistingSuccess() throws Exception {
        Class configClass = JsonConfig.class;
        JsonConfig jsonConfig = new JsonConfig();
        
        PowerMockito.mockStatic(JsonUtils.class);

		File mockFile = PowerMockito.mock(File.class);
		FileReader mockFileReader = PowerMockito.mock(FileReader.class);

		Mockito.when(mockFile.exists()).thenReturn(true);
		Mockito.when(mockFile.length()).thenReturn(1l);
		PowerMockito.whenNew(FileReader.class).withParameterTypes(File.class).withArguments(mockFile).thenReturn(mockFileReader);
		PowerMockito.when(JsonUtils.convertJsonFromFileReaderToObject(Mockito.isA(Gson.class), Mockito.isA(FileReader.class), Mockito.isA(Class.class))).thenReturn(jsonConfig);

		JsonConfig response = JsonConfig.load(mockFile, configClass);
		assertThat(response).isNotNull();
	
		Mockito.verify(mockFile, Mockito.times(1)).exists();
		Mockito.verify(mockFile, Mockito.times(1)).length();
	    PowerMockito.verifyNew(FileReader.class, Mockito.times(1)).withArguments(Mockito.isA(File.class));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testLoad_FailedToLoadExistingSuccess() throws Exception {
        Class configClass = JsonConfig.class;
        JsonConfig jsonConfig = null;
        
        PowerMockito.mockStatic(JsonUtils.class);

		File mockFile = PowerMockito.mock(File.class);
		FileReader mockFileReader = PowerMockito.mock(FileReader.class);

		Mockito.when(mockFile.exists()).thenReturn(true);
		Mockito.when(mockFile.length()).thenReturn(1l);
		PowerMockito.whenNew(FileReader.class).withParameterTypes(File.class).withArguments(mockFile).thenReturn(mockFileReader);
		PowerMockito.when(JsonUtils.convertJsonFromFileReaderToObject(Mockito.isA(Gson.class), Mockito.isA(FileReader.class), Mockito.isA(Class.class))).thenReturn(jsonConfig);
		
		try {
			JsonConfig response = JsonConfig.load(mockFile, configClass);
			assertThat(response).isNull();
		} catch (Exception e) {
			assertThat(e).isNotNull();
		}
		Mockito.verify(mockFile, Mockito.times(1)).exists();
		Mockito.verify(mockFile, Mockito.times(1)).length();
	    PowerMockito.verifyNew(FileReader.class, Mockito.times(1)).withArguments(Mockito.isA(File.class));
	}

	@Test
	public void testUpdate_NotJsonObjects() {
		Object data = new Object();
		File mockFile = PowerMockito.mock(File.class);
		JsonElement mockJsonElement = PowerMockito.mock(JsonElement.class);
		
        PowerMockito.mockStatic(JsonUtils.class);
		PowerMockito.when(JsonUtils.convertObjectToJsonTree(Mockito.isA(Gson.class), Mockito.any())).thenReturn(mockJsonElement);
		Mockito.when(mockJsonElement.isJsonObject()).thenReturn(false);
		Mockito.when(mockJsonElement.isJsonObject()).thenReturn(false);
		
		JsonConfig jsonConfig = new JsonConfig();
		boolean result = jsonConfig.update(mockFile, data);
		assertThat(result).isFalse();

	    Mockito.verify(mockJsonElement, Mockito.times(2)).isJsonObject();
	}
	
	@Test
	public void testUpdate_IOExceptionCreatingFileWriter() throws Exception {
		Object data = new Object();
		File mockFile = PowerMockito.mock(File.class);
		JsonElement mockJsonElement = PowerMockito.mock(JsonElement.class);
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("keyInt", 2);
        jsonObject.addProperty("keyString", "val1");
        jsonObject.addProperty("id", "0123456");

        PowerMockito.mockStatic(JsonUtils.class);
		PowerMockito.when(JsonUtils.convertObjectToJsonTree(Mockito.isA(Gson.class), Mockito.any())).thenReturn(mockJsonElement);
		Mockito.when(mockJsonElement.isJsonObject()).thenReturn(true);
		Mockito.when(mockJsonElement.isJsonObject()).thenReturn(true);
		Mockito.when(mockJsonElement.getAsJsonObject()).thenReturn(jsonObject);
		Mockito.when(mockJsonElement.getAsJsonObject()).thenReturn(jsonObject);
		PowerMockito.whenNew(FileWriter.class).withParameterTypes(File.class).withArguments(mockFile).thenThrow(new IOException());
		
		JsonConfig jsonConfig = new JsonConfig();
		boolean result = jsonConfig.update(mockFile, data);
		assertThat(result).isFalse();

	    Mockito.verify(mockJsonElement, Mockito.times(1)).isJsonObject();
	    Mockito.verify(mockJsonElement, Mockito.times(2)).getAsJsonObject();
	    PowerMockito.verifyNew(FileWriter.class, Mockito.times(1)).withArguments(Mockito.isA(File.class));
	}
	
	@Test
	public void testUpdate_Success() throws Exception {
		Object data = new Object();
		File mockFile = PowerMockito.mock(File.class);
		JsonElement mockJsonElement = PowerMockito.mock(JsonElement.class);
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("keyInt", 2);
        jsonObject.addProperty("keyString", "val1");
        jsonObject.addProperty("id", "0123456");
		
        FileWriter mockFileWriter = PowerMockito.mock(FileWriter.class);
    	FileWriter spyFileWriter = Mockito.spy(mockFileWriter);
    	
        PowerMockito.mockStatic(JsonUtils.class);
		PowerMockito.when(JsonUtils.convertObjectToJsonTree(Mockito.isA(Gson.class), Mockito.any())).thenReturn(mockJsonElement);
		Mockito.when(mockJsonElement.isJsonObject()).thenReturn(true);
		Mockito.when(mockJsonElement.isJsonObject()).thenReturn(true);
		Mockito.when(mockJsonElement.getAsJsonObject()).thenReturn(jsonObject);
		Mockito.when(mockJsonElement.getAsJsonObject()).thenReturn(jsonObject);
		PowerMockito.whenNew(FileWriter.class).withParameterTypes(File.class).withArguments(mockFile).thenReturn(mockFileWriter);
		PowerMockito.when(JsonUtils.convertObjectToJson(Mockito.isA(Gson.class), Mockito.any())).thenReturn("{}");
		Mockito.doNothing().when(spyFileWriter).write(Mockito.anyString());
		Mockito.doNothing().when(spyFileWriter).close();
		
		JsonConfig jsonConfig = new JsonConfig();
		boolean result = jsonConfig.update(mockFile, data);
		assertThat(result).isTrue();

	    Mockito.verify(mockJsonElement, Mockito.times(1)).isJsonObject();
	    Mockito.verify(mockJsonElement, Mockito.times(2)).getAsJsonObject();
	    PowerMockito.verifyNew(FileWriter.class, Mockito.times(1)).withArguments(Mockito.isA(File.class));
	}
	
	@Test
	public void testUpdate_SuccessOldAndNewDontHaveSameKeys() throws Exception {
		Object data = new Object();
		File mockFile = PowerMockito.mock(File.class);
		JsonObject oldJsonObject = new JsonObject();
        oldJsonObject.addProperty("id", "1");
		
		JsonObject updatedJsonObject = new JsonObject();
		updatedJsonObject.addProperty("2id", "id2");

        FileWriter mockFileWriter = PowerMockito.mock(FileWriter.class);
    	FileWriter spyFileWriter = Mockito.spy(mockFileWriter);
    	
        PowerMockito.mockStatic(JsonUtils.class);
		PowerMockito.when(JsonUtils.convertObjectToJsonTree(Mockito.isA(Gson.class), Mockito.any())).thenReturn(oldJsonObject, updatedJsonObject);
		PowerMockito.whenNew(FileWriter.class).withParameterTypes(File.class).withArguments(mockFile).thenReturn(mockFileWriter);
		PowerMockito.when(JsonUtils.convertObjectToJson(Mockito.isA(Gson.class), Mockito.any())).thenReturn("{}");
		Mockito.doNothing().when(spyFileWriter).write(Mockito.anyString());
		Mockito.doNothing().when(spyFileWriter).close();
		
		JsonConfig jsonConfig = new JsonConfig();
		boolean result = jsonConfig.update(mockFile, data);
		assertThat(result).isTrue();

	    PowerMockito.verifyNew(FileWriter.class, Mockito.times(1)).withArguments(Mockito.isA(File.class));
	}
	
	@Test
	public void testUpdate_SuccessOldAndNewHaveSameKeys() throws Exception {
		Object data = new Object();
		File mockFile = PowerMockito.mock(File.class);
		JsonObject oldJsonObject = new JsonObject();
        oldJsonObject.addProperty("id", "1");

        FileWriter mockFileWriter = PowerMockito.mock(FileWriter.class);
    	FileWriter spyFileWriter = Mockito.spy(mockFileWriter);
    	
        PowerMockito.mockStatic(JsonUtils.class);
		PowerMockito.when(JsonUtils.convertObjectToJsonTree(Mockito.isA(Gson.class), Mockito.any())).thenReturn(oldJsonObject, oldJsonObject);
		PowerMockito.whenNew(FileWriter.class).withParameterTypes(File.class).withArguments(mockFile).thenReturn(mockFileWriter);
		PowerMockito.when(JsonUtils.convertObjectToJson(Mockito.isA(Gson.class), Mockito.any())).thenReturn("{}");
		Mockito.doNothing().when(spyFileWriter).write(Mockito.anyString());
		Mockito.doNothing().when(spyFileWriter).close();
		
		JsonConfig jsonConfig = new JsonConfig();
		boolean result = jsonConfig.update(mockFile, data);
		assertThat(result).isTrue();

	    PowerMockito.verifyNew(FileWriter.class, Mockito.times(1)).withArguments(Mockito.isA(File.class));
	}
	
	@Test
	public void testUpdate_SuccessOldAndNewHaveSameKeysAndOneIsJsonObject() throws Exception {
		Object data = new Object();
		File mockFile = PowerMockito.mock(File.class);
		JsonObject oldJsonObject = new JsonObject();
        oldJsonObject.add("id", new JsonObject());

        FileWriter mockFileWriter = PowerMockito.mock(FileWriter.class);
    	FileWriter spyFileWriter = Mockito.spy(mockFileWriter);
    	
        PowerMockito.mockStatic(JsonUtils.class);
		PowerMockito.when(JsonUtils.convertObjectToJsonTree(Mockito.isA(Gson.class), Mockito.any())).thenReturn(oldJsonObject, oldJsonObject);
		PowerMockito.whenNew(FileWriter.class).withParameterTypes(File.class).withArguments(mockFile).thenReturn(mockFileWriter);
		PowerMockito.when(JsonUtils.convertObjectToJson(Mockito.isA(Gson.class), Mockito.any())).thenReturn("{}");
		Mockito.doNothing().when(spyFileWriter).write(Mockito.anyString());
		Mockito.doNothing().when(spyFileWriter).close();
		
		JsonConfig jsonConfig = new JsonConfig();
		boolean result = jsonConfig.update(mockFile, data);
		assertThat(result).isTrue();

	    PowerMockito.verifyNew(FileWriter.class, Mockito.times(1)).withArguments(Mockito.isA(File.class));
	    Mockito.verify(mockFileWriter, Mockito.times(1)).write(Mockito.anyString());
	    Mockito.verify(mockFileWriter, Mockito.times(2)).close();
	}
}

