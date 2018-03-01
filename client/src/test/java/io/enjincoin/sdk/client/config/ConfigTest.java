package io.enjincoin.sdk.client.config;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.FileWriter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import io.enjincoin.sdk.client.util.Constants;
import io.enjincoin.sdk.client.util.JsonUtils;

@RunWith(PowerMockRunner.class)
@PrepareForTest({JsonConfig.class, Class.class, File.class, FileWriter.class,
        Gson.class, Config.class, JsonUtils.class, JsonElement.class, JsonObject.class})
public class ConfigTest {

    @Test
    public void testLoad_FilesExistsSecondTimeAroundSuccess() throws Exception {
        File mockFile = PowerMockito.mock(File.class);
        FileWriter mockFileWriter = PowerMockito.mock(FileWriter.class);
        FileWriter spyFileWriter = Mockito.spy(mockFileWriter);

        Mockito.when(mockFile.exists()).thenReturn(false);
        PowerMockito.whenNew(FileWriter.class).withParameterTypes(File.class).withArguments(mockFile).thenReturn(mockFileWriter);
        Mockito.when(mockFile.getParentFile()).thenReturn(null);
        Mockito.when(mockFile.exists()).thenReturn(true);
        Mockito.doNothing().when(spyFileWriter).write(Mockito.anyString());
        Mockito.doNothing().when(spyFileWriter).close();

        Config response = Config.load(mockFile);
        assertThat(response).isNotNull();

        Mockito.verify(mockFile, Mockito.times(2)).exists();
        PowerMockito.verifyNew(FileWriter.class, Mockito.times(1)).withArguments(Mockito.isA(File.class));
        Mockito.verify(mockFile, Mockito.times(1)).getParentFile();
        Mockito.verify(mockFileWriter, Mockito.times(1)).write(Mockito.anyString());
        Mockito.verify(mockFileWriter, Mockito.times(2)).close();
    }

    @Test
    public void testIsInTestMode() {
        Config config = new Config();
        assertThat(config.isInTestMode()).isFalse();
    }

    @Test
    public void testGetTotalExecutors() {
        Config config = new Config();
        assertThat(config.getTotalExecutors()).isEqualTo(Constants.ONE);
    }

    @Test
    public void testGetTrustedPlatform() {
        Config config = new Config();
        assertThat(config.getTrustedPlatform()).isEqualToComparingFieldByField(ImmutablePlatform.builder().build());
    }

}
