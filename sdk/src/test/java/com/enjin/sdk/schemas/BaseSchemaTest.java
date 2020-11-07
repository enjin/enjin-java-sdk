package com.enjin.sdk.schemas;

import com.enjin.sdk.PlatformUtils;
import com.enjin.sdk.Testable;
import com.enjin.sdk.TrustedPlatformMiddleware;
import com.enjin.sdk.graphql.GraphQLError;
import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.services.BalanceService;
import com.enjin.sdk.services.PlatformService;
import com.enjin.sdk.services.PlayerService;
import com.enjin.sdk.services.ProjectService;
import com.enjin.sdk.services.RequestService;
import com.enjin.sdk.services.TokenService;
import com.enjin.sdk.services.WalletService;
import com.enjin.sdk.utils.LoggerProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.awaitility.Awaitility;
import static org.awaitility.Awaitility.*;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.*;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;

@ExtendWith({MockitoExtension.class,})
class BaseSchemaTest {

    private static final Gson GSON = new GsonBuilder()
            .setLenient()
            .create();
    private static final String SCHEMA = "test";
    private static final List<GraphQLError> DEFAULT_GRAPH_QL_ERRORS = new ArrayList<>();

    private final MockWebServer mockWebServer = new MockWebServer();

    @Mock
    private LoggerProvider mockLoggerProvider;

    private TestableBaseSchema classUnderTest;

    @BeforeAll
    public static void BeforeAll() {
        DEFAULT_GRAPH_QL_ERRORS.add(new GraphQLError());
        DEFAULT_GRAPH_QL_ERRORS.add(new GraphQLError());
        DEFAULT_GRAPH_QL_ERRORS.add(new GraphQLError());
    }

    @BeforeEach
    public void BeforeEach() {
        try {
            mockWebServer.start();
        } catch (Exception ignored) {
        }
        TrustedPlatformMiddleware middleware = PlatformUtils.createMiddleware(mockWebServer.url("/").toString());
        classUnderTest = new TestableBaseSchema(middleware, SCHEMA, mockLoggerProvider);
        Awaitility.reset();
    }

    @AfterEach
    @SneakyThrows
    public void AfterEach() {
        mockWebServer.shutdown();
    }

    @Test
    void createRequestBody_RegisteredRequest_ReturnBodyWithQueryAndVariables() {
        // Arrange
        final String queryName = "test.query";
        final String queryString = "query string";
        final String queryKey = "query";
        final String variablesKey = "variables";
        final GraphQLRequest request = new GraphQLRequest<>(queryName);
        classUnderTest.middleware.getQueryRegistry().register(queryName, queryString);

        // Act
        JsonObject actual = classUnderTest.createRequestBody(request);

        // Assert
        assertTrue(actual.has(queryKey));
        assertTrue(actual.has(variablesKey));
    }

    @Test
    void createService_BalanceService_CreatesService() {
        // Act
        BalanceService actual = (BalanceService) classUnderTest.createService(BalanceService.class);

        // Assert
        assertNotNull(actual);
    }

    @Test
    void createService_PlatformService_CreatesService() {
        // Act
        PlatformService actual = (PlatformService) classUnderTest.createService(PlatformService.class);

        // Assert
        assertNotNull(actual);
    }

    @Test
    void createService_PlayerService_CreatesService() {
        // Act
        PlayerService actual = (PlayerService) classUnderTest.createService(PlayerService.class);

        // Assert
        assertNotNull(actual);
    }

    @Test
    void createService_ProjectService_CreatesService() {
        // Act
        ProjectService actual = (ProjectService) classUnderTest.createService(ProjectService.class);

        // Assert
        assertNotNull(actual);
    }

    @Test
    void createService_RequestService_CreatesService() {
        // Act
        RequestService actual = (RequestService) classUnderTest.createService(RequestService.class);

        // Assert
        assertNotNull(actual);
    }

    @Test
    void createService_TokenService_CreatesService() {
        // Act
        TokenService actual = (TokenService) classUnderTest.createService(TokenService.class);

        // Assert
        assertNotNull(actual);
    }

    @Test
    void createService_WalletService_CreatesService() {
        // Act
        WalletService actual = (WalletService) classUnderTest.createService(WalletService.class);

        // Assert
        assertNotNull(actual);
    }

