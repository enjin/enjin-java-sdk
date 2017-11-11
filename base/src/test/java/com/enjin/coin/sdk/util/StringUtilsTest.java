package com.enjin.coin.sdk.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StringUtils.class)
public class StringUtilsTest {


    @Test
    public void testConstructor() {
        StringUtils stringUtils = new StringUtils();
        assertNotNull(stringUtils);
    }

    @Test
    public void testExceptionToString_ExceptionIsNull() {
        Exception e = null;
        String stacktrace = StringUtils.exceptionToString(e);
        assertNull(stacktrace);
    }
    @Test
    public void testExceptionToString_IOExceptionCreatingPrintWriter() throws Exception {
    	StringWriter mockStringWriter = PowerMockito.mock(StringWriter.class);

    	PowerMockito.whenNew(StringWriter.class).withNoArguments().thenReturn(mockStringWriter);
    	PowerMockito.whenNew(PrintWriter.class).withParameterTypes(OutputStream.class).withArguments(Mockito.isA(StringWriter.class)).thenThrow(new IOException());
    	
        Exception e = new NullPointerException();
        String stacktrace = StringUtils.exceptionToString(e);
        assertNull(stacktrace);
        
        PowerMockito.verifyNew(StringWriter.class, Mockito.times(1)).withNoArguments();
        PowerMockito.verifyNew(PrintWriter.class, Mockito.times(1)).withArguments(Mockito.isA(StringWriter.class));
    }
    @Test
    public void testExceptionToString_Success() throws Exception {
    	StringWriter mockStringWriter = PowerMockito.mock(StringWriter.class);
    	PrintWriter mockPrintWriter = PowerMockito.mock(PrintWriter.class);
    	
    	PowerMockito.whenNew(StringWriter.class).withNoArguments().thenReturn(mockStringWriter);
    	PowerMockito.whenNew(PrintWriter.class).withParameterTypes(OutputStream.class).withArguments(Mockito.isA(StringWriter.class)).thenReturn(mockPrintWriter);
    	
        Exception e = new NullPointerException();
        String stacktrace = StringUtils.exceptionToString(e);
        assertNotNull(stacktrace);
        
        PowerMockito.verifyNew(StringWriter.class, Mockito.times(1)).withNoArguments();
        PowerMockito.verifyNew(PrintWriter.class, Mockito.times(1)).withArguments(Mockito.isA(StringWriter.class));
    }


}
