package com.enjin.sdk.schemas;

import com.enjin.sdk.PlatformUtils;
import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.queries.GetPlatform;
import com.enjin.sdk.services.BalanceService;
import com.enjin.sdk.services.PlatformService;
import com.enjin.sdk.services.PlayerService;
import com.enjin.sdk.services.ProjectService;
import com.enjin.sdk.services.RequestService;
import com.enjin.sdk.services.TokenService;
import com.google.gson.JsonObject;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BaseSchemaTest {

    @Test
    void createRequestBody_ValidRequest_ReturnBodyHasQueryAndVariables() {
        // Arrange
        final String QUERY_KEY = "query";
        final String VARIABLES_KEY = "variables";
        final GraphQLRequest request = createValidRequest();
        final BaseSchema schema = defaultBaseSchema();

        // Act
        JsonObject actual = schema.createRequestBody(request);

        // Assert
        assertTrue(actual.has(QUERY_KEY));
        assertTrue(actual.has(VARIABLES_KEY));
    }

    @Test
    void createService_BalanceService_CreatesService() {
        // Arrange
        final BaseSchema schema = defaultBaseSchema();

        // Act
        BalanceService actual = (BalanceService) schema.createService(BalanceService.class);

        // Assert
        assertNotNull(actual);
    }

    @Test
    void createService_PlatformService_CreatesService() {
        // Arrange
        final BaseSchema schema = defaultBaseSchema();

        // Act
        PlatformService actual = (PlatformService) schema.createService(PlatformService.class);

        // Assert
        assertNotNull(actual);
    }

    @Test
    void createService_PlayerService_CreatesService() {
        // Arrange
        final BaseSchema schema = defaultBaseSchema();

        // Act
        PlayerService actual = (PlayerService) schema.createService(PlayerService.class);

        // Assert
        assertNotNull(actual);
    }

    @Test
    void createService_ProjectService_CreatesService() {
        // Arrange
        final BaseSchema schema = defaultBaseSchema();

        // Act
        ProjectService actual = (ProjectService) schema.createService(ProjectService.class);

        // Assert
        assertNotNull(actual);
    }

    @Test
    void createService_RequestService_CreatesService() {
        // Arrange
        final BaseSchema schema = defaultBaseSchema();

        // Act
        RequestService actual = (RequestService) schema.createService(RequestService.class);

        // Assert
        assertNotNull(actual);
    }

    @Test
    void createService_TokenService_CreatesService() {
        // Arrange
        final BaseSchema schema = defaultBaseSchema();

        // Act
        TokenService actual = (TokenService) schema.createService(TokenService.class);

        // Assert
        assertNotNull(actual);
    }

    private static BaseSchema defaultBaseSchema() {
        return new BaseSchema(PlatformUtils.createFakeMiddleware(), "");
    }

    private static GraphQLRequest createValidRequest() {
        return new GetPlatform();
    }

}