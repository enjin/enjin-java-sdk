package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.models.BalanceFilter;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GetBalancesTest {

    @Test
    void filter_HasVariable() {
        // Arrange
        final String key = "filter";
        final BalanceFilter expected = new BalanceFilter();
        final GetBalances request = new GetBalances();

        // Act
        request.filter(expected);
        BalanceFilter actual = (BalanceFilter) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}