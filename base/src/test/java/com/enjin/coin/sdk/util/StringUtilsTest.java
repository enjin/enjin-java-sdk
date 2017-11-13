package com.enjin.coin.sdk.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.assertj.core.api.Assertions.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StringUtils.class)
public class StringUtilsTest {

    @Test
    public void testConstructor() {
        StringUtils stringUtils = new StringUtils();
        assertThat(stringUtils).isNotNull();
    }

    @Test
    public void testExceptionToString_ExceptionIsNull() {
        Exception e = null;
        String stacktrace = StringUtils.exceptionToString(e);
        assertThat(stacktrace).isNull();
    }

    @Test
    public void testExceptionToString_IOExceptionCreatingPrintWriter() throws Exception {
        StringWriter mockStringWriter = PowerMockito.mock(StringWriter.class);

        PowerMockito.whenNew(StringWriter.class).withNoArguments().thenReturn(mockStringWriter);
        PowerMockito.whenNew(PrintWriter.class).withParameterTypes(OutputStream.class).withArguments(Mockito.isA(StringWriter.class)).thenThrow(new IOException());

        Exception e = new NullPointerException();
        String stacktrace = StringUtils.exceptionToString(e);
        assertThat(stacktrace).isNull();

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
        assertThat(stacktrace).isNotNull();

        PowerMockito.verifyNew(StringWriter.class, Mockito.times(1)).withNoArguments();
        PowerMockito.verifyNew(PrintWriter.class, Mockito.times(1)).withArguments(Mockito.isA(StringWriter.class));
    }

    @Test
    public void testIsEmpty_String_False() {
        String str = "str";
        assertThat(StringUtils.isEmpty(str)).isFalse();
    }

    @Test
    public void testIsEmpty_String_TrueNull() {
        String str = null;
        assertThat(StringUtils.isEmpty(str)).isTrue();
    }

    @Test
    public void testIsEmpty_String_TrueEmpty() {
        String str = "";
        assertThat(StringUtils.isEmpty(str)).isTrue();
    }

    @Test
    public void testIsNotEmpty_String_FalseEmpty() {
        String str = "";
        assertThat(StringUtils.isNotEmpty(str)).isFalse();
    }

    @Test
    public void testIsNotEmpty_String_FalseNull() {
        String str = null;
        assertThat(StringUtils.isNotEmpty(str)).isFalse();
    }

    @Test
    public void testIsNotEmpty_String_True() {
        String str = "str";
        assertThat(StringUtils.isNotEmpty(str)).isTrue();
    }

}
