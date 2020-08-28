package com.enjin.sdk.schemas;

import com.enjin.sdk.PlatformUtils;
import com.enjin.sdk.schemas.shared.queries.GetProject;
import com.google.gson.JsonObject;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BaseSchemaTest {

    @Test
    void createRequestBody_ValidRequest_ReturnBodyHasQueryAndVariables() {
        // Arrange
        final String QUERY_KEY = "query";
        final String VARIABLES_KEY = "variables";
        final GetProject request = new GetProject().id(1234);
        final BaseSchema schema = createMockBaseSchema();

        // Act
        JsonObject actual = schema.createRequestBody(request);

        // Assert
        assertTrue(actual.has(QUERY_KEY));
        assertTrue(actual.has(VARIABLES_KEY));
    }

    private static BaseSchema createMockBaseSchema() {
        return new BaseSchema(PlatformUtils.createMockMiddleware(), "");
    }

}