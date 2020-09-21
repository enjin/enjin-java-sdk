package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.models.TransactionFilter;
import com.enjin.sdk.models.TransactionSort;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GetRequestsTest {

    @Test
    void filter_HasVariable() {
        // Arrange
        final String key = "filter";
        final TransactionFilter expected = new TransactionFilter();
        final GetRequests request = new GetRequests();

        // Act
        request.filter(expected);
        TransactionFilter actual = (TransactionFilter) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void sort_HasVariable() {
        // Arrange
        final String key = "sort";
        final TransactionSort expected = new TransactionSort();
        final GetRequests request = new GetRequests();

        // Act
        request.sort(expected);
        TransactionSort actual = (TransactionSort) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}