    @Test
    void sendRequest_SyncRequest_ResponseHasGraphqlData_ReturnsResponseWithData() {
        // Arrange
        final DummyObject expected = DummyObject.createDefault();
        final String responseBody = String.format("{\"data\": {\"result\": %s}}", GSON.toJson(expected));
        final Call<GraphQLResponse<DummyObject>> dummyCall = classUnderTest.fakeService.getDummyObject(classUnderTest.schema,
                                                                                                       new JsonObject());
        final MockResponse mockResponse = new MockResponse()
                .addHeader("Content-Type: application/json")
                .setResponseCode(200)
                .setBody(responseBody);
        mockWebServer.enqueue(mockResponse);

        // Act
        GraphQLResponse<DummyObject> response = classUnderTest.sendRequest(dummyCall);
        DummyObject actual = response.getData();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void sendRequest_SyncRequest_ResponseHasGraphqlErrors_ReturnsResponseWithErrors() {
        // Arrange
        final String responseBody = String.format("{\"errors\": %s}", GSON.toJson(DEFAULT_GRAPH_QL_ERRORS));
        final Call<GraphQLResponse<DummyObject>> dummyCall = classUnderTest.fakeService.getDummyObject(classUnderTest.schema,
                                                                                                       new JsonObject());
        final MockResponse mockResponse = new MockResponse()
                .addHeader("Content-Type: application/json")
                .setResponseCode(400)
                .setBody(responseBody);
        mockWebServer.enqueue(mockResponse);

        // Act
        GraphQLResponse<DummyObject> response = classUnderTest.sendRequest(dummyCall);
        boolean actual = response.hasErrors();

        // Assert
        assertTrue(actual);
    }

    @Test
    void sendRequest_SyncRequest_RequestFailed_ThrowsException() {
        // Arrange
        final Call<GraphQLResponse<DummyObject>> dummyCall = classUnderTest.fakeService.getDummyObject(classUnderTest.schema,
                                                                                                       new JsonObject());
        final NetworkBehavior networkBehavior = NetworkBehavior.create();
        networkBehavior.setErrorPercent(1);
        final MockRetrofit mockRetrofit = new MockRetrofit.Builder(classUnderTest.getRetrofit())
                .networkBehavior(networkBehavior)
                .build();

        // Assert
        assertThrows(IOException.class, () -> classUnderTest.sendRequest(dummyCall));
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void sendRequest_Async_ResponseHasGraphqlData_CallbackReceivesResponseWithData() {
        // Arrange - Data
        final DummyObject expected = DummyObject.createDefault();
        final AtomicBoolean flag = new AtomicBoolean();
        final String responseBody = String.format("{\"data\": {\"result\": %s}}", GSON.toJson(expected));
        final Call<GraphQLResponse<DummyObject>> dummyCall = classUnderTest.fakeService.getDummyObject(classUnderTest.schema,
                                                                                                       new JsonObject());
        final HttpCallback<GraphQLResponse<DummyObject>> mockCallback = mock(HttpCallback.class);
        final MockResponse mockResponse = new MockResponse()
                .addHeader("Content-Type: application/json")
                .setResponseCode(200)
                .setBody(responseBody);
        final ArgumentCaptor<HttpResponse<GraphQLResponse<DummyObject>>> httpResponseCapture =
                ArgumentCaptor.forClass(HttpResponse.class);
        mockWebServer.enqueue(mockResponse);

        // Arrange - Stubbing
        doAnswer(invocation -> {
            flag.set(true);
            return null;
        }).when(mockCallback).onComplete(any());

        // Act
        classUnderTest.sendRequest(dummyCall, mockCallback);
        await().forever().until(flag::get);

        // Verify
        verify(mockCallback)
                .onComplete(httpResponseCapture.capture());

        HttpResponse<GraphQLResponse<DummyObject>> httpResponse = httpResponseCapture.getValue();
        GraphQLResponse<DummyObject> graphQLResponse = httpResponse.body();
        DummyObject actual = graphQLResponse.getData();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void sendRequest_Async_ResponseHasGraphqlErrors_CallbackReceivesResponseWithErrors() {
        // Arrange - Data
        final AtomicBoolean flag = new AtomicBoolean();
        final String responseBody = String.format("{\"errors\": %s}", GSON.toJson(DEFAULT_GRAPH_QL_ERRORS));
        final Call<GraphQLResponse<DummyObject>> dummyCall = classUnderTest.fakeService.getDummyObject(classUnderTest.schema,
                                                                                                       new JsonObject());
        final HttpCallback<GraphQLResponse<DummyObject>> mockCallback = mock(HttpCallback.class);
        final MockResponse mockResponse = new MockResponse()
                .addHeader("Content-Type: application/json")
                .setResponseCode(400)
                .setBody(responseBody);
        final ArgumentCaptor<HttpResponse<GraphQLResponse<DummyObject>>> httpResponseCapture =
                ArgumentCaptor.forClass(HttpResponse.class);
        mockWebServer.enqueue(mockResponse);

        // Arrange - Stubbing
        doAnswer(invocation -> {
            flag.set(true);
            return null;
        }).when(mockCallback).onComplete(any());

        // Act
        classUnderTest.sendRequest(dummyCall, mockCallback);
        await().forever().until(flag::get);

        // Verify
        verify(mockCallback)
                .onComplete(httpResponseCapture.capture());

        HttpResponse<GraphQLResponse<DummyObject>> httpResponse = httpResponseCapture.getValue();
        GraphQLResponse<DummyObject> graphQLResponse = httpResponse.body();

        // Assert
        assertTrue(graphQLResponse.hasErrors());
    }

    @Test
    @Timeout(value = 20, unit = TimeUnit.SECONDS)
    void sendRequest_Async_BadResponse_LogsExceptionAndNotifiesCallback() {
        // Arrange - Data
        final AtomicBoolean flag = new AtomicBoolean();
        final Call<GraphQLResponse<DummyObject>> dummyCall = classUnderTest.fakeService.getDummyObject(classUnderTest.schema,
                                                                                                       new JsonObject());
        final HttpCallback<GraphQLResponse<DummyObject>> mockCallback = mock(HttpCallback.class);
        final NetworkBehavior networkBehavior = NetworkBehavior.create();
        networkBehavior.setErrorPercent(1);
        final MockRetrofit mockRetrofit = new MockRetrofit.Builder(classUnderTest.getRetrofit())
                .networkBehavior(networkBehavior)
                .build();

        // Arrange - Stubbing
        doAnswer(invocation -> {
            flag.set(true);
            return null;
        }).when(mockCallback).onException(any());

        // Act
        classUnderTest.sendRequest(dummyCall, mockCallback);
        await().forever().until(flag::get);

        // Verify
        verify(mockLoggerProvider)
                .log(eq(Level.SEVERE), anyString(), any());
        verify(mockCallback)
                .onException(any());
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void sendRequest_Async_RequestFailed_LogsExceptionAndNotifiesCallback() {
        // Arrange - Data
        final AtomicBoolean flag = new AtomicBoolean();
        final Call<GraphQLResponse<DummyObject>> dummyCall = classUnderTest.fakeService.getDummyObject(classUnderTest.schema,
                                                                                                       new JsonObject());
        final HttpCallback<GraphQLResponse<DummyObject>> mockCallback = mock(HttpCallback.class);
        final MockResponse mockResponse = new MockResponse()
                .addHeader("Content-Type: application/json")
                .setResponseCode(400)
                .setBody("???");
        mockWebServer.enqueue(mockResponse);

        // Arrange - Stubbing
        doAnswer(invocation -> {
            flag.set(true);
            return null;
        }).when(mockCallback).onException(any());

        // Act
        classUnderTest.sendRequest(dummyCall, mockCallback);
        await().forever().until(flag::get);

        // Verify
        verify(mockLoggerProvider)
                .log(eq(Level.SEVERE), anyString(), any());
        verify(mockCallback)
                .onException(any());
    }

    private interface FakeService {

        @POST("/graphql/{schema}")
        @Headers("Content-Type: application/json")
        Call<GraphQLResponse<DummyObject>> getDummyObject(@Path("schema") String schema,
                                                          @Body JsonObject request);

    }

    private static class TestableBaseSchema extends BaseSchema implements Testable {

        private static final Field retrofitField;

        public final FakeService fakeService;

        static {
            Class<BaseSchema> c = BaseSchema.class;
            retrofitField = Testable.getField(c, "retrofit");
            retrofitField.setAccessible(true);
        }

        public TestableBaseSchema(TrustedPlatformMiddleware middleware,
                                  String schema,
                                  LoggerProvider loggerProvider) {
            super(middleware, schema, loggerProvider);
            fakeService = (FakeService) createService(FakeService.class);
        }

        @SneakyThrows
        public Retrofit getRetrofit() {
            return (Retrofit) retrofitField.get(this);
        }

    }

    @EqualsAndHashCode
    private static class DummyObject {

        private final Integer integer;

        public DummyObject(Integer integer) {
            this.integer = integer;
        }

        private static DummyObject createDefault() {
            return new DummyObject(0);
        }

    }

}