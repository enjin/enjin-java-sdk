package com.enjin.coin.sdk.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({FileUtils.class, Path.class, Files.class})
public class FileUtilsTest {

    @Test
    public void testConstructor() {
        FileUtils fileUtils = new FileUtils();
        assertNotNull(fileUtils);
    }

    @Test
    public void testGetFileContents_FilePathIsEmpty() throws Exception {
        String filePath = "";

        String fileContents = FileUtils.getFileContents(filePath);
        assertNull(fileContents);
    }

    @Test
    public void testGetFileContents_FilePathIsNull() throws Exception {
        String filePath = null;

        String fileContents = FileUtils.getFileContents(filePath);
        assertNull(fileContents);
    }

    @Test
    public void testGetFileContents_IOException() throws Exception {
        String filePath = "c:\\temp\\file.txt";

        Path mockPath = PowerMockito.mock(Path.class);
        PowerMockito.mockStatic(Paths.class);
        PowerMockito.mockStatic(Files.class);

        Mockito.when(Paths.get(Mockito.anyString())).thenReturn(mockPath);
        Mockito.when(Files.readAllBytes(Mockito.isA(Path.class))).thenThrow(new IOException());

        String fileContents = FileUtils.getFileContents(filePath);
        assertNull(fileContents);

        PowerMockito.verifyStatic(Paths.class);
        Paths.get(Mockito.anyString());
        PowerMockito.verifyStatic(Files.class);
        Files.readAllBytes(Mockito.isA(Path.class));
    }

    @Test
    public void testGetFileContents_BytesIsEmpty() throws Exception {
        String filePath = "c:\\temp\\file.txt";

        Path mockPath = PowerMockito.mock(Path.class);
        PowerMockito.mockStatic(Paths.class);
        PowerMockito.mockStatic(Files.class);

        Mockito.when(Paths.get(Mockito.anyString())).thenReturn(mockPath);
        Mockito.when(Files.readAllBytes(Mockito.isA(Path.class))).thenReturn("".getBytes());

        String fileContents = FileUtils.getFileContents(filePath);
        assertNull(fileContents);

        PowerMockito.verifyStatic(Paths.class);
        Paths.get(Mockito.anyString());
        PowerMockito.verifyStatic(Files.class);
        Files.readAllBytes(Mockito.isA(Path.class));
    }

    @Test
    public void testGetFileContents_BytesIsNull() throws Exception {
        String filePath = "c:\\temp\\file.txt";

        Path mockPath = PowerMockito.mock(Path.class);
        PowerMockito.mockStatic(Paths.class);
        PowerMockito.mockStatic(Files.class);

        Mockito.when(Paths.get(Mockito.anyString())).thenReturn(mockPath);
        Mockito.when(Files.readAllBytes(Mockito.isA(Path.class))).thenReturn(null);

        String fileContents = FileUtils.getFileContents(filePath);
        assertNull(fileContents);

        PowerMockito.verifyStatic(Paths.class);
        Paths.get(Mockito.anyString());
        PowerMockito.verifyStatic(Files.class);
        Files.readAllBytes(Mockito.isA(Path.class));
    }

    @Test
    public void testGetFileContents_Success() throws Exception {
        String filePath = "c:\\temp\\file.txt";

        Path mockPath = PowerMockito.mock(Path.class);
        PowerMockito.mockStatic(Paths.class);
        PowerMockito.mockStatic(Files.class);

        Mockito.when(Paths.get(Mockito.anyString())).thenReturn(mockPath);
        Mockito.when(Files.readAllBytes(Mockito.isA(Path.class))).thenReturn("hello".getBytes());

        String fileContents = FileUtils.getFileContents(filePath);
        assertNotNull(fileContents);
        assertTrue(fileContents.length() > 0);

        PowerMockito.verifyStatic(Paths.class);
        Paths.get(Mockito.anyString());
        PowerMockito.verifyStatic(Files.class);
        Files.readAllBytes(Mockito.isA(Path.class));
    }

}
