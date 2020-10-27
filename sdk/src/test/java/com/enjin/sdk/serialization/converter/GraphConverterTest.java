package com.enjin.sdk.serialization.converter;

import com.enjin.sdk.graphql.GraphQLError;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.models.PaginationCursor;
import com.enjin.sdk.serialization.converter.GraphConverter.GraphResponseConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

class GraphConverterTest {

    private static final Gson GSON = new GsonBuilder()
            .setLenient()
            .create();
    private static final DummyObject RESULT_ONE = DummyObject.createDefault();
    private static final List<DummyObject> RESULT_MANY = new ArrayList<>();
    private static final List<GraphQLError> ERRORS = new ArrayList<>();
    private static final PaginationCursor CURSOR = new PaginationCursor();
    private static final MockWebServer MOCK_WEB_SERVER = new MockWebServer();

    private final GraphConverter classUnderTest = new GraphConverter();

    @BeforeAll
    @SneakyThrows
    public static void BeforeAll() {
        RESULT_MANY.add(new DummyObject(1));
        RESULT_MANY.add(new DummyObject(2));
        RESULT_MANY.add(new DummyObject(3));
        ERRORS.add(new GraphQLError());
        ERRORS.add(new GraphQLError());
        ERRORS.add(new GraphQLError());
        MOCK_WEB_SERVER.start();
    }

    @AfterAll
    @SneakyThrows
    public static void AfterAll() {
        MOCK_WEB_SERVER.shutdown();
    }

    @Test
    void responseBodyConverter_TypeIsParameterizedType_RawTypeIsGraphQLResponse_ReturnsGraphResponseConverter() {
        // Arrange - Data
        final Annotation[] dummyAnnotations = createDummyAnnotations();
        final Retrofit dummyRetrofit = createDummyRetrofit();
        final ParameterizedType stubType = mock(ParameterizedType.class);

        // Arrange - Stubbing
        when(stubType.getRawType()).thenReturn(GraphQLResponse.class);
        when(stubType.getActualTypeArguments()).thenReturn(new Type[] {Object.class});

        // Act
        Converter<ResponseBody, ?> actual = classUnderTest.responseBodyConverter(stubType,
                                                                                 dummyAnnotations,
                                                                                 dummyRetrofit);

        // Assert
        assertNotNull(actual);
    }

    @Test
    void responseBodyConverter_TypeIsParameterizedType_RawTypeIsNotGraphQLResponse_ReturnNull() {
        // Arrange - Data
        final Annotation[] dummyAnnotations = createDummyAnnotations();
        final Retrofit dummyRetrofit = createDummyRetrofit();
        final ParameterizedType stubType = mock(ParameterizedType.class);

        // Arrange - Stubbing
        when(stubType.getRawType()).thenReturn(Object.class);

        // Act
        Converter<ResponseBody, ?> actual = classUnderTest.responseBodyConverter(stubType,
                                                                                 dummyAnnotations,
                                                                                 dummyRetrofit);

        // Assert
        assertNull(actual);
    }

    @Test
    void responseBodyConverter_TypeIsNotParameterizedType_ReturnNull() {
        // Arrange
        final Type mockType = mock(Type.class);
        final Annotation[] dummyAnnotations = createDummyAnnotations();
        final Retrofit dummyRetrofit = createDummyRetrofit();

        // Act
        Converter<ResponseBody, ?> actual = classUnderTest.responseBodyConverter(mockType,
                                                                                 dummyAnnotations,
                                                                                 dummyRetrofit);

        // Assert
        assertNull(actual);
    }

    @Test
    void create_ReturnsGraphConverter() {
        // Act
        GraphConverter actual = GraphConverter.create();

        // Assert
        assertNotNull(actual);
    }

