package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.models.TokenFilter;
import com.enjin.sdk.models.TokenSort;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GetTokensTest {

    @Test
    void filter_HasVariable() {
        // Arrange
        final String key = "filter";
        final TokenFilter expected = new TokenFilter();
        final GetTokens request = new GetTokens();

        // Act
        request.filter(expected);
        TokenFilter actual = (TokenFilter) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void sort_HasVariable() {
        // Arrange
        final String key = "sort";
        final TokenSort expected = new TokenSort();
        final GetTokens request = new GetTokens();

        // Act
        request.sort(expected);
        TokenSort actual = (TokenSort) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}