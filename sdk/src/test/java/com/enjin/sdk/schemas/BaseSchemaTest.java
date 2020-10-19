package com.enjin.sdk.schemas;

import com.enjin.sdk.PlatformUtils;
import com.enjin.sdk.TrustedPlatformMiddleware;
import com.enjin.sdk.graphql.GraphQLError;
import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.schemas.shared.queries.GetPlatform;
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
import lombok.SneakyThrows;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

@ExtendWith({MockitoExtension.class,})
class BaseSchemaTest {

    private static final Gson GSON = new GsonBuilder()
            .setLenient()
            .create();
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json");
    private static final MockWebServer MOCK_WEB_SERVER = new MockWebServer();
    private static final TrustedPlatformMiddleware MIDDLEWARE =
            PlatformUtils.createMiddleware(MOCK_WEB_SERVER.url("/").toString());
    private static final String SCHEMA = "test";
    private static final List<GraphQLError> DEFAULT_GRAPH_QL_ERRORS = new ArrayList<>();

    @Mock
    private LoggerProvider mockLoggerProvider;

    private BaseSchema classUnderTest;

    @BeforeAll
    public static void BeforeAll() {
        DEFAULT_GRAPH_QL_ERRORS.add(new GraphQLError());
        DEFAULT_GRAPH_QL_ERRORS.add(new GraphQLError());
        DEFAULT_GRAPH_QL_ERRORS.add(new GraphQLError());
        try {
            MOCK_WEB_SERVER.start();
        } catch (Exception ignored) {
        }
    }

    @BeforeEach
    public void BeforeEach() {
        classUnderTest = new BaseSchema(MIDDLEWARE, SCHEMA, mockLoggerProvider);
    }

    @AfterAll
    @SneakyThrows
    public static void AfterAll() {
        MOCK_WEB_SERVER.shutdown();
    }