    @Test
    @SneakyThrows
    void convert_SingleDataInRaw_ResponseHasData() {
        // Arrange - Data
        final String expectedRaw = String.format("{\"data\": {\"result\": %s}}", GSON.toJson(RESULT_ONE));
        final Type responseType = DummyObject.class;
        final GraphResponseConverter<DummyObject> responseConverter = createGraphResponseConverter(classUnderTest,
                                                                                                   responseType);
        final ResponseBody stubResponseBody = mock(ResponseBody.class);

        // Arrange - Stubbing
        when(stubResponseBody.string()).thenReturn(expectedRaw);

        // Act
        GraphQLResponse<DummyObject> actual = responseConverter.convert(stubResponseBody);

        // Assert
        assertNotNull(actual);
    }

    @Test
    @SneakyThrows
    void convert_MultipleDataInRaw_ResponseHasData() {
        // Arrange - Data
        final String expectedRaw = String.format("{\"data\": {\"result\": %s}}", GSON.toJson(RESULT_MANY));
        final Type responseType = TypeToken.getParameterized(List.class, DummyObject.class).getType();
        final GraphResponseConverter<List<DummyObject>> responseConverter = createGraphResponseConverter(classUnderTest,
                                                                                                         responseType);
        final ResponseBody stubResponseBody = mock(ResponseBody.class);

        // Arrange - Stubbing
        when(stubResponseBody.string()).thenReturn(expectedRaw);

        // Act
        GraphQLResponse<List<DummyObject>> actual = responseConverter.convert(stubResponseBody);

        // Assert
        assertNotNull(actual);
    }

    @Test
    @SneakyThrows
    void convert_ErrorsInRaw_ResponseHasErrors() {
        // Arrange - Data
        final String expectedRaw = String.format("{\"errors\": %s}", GSON.toJson(ERRORS));
        final Type responseType = DummyObject.class;
        final GraphResponseConverter<DummyObject> responseConverter = createGraphResponseConverter(classUnderTest,
                                                                                                   responseType);
        final ResponseBody stubResponseBody = mock(ResponseBody.class);

        // Arrange - Stubbing
        when(stubResponseBody.string()).thenReturn(expectedRaw);

        // Act
        GraphQLResponse<DummyObject> actual = responseConverter.convert(stubResponseBody);

        // Assert
        assertNotNull(actual);
    }

    @Test
    @SneakyThrows
    void convert_CursorInRaw_ResponseHasCursor() {
        // Arrange - Data
        final String expectedRaw = String.format("{\"data\": {\"result\": {\"cursor\": %s}}}", GSON.toJson(CURSOR));
        final Type responseType = DummyObject.class;
        final GraphResponseConverter<DummyObject> responseConverter = createGraphResponseConverter(classUnderTest,
                                                                                                   responseType);
        final ResponseBody stubResponseBody = mock(ResponseBody.class);

        // Arrange - Stubbing
        when(stubResponseBody.string()).thenReturn(expectedRaw);

        // Act
        GraphQLResponse<DummyObject> actual = responseConverter.convert(stubResponseBody);

        // Assert
        assertNotNull(actual);
    }

    private static <T> GraphResponseConverter<T> createGraphResponseConverter(GraphConverter converter, Type... types) {
        ParameterizedType stubType = mock(ParameterizedType.class);
        when(stubType.getRawType()).thenReturn(GraphQLResponse.class);
        when(stubType.getActualTypeArguments()).thenReturn(types);
        return (GraphResponseConverter<T>) converter.responseBodyConverter(stubType,
                                                                           createDummyAnnotations(),
                                                                           createDummyRetrofit());
    }

    private static Annotation[] createDummyAnnotations() {
        return new Annotation[0];
    }

    private static Retrofit createDummyRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(MOCK_WEB_SERVER.url("/"))
                .build();
    }

    @EqualsAndHashCode
    private static class DummyObject {

        private final Integer integer;

        public DummyObject(Integer integer) {
            this.integer = integer;
        }

        public static DummyObject createDefault() {
            return new DummyObject(1);
        }

    }

}