package com.enjin.sdk.serialization.converter;

import com.enjin.sdk.serialization.Json;
import com.enjin.sdk.serialization.converter.JsonStringConverter.DelegateToStringConverter;
import lombok.SneakyThrows;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

class JsonStringConverterTest {

    private static final MockWebServer MOCK_WEB_SERVER = new MockWebServer();

    @BeforeAll
    @SneakyThrows
    public static void BeforeAll() {
        MOCK_WEB_SERVER.start();
    }

    @AfterAll
    @SneakyThrows
    public static void AfterAll() {
        MOCK_WEB_SERVER.shutdown();
    }

    @Test
    void create_ReturnsJsonStringConverter() {
        // Arrange
        final Converter.Factory dummyFactory = mock(Converter.Factory.class);

        // Act
        JsonStringConverter actual = JsonStringConverter.create(dummyFactory);

        // Assert
        assertNotNull(actual);
    }

    @Test
    void stringConverter_AnnotationsDoesNotContainJsonAnnotation_ReturnsNull() {
        // Arrange
        final Converter.Factory dummyFactory = mock(Converter.Factory.class);
        final Type dummyType = mock(Type.class);
        final Retrofit dummyRetrofit = createDummyRetrofit();
        final Annotation[] fakeAnnotations = new Annotation[0];
        final JsonStringConverter converter = new JsonStringConverter(dummyFactory);

        // Act
        DelegateToStringConverter actual = (DelegateToStringConverter) converter.stringConverter(dummyType,
                                                                                                 fakeAnnotations,
                                                                                                 dummyRetrofit);

        // Assert
        assertNull(actual);
    }

    @Test
    void stringConverter_AnnotationsContainsJsonAnnotation_ReturnsDelegateToStringConverter() {
        // Arrange - Data
        final Type dummyType = mock(Type.class);
        final Retrofit dummyRetrofit = createDummyRetrofit();
        final Converter dummyRequestBodyConverter = mock(Converter.class);
        final Annotation[] fakeAnnotations = new Annotation[] {mock(Json.class)};
        final Converter.Factory mockFactory = mock(Converter.Factory.class);
        final JsonStringConverter converter = new JsonStringConverter(mockFactory);

        // Arrange - Stubbing
        when(mockFactory.requestBodyConverter(any(), any(), any(), any())).thenReturn(dummyRequestBodyConverter);

        // Act
        DelegateToStringConverter actual = (DelegateToStringConverter) converter.stringConverter(dummyType,
                                                                                                 fakeAnnotations,
                                                                                                 dummyRetrofit);

        // Assert
        assertNotNull(actual);
    }

    private static Retrofit createDummyRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(MOCK_WEB_SERVER.url("/"))
                .build();
    }

}