    @Test
    void createRequestBody_ValidRequest_ReturnBodyHasQueryAndVariables() {
        // Arrange
        final String QUERY_KEY = "query";
        final String VARIABLES_KEY = "variables";
        final GraphQLRequest request = createValidRequest();

        // Act
        JsonObject actual = classUnderTest.createRequestBody(request);

        // Assert
        assertTrue(actual.has(QUERY_KEY));
        assertTrue(actual.has(VARIABLES_KEY));
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
    @SneakyThrows
    void sendRequest_SyncRequest_ResponseHasGraphqlData_ReturnsResponseWithData() {
        // Arrange - Data
        final Object expected = new Object();
        final GraphQLResponse<Object> fakeGraphqlResponse = createGraphQLResponseWithData(expected);
        final Response<GraphQLResponse<Object>> fakeResponse = Response.success(200, fakeGraphqlResponse);
        final Call<GraphQLResponse<Object>> mockCall = mock(Call.class);

        // Arrange - Stubbing
        doReturn(fakeResponse).when(mockCall).execute();

        // Act
        GraphQLResponse<Object> response = classUnderTest.sendRequest(mockCall);
        Object actual = response.getData();

        // Verify
        verify(mockCall)
                .execute();

        // Assert
        assertFalse(response.hasErrors());
        assertEquals(expected, actual);
    }

    @Test
    @SneakyThrows
    void sendRequest_SyncRequest_ResponseHasGraphqlErrors_ReturnsResponseWithErrors() {
        // Arrange - Data
        final String responseBody = String.format("{\"errors\": %s}", GSON.toJson(DEFAULT_GRAPH_QL_ERRORS));
        final ResponseBody fakeResponseBody = ResponseBody.create(responseBody, MEDIA_TYPE);
        final Response<GraphQLResponse<Object>> fakeResponse = Response.error(400, fakeResponseBody);
        final Call<GraphQLResponse<Object>> mockCall = mock(Call.class);

        // Arrange - Stubbing
        doReturn(fakeResponse).when(mockCall).execute();

        // Act
        GraphQLResponse<Object> graphQLResponse = classUnderTest.sendRequest(mockCall);

        // Verify
        verify(mockCall)
                .execute();

        // Assert
        assertNotNull(graphQLResponse);
        assertTrue(graphQLResponse.hasErrors());
    }

    @Test
    @SneakyThrows
    void sendRequest_SyncRequest_RequestFailed_ThrowsException() {
        // Arrange - Data
        final IOException expected = new IOException("STUB EXCEPTION");
        final Call<GraphQLResponse<Object>> mockCall = mock(Call.class);

        // Arrange - Stubbing
        doThrow(expected).when(mockCall).execute();

        // Assert
        assertThrows(expected.getClass(), () -> classUnderTest.sendRequest(mockCall));

        // Verify
        verify(mockCall)
                .execute();
    }

    @Test
    void sendRequest_Async_ResponseHasGraphqlData_CallbackReceivesResponseWithData() {
        // Arrange - Data
        final Object expected = new Object();
        final GraphQLResponse<Object> fakeGraphqlResponse = createGraphQLResponseWithData(expected);
        final Response<GraphQLResponse<Object>> fakeResponse = Response.success(200, fakeGraphqlResponse);
        final Call<GraphQLResponse<Object>> mockCall = mock(Call.class);
        final HttpCallback<GraphQLResponse<Object>> mockCallback = mock(HttpCallback.class);
        final ArgumentCaptor<HttpResponse<GraphQLResponse<Object>>> httpResponseCapture =
                ArgumentCaptor.forClass(HttpResponse.class);

        // Arrange - Stubbing
        doAnswer(invocation -> {
            Callback<GraphQLResponse<Object>> callback = invocation.getArgument(0);
            callback.onResponse(mockCall, fakeResponse);
            return null;
        }).when(mockCall).enqueue(any());

        // Act
        classUnderTest.sendRequest(mockCall, mockCallback);

        // Verify
        verify(mockCall)
                .enqueue(any());
        verify(mockCallback)
                .onComplete(httpResponseCapture.capture());

        HttpResponse<GraphQLResponse<Object>> httpResponse = httpResponseCapture.getValue();
        GraphQLResponse<Object> graphQLResponse = httpResponse.body();
        Object actual = graphQLResponse.getData();

        // Assert
        assertTrue(httpResponse.isSuccess(), "HTTP response was not successful.");
        assertFalse(graphQLResponse.hasErrors(), "GraphQL response has errors.");
        assertEquals(expected, actual);
    }

    @Test
    void sendRequest_Async_ResponseHasGraphqlErrors_CallbackReceivesResponseWithErrors() {
        // Arrange - Data
        final String responseBody = String.format("{\"errors\": %s}", GSON.toJson(DEFAULT_GRAPH_QL_ERRORS));
        final ResponseBody fakeResponseBody = ResponseBody.create(responseBody, MEDIA_TYPE);
        final Response<GraphQLResponse<Object>> fakeResponse = Response.error(400, fakeResponseBody);
        final Call<GraphQLResponse<Object>> mockCall = mock(Call.class);
        final HttpCallback<GraphQLResponse<Object>> mockCallback = mock(HttpCallback.class);
        final ArgumentCaptor<HttpResponse<GraphQLResponse<Object>>> httpResponseCapture =
                ArgumentCaptor.forClass(HttpResponse.class);

        // Arrange - Stubbing
        doAnswer(invocation -> {
            Callback<GraphQLResponse<Object>> callback = invocation.getArgument(0);
            callback.onResponse(mockCall, fakeResponse);
            return null;
        }).when(mockCall).enqueue(any());

        // Act
        classUnderTest.sendRequest(mockCall, mockCallback);

        // Verify
        verify(mockCall)
                .enqueue(any());
        verify(mockCallback)
                .onComplete(httpResponseCapture.capture());

        HttpResponse<GraphQLResponse<Object>> httpResponse = httpResponseCapture.getValue();
        GraphQLResponse<Object> graphQLResponse = httpResponse.body();

        // Assert
        assertNotNull(graphQLResponse);
        assertTrue(graphQLResponse.hasErrors());
    }

    @Test
    void sendRequest_Async_BadResponse_LogsExceptionAndNotifiesCallback() {
        // Arrange - Data
        final Response<GraphQLResponse<Object>> stubResponse = createBadStubResponse();
        final Call<GraphQLResponse<Object>> mockCall = mock(Call.class);
        final HttpCallback<GraphQLResponse<Object>> mockCallback = mock(HttpCallback.class);
        final ArgumentCaptor<Exception> exceptionCapture = ArgumentCaptor.forClass(Exception.class);

        // Arrange - Stubbing
        doAnswer(invocation -> {
            Callback<GraphQLResponse<Object>> callback = invocation.getArgument(0);
            callback.onResponse(mockCall, stubResponse);
            return null;
        }).when(mockCall).enqueue(Mockito.any());

        // Act
        classUnderTest.sendRequest(mockCall, mockCallback);

        // Verify
        verify(mockCall)
                .enqueue(Mockito.any());
        verify(mockLoggerProvider)
                .log(eq(Level.SEVERE), Mockito.anyString(), Mockito.any());
        verify(mockCallback)
                .onException(exceptionCapture.capture());

        Exception actual = exceptionCapture.getValue();

        // Assert
        assertNotNull(actual);
    }

    @Test
    void sendRequest_Async_RequestFailed_LogsExceptionAndNotifiesCallback() {
        // Arrange - Data
        final Exception dummyException = new Exception("DUMMY EXCEPTION");
        final Request stubRequest = mock(Request.class);
        final Call<GraphQLResponse<Object>> mockCall = mock(Call.class);
        final HttpCallback<GraphQLResponse<Object>> mockCallback = mock(HttpCallback.class);
        final ArgumentCaptor<Exception> exceptionCapture = ArgumentCaptor.forClass(Exception.class);

        // Arrange - Stubbing
        when(stubRequest.toString()).thenReturn("STUB REQUEST");
        doAnswer(invocation -> {
            Callback<GraphQLResponse<Object>> callback = invocation.getArgument(0);
            callback.onFailure(mockCall, dummyException);
            return null;
        }).when(mockCall).enqueue(any());
        doReturn(stubRequest).when(mockCall).request();

        // Act
        classUnderTest.sendRequest(mockCall, mockCallback);

        // Verify
        verify(mockCall)
                .enqueue(any());
        verify(mockLoggerProvider)
                .log(eq(Level.SEVERE), anyString(), any());
        verify(mockCallback)
                .onException(exceptionCapture.capture());

        Exception actual = exceptionCapture.getValue();

        // Assert
        assertNotNull(actual);
    }

    private static GraphQLRequest createValidRequest() {
        return new GetPlatform();
    }

    private static <T> GraphQLResponse<T> createGraphQLResponseWithData(T data) {
        return new GraphQLResponse<>(null, data, null, null);
    }

    private static <T> Response<T> createBadStubResponse() {
        return mock(Response.class, invocation -> new RuntimeException("STUB EXCEPTION"));
    }

}